package com.data_tutorial.courseapidata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    // Create member variable & autowire it for TopicRepository
    @Autowired
    public TopicRepository topicRepository;

    /* Old Way of doing it, no longer need hard coded list, getting from database now:
    private List<Topic> topics = new ArrayList<>(Arrays.asList( // create new so that way its mutable so can add or remove from list
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "Core Java", "Java Description"),
            new Topic("javascript", "JavaScript", "JavaScript Description")
        ));
     */
    // Create method returns list of topics:
    public List<Topic> getAllTopics(){
        // return topics; // old way

        // JBA way of doing it:
        // findAll() gives back an interval need to convert interval into a list, create list
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll() // gives back an interval,
        .forEach(topics::add); // use forEach to iterate over it and use method reference
        return topics;
    }

    // Create Get Request that only returns single id of topic not all topics
    // This will return single topic from id: *** Will need to look into streams & Lambda Expressions
    public Topic getTopic(String id){
        // create lambda expression & that equals id
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get(); // old way of doing it

        // JBA way of doing it:
        return topicRepository.findById(id).get();
    }

    // Create for post request:
    public void addTopic(Topic topic){
        //topics.add(topic); // this add method built in and add to list, old way

        // JBA way of doing it:
        topicRepository.save(topic);
    }

    // Create for Put Request:
    // Use a for loop,
    public void updateTopic(String id, Topic topic){
        /* Old Way
        for (int i  = 0; i < topics.size(); i++){
            Topic t = topics.get(i);
            // if equals certain id then going to replace it with
            if(t.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }
         */

        // JBA way of doing it:
        // pass in the updated topic, save can do both add and update, it checks to see if row exist if not creates one
        topicRepository.save(topic);
    }

    // Create for Delete Request
    public void deleteTopic(String id){
        // use remove option for deleting topic, old way
        //topics.removeIf(t -> t.getId().equals(id));

        // JPA Way of doing it:
        topicRepository.deleteById(id);
    }
}
