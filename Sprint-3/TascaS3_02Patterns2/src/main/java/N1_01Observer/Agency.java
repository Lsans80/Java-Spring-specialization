package N1_01Observer;

public class Agency implements Observer {

    private String name;

    public Agency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(String ibex35) {

        System.out.println("Hi! Check the new update for ibex35: " + ibex35);

    }

    @Override
    public String toString() {
        return "N1_01Observer.Agency{" +
                "name='" + name + '\'' +
                '}';
    }
}
