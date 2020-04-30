import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		EncryptDecrypt CrypticObject = new EncryptDecrypt();
		Scanner sc = new Scanner(System.in);
		boolean pruef = false;
		do {

			System.out.println("Wollen sie Entschl�sseln oder Verschl�sseln? (Entschl�sseln = 1; Verschl�sseln = 2): ");
			int auswahl = sc.nextInt();
			sc.nextLine();
			switch (auswahl) {
			case 1: 
				System.out.println("Geben sie die zu Entschl�sselnde Nachricht ein: ");
				CrypticObject.setNachricht(sc.nextLine());
				System.out.println("Geben sie den Schl�ssel ein (1-129): ");
				CrypticObject.setSchl�ssel(sc.nextInt());
				String l�sung1 = CrypticObject.decryptMessage(CrypticObject.getNachricht(), CrypticObject.getSchl�ssel());

				System.out.println("Entschl�sselte Nachricht: " + l�sung1);
				pruef = true;
				break;
		case 2:
				System.out.println("Geben sie die zu Verschl�sselnde Nachricht ein: ");
				CrypticObject.setNachricht(sc.nextLine());
				System.out.println("Geben sie den Schl�ssel ein: ");
				CrypticObject.setSchl�ssel(sc.nextInt());
				String l�sung2 = CrypticObject.encryptMessage(CrypticObject.getNachricht(), CrypticObject.getSchl�ssel());

				System.out.println("Verschl�sselte Nachricht: " + l�sung2);
				pruef = true;
				break;

			default:
				System.out.println("Ung�ltige Eingabe");
				pruef = false;
				break;

			}

		} while (pruef == false); 
				
		sc.close();
	}
}