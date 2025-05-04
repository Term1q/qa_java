package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {
    private Feline feline;

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    @Test
    public void testInvalidSexThrowsException() {
        try {
            new Lion("Неизвестно", feline);
            fail("Ожидалось исключение");
        } catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }

    @Test
    public void testGetKittens() throws Exception {
        when(feline.getKittens()).thenReturn(5);
        Lion lion = new Lion("Самец", feline);
        assertEquals("Метод должен вернуть количество котят равное 5", 5, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", feline);
        assertEquals("Метод должен возвратить рацион: животные, птицы, рыбы", expectedFood, lion.getFood());
    }
}


