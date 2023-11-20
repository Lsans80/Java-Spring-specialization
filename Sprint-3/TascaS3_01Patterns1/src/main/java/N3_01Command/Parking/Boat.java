package N3_01Command.Parking;

import N3_01Command.Order;
//Concrete class implementing the Order interface.
public class Boat implements Order {
    @Override
    public void startUp() {

        System.out.println("Boat starting up!");
    }

    @Override
    public void accelerate() {

        System.out.println("Boat speeding up!");

    }

    @Override
    public void slowDown() {

        System.out.println("Boat slowing down!");


    }
}
