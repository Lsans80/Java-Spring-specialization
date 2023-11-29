package N3_01Command.Parking;

//Concrete class implementing the Order interface.
public class Bicycle implements Vehicle {
    @Override
    public void startUp() {

        System.out.println("Bicycle starting up!");

    }

    @Override
    public void accelerate() {

        System.out.println("Bicycle speeding up!");


    }

    @Override
    public void slowDown() {

        System.out.println("Bicycle slowing down!");


    }
}
