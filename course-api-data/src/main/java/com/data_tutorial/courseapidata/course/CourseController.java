package com.data_tutorial.courseapidata.course;

import com.data_tutorial.courseapidata.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// RestController will automatically convert return to json response
@RestController
public class CourseController {

    // Create a private variable of TopicService & inject it with Autowired
    @Autowired
    private CourseService courseService; // basically importing the service so can use method

    // This will return all course:
    @RequestMapping(value="/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){ // setting what response type List should be, return list of objects
        // Create a return as list used with getter and setters from Topic class, hardcoding for now data, later use database
        return courseService.getAllCourses(id); // call the service method
    }

    // This will return single course from id: don't worry to much about topicId, id is the primary
    @RequestMapping(method=RequestMethod.GET, value="/topics/{topicId}/courses/{id}") // using {} allows java to know that its going to pass a variable id into it
    public Course getCourse(@PathVariable String id){ // Annotation @PathVariable tells spring id is the id from mapping that is being passed
        return courseService.getCourse(id);
    }

    // Create a Post Request, void because its not returning anything
    @RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
    public String addCourse(@RequestBody Course course, @PathVariable String topicId){ // Use annotation RequestBody and pass it to the topic, convert it into topic instance
        course.setTopic(new Topic(topicId, "", "")); // create new topic when setting
        courseService.addCourse(course); // pass in the topic passing from the payload
        String response = "{\"Post Success\": true}"; // used to return message true if worked
        return response;
    }

    // Create Put Request
    @RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
    public String updateCourse(@PathVariable String id, @PathVariable String topicId, @RequestBody Course course){ // Use annotation RequestBody and pass it to the topic, convert it into topic instance
        course.setTopic(new Topic(topicId, "", "")); // create new topic when setting
        courseService.updateCourses(course); // pass in the topic passing from the payload & id
        String response = "{\"Put Success\": true}"; // used to return message true if worked
        return response;
    }

    // Create Delete Request
    @RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
    public String deleteCourses(@PathVariable String id){ // Use annotation RequestBody and pass it to the topic, convert it into topic instance
        courseService.deleteCourses(id); // pass in the topic passing from the payload & id
        String response = "{\"Deleted Success\": true}"; // used to return message true if worked
        return response;
    }
}

