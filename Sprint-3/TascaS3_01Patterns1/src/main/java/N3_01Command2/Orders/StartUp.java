package N3_01Command2.Orders;

import N3_01Command2.Parking.Vehicle;
//Concrete class, receiver.
public class StartUp implements Order{

    private Vehicle vehicle;

    public StartUp(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.startUp();
    }
}
