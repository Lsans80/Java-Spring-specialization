package n1_01Nogenerico;

public class MetodoNogenerico {

    private Persona objeto1;
    private Persona objeto2;
    private Persona objeto3;

    public MetodoNogenerico(Persona objeto1, Persona objeto2, Persona objeto3) {
        this.objeto1 = objeto1;
        this.objeto2 = objeto2;
        this.objeto3 = objeto3;
    }

    public Persona getObjeto1() {
        return objeto1;
    }

    public void setObjeto1(Persona objeto1) {
        this.objeto1 = objeto1;
    }

    public Persona getObjeto2() {
        return objeto2;
    }

    public void setObjeto2(Persona objeto2) {
        this.objeto2 = objeto2;
    }

    public Persona getObjeto3() {
        return objeto3;
    }

    public void setObjeto3(Persona objeto3) {
        this.objeto3 = objeto3;
    }

    @Override
    public String toString() {
        return "MetodoNogenerico{" +
                "objeto1=" + objeto1 +
                ", objeto2=" + objeto2 +
                ", objeto3=" + objeto3 +
                '}';
    }
}
