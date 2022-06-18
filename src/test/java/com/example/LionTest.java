package com.example;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class LionTest {

    @Ignore
    public static class TestBase {

        @Mock
        Feline feline;
    }


    @RunWith(Parameterized.class)
    public static class LionUsingParameterTest extends TestBase{

        private final String sex;
        private final boolean actual;

        public LionUsingParameterTest(String sex, boolean actual){
            this.sex = sex;
            this.actual = actual;

        }


        @Parameterized.Parameters(name = "Iteration #{index} -> sex = {0} AND actual = {1}")
        public static Object[][] getHasMane(){
            return new Object[][]{
                    {"Самец", true},
                    {"Самка", false},
            };
        }

        @Test
        public void testDoesHaveManeValidParameterReturnBoolean() throws Exception {

            Lion lion = new Lion(sex, feline);
            boolean expected = lion.doesHaveMane();

            assertEquals(expected, actual);

        }


    }

    @RunWith(MockitoJUnitRunner.class)
    public static class LionWithoutParameterTest extends TestBase{

        @Test
        public void testDoesHaveNonValidReturnException() {

            Exception exception = null;
            try{
                Lion lion = new Lion("оно", feline);
            } catch(Exception ex){
                exception =ex;

            }
            assertNotNull(exception);

            assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
            //"самей написано в исходной реализации, поэтому я неправила"
        }

        @Test
        public void testGetKittensDefaultReturnInt() throws Exception {

            Lion lion = new Lion("Самка", feline);
            Mockito.when(feline.getKittens()).thenReturn(5);


            int expected = lion.getKittens();
            int actual = 5;

            assertEquals(expected, actual);

        }

        @Test
        public void testGetFoodDefaultReturnListAnimal() throws Exception{

            Lion lion = new Lion("Самка", feline);

            Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(List.of("Животные", "Птицы", "Рыба"));

            List<String> expect = lion.getFood();
            List<String> actual = List.of("Животные", "Птицы", "Рыба");

            assertEquals(expect, actual);


        }

    }
}