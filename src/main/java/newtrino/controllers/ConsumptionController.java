package newtrino.controllers;

import newtrino.utils.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("consumption")
public class ConsumptionController {


    @RequestMapping("home")
    public String renderConsumptionHome(){
        return ViewNames.CONSUMPTION_HOME;
    }

}
