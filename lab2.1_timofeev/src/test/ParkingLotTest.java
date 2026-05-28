package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParkingLotTest {
//    @BeforeEach
//    void setUp(){
//        int parkingLot = new ParkingLot(50,2.5).getAvailableSpaces();
//        if (parkingLot>=50)
//            System.out.println("Свободно 50 парковочных мест");
//        else {
//            System.out.println("Парковочных мест меньше 50");
//        }
//    }

    @Test
    void leaveCar() {
    }

    @Test
    void calculatePayment() {
        int calculate = new ParkingLotTest().calculatePayment(5);
    }

    @Test
    void getAvailableSpaces() {
    }

    @BeforeEach
    void testParkCar() {
        int car = 1;
        int parkingLot =50;
        if (car < parkingLot){
            parkingLot--;

        }
        System.out.println("Осталось свободных мест "+parkingLot+", препорковалось машин: "+car);
    }
}