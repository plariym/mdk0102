

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    private ParkingLot parkingLot;
    private static int totalCarsParked;

    @BeforeAll
    static void initTotalCarsParked() {
        totalCarsParked = 0;
        System.out.println("Инициализация общего счётчика: totalCarsParked = " + totalCarsParked);
    }

    @BeforeEach
    void setUp() {
        parkingLot = new ParkingLot(50, 100.0);
        System.out.println("Создана новая парковка: 50 мест, тариф 100 руб/час");
    }

    //Задание 1
    @Test
    void testInitialAvailableSpaces() {
        assertEquals(50, parkingLot.getAvailableSpaces(),
                "После создания должно быть 50 свободных мест");
    }

    //Задание 2
    @Test
    void testParkOneCar() {
        boolean parked = parkingLot.parkCar();
        assertTrue(parked, "Машина должна успешно припарковаться");
        assertEquals(49, parkingLot.getAvailableSpaces(),
                "После парковки 1 машины свободных мест должно стать 49");
    }

    @Test
    void testCalculatePaymentForThreeHours() {
        double payment = parkingLot.calculatePayment(3);
        assertEquals(300.0, payment, 0.001,
                "Оплата за 3 часа по тарифу 100 руб/час должна быть 300 руб");
    }

    //Задание 3
    @Test
    void testTotalCarsParkedIncrement() {
        // Паркуем 3 машины
        parkingLot.parkCar();
        parkingLot.parkCar();
        parkingLot.parkCar();
    }

    @AfterEach
    void checkTotalCarsParked(TestInfo testInfo) {
        System.out.println("После теста \"" + testInfo.getDisplayName() +
                "\" totalCarsParked = " + totalCarsParked);
    }

    @Test
    @DisplayName("Парковка 5 машин и проверка увеличения счётчика")
    void testMultipleParkingAndCounter() {
        int carsToPark = 5;
        for (int i = 0; i < carsToPark; i++) {
            parkingLot.parkCar();
        }
    }

    @AfterAll
    static void printTotalCarsParked() {
        System.out.println("Общее количество припаркованных машин за все тесты: " + totalCarsParked);
    }
}