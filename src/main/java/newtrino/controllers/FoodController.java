package newtrino.controllers;

import newtrino.utils.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("food")
public class FoodController {

    @RequestMapping("home")
    public String renderHome(){
        return ViewNames.FOOD_HOME;
    }

    @RequestMapping("add")
    public String renderAddFood(){
        return ViewNames.ADD_FOOD;
    }

}
