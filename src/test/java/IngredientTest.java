import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    private final IngredientType type = IngredientType.SAUCE;
    private final String name = "KetchUp";
    private final float price = 5.0f;

    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "KetchUp", 5f);


    @Test
    public void getPriceTest() {
        Assert.assertEquals("Цены не совпадают", price, ingredient.getPrice(), 0f);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("Название одинаковые", name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals("Соусы не те", type, ingredient.getType());
    }


}
