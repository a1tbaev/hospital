package hospital.repository.impl;

import hospital.App;
import hospital.models.Appointment;
import hospital.models.Department;
import hospital.models.Doctor;
import hospital.models.Patient;
import hospital.repository.AppointmentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class AppointmentRepositoryImpl implements AppointmentRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void saveAppointment(Patient patient, Appointment appointment, Long id) {
        Department department = entityManager.createQuery("select de from Doctor d join d.departments de where d.id = :id", Department.class)
                .setParameter("id", id).getSingleResult();
        entityManager.persist(appointment);
        Doctor doctor = entityManager.find(Doctor.class, id);
        appointment.setDoctor(doctor);
        appointment.setDepartment(department);
    }

    @Override
    public Appointment getById(Long appointmentId) {
        return entityManager.find(Appointment.class, appointmentId);
    }

    @Override
    public List<Appointment> getAllAppointments(Long doctorsId) {
        return entityManager.createQuery("select a from Appointment a join a.doctor d on d.id = :id", Appointment.class)
                .setParameter("id", doctorsId).getResultList();
    }

    @Override
    public void deleteAppointments(Long appointmentsId) {
        entityManager.remove(entityManager.find(Appointment.class, appointmentsId));
    }

    @Override
    public void updateAppointments(Long appointmentId, Appointment appointment) {

    }
}
