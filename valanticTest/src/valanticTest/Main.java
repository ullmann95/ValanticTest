package valanticTest;

public class Main {
	public static String stringFormatieren(String s) {
		
		s = s.toLowerCase();
		
		return s;
	}
	
	public static void erkenneReservierung(String reservierung) {
		reservierung = stringFormatieren(reservierung);
		Reservierung reservierung1 = new Reservierung();
		int index = 0;
		String[] arrayOfWords = reservierung.split(" ");

		reservierung1.setName(arrayOfWords[arrayOfWords.length - 2] + " " + arrayOfWords[arrayOfWords.length - 1]);
		System.out.println(reservierung1.getName());

		if (reservierung.contains("uhr")) {
			for (int i = 0; i < arrayOfWords.length; i++) {
				if (arrayOfWords[i].contains("uhr")) {
					index = i;
					break;
				}
			}
			reservierung1.setUhrzeit(arrayOfWords[index - 1] + " Uhr");
			arrayOfWords[index - 1] = "";
			System.out.println(reservierung1.getUhrzeit());
			reservierung = "";
			for (int i = 0; i < arrayOfWords.length; i++) {
				reservierung = reservierung + " " + arrayOfWords[i];
			}
			
		}
		if (reservierung.contains("am")) {
			for (int i = 0; i < arrayOfWords.length; i++) {
				if (arrayOfWords[i].equals("am")) {
					index = i;
					break;
				}
			}
			if (arrayOfWords[index + 1].length() > 3) {
				reservierung1.setDatum(arrayOfWords[index + 1]);
			} else {
				reservierung1.setDatum(arrayOfWords[index + 1] + " " + arrayOfWords[index + 2]);
			}
			arrayOfWords[index + 1]="";
			reservierung="";
			System.out.println(reservierung1.getDatum());
			for (int i = 0; i < arrayOfWords.length; i++) {
				reservierung = reservierung + " " + arrayOfWords[i];
			}
			
		}
		for (int i = 0; i < arrayOfWords.length; i++) {
			
				
			       
			switch (arrayOfWords[i]) {
			case "1":
				reservierung1.setAnzahlGaeste(1);
				;
				break;
			case "2":
				reservierung1.setAnzahlGaeste(2);
				;
				break;
			case "3":
				reservierung1.setAnzahlGaeste(3);
				;
				break;
			case "4":
				reservierung1.setAnzahlGaeste(4);
				;
				break;
			case "5":
				reservierung1.setAnzahlGaeste(5);
				;
				break;
			case "6":
				reservierung1.setAnzahlGaeste(6);
				;
				break;
			case "7":
				reservierung1.setAnzahlGaeste(7);
				;
				break;
			case "8":
				reservierung1.setAnzahlGaeste(8);
				;
				break;
			case "9":
				reservierung1.setAnzahlGaeste(9);
				;
				break;
			case "eine":
				reservierung1.setAnzahlGaeste(1);
				;
				break;
			case "zwei":
				reservierung1.setAnzahlGaeste(2);
				;
				break;
			case "drei":
				reservierung1.setAnzahlGaeste(3);
				;
				break;
			case "vier":
				reservierung1.setAnzahlGaeste(4);
				;
				break;
			case "fünf":
				reservierung1.setAnzahlGaeste(5);
				;
				break;
			case "sechs":
				reservierung1.setAnzahlGaeste(6);
				;
				break;
			case "sieben":
				reservierung1.setAnzahlGaeste(7);
				;
				break;
			case "acht":
				reservierung1.setAnzahlGaeste(8);
				;
				break;
			case "neun":
				reservierung1.setAnzahlGaeste(9);
				;
				break;
			}
		
		}
		System.out.println(reservierung1.getAnzahlGaeste());
	}

	public static void main(String args[]) {
		erkenneReservierung("Guten Tag, einen Tisch für 8 Mann am 1.5. 9 Uhr abends, Gruß Franz Schulze");
	}
}
