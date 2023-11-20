package N3_01Command2.Parking;

//Concrete class implementing the Order interface.
public class Car implements Vehicle {

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
