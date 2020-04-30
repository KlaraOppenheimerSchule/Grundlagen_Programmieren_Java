import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Zutaten Wasser = new Zutaten("Wasser", 50, "ml", 0);
		Zutaten Salz = new Zutaten("Salz", 1, "prise", 0);
		Zutaten Nudel = new Zutaten("Nudel", 50, "g", 68);
		Zutaten TomatPass = new Zutaten("Passierte Tomaten", 50, "g", 19);
		Zutaten ItalKr = new Zutaten("Italienische Kräuter", 5, "g", 10);
		Zutaten Schinken = new Zutaten("Kochschinken", 10, "g", 15);

		Collection<Zutaten> Rezept1Zutaten = new ArrayList<Zutaten>();
		int kalorien = 0;
		System.out.println("Bitte Wählen sie ein Rezept (Napolinudeln = 1, Schinkennudeln = 2)");
		int auswahl = sc.nextInt();
		switch (auswahl) {
		case 1:
			Wasser.setEinheit("l");
			Wasser.setMenge(3);
			Rezept1Zutaten.add(Wasser);
			Salz.setMenge(3);
			Rezept1Zutaten.add(Salz);
			TomatPass.setMenge(100);
			Rezept1Zutaten.add(TomatPass);
			Rezept1Zutaten.add(ItalKr);
			Nudel.setMenge(250);
			Nudel.setKalorien(300);
			Rezept1Zutaten.add(Nudel);
			String napoliZubereitung = "Zuerst wird ein Topf mit 3 Liter Wasser und 2 Prisen Salz aufgesetzt.Gleichzeitig wird in einem zweiten Topf 100g passierte Tomaten erhitzt.Diese werden mit einer Prise Salz und 5 Gramm Italienischen Kräutern gewürzt und 10 minuten gekocht.Sobald das Nudelwasser kocht, die Nudeln bissfest (9 Minuten) kochen. Anrichten und Servieren.";
			Rezept NapoliNudeln = new Rezept("Nudeln Napoli", 20, napoliZubereitung, Rezept1Zutaten);

			for (Iterator<Zutaten> it = Rezept1Zutaten.iterator(); it.hasNext();) {
				kalorien = kalorien + it.next().getKalorien();
			}

			System.out.println(NapoliNudeln.toString());
			System.out.println("Gesamte Kalorien der Speise : " + kalorien + " kCal");
			break;
		case 2:
			Wasser.setEinheit("l");
			Wasser.setMenge(3);
			Rezept1Zutaten.add(Wasser);
			Salz.setMenge(3);
			Rezept1Zutaten.add(Salz);
			Schinken.setMenge(150);
			Schinken.setKalorien(225);
			Rezept1Zutaten.add(Schinken);
			Nudel.setMenge(250);
			Nudel.setKalorien(300);
			Rezept1Zutaten.add(Nudel);

			String schinkenZubereitung = "Zuerst wird ein Topf mit 3 Liter Wasser und 2 Prisen Salz aufgesetzt.Danach werden die Nudeln mit dem gewürfeltem Schinken in einer Pfanne angebraten und gesalzen. Danach anrichten und servieren.";
			Rezept SchinkenNudeln = new Rezept("Schinkennudeln", 15, schinkenZubereitung, Rezept1Zutaten);

			for (Iterator<Zutaten> it = Rezept1Zutaten.iterator(); it.hasNext();) {
				kalorien = kalorien + it.next().getKalorien();
			}

			System.out.println(SchinkenNudeln.toString());
			System.out.println("Gesamte Kalorien der Speise : " + kalorien + " kCal");
			break;

		default:
			System.out.println("Ungültige Auswahl");
			break;
		}

		sc.close();
	}
}
