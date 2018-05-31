package ruk.paul.testRest.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by paul on 30.05.18.
 */
@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String getIndexPage() {
        return "return readme";
    }
}
