package kz.rakhimov.myProjectRestAndDto.services.impl;

import kz.rakhimov.myProjectRestAndDto.entities.Student;
import kz.rakhimov.myProjectRestAndDto.entities.StudentDto;
import kz.rakhimov.myProjectRestAndDto.mapper.StudentMapper;
import kz.rakhimov.myProjectRestAndDto.repositories.StudentRepository;
import kz.rakhimov.myProjectRestAndDto.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentMapper studentMapper;
    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setFullName(studentDto.getFullName());
        student.setFaculty(studentDto.getFaculty());
        student.setExamScore(studentDto.getExamScore());
        student.setGpa(studentDto.getGpa());
        student.setIdentificationStudentNumber(UUID.randomUUID().toString());
        return studentMapper.mapToDto(studentRepository.save(student));
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return studentMapper.mapToDtoList(studentRepository.findAll());
    }

    @Override
    public StudentDto getStudent(Long id) {
        return studentMapper.mapToDto(studentRepository.findAllById(id));
    }

    @Override
    public StudentDto updateStudent(StudentDto updatedStudent) {
        Student student = studentRepository.findAllById(updatedStudent.getId());
        student.setId(updatedStudent.getId());
        student.setFullName(updatedStudent.getFullName());
        student.setFaculty(updatedStudent.getFaculty());
        student.setExamScore(updatedStudent.getExamScore());
        student.setGpa(updatedStudent.getGpa());
        return studentMapper.mapToDto(studentRepository.save(student));
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
