package hospital.service.impl;
import hospital.models.Hospital;
import hospital.repository.HospitalRepository;
import hospital.service.HospitalService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class HospitalServiceImpl implements HospitalService {
    private final HospitalRepository hospitalRepository;

    @Autowired
    public HospitalServiceImpl(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public void save(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    @Override
    public List<Hospital> hospitals() {
        return hospitalRepository.hospitals();
    }

    @Override
    public Hospital getHospitalById(Long id) {
        return hospitalRepository.getHospitalById(id);
    }

    @Override
    public void deleteHospitalByID(Long id) {
        hospitalRepository.deleteHospitalByID(id);
    }

    @Override
    public void updateHospitalById(Long id, Hospital hospital) {
        hospitalRepository.updateHospitalById(id, hospital);
    }
}
