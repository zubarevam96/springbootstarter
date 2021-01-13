package com.orkisgorki.springbootstarter.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return Arrays.asList(
                new Topic("spring", "Spring Framework", "Spring Framework Description"),
                new Topic("java", "Java Core", "Java Core Description"),
                new Topic("javascript", "JavaScript Core", "JavaScript Core Description")
        );
    }


}
