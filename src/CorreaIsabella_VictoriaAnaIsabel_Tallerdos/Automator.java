package CorreaIsabella_VictoriaAnaIsabel_Tallerdos;

import java.util.*;

import processing.core.*;

public class Automators extends Thread {

	private PApplet app;
	private PVector pos;
	private PVector vel;
	private int puntaje;
	private int direccion;
	private PImage[] aut1;
	private PImage[] aut2;
	private PImage[] aut3;
	private int auto;
	private int tipo;
	private Saini si;

	public Automators(PApplet app, Saini si) {
		this.app = app;
		this.si = si;
		puntaje =0;
		pos = new PVector(app.random(0, 2400), app.random(-700, 700));
		vel = new PVector(2, 2);
		aut1 = new PImage[3];
		aut2 = new PImage[3];
		aut3 = new PImage[3];
		auto = 1;
		for (int i = 0; i < aut1.length; i++) {
			aut1[i] = app.loadImage("azul" + (i + 1) + ".png");
			aut2[i] = app.loadImage("rojo" + (i + 1) + ".png");
			aut3[i] = app.loadImage("verde" + (i + 1) + ".png");
		}
		tipo = (int) app.random(0, 3);
		direccion = (int) app.random(1, 5);
	}

	public void pintar() {
		pos.x = pos.x + si.getVelCamX();
		pos.y = pos.y + si.getVelCamY();
		if (tipo == 0) {
			switch (auto) {
			case 1:
				app.image(aut1[0], pos.x, pos.y);
				break;
			case 2:
				app.image(aut1[1], pos.x, pos.y);
				break;
			case 3:
				app.image(aut1[2], pos.x, pos.y);
				break;
			}
		}
		if (tipo == 1) {
			switch (auto) {
			case 1:
				app.image(aut2[0], pos.x, pos.y);
				break;
			case 2:
				app.image(aut2[1], pos.x, pos.y);
				break;
			case 3:
				app.image(aut2[2], pos.x, pos.y);
				break;
			}
		}
		if (tipo == 2) {
			switch (auto) {
			case 1:
				app.image(aut3[0], pos.x, pos.y);
				break;
			case 2:
				app.image(aut3[1], pos.x, pos.y);
				break;
			case 3:
				app.image(aut3[2], pos.x, pos.y);
				break;
			}
		}
	}

	public void mover() {

		if (app.dist(si.getX(), si.getY(), pos.x, pos.y) < 300) {
			vel.x = si.getX() - pos.x;
			vel.y = si.getY() - pos.y;
			vel.normalize();
			pos.add(vel);
			auto = si.getSain();
		} else {
			vel.x = 2;
			vel.y = 2;
			switch (direccion) {

			case 1:
				pos.y += vel.y;
				auto = 1;
				break;
			case 2:
				pos.y -= vel.y;
				auto = 1;
				break;
			case 3:
				pos.x -= vel.x;
				auto = 3;
				break;
			case 4:
				pos.x += vel.x;
				auto = 2;
				break;

			}
			if (app.frameCount % 30 == 0) {
				direccion = (int) app.random(1, 5);
			}
		}
	}

	public void run() {
	}

	public void validar() {
		if (si.isInvul() == false) {
			if (app.dist(si.getX(), si.getY(), pos.x, pos.y) < 60) {
				si.setPuntaje(si.getPuntaje() - 1);
				puntaje -= 1;
				si.setInvul(true);
			}
		}
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	
}
