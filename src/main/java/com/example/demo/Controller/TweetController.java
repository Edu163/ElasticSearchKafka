package com.example.demo.Controller;

import com.example.demo.Model.Tweet;
import com.example.demo.Repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
public class TweetController {
    @Autowired
    private TweetRepository tweetRepository;

    /*@PostMapping("/saveTweet")
    public int saveTweetList(@RequestBody List<Tweet> tweets){
        tweetRepository.saveAll(tweets);
        return tweets.size();
    }*/

    @PostMapping("/saveTweets")
    public int saveTweetAlone(@RequestBody Tweet tweet){
        tweetRepository.save(tweet);
        return 1;
    }

    @GetMapping("/findAll")
    public Iterable<Tweet> findAllTweets() {
        return tweetRepository.findAll();
    }

    /*@GetMapping("/findGeolocation")
    public Iterable<Tweet> findGeoLocation() {
        return tweetRepository.findAllByGeoLocationIsNotContaining(null);
    }*/
    @GetMapping("findByDate/{date1}/{date2}")
    public List<Tweet> findByDate(@PathVariable String date1, @PathVariable String date2){
        String myDate1 = date1 + " 00:00:00";
        String myDate2 = date2 +  " 00:00:00";
        LocalDateTime localDateTime1 = LocalDateTime.parse(myDate1,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime localDateTime2 = LocalDateTime.parse(myDate2,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Long milliDate1 = localDateTime1
                .atZone(ZoneId.systemDefault())
                .toInstant().toEpochMilli();
        Long milliDate2 = localDateTime2
                .atZone(ZoneId.systemDefault())
                .toInstant().toEpochMilli();
        return tweetRepository.findByPublicationDateBetween(milliDate1, milliDate2);

    }

    @GetMapping("/findByText/{text}")
    public List<Tweet> findByText(@PathVariable String text) {
        return tweetRepository.findAllByText(text);
    }
}
