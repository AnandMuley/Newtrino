package newtrino.dtos.chart;

import newtrino.dtos.NutrientDto;

public class ConsumptionJsonDto {

    private String nutrientName;
    private Object[] data;

    private Options options;
    private Integer quantityConsumed;

    public ConsumptionJsonDto(NutrientDto nutrientDto) {
        nutrientName = nutrientDto.getName();
        data = new Object[2];
        data [0]= new Object[]{"Nutrient", "Consumed","Deficient"};
        data [1]= new Object[]{nutrientName, nutrientDto.getUnitDto().getQuantity(),nutrientDto.getUnitDto().getQuantity()+10};
        options = new Options(nutrientDto);
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public String getNutrientName() {
        return nutrientName;
    }

    public void setNutrientName(String nutrientName) {
        this.nutrientName = nutrientName;
    }

    public Integer getQuantityConsumed() {
        return quantityConsumed;
    }

    public void setQuantityConsumed(Integer quantityConsumed) {
        this.quantityConsumed = quantityConsumed;
    }

    public void incrementQuantityConsumed(){
        this.quantityConsumed++;
        refreshData();
    }

    public void decrementQuantityConsumed(){
        this.quantityConsumed--;
        refreshData();
    }

    private void refreshData(){
        data [1]= new Object[]{nutrientName, quantityConsumed,quantityConsumed + 10};
    }
}
