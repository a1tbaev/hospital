package hospital.service;

import hospital.models.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PatientService {
    List<Patient> getAllPatients(Long appointmentId);
    void savePatient(Long appointmentId, Patient newPatient);
    Patient findById(Long patientId);
    void deletePatient(Long patientId);
    void updatePatient(Long patientId, Patient patient);
}
