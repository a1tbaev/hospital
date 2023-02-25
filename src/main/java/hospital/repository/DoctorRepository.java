package hospital.repository;

import hospital.models.Doctor;
import hospital.models.Hospital;

import java.util.List;

public interface DoctorRepository {
    List<Doctor> getAllDoctors(Long departmentId);
    void saveDoctor(Doctor doctor, Long departmentId);
    Doctor getDoctorById(Long doctorId);
    void deleteDoctor(Long doctorId);
    void updateDoctor(Doctor doctor ,Long doctorId);
}
