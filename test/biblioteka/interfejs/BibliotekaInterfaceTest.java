package biblioteka.interfejs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import biblioteka.Knjiga;

public abstract class BibliotekaInterfaceTest {

	protected BibliotekaInterface biblioteka;
	
	@Test
	void testDodajKnjigu() {
		Knjiga k = new Knjiga();
		k.setNaslov("Knjiga 1");
		
		biblioteka.dodajKnjigu(k);
		
		assertEquals(1, biblioteka.vratiSveKnjige().size());
		assertEquals(k,biblioteka.vratiSveKnjige().get(0));
	}

	@Test
	void testDodajKnjiguNull() {
		assertThrows(java.lang.NullPointerException.class, ()-> biblioteka.dodajKnjigu(null));
	}
	
	@Test
	void testDodajKnjiguDuplikat() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		Knjiga k2 = new Knjiga();
		k2.setIsbn("12345");
		
		biblioteka.dodajKnjigu(k);
		RuntimeException e = assertThrows(java.lang.RuntimeException.class, () -> biblioteka.dodajKnjigu(k2));
		
		assertEquals("Knjiga vec postoji", e.getMessage());
	}
	
	@Test
	void testObrisiKnjigu() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		
		biblioteka.dodajKnjigu(k);
		
		biblioteka.obrisiKnjigu(k);
		
		assertEquals(0, biblioteka.vratiSveKnjige().size());
	}

	@Test
	void testObrisiKnjiguNull() {
		assertThrows(java.lang.NullPointerException.class, () -> biblioteka.obrisiKnjigu(null));
	}
	
	@Test
	void testObrisiKnjiguNePostoji() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		
		biblioteka.dodajKnjigu(k);
		Knjiga k2 = new Knjiga();
		k.setIsbn("12345213");
		
		assertThrows(java.lang.RuntimeException.class, () -> biblioteka.obrisiKnjigu(k2));
	}
	@Test
	void testVratiSveKnjige() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		
		biblioteka.dodajKnjigu(k);
		
		List<Knjiga> knjige = biblioteka.vratiSveKnjige();
		assertEquals(1, knjige.size());
		assertEquals(k, knjige.get(0));
	}

	@Test
	void testPronadjiKnjigu() {
		Knjiga k1 = new Knjiga();
		k1.setIsbn("1234");
		k1.setNaslov("Knjiga o dzungli");

		Knjiga k2 = new Knjiga();
		k2.setNaslov("Dzungla zivota");
		k2.setIsbn("5678");
		Knjiga k3 = new Knjiga();
		k3.setNaslov("Evgenija Onjegin");
		k3.setIsbn("91011");;
		biblioteka.dodajKnjigu(k1);
		biblioteka.dodajKnjigu(k2);
		biblioteka.dodajKnjigu(k3);
		//prethodno bi se moglo ubaciti i u set up
		List<Knjiga> rezultat = biblioteka.pronadjiKnjigu(null, null, "zung", null);
		assertEquals(2, rezultat.size());
		assertTrue(rezultat.contains(k1));
		assertTrue(rezultat.contains(k2));
	}
	
	@Test
	void testPronadjiKnjiguNull() {
		assertThrows(java.lang.RuntimeException.class, () -> biblioteka.pronadjiKnjigu(null, null, null, null));
	}

}
