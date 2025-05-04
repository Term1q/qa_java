package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FelineTest {
    private Feline feline;

    @Before
    public void setUp() {
        feline = Mockito.spy(new Feline());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Метод должен возвращать рацион - животные, птицы, рыба", expectedFood, feline.getFood("Хищник"));
    }

    @Test
    public void testEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        doReturn(expectedFood).when(feline).getFood("Хищник");
        assertEquals("Метод должен возвращать рацион хищника", expectedFood, feline.eatMeat());
        verify(feline, times(1)).getFood("Хищник");
    }

    @Test
    public void testGetKittensReturnOne() {
        assertEquals("Метод должен возвратить 1", 1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithCount() {
        assertEquals(3, feline.getKittens(3));
    }

    @Test
    public void testGetFamily() {
        assertEquals("Метод должен возвратить - Кошачьи", "Кошачьи", feline.getFamily());
    }
}


