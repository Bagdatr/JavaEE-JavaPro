package kz.rakhimov.myProjectRestAndDto.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="t_student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String faculty;
    private int examScore;
    private double gpa;
    private String identificationStudentNumber;
}
