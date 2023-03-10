package hospital.repository;

import hospital.App;
import hospital.models.Appointment;
import hospital.models.Patient;

import java.util.List;

public interface AppointmentRepository {
    void saveAppointment(Patient patient, Appointment appointment, Long id);
    Appointment getById(Long appointmentId);
    List<Appointment>getAllAppointments(Long doctorsId);
    void deleteAppointments(Long appointmentsId);
    void updateAppointments(Long appointmentId, Appointment appointment);
}
