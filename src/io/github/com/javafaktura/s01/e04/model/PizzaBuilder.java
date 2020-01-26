package io.github.com.javafaktura.s01.e04.model;



import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder {

    private Dough dough;
    private String pizzaName;
    private Sauce sauce;
    private Size size;
    private List<Topping> toppings = new ArrayList<>();

    public PizzaBuilder withSize(String sizeValue) {
        if (sizeValue.isBlank()) sizeValue = "MEDIUM";
        this.size =  Size.valueOf(sizeValue);
        return this;
    }

    public PizzaBuilder withSauce(String sauceValue) {
        if (sauceValue.isBlank()) sauceValue = "TOMATO_CHEESE";
        this.sauce = Sauce.valueOf(sauceValue);
        return this;
    }

    public PizzaBuilder withDough(String doughValue) {
        if (doughValue.isBlank()) doughValue = "ITALIAN";
        this.dough = Dough.valueOf(doughValue);
        return this;
    }

    public PizzaBuilder withName(String pizzaName) {
        if (pizzaName.isBlank()) pizzaName = "John";
        this.pizzaName = pizzaName;
        return this;
    }



    public PizzaBuilder addTopping(Topping topping) {
        this.toppings.add(topping);
        return this;
    }
    public Pizza build() {
        return new Pizza(pizzaName, dough, sauce, size, toppings);
    }
}
