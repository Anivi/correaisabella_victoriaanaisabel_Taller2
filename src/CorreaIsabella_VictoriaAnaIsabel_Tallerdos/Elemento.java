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

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public PImage getElementoImagen() {
		return elementoImagen;
	}

	public void setElementoImagen(PImage elementoImagen) {
		this.elementoImagen = elementoImagen;
	}

	public int getPunto() {
		return punto;
	}

	public void setPunto(int punto) {
		this.punto = punto;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Saini getSaini() {
		return saini;
	}

	public void setSaini(Saini saini) {
		this.saini = saini;
	}

	
}