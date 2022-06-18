package com.example;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(Enclosed.class)
public class AnimalTest {

    @RunWith(Parameterized.class)
    public static class AnimalUsingParameterTest{

        private final String animalKind;
        private final List<String> actual;

        public AnimalUsingParameterTest(String animalKind, List<String> actual){
            this.animalKind = animalKind;
            this.actual = actual;
        }

        @Parameterized.Parameters(name = "Iteration #{index} -> animalKind = {0} AND actual = {1}")
        public static Object[][] getFoodText(){
            return new Object[][]{
                    {"Травоядное", List.of("Трава", "Различные растения")},
                    {"Хищник", List.of("Животные", "Птицы", "Рыба")},
            };
        }

        @Test
        public void testGetFoodValidAnimalKindReturnListEat() throws Exception{
            Animal animal = new Animal();

            List<String> expected = animal.getFood(animalKind);

            assertEquals(expected, actual);

        }

    }

    public static class AnimalWithoutParameterTest{

        @Test
        public void testGetFoodNonValidAnimalsKindReturnException(){
            Exception exception = null;

            try{
                Animal animal = new Animal();
                animal.getFood("notKind");

            }catch(Exception exc){
                exception = exc;
            }

            assertNotNull(exception);
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        }


        @Test
        public void testGetFamilyDefaultReturnTextFamily(){

            Animal animal = new Animal();

            String expected = animal.getFamily();
            String actual = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

            assertEquals(expected, actual);

        }

    }


}
