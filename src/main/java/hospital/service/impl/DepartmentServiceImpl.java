package hospital.service.impl;
import hospital.models.Appointment;
import hospital.models.Department;
import hospital.models.Hospital;
import hospital.repository.AppointmentRepository;
import hospital.repository.DepartmentRepository;
import hospital.service.DepartmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepo;
    private final AppointmentRepository appointmentRepository;

    @Override
    public Department save(Department department, Long id) {
        return departmentRepo.save(department, id);
    }

    @Override
    public List<Department> getAll(Long id) {
        return departmentRepo.getAll(id);
    }

    @Override
    public void deleteById(Long departmentId) {
        Hospital hospital = departmentRepo.getById(departmentId).getHospital();
        List<Appointment> appointments = hospital.getAppointments();
        List<Appointment> depAppointments = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getDepartment().getId().equals(departmentId)) {
                depAppointments.add(appointment);
            }
        }
        depAppointments.forEach(a->a.setDepartment(null));
        depAppointments.forEach(a->a.setPatient(null));
        depAppointments.forEach(a->a.setDoctor(null));
        hospital.getAppointments().removeAll(depAppointments);
        for (Appointment depAppointment : depAppointments) {
            appointmentRepository.deleteAppointments(depAppointment.getId());
        }
        departmentRepo.deleteById(departmentId);
    }
    @Override
    public Department getById(Long id) {
        return departmentRepo.getById(id);
    }

    @Override
    public void update(Long id, Department newDepartment) {
        departmentRepo.update(id, newDepartment);
    }
}
