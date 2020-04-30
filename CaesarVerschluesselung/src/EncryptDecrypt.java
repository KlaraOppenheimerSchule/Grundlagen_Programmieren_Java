
public class EncryptDecrypt {

	String nachricht;
	int schl�ssel;

	public EncryptDecrypt() {

	}

	public String getNachricht() {
		return nachricht;
	}

	public void setNachricht(String nachricht) {
		this.nachricht = nachricht;
	}

	public int getSchl�ssel() {
		return schl�ssel;
	}

	public void setSchl�ssel(int schl�ssel) {
		this.schl�ssel = schl�ssel;
	}

	public String encryptMessage(String nachricht, int schl�ssel) {
		// nachricht = nachricht.toUpperCase();
		nachricht = nachricht.replaceAll("\\s", "");
		char[] neu = nachricht.toCharArray();

		for (int i = 0; i < neu.length; i++) {
			char c = neu[i];
			if (Character.isUpperCase(c)) {
				c = (char) ((c - 65 + schl�ssel) % 26 + 65);
				neu[i] = c;
				
			}
			if (Character.isLowerCase(c)) {
				c = (char) ((c - 97 + schl�ssel) % 26 + 97);
				neu[i] = c;

			}  

		}
		String returnValue = new String(neu);
		return returnValue;
	}

	public String decryptMessage(String nachricht, int schl�ssel) {
		// nachricht = nachricht.toUpperCase();
		nachricht = nachricht.replaceAll("\\s", "");
		char[] neu = nachricht.toCharArray();

		for (int i = 0; i < neu.length; i++) {
			char c = neu[i];

			if (Character.isUpperCase(c)) {
				c = (char) ((c - 39 - schl�ssel) % 26 + 65);
				neu[i] = c;
				
			}
			if (Character.isLowerCase(c)) {
				c = (char) ((c - 71 - schl�ssel) % 26 + 97);
				neu[i] = c;
			} 

		}
		String returnValue = new String(neu);
		return returnValue;
	}
}
