package newtrino.dtos;

public class NutrientDto {

    private String name;
    private UnitDto unitDto;


    public NutrientDto() {
    }

    public NutrientDto(String name, UnitDto unitDto) {
        this.name = name;
        this.unitDto = unitDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UnitDto getUnitDto() {
        return unitDto;
    }

    public void setUnitDto(UnitDto unitDto) {
        this.unitDto = unitDto;
    }

    @Override
    public String toString() {
        return "NutrientDto{" +
                "name='" + name + '\'' +
                ", unitDto=" + unitDto +
                '}';
    }
}
