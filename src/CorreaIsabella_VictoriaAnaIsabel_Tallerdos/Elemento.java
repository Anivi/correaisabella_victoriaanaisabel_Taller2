package CorreaIsabella_VictoriaAnaIsabel_Tallerdos;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Elemento extends Thread {
	private PApplet app;
	private PImage elementoImagen;
	private int punto;
	private float x, y;
	private Saini saini;

	public Elemento(PApplet app, Saini saini) {

		this.app = app;
		this.saini = saini;
		elementoImagen = this.app.loadImage("pildora.png");

		x = app.random(300, 2200);
		y = app.random(100, 1000);

	}

	public void pintar() {

		x = x + saini.getVelCamX();
		y = y + saini.getVelCamY();
		app.image(elementoImagen, x, y);
	}

}