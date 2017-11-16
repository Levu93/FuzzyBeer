package domen;
public class Beer {

	private String naziv;
	private String alkohol;
	private String proizvodjac;
	private String zemlja;
	private String info;
	private String stil;
	
	public Beer(){
		
	}
	

	public Beer(String naziv, String alkohol, String proizvodjac,
			String zemlja, String info, String stil) {
		super();
		this.naziv = naziv;
		this.alkohol = alkohol;
		this.proizvodjac = proizvodjac;
		this.zemlja = zemlja;
		this.info = info;
		this.stil = stil;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAlkohol() {
		return alkohol;
	}

	public void setAlkohol(String alkohol) {
		this.alkohol = alkohol;
	}

	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public String getZemlja() {
		return zemlja;
	}

	public void setZemlja(String zemlja) {
		this.zemlja = zemlja;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	public String getStil() {
		return stil;
	}


	public void setStil(String stil) {
		this.stil = stil;
	}


	public String toString(){
		return naziv;
	}
}
