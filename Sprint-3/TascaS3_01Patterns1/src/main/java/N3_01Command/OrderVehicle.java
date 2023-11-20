package N3_01Command;
//Invoker class.
public class OrderVehicle {

    private Order order;

    public OrderVehicle(Order order) {
        this.order = order;
    }

    public void executeStartUp (){
        order.startUp();
    }

    public void executeAccelerate (){
        order.accelerate();
    }

    public void executeSlowDown (){
        order.slowDown();
    }
}
