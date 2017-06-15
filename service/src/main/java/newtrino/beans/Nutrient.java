package newtrino.beans;

public class Nutrient {

    private String name;
    private Unit unit;

    public Nutrient() {
    }

    public Nutrient(String name, Unit unit) {
        this.name = name;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Nutrient{" +
                "name='" + name + '\'' +
                ", unit=" + unit +
                '}';
    }
}
