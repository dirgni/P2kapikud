package object;

public class Kommentaar {
	private int id;
	private String nimi;
	private String tekst;
	private String aeg;
	
	public Kommentaar() {
		super();
	}

	public Kommentaar(int id, String nimi, String tekst, String aeg) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.tekst = tekst;
		this.aeg = aeg;
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
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	public String getAeg() {
		return aeg;
	}
	public void setAeg(String aeg) {
		this.aeg = aeg;
	}
}
