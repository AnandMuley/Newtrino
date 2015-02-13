package newtrino.dtos;

public class UnitDto {

    private String type;
    private long quantity;

    public UnitDto() {
    }

    public UnitDto(long quantity,String type) {
        this.type = type;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
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
