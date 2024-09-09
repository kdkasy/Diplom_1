import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;
    private final float delta = 0.00001f;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredients() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 10.10f},
                {IngredientType.SAUCE, "cheese sauce", 30f},
                {IngredientType.FILLING, "salad", 23f},
                {IngredientType.FILLING, "tomato", 10f}
        };
    }

    @Before
    public void createIngredient() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void createIngredientTest() {
        Ingredient testIngredient = new Ingredient(type, name, price);
        assertEquals(type, testIngredient.type);
        assertEquals(name, testIngredient.name);
        assertEquals(price, testIngredient.price, delta);
    }

    @Test
    public void getIngredientType() {
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void getIngredientName() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getIngredientPrice() {
        assertEquals(price, ingredient.getPrice(), delta);
    }
}
