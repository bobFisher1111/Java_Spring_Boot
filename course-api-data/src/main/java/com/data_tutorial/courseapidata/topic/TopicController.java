package com.data_tutorial.courseapidata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// RestController will automatically convert return to json response
@RestController
public class TopicController {

    // Create a private variable of TopicService & inject it with Autowired
    @Autowired
    private TopicService topicService; // basically importing the service so can use method

    // This will return all topics:
    @RequestMapping(method=RequestMethod.GET, value="/topics")
    public List<Topic> getAllTopics(){ // setting what response type List should be, return list of objects
        // Create a return as list used with getter and setters from Topic class, hardcoding for now data, later use database
        return topicService.getAllTopics(); // call the service method
    }

    // This will return single topic from id:
    @RequestMapping(method=RequestMethod.GET, value="/topics/{id}") // using {} allows java to know that its going to pass a variable id into it
    public Topic getTopic(@PathVariable String id){ // Annotation @PathVariable tells spring id is the id from mapping that is being passed
        return topicService.getTopic(id);
    }

    // Create a Post Request, void because its not returning anything
    @RequestMapping(method=RequestMethod.POST, value="/topics")
    public String addTopic(@RequestBody Topic topic){ // Use annotation RequestBody and pass it to the topic, convert it into topic instance
        topicService.addTopic(topic); // pass in the topic passing from the payload
        String response = "{\"Post Success\": true}"; // used to return message true if worked
        return response;
    }

    // Create Put Request
    @RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
    public String updateTopic(@PathVariable String id, @RequestBody Topic topic){ // Use annotation RequestBody and pass it to the topic, convert it into topic instance
        topicService.updateTopic(id, topic); // pass in the topic passing from the payload & id
        String response = "{\"Put Success\": true}"; // used to return message true if worked
        return response;
    }

    // Create Delete Request
    @RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
    public String deleteTopic(@PathVariable String id){ // Use annotation RequestBody and pass it to the topic, convert it into topic instance
        topicService.deleteTopic(id); // pass in the topic passing from the payload & id
        String response = "{\"Deleted Success\": true}"; // used to return message true if worked
        return response;
    }
}

// Left off @ video 20

