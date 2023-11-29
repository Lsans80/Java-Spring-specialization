package N1_01Observer;

public interface Observable {

    void registerObserver(Observer observer);
    void removeObserver (Observer observer);
    void listObserver ();
    void notifyObservers ();
}
