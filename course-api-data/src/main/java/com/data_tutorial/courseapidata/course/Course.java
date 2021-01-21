package com.data_tutorial.courseapidata.course;

import com.data_tutorial.courseapidata.topic.Topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {
    // Member variables:
    @Id
    private String id;
    private String name;
    private String description;

    // Tying Topic Class to Course Class: JPA Annotation @ManyToOne
    @ManyToOne // lets Spring Boot know this mapping between course & topic
    private Topic topic;

    // No arg constructor: easier to initialize:
    public Course() {}

    // Constructor with args:
    public Course(String id, String name, String description, String topicId){
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic = new Topic(topicId, "", "");
    }

    // Getters & Setters
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){ this.description = description; }
    public Topic getTopic(){
        return topic;
    } // if trouble, could be because of here. left off at 30 7:56
    public void setTopic(Topic id){
        this.topic = topic;
    }
}
