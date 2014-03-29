package object;

public class Ajakirjanik {
	private int id;
	private String nimi;
	
	public Ajakirjanik() {
		super();
	}

	public Ajakirjanik(int id, String nimi) {
		super();
		this.id = id;
		this.nimi = nimi;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
}
