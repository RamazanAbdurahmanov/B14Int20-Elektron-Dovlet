package az.baau.msteacher.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "muellimler")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Ad")
    private String name;
    @Column(name = "Fenn")
    private String subject;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(name = "Shekil")
    private String image;
}
