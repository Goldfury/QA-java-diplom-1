import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {


    Burger burger = new Burger();

    @Mock
    public Bun bun;

    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient2;
    @Mock
    Ingredient ingredient3;


    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        Assert.assertEquals(3, burger.ingredients.size());
        burger.moveIngredient(1, 2);
        Assert.assertEquals(ingredient2, burger.ingredients.get(2));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(ingredient.getPrice()).thenReturn(5f);
        Assert.assertEquals(25f, burger.getPrice(), 0f);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(bun.getName()).thenReturn("Булочка с кунжутом");

        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getPrice()).thenReturn(5f);
        Mockito.when(ingredient.getName()).thenReturn("Плавленный сыр чеддер");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);

        burger.addIngredient(ingredient2);
        Mockito.when(ingredient2.getPrice()).thenReturn(15f);
        Mockito.when(ingredient2.getName()).thenReturn("Двойная говяжья котлета");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);

        String expectedString = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", IngredientType.FILLING.toString().toLowerCase(), ingredient.getName()) +
                String.format("= %s %s =%n", IngredientType.FILLING.toString().toLowerCase(), ingredient2.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        Assert.assertEquals(expectedString, burger.getReceipt());
    }


}
