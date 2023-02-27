package hospital.repository.impl;

import hospital.models.Department;
import hospital.models.Doctor;
import hospital.models.Hospital;
import hospital.repository.DepartmentRepository;
import hospital.repository.DoctorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class DoctorRepositoryImpl implements DoctorRepository {
    @PersistenceContext
    private final EntityManager entityManager;
    private final DepartmentRepository departmentRepository;

    public DoctorRepositoryImpl(EntityManager entityManager, DepartmentRepository departmentRepository) {
        this.entityManager = entityManager;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Doctor> getAllDoctors(Long departmentId) {
        return entityManager.createQuery("select d from Department de join de.doctors d where de.id = :id" , Doctor.class)
                .setParameter("id", departmentId).getResultList();
    }

    @Override
    public void saveDoctor(Doctor doctor, Long departmentId) {
        Hospital hospitalByDepartmentId = departmentRepository.getHospitalByDepartmentId(departmentId);
        Department department = entityManager.find(Department.class, departmentId);
        doctor.addDepartment(department);
        entityManager.persist(doctor);
        doctor.setHospital(hospitalByDepartmentId);
    }

    @Override
    public Doctor getDoctorById(Long doctorId) {
        return entityManager.find(Doctor.class, doctorId);
    }

    @Override
    public void deleteDoctor(Long doctorId) {
        entityManager.createQuery("delete from Doctor where id = :id")
                .setParameter("id", doctorId)
                .executeUpdate();
    }

    @Override
    public void updateDoctor(Doctor doctor, Long doctorId) {
        Doctor doctor1 = entityManager.find(Doctor.class, doctorId);
        doctor1.setFirstName(doctor.getFirstName());
        doctor1.setLastName(doctor.getLastName());
        doctor1.setPosition(doctor.getPosition());
    }
}
