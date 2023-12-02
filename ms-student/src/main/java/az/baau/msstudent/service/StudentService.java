package az.baau.msstudent.service;

import az.baau.msstudent.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto saveStudent(StudentDto studentDto);

    StudentDto getStudentById(Integer studentId);

    List<StudentDto> getAllStudents();

    StudentDto updateStudent(StudentDto studentDto, Integer studentId);

    void deleteStudentById(Integer studentId);
}
