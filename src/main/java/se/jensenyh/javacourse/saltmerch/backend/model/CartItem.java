package se.jensenyh.javacourse.saltmerch.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartItem {
    @JsonProperty
    public int product_id;
    @JsonProperty
    public String title;
    @JsonProperty
    public String size;
    @JsonProperty
    public String color;
    @JsonProperty
    public String preview_image;
    @JsonProperty
    public int quantity;


    public CartItem() {
    }

    public CartItem(int product_id, String title, String color, String size, String preview_image) {
        this.product_id = product_id;
        this.title = title;
        this.color = color;
        this.size = size;
        this.preview_image = preview_image;
    }

    public CartItem(int product_id, String title, String color, String size, String preview_image, int quantity) {
        this.product_id = product_id;
        this.title = title;
        this.color = color;
        this.size = size;
        this.preview_image = preview_image;
        this.quantity = quantity;
    }


}
