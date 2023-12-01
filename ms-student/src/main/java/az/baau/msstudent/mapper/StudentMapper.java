package az.baau.msstudent.mapper;

import az.baau.msstudent.dto.StudentDto;
import az.baau.msstudent.entity.StudentEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class StudentMapper {
    private final ModelMapper modelMapper;

    public StudentDto convertToDto(StudentEntity studentEntity) {
        return modelMapper.map(studentEntity, StudentDto.class);
    }

    public StudentEntity convertToEntity(StudentDto studentDto) {
        return modelMapper.map(studentDto, StudentEntity.class);
    }
}
