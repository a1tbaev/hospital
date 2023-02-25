package hospital.repository;

import hospital.models.Hospital;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository {
    void save(Hospital hospital);
    List<Hospital> hospitals();
    Hospital getHospitalById(Long id);
    void deleteHospitalByID(Long id);
    void updateHospitalById(Long id, Hospital hospital);


}
