package kz.rakhimov.myProjectRestAndDto.services;

import kz.rakhimov.myProjectRestAndDto.entities.Student;
import kz.rakhimov.myProjectRestAndDto.entities.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto addStudent(StudentDto studentDto);
    List<StudentDto> getAllStudents();
    StudentDto getStudent(Long id);
    StudentDto updateStudent(StudentDto updatedStudent);
    void deleteStudent(Long id);
}
