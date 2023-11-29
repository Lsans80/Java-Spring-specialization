package N3_01Command.Parking;

public class Plane implements Vehicle {
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
