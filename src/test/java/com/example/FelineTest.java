package com.example;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;


public class FelineTest {

    @Test
    public void testGetFamilyDefaultReturnFamilyCat(){
        Feline feline = new Feline();

        String expect = feline.getFamily();
        String actual = "Кошачьи";

        assertEquals(expect, actual);
    }

    @Test
    public void testEatMeatDefaultReturnEatForPredator() throws Exception{

        Feline feline = new Feline();

        List<String> expect = feline.eatMeat();
        List<String> actual = List.of("Животные", "Птицы", "Рыба");

        assertEquals(expect, actual);

    }

    @Test
    public void testGetKittensDefaultReturnOne(){
        Feline feline = new Feline();

        int expected = feline.getKittens();
        int actual = 1;

        assertEquals(expected, actual);
    }

    @Test
    public void testGetKittensFiveCatCountReturnCatCount(){

        Feline feline = new Feline();
        int expected = feline.getKittens(5);
        int actual = 5;

        assertEquals(expected, actual);

    }

}