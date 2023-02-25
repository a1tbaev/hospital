package hospital.service;

import hospital.models.Doctor;
import hospital.models.Hospital;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
@Service
public interface DoctorService {
    List<Doctor> getAllDoctors(Long departmentId);
    void saveDoctor(Doctor doctor, Long departmentId);
    Doctor getDoctorById(Long doctorId);
    void deleteDoctor(Long doctorId);
    void updateDoctor(Doctor doctor, Long doctorId);
}
