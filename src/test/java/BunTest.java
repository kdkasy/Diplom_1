import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String bunName;
    private final float bunPrice;

    public BunTest( String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getBun() {
        return new Object[][]{
                {"sesame bun", 10.111f},
                {"white bread", 100f},
                {"rye bread", 23f},
        };
    }

    @Test
    public void createBun() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(bunName, bun.name);
        assertEquals(bunPrice, bun.price, .4);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("Expected same price", bunPrice, bun.getPrice(), .4);
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("Expected same name", bunName, bun.getName());
    }
}
