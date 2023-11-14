package n1_01Meses;

public class Mes implements Comparable<Mes> {

	private String mes;

	public Mes(String mes) {

		this.mes = mes;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	@Override
	public int compareTo(Mes o) {
		
		int compare = this.mes.compareTo(o.mes);
		
		return compare;
	}

	@Override
	public String toString() {
		return "Mes [mes=" + mes + "]";
	}

}
