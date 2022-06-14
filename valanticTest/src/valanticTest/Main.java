package valanticTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	/**
	 * Entfernt überflüssige Satzzeichen und konvertiert alle enthaltenen Chars zu
	 * Kleinbuchstaben.
	 */
	public static String stringFormatieren(String satz) {
		satz = satz.toLowerCase();
		satz = satz.replace(',', ' ');
		satz = satz.replace('!', ' ');
		satz = satz.replace('?', ' ');
		return satz;
	}

	/**
	 * Erzeugt einheitliche Datumsangaben.
	 */
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
		default:
			System.out.println("Es ist ein fehler aufgetreten!");
		}
		return tage;
	}

	/**
	 * Entnimmt aus gegebenen String alle wichtigen Informationen zu einer
	 * Reservierung
	 */
	public static void erkenneReservierung(String reservierung) {
		int indexUhr = 0;
		int indexAm = 0;

		// Entfernen von Satzzeichen und kleinschreiben des Inputs.
		reservierung = stringFormatieren(reservierung);
		Reservierung reservierung1 = new Reservierung();
		String[] arrayOfWords = reservierung.split(" ");

		// Prüfe auf Länge des Inputs.
		if (arrayOfWords.length >= 2) {
			reservierung1.setName(arrayOfWords[arrayOfWords.length - 2] + " " + arrayOfWords[arrayOfWords.length - 1]);
		} else {
			reservierung1.setName("Invalid Name!");
		}

		for (int i = 0; i < arrayOfWords.length; i++) {

			if (arrayOfWords[i].contains("uhr")) {
				indexUhr = i;
			} else if (arrayOfWords[i].equals("am")) {
				indexAm = i;
			}
		}

		if (indexUhr > 0) {
			reservierung1.setUhrzeit(arrayOfWords[indexUhr - 1]);
			arrayOfWords[indexUhr - 1] = ""; // Löschen von bereits verwendete Informationen
		} else {
			reservierung1.setUhrzeit("Invalid Time!");
		}

		/*
		 * Speichert entnommenes Datum mit Fallunterscheidung für verschiedene
		 * Datumsangaben, wie z.B. 01.06. oder 1. Juni
		 */
		if (arrayOfWords.length > indexAm + 1) {
			if (arrayOfWords[indexAm + 1].length() > 3) {
				reservierung1.setDatum(arrayOfWords[indexAm + 1]);
			} else {
				reservierung1.setDatum(datumFormatieren(arrayOfWords[indexAm + 1], arrayOfWords[indexAm + 2]));
			}
			arrayOfWords[indexAm + 1] = "";// Löschen von bereits verwendete Informationen
		} else {
			reservierung1.setDatum("Invalid Date!");
		}

		// Wiederherstellung des Strings, ohne bereits verwendeter Informationen.
		reservierung = "";

		for (int i = 0; i < arrayOfWords.length; i++) {
			reservierung = reservierung + " " + arrayOfWords[i];
		}

		// Sucht nach Wörtern, welche nur aus Ziffern bestehen
		Pattern pattern = Pattern.compile("[0-9]+");
		Matcher matcher = pattern.matcher(reservierung);

		/*
		 * Prüft, ob die Suche erfolgreich war. Ist es erfolgreich wird die Reservierung
		 * gesetzt. Ansonsten wird nach ausgeschrieben Zahlenwörtern gesucht und diese
		 * zu Integern konvertiert.
		 */
		if (matcher.find()) {
			reservierung1.setAnzahlGaeste(Integer.parseInt((reservierung.substring(matcher.start(), matcher.end()))));
		} else {

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
				default:
					reservierung1.setAnzahlGaeste(-1);
				}
			}
		}

		// Ausgabe der Reservierung mit Fehlererkennung.
		if (reservierung1.getAnzahlGaeste() > 0) {
			System.out.println("(" + reservierung1.getName() + ", " + reservierung1.getDatum() + ", "
					+ reservierung1.getUhrzeit() + ", " + reservierung1.getAnzahlGaeste() + ")");
		} else {
			System.out.println("(" + reservierung1.getName() + ", " + reservierung1.getDatum() + ", "
					+ reservierung1.getUhrzeit() + ", " + "Invalid NumberOfGuests!)");
		}
	}

	public static void main(String args[]) {

		erkenneReservierung("");
	}
}
