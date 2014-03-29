package object;

public class Uudis {
	private int id;
	private String pealkiri;
	private String[] tekst;
	private String pilt;
	private int ajakirjanikId;
	private String aeg;
	
	public Uudis() {
		super();
	}
	
	public Uudis(int id, String pealkiri, String[] tekst, String pilt,
			int ajakirjanikId, String aeg) {
		super();
		this.id = id;
		this.pealkiri = pealkiri;
		this.tekst = tekst;
		this.pilt = pilt;
		this.ajakirjanikId = ajakirjanikId;
		this.aeg = aeg;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPealkiri() {
		return pealkiri;
	}
	public void setPealkiri(String pealkiri) {
		this.pealkiri = pealkiri;
	}
	public String[] getTekst() {
		return tekst;
	}
	public void setTekst(String[] tekst) {
		this.tekst = tekst;
	}
	public String getPilt() {
		return pilt;
	}
	public void setPilt(String pilt) {
		this.pilt = pilt;
	}
	public int getAjakirjanikId() {
		return ajakirjanikId;
	}
	public void setAjakirjanikId(int ajakirjanikId) {
		this.ajakirjanikId = ajakirjanikId;
	}
	public String getAeg() {
		return aeg;
	}
	public void setAeg(String aeg) {
		this.aeg = aeg;
	}
}
