package newtrino.controllers;

import newtrino.dtos.chart.ConsumptionJsonDto;
import newtrino.services.ReportingService;
import newtrino.utils.ViewNames;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("reports")
public class StatusReportController {

    @Autowired
    private ReportingService reportingService;

    @RequestMapping("home")
    public String renderReportHome(){
        return ViewNames.REPORT_HOME;
    }

    @ResponseBody
    @RequestMapping("fetchdata")
    public List<ConsumptionJsonDto> fetchConsumptionData(){
        List<ConsumptionJsonDto> jsons = Collections.emptyList();
        try {
            jsons = reportingService.fetchConsumptionData();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsons;
    }

}
