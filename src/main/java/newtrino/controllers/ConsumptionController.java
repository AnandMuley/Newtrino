package newtrino.controllers;

import newtrino.dtos.ConsumptionDto;
import newtrino.dtos.ProductDto;
import newtrino.services.ConsumptionService;
import newtrino.utils.Messages;
import newtrino.utils.Models;
import newtrino.utils.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Set;

@Controller
@RequestMapping("consumption")
public class ConsumptionController {

    @Autowired
    private ConsumptionService consumptionService;

    @RequestMapping("home")
    public String renderConsumptionHome(Model model){
        Date today  = new Date();
        Set<ConsumptionDto> consumptionDtos = consumptionService.productsConsumedOn(today);
        model.addAttribute(Models.CONSUMPTIONS,consumptionDtos);
        return ViewNames.CONSUMPTION_HOME;
    }

    @RequestMapping("consume")
    public String consumedAProduct(ConsumptionDto consumptionDto,Model model){
        consumptionService.consumeProduct(consumptionDto);
        return renderConsumptionHome(model);
    }


}
