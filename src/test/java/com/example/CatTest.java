package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatGetFoodTest {

   /* @Test
    public void getSoundTest(){

        Feline feline = new Feline();
        Cat cat = new Cat(feline);

        String expect = cat.getSound();
        String actual = "Мяу";

        assertEquals(expect, actual);

    }*/

    @Mock
    Feline feline;

    @Test()
    public void getFoodTest() throws Exception {

      Cat cat = new Cat(feline);

        //написать мок на getFood
       Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> expect = cat.getFood();
        System.out.println(expect);
        List<String> actual = List.of("Животные", "Птицы", "Рыба");

       assertEquals(expect, actual);
    }

    @Test(expected = Exception.class)
    public void getFoodExceptionTest() throws Exception {

        //Feline feline = new Feline();

        Cat cat = new Cat(feline);

        //написать мок на getFood
        Mockito.when(feline.eatMeat()).thenThrow(Exception.class);

        cat.getFood();
        //System.out.println(expect);
        //List<String> actual = List.of("Животные", "Птицы", "Рыба");

        // assertEquals(expect, actual);
    }

    @Test
    public void getSoundTest(){

        Cat cat = new Cat(feline);

        String expect = cat.getSound();
        String actual = "Мяу";

        assertEquals(expect, actual);
    }



}