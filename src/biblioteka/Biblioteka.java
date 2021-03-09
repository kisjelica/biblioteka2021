package biblioteka;

import java.util.LinkedList;

import biblioteka.interfejs.BibliotekaInterface;

public class Biblioteka implements BibliotekaInterface {

	private LinkedList<Knjiga> knjige = new LinkedList<>();
	
	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		knjige.add(knjiga);

	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		knjige.remove(knjiga);
		
	}

	@Override
	public LinkedList<Knjiga> vratiSveKnjige() {
		return knjige;
		//bolje je nemati metodu koja vraca sve, vratiti neki klon ili vratiti samo dio kolekcije
	}

	@Override
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String izdavac) {
		LinkedList<Knjiga> rezultat = new LinkedList<>();
		
		for (Knjiga knjiga : knjige) {
			if(knjiga.getNaslov().contains(naslov)) {
				rezultat.add(knjiga);
			}
		}
		return rezultat;
	}

}
