package com.epam.manytomany_application;

import com.epam.manytomany_application.model.Course;
import com.epam.manytomany_application.model.StudentDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ManyToManyApplication {

    public static void main(String[] args) {

        SpringApplication.run(ManyToManyApplication.class, args);
    }

    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }

    @Bean
    public TypeToken<List<StudentDto>> getToken() {
        return new TypeToken<>(){};
    }

    @Bean
    public TypeToken<List<Course>> getCourseToken() {
        return new TypeToken<>(){};
    }
}
