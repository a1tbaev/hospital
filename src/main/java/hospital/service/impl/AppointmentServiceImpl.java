package hospital.service.impl;

import hospital.models.Appointment;
import hospital.models.Patient;
import hospital.repository.AppointmentRepository;
import hospital.service.AppointmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    @Override
    public void saveAppointment(Patient patient, Appointment appointment, Long id) {
        appointmentRepository.saveAppointment(patient, appointment, id);
    }

    @Override
    public Appointment getById(Long appointmentId) {
        return appointmentRepository.getById(appointmentId);
    }

    @Override
    public List<Appointment> getAllAppointments(Long doctorsId) {
        return appointmentRepository.getAllAppointments(doctorsId);
    }

    @Override
    public void deleteAppointments(Long appointmentsId) {
        appointmentRepository.deleteAppointments(appointmentsId);
    }

    @Override
    public void updateAppointments(Long appointmentId, Appointment appointment) {
        appointmentRepository.updateAppointments(appointmentId, appointment);
    }
}
