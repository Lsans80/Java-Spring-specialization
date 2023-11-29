package N3_01Command;

import N3_01Command.Orders.Order;

//Invoker class.
public class OrderVehicle {

    private Order startUp;
    private Order accelerate;
    private Order slowDown;

    public void setStartUp(Order startUp) {
        this.startUp = startUp;
    }

    public void setAccelerate(Order accelerate) {
        this.accelerate = accelerate;
    }

    public void setSlowDown(Order slowDown) {
        this.slowDown = slowDown;
    }

    public void executeStartUp (){
        startUp.execute();
    }

    public void executeAccelerate (){
        accelerate.execute();
    }

    public void executeSlowDown (){
        slowDown.execute();
    }
}
