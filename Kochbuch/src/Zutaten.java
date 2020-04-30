
public class Zutaten {
	String name;
	int menge;
	String einheit;
	int kalorien;

	public Zutaten(String name, int menge, String einheit, int kalorien) {
		this.name = name;
		this.menge = menge;
		this.einheit = einheit;
		this.kalorien = kalorien;
	}

	public Zutaten() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	public String getEinheit() {
		return einheit;
	}

	public void setEinheit(String einheit) {
		this.einheit = einheit;
	}

	public int getKalorien() {
		return kalorien;
	}

	public void setKalorien(int kalorien) {
		this.kalorien = kalorien;
	}

	@Override
	public String toString() {
		return menge + " " + einheit + " " + name + "(" + kalorien + "kCal)";

	}

}
