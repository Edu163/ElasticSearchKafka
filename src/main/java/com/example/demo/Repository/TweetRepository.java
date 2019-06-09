package com.example.demo.Repository;

import com.example.demo.Model.Tweet;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Date;
import java.util.List;

public interface TweetRepository extends ElasticsearchRepository<Tweet, Long> {
    List<Tweet> findAllByText(String text);
    List<Tweet> findByPublicationDateBetween(Long date1, Long date2);

}
