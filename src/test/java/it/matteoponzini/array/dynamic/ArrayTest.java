package it.matteoponzini.array.dynamic;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ArrayTest {

    record Car(String name, String plate, LocalDate year) {
    }

    @Test
    void instanceFromArray() {
        List<Car> carsList = Arrays.asList(
                new Car("VW Polo", "ATX514", LocalDate.of(2021, Month.APRIL, 10)),
                new Car("VW Golf", "ATX514", LocalDate.of(2021, Month.APRIL, 10)),
                new Car("VW Turan", "ATX514", LocalDate.of(2021, Month.APRIL, 10)),
                new Car("VW Gtx", "ATX514", LocalDate.of(2021, Month.APRIL, 10)),
                new Car("VW Master", "ATX514", LocalDate.of(2021, Month.APRIL, 10)),
                new Car("VW Das", "ATX514", LocalDate.of(2021, Month.APRIL, 10)),
                new Car("VW", "ATX514", LocalDate.of(2021, Month.APRIL, 10))
        );

        Array<Car> cars = new Array<>(carsList);
        assertEquals(carsList.size(), cars.size());
    }

    @Test
    void addElement() {
        Array<Car> cars = new Array<>(3);
        cars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        assertEquals(2, cars.size());
    }

    @Test
    void growElement() {
        Array<Car> cars = new Array<>(3);
        cars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat 500", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        assertEquals(5, cars.size());
    }

    @Test
    void emptyArray(){
        Array<Car> cars = new Array<>();
        assertTrue(cars.isEmpty());
    }

    @Test
    void isNotEmptyArray(){
        Array<Car> cars = new Array<>(1);
        cars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        assertFalse(cars.isEmpty());
    }

    @Test
    void getElement() {
        Car carOpel = new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10));
        Array<Car> cars = new Array<>(5);
        cars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(carOpel);
        cars.add(new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        assertEquals(carOpel, cars.get(1));
    }

    @Test
    void getIndexElementDontExist() {
        Car carOpel = new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10));
        Array<Car> cars = new Array<>(5);
        cars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(carOpel);
        cars.add(new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        assertThrows(IndexOutOfBoundsException.class, ()-> cars.get(10));
    }

    @Test
    void insertElement() {
        Car carOpel = new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10));
        Array<Car> cars = new Array<>(5);
        cars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat 500", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.set(carOpel, 4);
        assertEquals(carOpel, cars.get(4));
    }

    @Test
    void insertElementDontExist() {
        Car carOpel = new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10));
        Array<Car> cars = new Array<>(5);
        cars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat 500", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        assertThrows(IndexOutOfBoundsException.class, ()-> cars.set(carOpel, 10));
    }


    @Test
    void indexOfElement() {
        Car carOpel = new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10));
        Array<Car> cars = new Array<>(6);
        cars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(null);
        assertEquals(1, cars.indexOf(carOpel));
        assertEquals(5, cars.indexOf(null));
        assertEquals(-1, cars.indexOf(new Car("VW Polo", "ARSD", LocalDate.of(2020, Month.AUGUST, 10))));
    }

    @Test
    void removeElementSecondPosition() {
        Array<Car> cars = new Array<>(5);
        cars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.remove(2);

        Array<Car> expectedCars = new Array<>(4);
        expectedCars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));

        for(int i = 0; i < cars.size(); i++){
            assertEquals(expectedCars.get(i), cars.get(i));
        }
    }

    @Test
    void removeElementFirstPosition() {
        Array<Car> cars = new Array<>(5);
        cars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.remove(0);

        Array<Car> expectedCars = new Array<>(4);
        expectedCars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));

        for(int i = 0; i < cars.size(); i++){
            assertEquals(expectedCars.get(i), cars.get(i));
        }
    }


    @Test
    void removeElementLastPosition() {
        Array<Car> cars = new Array<>(5);
        cars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.remove(4);

        Array<Car> expectedCars = new Array<>(4);
        expectedCars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));

        for(int i = 0; i < cars.size(); i++){
            assertEquals(expectedCars.get(i), cars.get(i));
        }
    }

    @Test
    void removeElementLastAndThirdPosition() {
        Array<Car> cars = new Array<>(5);
        cars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.remove(4);
        cars.remove(3);

        Array<Car> expectedCars = new Array<>(4);
        expectedCars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));

        for(int i = 0; i < cars.size(); i++){
            assertEquals(expectedCars.get(i), cars.get(i));
        }
    }

    @Test
    void removeElementDontPosition() {
        Array<Car> cars = new Array<>(5);
        cars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        assertThrows(IndexOutOfBoundsException.class, ()->  cars.remove(5));
    }


    @Test
    void removeElement() {
        Car fiatPunto = new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10));
        Array<Car> cars = new Array<>(5);
        cars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.remove(fiatPunto);
        Array<Car> expectedCars = new Array<>(4);
        expectedCars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        for(int i = 0; i < cars.size(); i++){
            assertEquals(expectedCars.get(i), cars.get(i));
        }
    }

    @Test
    void testToString() {
        Array<Car> cars = new Array<>(4);
        cars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        assertEquals("{ size = 4, array = [ Car[name=Opel, plate=ATX514, year=2021-04-10],Car[name=OpelNew, plate=ATX514New, year=2021-04-10],Car[name=Fiat Multipla, plate=ATX5421, year=2021-04-10],Car[name=Alfaromeo mito, plate=ATX5421, year=2021-04-10] ] }", cars.toString());
    }


    @Test
    void insertInPositionElement() {
        Array<Car> cars = new Array<>(5);
        cars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        Car fiatPunto = new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10));
        cars.insert(fiatPunto,1);
        Array<Car> expectedCars = new Array<>(4);
        expectedCars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        for(int i = 0; i < cars.size(); i++){
            assertEquals(expectedCars.get(i), cars.get(i));
        }
    }

    @Test
    void insertInPositionFirstElement() {
        Array<Car> cars = new Array<>(5);
        cars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        Car fiatPunto = new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10));
        cars.insert(fiatPunto,0);
        Array<Car> expectedCars = new Array<>(4);
        expectedCars.add(new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        for(int i = 0; i < cars.size(); i++){
            assertEquals(expectedCars.get(i), cars.get(i));
        }
    }


    @Test
    void insertInPositionLastElement() {
        Array<Car> cars = new Array<>(5);
        cars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        cars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        Car fiatPunto = new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10));
        cars.insert(fiatPunto,3);
        Array<Car> expectedCars = new Array<>(4);
        expectedCars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        expectedCars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
        for(int i = 0; i < cars.size(); i++){
            assertEquals(expectedCars.get(i), cars.get(i));
        }
    }

//    @Test
//    void insertInPositionGrowElement() {
//        Array<Car> cars = new Array<>(4);
//        cars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
//        cars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
//        cars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
//        cars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
//        Car fiatPunto = new Car("Fiat Punto", "ATX5421", LocalDate.of(2021, Month.APRIL,10));
//        cars.insert(fiatPunto,1);
//        Array<Car> expectedCars = new Array<>(4);
//        expectedCars.add(new Car("Opel", "ATX514", LocalDate.of(2021, Month.APRIL,10)));
//        expectedCars.add(new Car("OpelNew", "ATX514New", LocalDate.of(2021, Month.APRIL,10)));
//        expectedCars.add(new Car("Fiat Multipla", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
//        expectedCars.add(new Car("Alfaromeo mito", "ATX5421", LocalDate.of(2021, Month.APRIL,10)));
//        for(int i = 0; i < cars.size(); i++){
//            assertEquals(expectedCars.get(i), cars.get(i));
//        }
//    }


    @Test
    void basicOrder() {
        Array<Integer> ints = new Array<>(5);
        ints.add(40);
        ints.add(10);
        ints.add(20);
        ints.add(90);
        ints.add(2);
        ints.sorting(obj -> {
            for (int i = 1; i < obj.size(); i++) {
                Integer element = obj.get(i);
                int j = i;
                while (j > 0 && obj.get(j - 1) > element) {
                    obj.set(obj.get(j - 1), j);
                    j--;
                }
                obj.set(element, j);
            }
        });
        assertEquals("{ size = 5, array = [ 2,10,20,40,90 ] }", ints);
    }

}
