package com.epam.manytomany_application.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDto {
    @Id
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    private String name;
    private List<CourseDto> courses;
}
