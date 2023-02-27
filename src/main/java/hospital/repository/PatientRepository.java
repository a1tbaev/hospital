package hospital.repository;

import hospital.models.Patient;

import java.util.List;

public interface PatientRepository {
    List<Patient> getAllPatients(Long appointmentId);
    void savePatient(Long appointmentId, Patient newPatient);
    Patient findById(Long patientId);
    void deletePatient(Long patientId);
    void updatePatient(Long patientId, Patient patient);

}
