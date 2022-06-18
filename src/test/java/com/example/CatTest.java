package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test()
    public void testGetFoodDefaultReturnListAnimal() throws Exception {

        Cat cat = new Cat(feline);

       Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> expect = cat.getFood();
        System.out.println(expect);
        List<String> actual = List.of("Животные", "Птицы", "Рыба");

       assertEquals(expect, actual);
    }

    @Test(expected = Exception.class)
    public void testGetFoodReturnException() throws Exception {

        Cat cat = new Cat(feline);

        Mockito.when(feline.eatMeat()).thenThrow(Exception.class);

        cat.getFood();
    }

    @Test
    public void testGetSoundDefaultReturnText(){

        Cat cat = new Cat(feline);

        String expect = cat.getSound();
        String actual = "Мяу";

        assertEquals(expect, actual);
    }



}