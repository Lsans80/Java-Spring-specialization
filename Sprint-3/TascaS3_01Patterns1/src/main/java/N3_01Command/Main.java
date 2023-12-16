package N3_01Command;

import N3_01Command.Orders.Accelerate;
import N3_01Command.Orders.SlowDown;
import N3_01Command.Orders.StartUp;
import N3_01Command.Orders.OrderVehicle;
import N3_01Command.Parking.*;

public class Main {

    public static void main (String [] args){

        Vehicle car = new Car();
        Vehicle bicycle = new Bicycle();
        Vehicle plane = new Plane();
        Vehicle boat = new Boat();

        //Instancia invoker class.
        OrderVehicle orders = new OrderVehicle();

        //Se establecen los comandos para cada vehículo y se ejecutan.
        executeOrdersforVehicle(orders,car);
        executeOrdersforVehicle(orders,bicycle);
        executeOrdersforVehicle(orders,plane);
        executeOrdersforVehicle(orders,boat);
    }

    public static void executeOrdersforVehicle(OrderVehicle orders, Vehicle vehicle){

        orders.setStartUp(new StartUp(vehicle));
        orders.setAccelerate(new Accelerate(vehicle));
        orders.setSlowDown(new SlowDown(vehicle));

        orders.executeStartUp();
        orders.executeAccelerate();
        orders.executeSlowDown();
    }
}
