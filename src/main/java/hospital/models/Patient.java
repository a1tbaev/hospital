package hospital.models;

import hospital.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "patients")
public class Patient {
    @Id
    @SequenceGenerator(name = "patient_generator", sequenceName = "patient_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_generator")
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Gender gender;
    private String email;
    @ManyToOne
    private Hospital hospital;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

}
