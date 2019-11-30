package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite
{
    @Test
    public void testBigmacBuilder()
    {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .setBun(Bun.SESAME_SEED)
                .setBurgers(1)
                .setSauce(Sauce.STANDARD)
                .addIngredient(Ingredient.PICKLES)
                .addIngredient(Ingredient.CHEESE)
                .addIngredient(Ingredient.CHEESE)
                .addIngredient(Ingredient.CHILIES)
                .build();
        System.out.println(bigmac);
        int expResultNumOfIngredients = 4;
        String expResultIngredient = "Pickles";
        int expResultBurgers = 1;
        String expResultSauce = "Standard sauce";
        String expResultBun = "Sesame seed bun";
        //When
        int actResultNumOfIngredients = bigmac.getIngredients().size();
        int actResultBurgers = bigmac.getBurgers();
        boolean actResultIngredient = bigmac.getIngredients().contains(expResultIngredient);
        String actResultSauce = bigmac.getSauce();
        String actResultBun = bigmac.getBun();
        //Then
        Assert.assertEquals(expResultNumOfIngredients, actResultNumOfIngredients);
        Assert.assertEquals(expResultBurgers, actResultBurgers);
        Assert.assertTrue(actResultIngredient);
        Assert.assertEquals(expResultSauce, actResultSauce);
        Assert.assertEquals(expResultBun, actResultBun);
    }
}
