package CorreaIsabella_VictoriaAnaIsabel_Tallerdos;

import processing.core.*;

public class Main extends PApplet {

	Logica logica;

	public static void main(String[] args) {
		PApplet.main("CorreaIsabella_VictoriaAnaIsabel_Tallerdos.Main");

	}

	public void settings() {
		size(1200, 700);
	}

	public void setup() {
		logica = new Logica(this);
	}

	public void draw() {
		background(0);
		logica.pintar();
	}

	public void keyPressed() {
		logica.tecla();
	}

	public void mousePressed() {
		logica.mouse();
	}
	public void keyReleased() {
		logica.soltar();
	}
}
