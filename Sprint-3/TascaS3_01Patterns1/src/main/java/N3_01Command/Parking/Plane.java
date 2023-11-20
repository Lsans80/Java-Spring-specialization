package N3_01Command.Parking;

import N3_01Command.Order;

public class Plane implements Order {
    @Override
    public void startUp() {

        System.out.println("Plane starting up!");

    }

    @Override
    public void accelerate() {

        System.out.println("Plane speeding up!");

    }

    @Override
    public void slowDown() {

        System.out.println("Plane slowing down!");

    }
}
