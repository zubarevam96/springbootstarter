package com.orkisgorki.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id) {
        return topicRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("topic is not found in base")
                );
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void update(Topic topic) {
        topicRepository.save(topic);

    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}
