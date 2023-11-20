package N3_01Command2.Parking;

//Concrete class implementing the Order interface.
public class Boat implements Vehicle {
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
