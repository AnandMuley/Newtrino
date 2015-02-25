package newtrino.dtos.chart;

import com.fasterxml.jackson.annotation.JsonProperty;
import newtrino.dtos.NutrientDto;

public class Options {

    private String title;
    private String[] colors;
    private int width;
    private int height;
    private Legend legend;
    @JsonProperty("isStacked")
    private boolean stacked = true;
    private TitleTextStyle titleTextStyle;
    private String backgroundColor;
    private HAxis hAxis;

    public Options(NutrientDto nutrientDto) {
        title = nutrientDto.getName()+"("+nutrientDto.getUnitDto().getType()+")";
        colors = new String[]{"#ff5037","#ffbbb1"};
        width = 250;
        height = 300;
        legend = new Legend();
        titleTextStyle = new TitleTextStyle();
        backgroundColor = "#EFF3F1";
        hAxis = new HAxis();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Legend getLegend() {
        return legend;
    }

    public void setLegend(Legend legend) {
        this.legend = legend;
    }

    public boolean isStacked() {
        return stacked;
    }

    public void setStacked(boolean stacked) {
        this.stacked = stacked;
    }

    public TitleTextStyle getTitleTextStyle() {
        return titleTextStyle;
    }

    public void setTitleTextStyle(TitleTextStyle titleTextStyle) {
        this.titleTextStyle = titleTextStyle;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public HAxis gethAxis() {
        return hAxis;
    }

    public void sethAxis(HAxis hAxis) {
        this.hAxis = hAxis;
    }
}
