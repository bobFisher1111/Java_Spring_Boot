package com.data_tutorial.courseapidata.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String>{
    /*
        - This is where we will create custom methods for CrudRepository
     */

    // method returns course by name
    public List<Course> findByName(String name); // gets name from column created in the Courses class

    // method returns list of courses by specific description
    public List<Course> findByDescription(String description);

    // method returns by Topic, since not a string will have to do Topic topicId, findByTopicId
    public List<Course> findByTopicId(String topicId);
}
