package N3_01Command;

import N3_01Command.Parking.Bicycle;
import N3_01Command.Parking.Boat;
import N3_01Command.Parking.Car;
import N3_01Command.Parking.Plane;

public class Main {

    public static void main (String [] args){

        Car car = new Car();
        Bicycle bicycle = new Bicycle();
        Plane plane = new Plane();
        Boat boat = new Boat();

        OrderVehicle ordersCar = new OrderVehicle(car);
        OrderVehicle ordersBicycle = new OrderVehicle(bicycle);
        OrderVehicle ordersPlane = new OrderVehicle(plane);
        OrderVehicle ordersBoat = new OrderVehicle(boat);

        ordersCar.executeStartUp();
        ordersCar.executeAccelerate();
        ordersCar.executeSlowDown();

        ordersBicycle.executeStartUp();
        ordersBicycle.executeAccelerate();
        ordersBicycle.executeSlowDown();

        ordersBoat.executeStartUp();
        ordersBoat.executeAccelerate();
        ordersBoat.executeSlowDown();

        ordersPlane.executeStartUp();
        ordersPlane.executeAccelerate();
        ordersPlane.executeSlowDown();



    }
}
