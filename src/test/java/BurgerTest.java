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

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Spy
    Burger burger;

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
        Mockito.verify(burger,Mockito.times(1)).setBuns(bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Mockito.verify(burger).addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
        burger.ingredients.remove(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        Assert.assertEquals(3,burger.ingredients.size());
        burger.moveIngredient(1, 1);

    }

    @Test
    public void getPriceTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(ingredient.getPrice()).thenReturn(5f);
        Assert.assertEquals(25f,burger.getPrice(),0f);
    }



}
