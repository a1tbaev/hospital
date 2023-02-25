package hospital.service.impl;

import hospital.models.Doctor;
import hospital.models.Hospital;
import hospital.repository.DepartmentRepository;
import hospital.repository.DoctorRepository;
import hospital.repository.HospitalRepository;
import hospital.service.DoctorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    @Override
    public List<Doctor> getAllDoctors(Long departmentId) {
        return doctorRepository.getAllDoctors(departmentId);
    }

    @Override
    public void saveDoctor(Doctor doctor, Long departmentId) {
        doctorRepository.saveDoctor(doctor, departmentId);
    }

    @Override
    public Doctor getDoctorById(Long doctorId) {
        return doctorRepository.getDoctorById(doctorId);
    }

    @Override
    public void deleteDoctor(Long doctorId) {
        doctorRepository.deleteDoctor(doctorId);
    }

    @Override
    public void updateDoctor(Doctor doctor, Long doctorId) {
        doctorRepository.updateDoctor(doctor, doctorId);
    }
}
