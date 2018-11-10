package CorreaIsabella_VictoriaAnaIsabel_Tallerdos;

import java.util.*;

import processing.core.*;

public class Logica {

	public static final int CACTUS = 0;
	public static final int CHOCOLATE = 1;
	public static final int PASTEL = 2;
	public static final int POSION = 3;

	private PApplet app;
	private LinkedList<Modificador> modificadores;
	private LinkedList<Automator> automators;
	private LinkedList<Elemento> elementos;
	private int pantallas = 0;
	private Saini saini;
	private PImage[] pantalla;
	private PImage psaini;
	private PImage pazul;
	private PImage pverde;
	private PImage projo;
	private int punver;
	private int punazu;
	private int punroj;

	public Logica(PApplet app) {

		modificadores = new LinkedList<Modificador>();
		automators = new LinkedList<Automator>();
		elementos = new LinkedList<Elemento>();
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
		saini = new Saini(app, 0, 0);
		saini.start();
		for (int i = 0; i < 6; i++) {
			automators.add(new Automator(app, saini));
		}
		for (int i = 0; i < automators.size(); i++) {
			automators.get(i).start();
		}

		for (int i = 0; i < 15; i++) {
			elementos.add(new Elemento(app, saini));
		}
		for (int i = 0; i < elementos.size(); i++) {
			elementos.get(i).start();
		}

		for (int i = 0; i < 21; i++) {

			if (i <= 5) {
				modificadores.add(new Modificador(app, saini, 0));
			} else if (i > 5 & i <= 10) {
				modificadores.add(new Modificador(app, saini, 1));
			} else if (i > 10 & i <= 15) {
				modificadores.add(new Modificador(app, saini, 2));
			} else if (i > 15) {
				modificadores.add(new Modificador(app, saini, 3));
			}
		}
		for (int i = 0; i < modificadores.size(); i++) {
			modificadores.get(i).start();
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
			app.image(pantalla[1], saini.getCamx(), saini.getCamy());
			app.image(psaini, 0, 0);
			app.image(pazul, 110, 0);
			app.image(pverde, 220, 0);
			app.image(projo, 330, 0);
			app.textSize(50);
			app.textAlign(app.CENTER);
			app.text(saini.getPuntaje(), 50, 50);

			app.text(saini.getPuntaje(), 50, 50);

			app.fill(255);
			app.ellipse(1193, 691, 80, 80);
			saini.pintar();
			for (int i = 0; i < automators.size(); i++) {
				automators.get(i).pintar();
				automators.get(i).mover();
				automators.get(i).validar();
			}

			for (int i = 0; i < elementos.size(); i++) {
				elementos.get(i).pintar();
			}

			for (int i = 0; i < modificadores.size(); i++) {
				modificadores.get(i).pintar();
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
		saini.mover();
	}

	public void soltar() {
		saini.noMover();
	}
}
