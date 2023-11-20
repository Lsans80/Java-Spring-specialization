package N3_01Command2.Orders;

import N3_01Command2.Parking.Vehicle;
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
