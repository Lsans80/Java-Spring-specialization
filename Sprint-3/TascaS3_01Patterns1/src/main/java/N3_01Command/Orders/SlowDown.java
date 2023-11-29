package N3_01Command.Orders;

import N3_01Command.Parking.Vehicle;
//Concrete class, receiver.
public class SlowDown implements Order{

    private Vehicle vehicle;

    public SlowDown(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {

        vehicle.slowDown();
    }
}
