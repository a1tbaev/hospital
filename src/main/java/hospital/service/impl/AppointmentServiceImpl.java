package hospital.service.impl;

import hospital.models.Appointment;
import hospital.models.Hospital;
import hospital.models.Patient;
import hospital.repository.AppointmentRepository;
import hospital.repository.DoctorRepository;
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
    private final DoctorRepository doctorRepository;
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
    public void deleteAppointments(Long doctorId, Long appointmentsId) {
        Hospital hospital = doctorRepository.getDoctorById(doctorId).getHospital();
        Appointment appointment = appointmentRepository.getById(appointmentsId);
        appointment.setDoctor(null);
        appointment.setDepartment(null);
        appointment.setPatient(null);
        hospital.getAppointments().remove(appointment);
        appointmentRepository.deleteAppointments(appointmentsId);
    }

    @Override
    public void updateAppointments(Long appointmentId, Appointment appointment) {
        appointmentRepository.updateAppointments(appointmentId, appointment);
    }
}
