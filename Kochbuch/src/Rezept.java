import java.util.Arrays;
import java.util.Collection;

public class Rezept {

	String name;
	int zDauer;
	String anweisungen;
	Collection<Zutaten> Zutaten;

	public Rezept(String name, int zDauer, String anweisungen, Collection<Zutaten> Zutaten) {
		this.name = name;
		this.zDauer = zDauer;
		this.anweisungen = anweisungen;
		this.Zutaten = Zutaten;
	}

	public Rezept() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getzDauer() {
		return zDauer;
	}

	public void setzDauer(int zDauer) {
		this.zDauer = zDauer;
	}

	public String getAnweisungen() {
		return anweisungen;
	}

	public void setAnweisungen(String anweisungen) {
		this.anweisungen = anweisungen;
	}

	public Collection<Zutaten> getZutaten() {
		return Zutaten;
	}

	public void setZutaten(Collection<Zutaten> zutaten) {
		Zutaten = zutaten;
	}

	@Override
	public String toString() {
		return "Rezept: " + name + "\n" + "Zubereitungsdauer in Minuten: " + zDauer + "\n" + "Erforderliche Zutaten: "
				+ Arrays.toString(Zutaten.toArray()) + "\n" + "Zubereitung: " + "\n" + anweisungen;

	}

}
