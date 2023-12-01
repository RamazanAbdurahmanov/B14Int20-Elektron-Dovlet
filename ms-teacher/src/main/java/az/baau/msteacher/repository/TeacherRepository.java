package az.baau.msteacher.repository;

import az.baau.msteacher.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer> {

}
