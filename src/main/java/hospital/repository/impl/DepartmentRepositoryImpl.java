package hospital.repository.impl;

import hospital.models.Department;
import hospital.models.Hospital;
import hospital.repository.DepartmentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
@Transactional
public class DepartmentRepositoryImpl implements DepartmentRepository {
    @PersistenceContext
    private final EntityManager entityManager;
    @Autowired
    public DepartmentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Department save(Department department, Long id) {
        entityManager.persist(department);
        Hospital hospital = entityManager.find(Hospital.class, id);
        department.setHospital(hospital);
        return null;
    }

    @Override
    public List<Department> getAll(Long id) {
        return entityManager.createQuery("select d from Hospital h join h.departments d where h.id = :id", Department.class).setParameter("id", id).getResultList();
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(
                entityManager.createQuery("select d from Hospital h join h.departments d where d.id = :id", Department.class)
                        .setParameter("id", id).getSingleResult()
        );
    }

    @Override
    public Department getById(Long id) {
        return entityManager.find(Department.class,id);
    }

    @Override
    public void update(Long id, Department newDepartment) {
        Department oldDepartment=entityManager.find(Department.class,id);
        oldDepartment.setName(newDepartment.getName());
    }

    @Override
    public Hospital getHospitalByDepartmentId(Long departmentId){
        return entityManager.createQuery("select h from Department d join d.hospital h on d.id = :id", Hospital.class)
                .setParameter("id", departmentId).getSingleResult();
    }
}
