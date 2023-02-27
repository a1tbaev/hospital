package hospital.repository.impl;

import hospital.models.Appointment;
import hospital.models.Hospital;
import hospital.models.Patient;
import hospital.repository.PatientRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class PatientRepositoryImpl implements PatientRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Patient> getAllPatients(Long appointmentId) {
        return entityManager.createQuery("select p from Appointment a join a.patient p on a.id = :id", Patient.class).setParameter("id", appointmentId).getResultList();
    }

    @Override
    public void savePatient(Long appointmentId, Patient newPatient) {
        //Hospital id = entityManager.createQuery("select h from Hospital h join h.appointments a on a.id = :id", Hospital.class).setParameter("id", appointmentId).getSingleResult();
        Appointment appointment = entityManager.find(Appointment.class, appointmentId);
        entityManager.persist(newPatient);
        appointment.setPatient(newPatient);
        //id.addPatient(newPatient);
    }

    @Override
    public Patient findById(Long patientId) {
        return entityManager.find(Patient.class, patientId);
    }

    @Override
    public void deletePatient(Long patientId) {
        entityManager.remove(entityManager.find(Patient.class, patientId));
    }

    @Override
    public void updatePatient(Long patientId, Patient patient) {

    }
}
