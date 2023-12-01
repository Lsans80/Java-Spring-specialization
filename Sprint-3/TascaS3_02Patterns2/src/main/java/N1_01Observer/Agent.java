package N1_01Observer;

import java.util.ArrayList;
import java.util.List;

public class Agent implements Observable{
    private final List<Observer> agencies = new ArrayList<>();
    private String ibex35;

    public Agent(String ibex35) {

        this.ibex35 = ibex35;
    }

    public String getIbex35() {
        return ibex35;
    }

    public void setIbex35(String ibex35) {
        this.ibex35 = ibex35;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {

        agencies.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {

        agencies.remove(observer);
        System.out.println("La agencia " + observer.getName() + " ha sido eliminado.");

    }

    @Override
    public void listObserver() {

        agencies.forEach(System.out::println);

    }

    @Override
    public void notifyObservers() {

        agencies.forEach(agency -> agency.update(ibex35));

    }
}
