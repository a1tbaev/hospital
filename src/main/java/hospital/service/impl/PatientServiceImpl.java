package hospital.service.impl;

import hospital.models.Patient;
import hospital.repository.PatientRepository;
import hospital.service.PatientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    @Override
    public List<Patient> getAllPatients(Long appointmentId) {
        return patientRepository.getAllPatients(appointmentId);
    }

    @Override
    public void savePatient(Long appointmentId, Patient newPatient) {
        patientRepository.savePatient(appointmentId, newPatient);
    }

    @Override
    public Patient findById(Long patientId) {
        return patientRepository.findById(patientId);
    }

    @Override
    public void deletePatient(Long patientId) {
        patientRepository.deletePatient(patientId);
    }

    @Override
    public void updatePatient(Long patientId, Patient patient) {
        patientRepository.updatePatient(patientId, patient);
    }
}
