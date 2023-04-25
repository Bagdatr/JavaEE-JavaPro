package kz.bitlab.crmNewProject.services;

import kz.bitlab.crmNewProject.entities.Course;

import java.util.List;

public interface CourseService {
    Course addCourse(Course course);
    List<Course> getAllCourses();
}
