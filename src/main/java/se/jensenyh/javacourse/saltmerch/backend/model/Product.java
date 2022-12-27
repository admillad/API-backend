package se.jensenyh.javacourse.saltmerch.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {
    @JsonProperty
    public int product_id;
    @JsonProperty
    public String category;
    @JsonProperty
    public String title;
    @JsonProperty
    public String description;
    @JsonProperty
    public String preview_image;
    @JsonProperty
    public ArrayList<ColorVariant> colorVariants;

    public Product() {
        this.colorVariants = new ArrayList<>();
    }

    public Product(int product_id, String category, String title, String description, String preview_image) {
        this.colorVariants = new ArrayList<>();
    }

    public Product(int product_id, String category, String title, String description, ArrayList<ColorVariant> colorVariants) {
        this.product_id = product_id;
        this.category = category;
        this.title = title;
        this.description = description;
        this.colorVariants = colorVariants;
    }

    //Fattade inte riktigt den 2:a constructorn.
    // todo: needs 3 constructors:
    //  1. empty constructor: this one only initializes colorVariants to new ArrayList<>()
    //  2. constructor with id, category, title, description, and previewImage: this one initializes colorVariants to new ArrayList<>()
    //  3. constructor with id, category, title, description, colorVariants


}
