import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Spy
    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredientMockBurger1;

    @Mock
    private Ingredient ingredientMockBurger2;

    @Mock
    private Ingredient ingredientMockBurger3;

    private final float delta = 0.00001f;

    @Before
    public void createSimpleBurger() {
        burger = new Burger();
    }

    @Test
    public void getBurgerPriceTest() {
        burger.bun = bun;

        burger.ingredients.add(ingredientMockBurger1);
        burger.ingredients.add(ingredientMockBurger2);

        when(ingredientMockBurger1.getPrice()).thenReturn(5f);
        when(ingredientMockBurger2.getPrice()).thenReturn(10f);
        when(bun.getPrice()).thenReturn(5f);

        assertEquals(25 ,burger.getPrice(), delta);
    }

    @Test
    public void getReceiptTest() {
        burger.bun = bun;
        burger.ingredients.add(ingredientMockBurger1);
        burger.ingredients.add(ingredientMockBurger2);

        when(ingredientMockBurger1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientMockBurger2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientMockBurger1.getName()).thenReturn("Начинка");
        when(ingredientMockBurger2.getName()).thenReturn("Соус");
        when(bun.getName()).thenReturn("Сладкая булочка");
        when(burger.getPrice()).thenReturn(100F);

        assertEquals("(==== Сладкая булочка ====)\n= filling Начинка =\n= sauce Соус =\n(==== Сладкая булочка ====)\n\nPrice: 100.000000\n", burger.getReceipt());


    }

    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        assertNotNull(burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredientMockBurger1);
        burger.addIngredient(ingredientMockBurger2);
        assertEquals(2, burger.ingredients.size());
        assertEquals(ingredientMockBurger1, burger.ingredients.get(0));
        assertEquals(ingredientMockBurger2, burger.ingredients.get(1));
    }

    @Test
    public void removeIngredientTest() {
        burger.ingredients.add(ingredientMockBurger1);
        burger.ingredients.add(ingredientMockBurger2);
        burger.ingredients.add(ingredientMockBurger3);

        burger.removeIngredient(1);

        assertEquals(2, burger.ingredients.size());
        assertEquals(ingredientMockBurger1, burger.ingredients.get(0));
        assertEquals(ingredientMockBurger3, burger.ingredients.get(1));
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients.add(ingredientMockBurger1);
        burger.ingredients.add(ingredientMockBurger2);
        burger.ingredients.add(ingredientMockBurger3);

        burger.moveIngredient(2, 0);

        assertEquals(3, burger.ingredients.size());
        assertEquals(ingredientMockBurger3, burger.ingredients.get(0));
        assertEquals(ingredientMockBurger1, burger.ingredients.get(1));
        assertEquals(ingredientMockBurger2, burger.ingredients.get(2));

    }
}
