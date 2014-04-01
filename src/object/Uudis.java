package object;

import java.util.ArrayList;

public class Uudis {
	private int id;
	private String pealkiri;
	private ArrayList<String> tekst;
	private String pilt;
	private int ajakirjanikId;
	private String kell;
	private String kuupäev;
	private int kommentaare;
	private ArrayList<String> tagid;
	
	public Uudis() {
		super();
	}

	public Uudis(int id, String pealkiri, ArrayList<String> tekst, String pilt,
			int ajakirjanikId, String kell, String kuupäev, int kommentaare,
			ArrayList<String> tagid) {
		super();
		this.id = id;
		this.pealkiri = pealkiri;
		this.tekst = tekst;
		this.pilt = pilt;
		this.ajakirjanikId = ajakirjanikId;
		this.kell = kell;
		this.kuupäev = kuupäev;
		this.kommentaare = kommentaare;
		this.tagid = tagid;
	}

	public int getKommentaare() {
		return kommentaare;
	}

	public void setKommentaare(int kommentaare) {
		this.kommentaare = kommentaare;
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
	public ArrayList<String> getTekst() {
		return tekst;
	}
	public void setTekst(ArrayList<String> tekst) {
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
	public ArrayList<String> getTagid() {
		return tagid;
	}
	public void setTagid(ArrayList<String> tagid) {
		this.tagid = tagid;
	}
}
