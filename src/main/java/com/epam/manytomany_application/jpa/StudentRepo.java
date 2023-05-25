package com.epam.manytomany_application.jpa;

import com.epam.manytomany_application.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}
