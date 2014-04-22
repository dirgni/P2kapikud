package object;

public class Kommentaar {
	private int id;
	private int uudisId;
	private String nimi;
	private String tekst;
	private String kell;
	private String kuupäev;
	
	public Kommentaar() {
		super();
	}

	public Kommentaar(int id, String nimi, String tekst, String kell, String kuupäev) {
		super();
		this.id = id;
		this.uudisId = uudisId;
		this.nimi = nimi;
		this.tekst = tekst;
		this.kell = kell;
		this.kuupäev = kuupäev;
	}

	public int getUudisId() {
		return uudisId;
	}
	public void setUudisId(int uudisId) {
		this.uudisId = uudisId;
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
	public String getKell() {
		return kell;
	}
	public void setKell(String kell) {
		this.kell = kell;
	}
	public String getKuupäev() {
		return kuupäev;
	}
	public void setKuupäev(String kuupäev) {
		this.kuupäev = kuupäev;
	}
}
