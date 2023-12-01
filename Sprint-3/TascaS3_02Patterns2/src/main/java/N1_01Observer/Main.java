package N1_01Observer;

public class Main {

    public static void main (String [] args){

        Agent agent = new Agent("10.416,60");

        Agency Bcn = new Agency("BarnaBrokers");
        Agency Mad = new Agency("MadridBrokers");
        Agency USA = new Agency("USABrokers");

        agent.registerObserver(Bcn);
        agent.registerObserver(Mad);
        agent.registerObserver(USA);

        agent.listObserver();

        agent.setIbex35("10.987,90");
        agent.setIbex35("9.987,90");

        agent.removeObserver(Mad);
        agent.listObserver();

    }
}
