package N3_01Command;

import N3_01Command.Orders.Accelerate;
import N3_01Command.Orders.SlowDown;
import N3_01Command.Orders.StartUp;
import N3_01Command.Parking.Plane;
import N3_01Command.Parking.Bicycle;
import N3_01Command.Parking.Boat;
import N3_01Command.Parking.Car;

public class Main {

    public static void main (String [] args){

        //Instancia clases.
        Car car = new Car();
        Bicycle bicycle = new Bicycle();
        Plane plane = new Plane();
        Boat boat = new Boat();

        //Instancia invoker class.
        OrderVehicle order = new OrderVehicle();

        //Se establece el comando para cada vehículo y se ejecuta.
        order.setStartUp(new StartUp(car));
        order.setAccelerate(new Accelerate(car));
        order.setSlowDown(new SlowDown(car));
        order.executeStartUp();
        order.executeAccelerate();
        order.executeSlowDown();

        order.setStartUp(new StartUp(bicycle));
        order.setAccelerate(new Accelerate(bicycle));
        order.setSlowDown(new SlowDown(bicycle));
        order.executeStartUp();
        order.executeAccelerate();
        order.executeSlowDown();

        order.setStartUp(new StartUp(boat));
        order.setAccelerate(new Accelerate(boat));
        order.setSlowDown(new SlowDown(boat));
        order.executeStartUp();
        order.executeAccelerate();
        order.executeSlowDown();

        order.setStartUp(new StartUp(plane));
        order.setAccelerate(new Accelerate(plane));
        order.setSlowDown(new SlowDown(plane));
        order.executeStartUp();
        order.executeAccelerate();
        order.executeSlowDown();


    }
}
