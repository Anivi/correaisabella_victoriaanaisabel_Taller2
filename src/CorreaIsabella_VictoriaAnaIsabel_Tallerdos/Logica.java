package CorreaIsabella_VictoriaAnaIsabel_Tallerdos;

import java.util.*;

import processing.core.*;

public class Logica {
	private PApplet app;
	private LinkedList<Modificadores> mod;
	private LinkedList<Automators> ors;
	private LinkedList<Elementos> ele;
	private int pantallas = 0;
	private Saini sai;
	private PImage[] pantalla;
	private PImage psaini;
	private PImage pazul;
	private PImage pverde;
	private PImage projo;
	private int punver;
	private int punazu;
	private int punroj;

	public Logica(PApplet app) {

		mod = new LinkedList<Modificadores>();
		ors = new LinkedList<Automators>();
		ele = new LinkedList<Elementos>();
		psaini = new PImage();
		pazul = new PImage();
		pverde = new PImage();
		projo = new PImage();
		this.app = app;
		pantalla = new PImage[4];
		pantalla[0] = app.loadImage("comenzar1.png");
		pantalla[1] = app.loadImage("fondo.png");
		pantalla[2] = app.loadImage("perdiste.png");
		pantalla[3] = app.loadImage("ganaste.png");
		psaini = app.loadImage("psaini.png");
		pazul = app.loadImage("pazul.png");
		pverde = app.loadImage("pverde.png");
		projo = app.loadImage("projo.png");
		sai = new Saini(app, 0, 0);
		sai.start();
		for (int i = 0; i < 6; i++) {
			ors.add(new Automators(app, sai));
		}
		for (int i = 0; i < ors.size(); i++) {
			ors.get(i).start();
		}

	}

	public void pintar() {

		switch (pantallas) {

		case 0:
			app.imageMode(app.CORNER);
			app.image(pantalla[0], 0, 0);
			break;

		case 1:
			app.imageMode(app.CORNER);
			app.image(pantalla[1], sai.getCamx(), sai.getCamy());
			app.image(psaini, 0, 0);
			app.image(pazul, 110, 0);
			app.image(pverde, 220, 0);
			app.image(projo, 330, 0);
			app.textSize(50);
			app.textAlign(app.CENTER);
			app.text(sai.getPuntaje(), 50, 50);

			app.text(sai.getPuntaje(), 50, 50);
			
			app.fill(255);
			app.ellipse(1193, 691, 80, 80);
			sai.pintar();
			for (int i = 0; i < ors.size(); i++) {
				ors.get(i).pintar();
				ors.get(i).mover();
				ors.get(i).validar();
			}

			break;
		case 2:
			app.imageMode(app.CORNER);
			app.image(pantalla[2], 0, 0);

			break;
		case 3:
			app.imageMode(app.CORNER);
			app.image(pantalla[3], 0, 0);
			app.fill(255);
			app.ellipse(1193, 691, 80, 80);
			break;

		}

	}

	public void coger() {

	}

	public void mouse() {

		if (app.mouseX >= 286 && app.mouseX <= 528 && app.mouseY >= 568 && app.mouseY <= 655 && pantallas == 0) {
			pantallas = 1;
		}
		if (app.dist(app.mouseX, app.mouseY, 1193, 691) < 40 && pantallas == 3) {
			pantallas = 2;
		}
		if (app.dist(app.mouseX, app.mouseY, 1193, 691) < 40 && pantallas == 1) {
			pantallas = 3;
		}

		System.out.println(app.mouseX + " " + app.mouseY);
	}

	public void tecla() {
		sai.mover();
	}

	public void soltar() {
		sai.noMover();
	}
}
