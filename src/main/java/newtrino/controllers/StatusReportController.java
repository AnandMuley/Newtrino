package newtrino.controllers;

import newtrino.utils.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("reports")
public class StatusReportController {

    @RequestMapping("home")
    public String renderReportHome(){
        return ViewNames.REPORT_HOME;
    }

}
