package com.orkisgorki.springbootstarter.topic;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "Java Core", "Java Core Description"),
            new Topic("javascript", "JavaScript Core", "JavaScript Core Description")
            ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().orElseThrow(() -> new NoSuchElementException("topic is not found in base"));
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void putTopic(Topic topic) {
        for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getId().equals(topic.getId())) {
                topics.set(i, topic);
                return;
            }
        }

        throw new NoSuchElementException("topic is not found in base");
    }

    public void deleteTopic(String id) {
        if (!topics.removeIf(t -> t.getId().equals(id))) throw new NoSuchElementException("topic is not found in base");
    }
}
