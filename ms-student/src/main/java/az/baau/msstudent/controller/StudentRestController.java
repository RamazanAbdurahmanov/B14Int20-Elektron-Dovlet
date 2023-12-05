package az.baau.msstudent.controller;

import az.baau.msstudent.dto.StudentDto;
import az.baau.msstudent.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class StudentRestController {
    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto) {
        studentService.saveStudent(studentDto);
        return new ResponseEntity<>(studentDto, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Integer id, @RequestBody StudentDto studentDto) {
        studentService.updateStudent(studentDto, id);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Integer id) {
        StudentDto studentDto = studentService.getStudentById(id);
        return new ResponseEntity<>(studentDto, HttpStatus.FOUND);
    }

    @GetMapping("get/all")
    public ResponseEntity<List<StudentDto>> getAllStudents() {

        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.FOUND);
    }

    @DeleteMapping("delete/{id}")
    public void deleteStudentById(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
    }
}
