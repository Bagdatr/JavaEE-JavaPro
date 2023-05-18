package kz.rakhimov.myProjectRestAndDto.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    private Long id;
    private String fullName;
    private String faculty;
    private int examScore;
    private double gpa;
}
