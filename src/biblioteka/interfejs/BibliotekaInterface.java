package biblioteka.interfejs;

import java.util.LinkedList;

import biblioteka.Autor;
import biblioteka.Knjiga;
/**
 * Interfejs koji predstavlja biblioteku.
 * @author rastko
 *
 */
public interface BibliotekaInterface {
	/**
	 * Dodaje novu knjigu u biblioteku.
	 * @param knjiga Knjiga koja se dodaje.
	 * @throws java.lang.NullPointerException  ako je knjiga null
	 * @throws java.lang.RuntimeException ako knjiga vec postoji
	 */
	public void dodajKnjigu(Knjiga knjiga);
	/**
	 * Brise knjigu iz biblioteke.
	 * @param knjiga Knjiga koja se brise iz biblioteke.
	 */
	public void obrisiKnjigu(Knjiga knjiga);
	
	public LinkedList<Knjiga> vratiSveKnjige();
	
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String izdavac);
	
}
