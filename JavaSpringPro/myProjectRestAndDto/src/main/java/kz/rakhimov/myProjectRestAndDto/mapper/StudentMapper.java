package kz.rakhimov.myProjectRestAndDto.mapper;

import kz.rakhimov.myProjectRestAndDto.entities.Student;
import kz.rakhimov.myProjectRestAndDto.entities.StudentDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    List<StudentDto> mapToDtoList(List<Student> students);
    StudentDto mapToDto(Student student);
    Student mapToEntity(StudentDto studentDto);
}
