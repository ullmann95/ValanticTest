package valanticTest;

public class Reservierung {
private String name;
private String datum;
private String uhrzeit;
private int anzahlGaeste;

public String getName() {
	return name;
}
protected void setName(String name) {
	this.name = name;
}
public String getUhrzeit() {
	return uhrzeit;
}
protected void setUhrzeit(String uhrzeit) {
	this.uhrzeit = uhrzeit;
}
public int getAnzahlGaeste() {
	return anzahlGaeste;
}
protected void setAnzahlGaeste(int anzahlGaeste) {
	this.anzahlGaeste = anzahlGaeste;
}
public String getDatum() {
	return datum;
}
protected void setDatum(String datum) {
	this.datum = datum;
}
public Reservierung() {
}
}

