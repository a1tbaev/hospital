package hospital.service;

import hospital.models.Hospital;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface HospitalService {
    void save(Hospital hospital);
    List<Hospital> hospitals();
    Hospital getHospitalById(Long id);
    void deleteHospitalByID(Long id);
    void updateHospitalById(Long id, Hospital hospital);
}
