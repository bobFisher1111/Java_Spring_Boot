package com.data_tutorial.courseapidata.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    // Create member variable & autowire it for TopicRepository
    @Autowired
    public CourseRepository courseRepository;

    // Create method returns list of Courses:
    public List<Course> getAllCourses(String topicId){ // this will be using custom method in courseRepository
        // JBA way of doing it:
        // findAll() gives back an interval need to convert interval into a list, create list
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId)// gives back an interval,
        .forEach(courses::add); // use forEach to iterate over it and use method reference
        return courses;
    }

    // Create Get Request that only returns single id of Courses not all Courses
    // This will return single Courses from id: *** Will need to look into streams & Lambda Expressions
    public Course getCourse(String id){
        // JBA way of doing it:
        return courseRepository.findById(id).get();
    }

    // Create for post request:
    public void addCourse(Course course){
        // JBA way of doing it:
        courseRepository.save(course);
    }

    // Create for Put Request:
    public void updateCourses(Course course){
        // JBA way of doing it:
        // pass in the updated topic, save can do both add and update, it checks to see if row exist if not creates one
        courseRepository.save(course);
    }

    // Create for Delete Request
    public void deleteCourses(String id){
        // JPA Way of doing it:
        courseRepository.deleteById(id);
    }
}
