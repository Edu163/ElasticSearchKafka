package com.example.demo.Listener;

import com.example.demo.Model.Tweet;
import com.example.demo.Repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/*@Service
public class KafkaConsumer {

    @Autowired
    TweetRepository tweetRepository;
    /*MongoClient mongoClient = MongoClients.create("mongodb://kafkaApi:kafkatbd2019@localhost:27017/?authSource=ligaChilenaDB");
    MongoDatabase data = mongoClient.getDatabase("ligaChilenaDB");
    MongoCollection<Document> tweetCollection = data.getCollection("ligaTweets");*/
/*
    @KafkaListener(topics = "${kafka.topic}", groupId = "${zookeeper.group-id}", containerFactory = "kafkaListenerFactory")
    public void consumer(Tweet tweet)
    {
        System.out.println(tweet.toString());
        tweetRepository.save(tweet);
    }
}*/
