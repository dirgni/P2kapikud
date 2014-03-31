package object;

public class Ajakirjanik {
	private int id;
	private String eesnimi;
	private String perenimi;
	private String roll;
	
	public Ajakirjanik() {
		super();
	}
	
	public Ajakirjanik(int id, String eesnimi, String perenimi, String roll) {
		super();
		this.id = id;
		this.eesnimi = eesnimi;
		this.perenimi = perenimi;
		this.roll = roll;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEesnimi() {
		return eesnimi;
	}
	public void setEesnimi(String eesnimi) {
		this.eesnimi = eesnimi;
	}
	public String getPerenimi() {
		return perenimi;
	}
	public void setPerenimi(String perenimi) {
		this.perenimi = perenimi;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
}
