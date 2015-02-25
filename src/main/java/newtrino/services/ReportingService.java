package newtrino.services;

import newtrino.dtos.chart.ConsumptionJsonDto;
import org.json.JSONException;

import java.util.List;

public interface ReportingService {

    List<ConsumptionJsonDto> fetchConsumptionData() throws JSONException;
}
