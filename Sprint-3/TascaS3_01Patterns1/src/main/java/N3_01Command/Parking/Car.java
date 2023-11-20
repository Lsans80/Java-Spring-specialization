package N3_01Command.Parking;

import N3_01Command.Order;
//Concrete class implementing the Order interface.
public class Car implements Order {

    @Override
    public void startUp() {

        System.out.println("Car starting up!");

    }

    @Override
    public void accelerate() {

        System.out.println("Car speeding up!");

    }

    @Override
    public void slowDown() {

        System.out.println("Car slowing down!");

    }
}
