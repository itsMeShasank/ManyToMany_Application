package com.epam.manytomany_application.jpa;

import com.epam.manytomany_application.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Long> {
}
