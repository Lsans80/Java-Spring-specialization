package N3_01Command.Orders;

import N3_01Command.Parking.Vehicle;
//Concrete class, receiver.
public class Accelerate implements Order{

    private Vehicle vehicle;

    public Accelerate(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {

        vehicle.accelerate();

    }
}
