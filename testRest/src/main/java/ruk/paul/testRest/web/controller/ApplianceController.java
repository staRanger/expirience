package ruk.paul.testRest.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ruk.paul.testRest.domain.model.Appliance;
import ruk.paul.testRest.service.ApplianceService;
import ruk.paul.testRest.web.dto.ApplianceDto;

/**
 * Created by paul on 30.05.18.
 */
@RestController
@RequestMapping("/appliance")
public class ApplianceController {

    @Autowired
    private ApplianceService applianceService;

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Appliance get(@PathVariable(name = "id", required = true)Integer id) {
        return applianceService.findById(id);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Integer create(@RequestBody ApplianceDto applianceDto) {
        return applianceService.create(applianceDto);
    }


}
