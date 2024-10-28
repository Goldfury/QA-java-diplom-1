import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    @Mock
    private Bun bun;


    @Test
    public void getNameReturnsName() {
        Mockito.when(bun.getName()).thenReturn("Whopper");
        Assert.assertEquals("Название булочки не совпадает",
                "Whopper", bun.getName());
    }

    @Test
    public void getPriceReturnsPrice() {
        Mockito.when(bun.getPrice()).thenReturn(850f);
        Assert.assertEquals("Суммы не одинаковы",
                850f, bun.getPrice(), 0f);
    }

}
