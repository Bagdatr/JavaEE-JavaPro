package kz.rakhimov.myProjectRestAndDto.controllers;

import kz.rakhimov.myProjectRestAndDto.entities.StudentDto;
import kz.rakhimov.myProjectRestAndDto.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(value="/{id}")
    public StudentDto getStudent(@PathVariable("id") Long id){
        return studentService.getStudent(id);
    }

    @PostMapping
    public StudentDto addStudent(@RequestBody StudentDto studentDto){
        return studentService.addStudent(studentDto);
    }

    @PutMapping
    public StudentDto updateStudent(@RequestBody StudentDto studentDto){
        return studentService.updateStudent(studentDto);
    }

    @DeleteMapping(value="{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
    }
}
