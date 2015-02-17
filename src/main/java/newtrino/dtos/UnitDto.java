package newtrino.dtos;

public class UnitDto {

    private String type;
    private double quantity;

    public UnitDto() {
    }

    public UnitDto(double quantity,String type) {
        this.type = type;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "UnitDto{" +
                "type='" + type + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
