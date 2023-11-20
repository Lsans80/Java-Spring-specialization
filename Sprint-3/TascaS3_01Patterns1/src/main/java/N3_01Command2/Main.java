package N3_01Command2;

import N3_01Command2.Orders.Accelerate;
import N3_01Command2.Orders.Order;
import N3_01Command2.Orders.SlowDown;
import N3_01Command2.Orders.StartUp;
import N3_01Command2.Parking.Plane;
import N3_01Command2.Parking.Bicycle;
import N3_01Command2.Parking.Boat;
import N3_01Command2.Parking.Car;

public class Main {

    public static void main (String [] args){

        //Instanciamos clases.
        Car car = new Car();
        Bicycle bicycle = new Bicycle();
        Plane plane = new Plane();
        Boat boat = new Boat();

        //Instancia invoker class.
        OrderVehicle order = new OrderVehicle();

        //Instancia de comandos para cada vehículo.
        Order startUpCar = new StartUp(car);
        Order accelerateCar = new Accelerate(car);
        Order slowDownCar = new SlowDown(car);

        Order startUpBicycle = new StartUp(bicycle);
        Order acceleratBicyclee = new Accelerate(bicycle);
        Order slowDownBicycle = new SlowDown(bicycle);

        Order startUpPlane = new StartUp(plane);
        Order acceleratePlane = new Accelerate(plane);
        Order slowDownPlane = new SlowDown(plane);

        Order startUpBoat = new StartUp(boat);
        Order accelerateBoat = new Accelerate(boat);
        Order slowDownBoat = new SlowDown(boat);

        //Se establece el comando y se ejecuta.
        order.setStartUp(startUpCar);
        order.executeStartUp();

        order.setStartUp(startUpBicycle);
        order.executeStartUp();

    }
}
