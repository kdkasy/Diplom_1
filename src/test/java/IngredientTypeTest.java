import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String ingredientType;
    private final boolean isContains;


    public IngredientTypeTest(String ingredientType, boolean isContains) {
        this.ingredientType = ingredientType;
        this.isContains = isContains;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredients() {
        return new Object[][]{
                {"SAUCE", true},
                {"FILLING", true},
                {"MEAT", false}
        };
    }

    @Test
    public void isIngredientExist() {
        if(isContains) {
            assertThat(IngredientType.valueOf(ingredientType), is(notNullValue()));
        }
        else {
            Exception exception = assertThrows(IllegalArgumentException.class,() -> IngredientType.valueOf(ingredientType));
            assertTrue(exception.getMessage().contains("No enum constant"));
            }
        }
}
