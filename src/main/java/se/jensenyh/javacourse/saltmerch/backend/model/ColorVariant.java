package se.jensenyh.javacourse.saltmerch.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;

public class ColorVariant {
    @JsonProperty
    public String colorName;
    @JsonProperty
    public ArrayList<String> images;
    @JsonProperty
    public ArrayList<SizeContainer> sizes;

    public ColorVariant() {
        this.images = new ArrayList<>();
        this.sizes = new ArrayList<>();
    }

    public ColorVariant(String colorName, ArrayList<String> images,
                        ArrayList<SizeContainer> sizes) {
        this.colorName = colorName;
        this.images = images;
        this.sizes = sizes;
    }

    public void setImagesFromCSV(String csv) throws Exception {
        images = new ArrayList<>(Arrays.asList(csv.split(",")));
    }

}
