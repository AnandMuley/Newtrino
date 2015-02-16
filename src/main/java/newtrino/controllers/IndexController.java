package newtrino.controllers;

import newtrino.utils.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("index")
    public String renderIndexPage(){
        return ViewNames.INDEX;
    }

}
