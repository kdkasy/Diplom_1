import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String ingredientType;
    private final boolean isContains;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


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
            exceptionRule.expect(IllegalArgumentException.class);
            exceptionRule.expectMessage("No enum constant");
            IngredientType.valueOf(ingredientType);
            }
        }
}
