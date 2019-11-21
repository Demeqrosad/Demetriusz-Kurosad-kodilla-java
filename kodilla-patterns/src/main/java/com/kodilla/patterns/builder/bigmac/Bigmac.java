package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac
{
    private final String bun;
    private final int burgers;
    private final String sauce;
    private final List<String> ingredients;

    public final static class BigmacBuilder
    {
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder setBun(final String bun)
        {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder setBurgers(final int burgers)
        {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder setSauce(final String sauce)
        {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder addIngredient(final String ingredient)
        {
            this.ingredients.add(ingredient);
            return this;
        }

        public Bigmac build()
        {
            return new Bigmac(this.bun, this.burgers, this.sauce, this.ingredients);
        }
    }

    private Bigmac(final String bun, final int burgers, final String sauce, List<String> ingredients)
    {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getBun()
    {
        return this.bun;
    }

    public int getBurgers()
    {
        return this.burgers;
    }

    public String getSauce()
    {
        return this.sauce;
    }

    public List<String> getIngredients()
    {
        return new ArrayList<>(this.ingredients);
    }

    @Override
    public String toString()
    {
        return "Bigmac{" +
                "bun='" + this.bun + '\'' +
                ", burgers=" + this.burgers +
                ", sauce='" + this.sauce + '\'' +
                ", ingredients=" + this.ingredients +
                '}';
    }
}
