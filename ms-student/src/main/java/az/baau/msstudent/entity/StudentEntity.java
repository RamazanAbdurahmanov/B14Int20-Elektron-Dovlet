package az.baau.msstudent.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "telebeler")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Ad")
    private String firstName;
    @Column(name = "Soyad")
    private String lastName;
    @Column(nullable = false, unique = true, name = "Email")
    private String email;
    @Column(name = "Unvan")
    private String address;
    @Column(name = "Shekil")
    private String image;
}
