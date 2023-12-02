package az.baau.msstudent.service.impl;

import az.baau.msstudent.dto.StudentDto;
import az.baau.msstudent.entity.StudentEntity;
import az.baau.msstudent.mapper.StudentMapper;
import az.baau.msstudent.repository.StudentRepository;
import az.baau.msstudent.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentMapper studentMapper, StudentRepository studentRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public StudentDto saveStudent(StudentDto studentDto) {
        StudentEntity studentEntity = studentMapper.convertToEntity(studentDto);
        studentRepository.save(studentEntity);
        return studentMapper.convertToDto(studentEntity);

    }

    @Override
    public StudentDto getStudentById(Integer studentId) {
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(studentId);
        if (optionalStudentEntity.isPresent()) {
            StudentEntity studentEntity = optionalStudentEntity.get();
            return studentMapper.convertToDto(studentEntity);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<StudentEntity> studentList = studentRepository.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (StudentEntity studentEntity : studentList) {
            studentDtoList.add(studentMapper.convertToDto(studentEntity));
        }
        return studentDtoList;
    }


    @Override
    public StudentDto updateStudent(StudentDto studentDto, Integer studentId) {
        StudentEntity studentEntity = studentMapper.convertToEntity(studentDto);
        Optional<StudentEntity> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            StudentEntity student = optionalStudent.get();
            student.setAddress(studentEntity.getAddress());
            student.setEmail(studentEntity.getEmail());
            student.setImage(studentEntity.getImage());
            student.setFirstName(studentEntity.getFirstName());
            student.setLastName(studentEntity.getLastName());
            studentRepository.save(student);
            return studentMapper.convertToDto(studentEntity);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentRepository.deleteById(studentId);
    }
}
