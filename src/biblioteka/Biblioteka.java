package biblioteka;

import java.util.LinkedList;

import biblioteka.interfejs.BibliotekaInterface;

public class Biblioteka implements BibliotekaInterface {

	private LinkedList<Knjiga> knjige = new LinkedList<>();

	@Override
	public void dodajKnjigu(Knjiga knjiga) {

		if (knjiga == null)
			throw new NullPointerException("Knjiga ne smije biti null.");
		if (knjige.contains(knjiga))
			throw new RuntimeException("Knjiga vec postoji");

		knjige.add(knjiga);

	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		if (knjiga == null || !knjige.contains(knjiga))
			throw new RuntimeException("Knjiga ne smije biti null i mora postojati u bibilioteci.");

		knjige.remove(knjiga);

	}

	@Override
	public LinkedList<Knjiga> vratiSveKnjige() {
		return knjige;
		// bolje je nemati metodu koja vraca sve, vratiti neki klon ili vratiti samo dio
		// kolekcije
	}

	@Override
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String izdavac) {
		if (autor == null && isbn == null && naslov == null && izdavac == null)

			throw new RuntimeException("Morate unijeti bar jedan kriterijum pretrage.");

		LinkedList<Knjiga> rezultat = new LinkedList<>();

		for (Knjiga knjiga : knjige) {
			if (knjiga.getNaslov().contains(naslov)) {
				rezultat.add(knjiga);
			}
		}
		return rezultat;
	}

}
