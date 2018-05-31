package ruk.paul.testRest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ruk.paul.testRest.domain.model.Appliance;
import ruk.paul.testRest.domain.repository.ApplianceRepository;
import ruk.paul.testRest.exception.DataNotFoundException;
import ruk.paul.testRest.service.ApplianceService;
import ruk.paul.testRest.web.dto.ApplianceDto;

import java.util.Optional;

/**
 * Created by paul on 30.05.18.
 */
@Service
public class DefaultApplianceService implements ApplianceService{

    @Autowired
    ApplianceRepository applianceRepository;

    @Override
    public Appliance findById(Integer id) {
        Optional<Appliance> appliance = applianceRepository.findById(id);
        if (appliance.isPresent()) {
            return appliance.get();
        }
        throw new DataNotFoundException(String.format("No appliance found for id = %s", id));
    }

    @Override
    public Integer create(ApplianceDto applianceDto) {
        Appliance appliance = new Appliance();
        appliance.setItem(applianceDto.getItemid());
        appliance.setState(applianceDto.getState());
        appliance.setType(applianceDto.getType());
        //TODO: exceptions
        return applianceRepository.save(appliance).getId();
    }
}
