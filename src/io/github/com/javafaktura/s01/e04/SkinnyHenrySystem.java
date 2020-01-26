package io.github.com.javafaktura.s01.e04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import io.github.com.javafaktura.s01.e04.model.*;

public class SkinnyHenrySystem {

    public static void main(String[] args) {
	    new SkinnyHenrySystem().run();
    }

    void run() {
        System.out.println("What's up! This is Skinny Henry pizzeria system.");

        addPizza();
    }

    private void addPizza() {
        PizzaBuilder builder = new PizzaBuilder();

        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Give me a pizza name");
            builder.withName(in.nextLine());

            System.out.println("Which dough do you want? (ITALIAN, POLISH, PLUMB)");
            String doughValue = in.nextLine();
            builder.withDough(doughValue);

            System.out.println("Which sauce do you want? (TOMATO, CHEESE, TOMATO-CHEESE)");
            String sauceValue = in.nextLine();
            builder.withSauce(sauceValue);

            System.out.println("Give me the size of pizza (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
            String sizeValue = in.nextLine();
            builder.withSize(sizeValue);


            while (true) {
                System.out.println("Which topping do you want?");
                builder.addTopping(Topping.valueOf(in.nextLine()));

                System.out.println("More toppings? (YES/NO)");
                String nextTopping = in.nextLine();

                if (nextTopping.equals("NO")) {
                    break;
                }
            }

            Pizza pizza = builder.build();

            PizzaBuilder pizzaBuilder2 = new PizzaBuilder();
            Pizza pizza1 = pizzaBuilder2.addTopping(Topping.BACON).addTopping(Topping.ANANAS).build();
            System.out.println("pizza1 = " + pizza1);

            System.out.println(pizza);
        }
    }


}