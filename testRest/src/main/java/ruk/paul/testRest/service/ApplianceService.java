package ruk.paul.testRest.service;

import ruk.paul.testRest.domain.model.Appliance;
import ruk.paul.testRest.web.dto.ApplianceDto;

/**
 * Created by paul on 30.05.18.
 */
public interface ApplianceService {

    Appliance findById(Integer id);

    Integer create(ApplianceDto applianceDto);
}
