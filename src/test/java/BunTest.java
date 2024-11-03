import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    private Bun bun = new Bun("Whopper", 850f);
    private String name = "Whopper";
    private float price= 850f;


    @Test
    public void getNameReturnsName() {
        Assert.assertEquals("Название булочки не совпадает",
                name, bun.getName());
    }

    @Test
    public void getPriceReturnsPrice() {
        Assert.assertEquals("Суммы не одинаковы",
                price, bun.getPrice(), 0f);
    }

}
