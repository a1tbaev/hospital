package hospital.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "doctors")
public class Doctor {
    @Id
    @SequenceGenerator(name = "doctor_generator", sequenceName = "doctor_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_generator")
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    @ManyToMany
    private List<Department> departments;
    public void addDepartment(Department department){
        if (departments == null){
            departments = new ArrayList<>();
        }
        departments.add(department);
    }
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private List<Appointment> appointments;
    public void getAppointmentById(Long appointmentId){
        Appointment appointment = new Appointment();
        for (Appointment appointment1 : appointments) {
            if(Objects.equals(appointment.getId(), appointmentId)){
                appointment = appointment1;
            }
        }
    }
    @ManyToOne
    private Hospital hospital;

}
