package valanticTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
/*Entfernt für das Programm überflüssige Satzzeichen und konvertiert alle enthaltenen Chars in Kleinschreibung*/
	public static String stringFormatieren(String s) {

		s = s.toLowerCase();
		s = s.replace(',', ' ');
		s = s.replace('!', ' ');
		s = s.replace('?', ' ');
		return s;
	}
/*Erzeugt einheitliche Datumsangaben*/
	public static String datumFormatieren(String tage, String monat) {
		switch (monat) {
		
		case "januar":
			tage = tage + "01.";
			break;
		case "februar":
			tage = tage + "02.";
			break;
		case "märz":
			tage = tage + "03.";
			break;
		case "april":
			tage = tage + "04.";
			break;
		case "mai":
			tage = tage + "05.";
			break;
		case "juni":
			tage = tage + "06.";
			break;
		case "juli":
			tage = tage + "07.";
			break;
		case "august":
			tage = tage + "08.";
			break;
		case "september":
			tage = tage + "09.";
			break;
		case "oktober":
			tage = tage + "10.";
			break;
		case "november":
			tage = tage + "11.";
			break;
		case "dezember":
			tage = tage + "12.";
			break;
		}
		return tage;
	}
	
	
/*Entnimmt aus gegebenen String alle wichtigen Informationen zu einer Reservierung*/
	public static void erkenneReservierung(String reservierung) {
		
		reservierung = stringFormatieren(reservierung);//Entfernen von Satzzeichen und kleinschreiben des Inputs
		Reservierung reservierung1 = new Reservierung();//Erzeuge neue Reservierung
		int index = 0;									//Zähler für Schleifen
		String[] arrayOfWords = reservierung.split(" ");//Array welches die einzelnen Wörtern vom Inputstring enthält

		reservierung1.setName(arrayOfWords[arrayOfWords.length - 2]+ " " //Entnimmt den Namen aus dem String, mit Annahme dass er am Ende steht
		+ arrayOfWords[arrayOfWords.length - 1]);

		if (reservierung.contains("uhr")) {	//Sucht nach dem Wort "Uhr" im String und merkt sich dessen Position

			for (int i = 0; i < arrayOfWords.length; i++) {

				if (arrayOfWords[i].contains("uhr")) {

					index = i;
					break;

				}
			}

			reservierung1.setUhrzeit(arrayOfWords[index - 1] + " Uhr"); //Setzt Uhrzeit in der Reservierung
			
			arrayOfWords[index - 1] = ""; //Löschen von bereits verwendeter Information

			reservierung = "";

			for (int i = 0; i < arrayOfWords.length; i++) {

				reservierung = reservierung + " " + arrayOfWords[i];
			}

		}
		if (reservierung.contains("am")) {	//Sucht nach dem Wort "am" im String und merkt sich dessen Position

			for (int i = 0; i < arrayOfWords.length; i++) {

				if (arrayOfWords[i].equals("am")) {

					index = i;
					break;

				}
			}
			if (arrayOfWords[index + 1].length() > 3) {	//Fallunterscheidung für verschiedene Datumsangaben, wie z.B. 01.06. oder 1. Juni

				reservierung1.setDatum(arrayOfWords[index + 1]);

			} else {

				reservierung1.setDatum(datumFormatieren(arrayOfWords[index + 1], arrayOfWords[index + 2]));
			}

			arrayOfWords[index + 1] = "";	//Löschen von bereits verwendeter Information
			reservierung = "";

			for (int i = 0; i < arrayOfWords.length; i++) {

				reservierung = reservierung + " " + arrayOfWords[i];

			}

		}

		Pattern pattern = Pattern.compile("[0-9]+");	//Sucht nach Wörtern, welche nur aus Ziffern bestehen
		Matcher matcher = pattern.matcher(reservierung);

		if (matcher.find()) {	//Wenn die Suche erfolgreich war, dann muss es sich um die Anzahl der Gäste handeln

			reservierung1.setAnzahlGaeste(Integer.parseInt((reservierung.substring(matcher.start(), matcher.end()))));

		} else {	//Ansonsten wird nach ausgeschrieben Zahlenwörtern gesucht und diese in Integer konvertiert

			for (int i = 0; i < arrayOfWords.length; i++) {

				switch (arrayOfWords[i]) {

				case "eine":
					reservierung1.setAnzahlGaeste(1);
					break;
				case "zwei":
					reservierung1.setAnzahlGaeste(2);
					break;
				case "drei":
					reservierung1.setAnzahlGaeste(3);
					break;
				case "vier":
					reservierung1.setAnzahlGaeste(4);
					break;
				case "fünf":
					reservierung1.setAnzahlGaeste(5);
					break;
				case "sechs":
					reservierung1.setAnzahlGaeste(6);
					break;
				case "sieben":
					reservierung1.setAnzahlGaeste(7);
					break;
				case "acht":
					reservierung1.setAnzahlGaeste(8);
					break;
				case "neun":
					reservierung1.setAnzahlGaeste(9);
					break;
				}
			}
		}
		//Ausgabe der Reservierung.
		System.out.println("(" + reservierung1.getName() + ", " + reservierung1.getDatum() + ", "
				+ reservierung1.getUhrzeit() + ", " + reservierung1.getAnzahlGaeste() + ")");
	}

	public static void main(String args[]) {

		erkenneReservierung(
				"Sehr geehrte Damen Herren, wir würden gern am 9. April 9:45 Uhr mit sechs Leuten zum Brunch kommen, Mit freundlichen Grüßen Maria"
						+ " Meier");

	}
}
