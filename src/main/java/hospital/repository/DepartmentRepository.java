package hospital.repository;

import hospital.models.Department;
import hospital.models.Hospital;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository {
    Department save(Department department, Long id);
    List<Department> getAll(Long id);
    void deleteById(Long id);
    Department getById(Long id);
    void update (Long id, Department newDepartment);
    Hospital getHospitalByDepartmentId(Long departmentId);
}
