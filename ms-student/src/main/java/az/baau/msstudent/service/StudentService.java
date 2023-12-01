package az.baau.msstudent.service;

import az.baau.msstudent.dto.StudentDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    ResponseEntity<StudentDto> saveStudent(StudentDto studentDto);
    ResponseEntity<StudentDto> getStudentById(Integer studentId);
    ResponseEntity<List<StudentDto>> getAllStudents();

    ResponseEntity<StudentDto> updateStudent(StudentDto studentDto, Integer studentId);

    void deleteStudentById(Integer studentId);
}
