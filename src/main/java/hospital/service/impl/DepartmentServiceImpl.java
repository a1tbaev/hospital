package hospital.service.impl;
import hospital.models.Department;
import hospital.repository.DepartmentRepository;
import hospital.service.DepartmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepo;

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
