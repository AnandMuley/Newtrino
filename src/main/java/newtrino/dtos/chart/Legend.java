package newtrino.dtos.chart;

public class Legend {

    private String position;
    private String alignment;

    public Legend() {
        position = "bottom";
        alignment = "center";
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }
}
