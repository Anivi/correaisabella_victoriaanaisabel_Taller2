package CorreaIsabella_VictoriaAnaIsabel_Tallerdos;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Elemento extends Thread {
	private PApplet app;
	private PVector pos;
	private PImage elementoImagen;
	private int punto;
	private float x, y;

	public Elemento(PApplet app) {

		this.app = app;
		elementoImagen = this.app.loadImage("pildora.png");

		x = app.random(300, 2200);
		y = app.random(100, 1000);

	}

	public void pintar() {

		app.image(elementoImagen, x, y);
	}

}