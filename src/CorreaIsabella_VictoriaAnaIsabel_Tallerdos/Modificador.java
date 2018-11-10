package CorreaIsabella_VictoriaAnaIsabel_Tallerdos;

import processing.core.PApplet;
import processing.core.PImage;

public class Modificador extends Thread {
	private PApplet app;
	private PImage modificadorSeleccionado;
	private int punto;
	private float x, y;
	private Saini saini;
	private int estado;

	public Modificador(PApplet app, Saini saini, int id) {

		this.app = app;
		this.saini = saini;
		modificadorSeleccionado = new PImage();
		seleccionarModificador(id);

		x = app.random(300, 2200);
		y = app.random(100, 1000);

	}

	private void seleccionarModificador(int id) {
		switch (id) {
		case 0:
			modificadorSeleccionado = app.loadImage("cactus.png");
			break;
		case 1:
			modificadorSeleccionado = app.loadImage("chocolate.png");
			break;
		case 2:
			modificadorSeleccionado = app.loadImage("pastel.png");
			break;
		case 3:
			modificadorSeleccionado = app.loadImage("posion.png");
			break;
		default:
			break;
		}
	}

	public void pintar() {

		x = x + saini.getVelCamX();
		y = y + saini.getVelCamY();
		app.image(modificadorSeleccionado, x, y);
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public PImage getModificadorSeleccionado() {
		return modificadorSeleccionado;
	}

	public void setModificadorSeleccionado(PImage modificadorSeleccionado) {
		this.modificadorSeleccionado = modificadorSeleccionado;
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

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
