package hospital.repository.impl;

import hospital.models.Hospital;
import hospital.repository.HospitalRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class HospitalRepositoryImpl implements HospitalRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public HospitalRepositoryImpl(){}

    @Override
    public void save(Hospital hospital) {
        entityManager.persist(hospital);
    }

    @Override
    public List<Hospital> hospitals() {
        return entityManager.createQuery("select h from Hospital h", Hospital.class).getResultList();
    }

    @Override
    public Hospital getHospitalById(Long id) {
        return entityManager.find(Hospital.class, id);
    }

    @Override
    public void deleteHospitalByID(Long id) {
        entityManager.remove(entityManager.find(Hospital.class, id));
    }

    @Override
    public void updateHospitalById(Long id, Hospital hospital) {
        Hospital hospital1 = entityManager.find(Hospital.class, id);
        hospital1.setName(hospital.getName());
        hospital1.setAddress(hospital.getAddress());
        hospital1.setImage(hospital.getImage());
    }


}
