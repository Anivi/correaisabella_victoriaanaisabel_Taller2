package CorreaIsabella_VictoriaAnaIsabel_Tallerdos;

import processing.core.*;

public class Saini extends Thread {

	private PVector vel;
	private PVector pos;
	private int puntaje;
	private PApplet app;
	private int camx = 0;
	private int camy = -700;
	private PVector velcam;
	private PImage[] sai;
	private int sain;
	private int mover;
	private int contador;
	private boolean invul;

	public Saini(PApplet app, float x, float y) {
		this.app = app;
		pos = new PVector(x, y);
		vel = new PVector(2, 2);
		velcam = new PVector(0, 0);
		mover = 0;
		puntaje = 0;
		invul = false;
		// sai = app.loadImage("saini.png");
		sai = new PImage[3];
		sain = 1;
		for (int i = 0; i < sai.length; i++) {
			sai[i] = app.loadImage("saini" + (i + 1) + ".png");
		}

	}

	public void pintar() {
		app.fill(255);
		// app.ellipse(pos.x, pos.y, 50, 50);
		if (invul == false) {
			switch (sain) {
			case 1:
				app.image(sai[0], pos.x, pos.y);
				break;
			case 2:
				app.image(sai[1], pos.x, pos.y);
				break;
			case 3:
				app.image(sai[2], pos.x, pos.y);
				break;
			}
		} else {
			if (app.frameCount % 10 == 0) {
				switch (sain) {
				case 1:
					app.image(sai[0], pos.x, pos.y);
					break;
				case 2:
					app.image(sai[1], pos.x, pos.y);
					break;
				case 3:
					app.image(sai[2], pos.x, pos.y);
					break;
				}
			}
		}
		switch (mover) {
		case 0:
			break;
		case 1:
			if (pos.y - 40 >= 40) {
				pos.y -= 2;
				velcam.x = 0;
			} else {
				if (camy <= -40)
					camy += 2;
				velcam.y = 2;
			}
			break;
		case 2:
			if (pos.y + 40 <= app.height - 80) {
				pos.y += 2;
				velcam.y = 0;
			} else {
				if (camy >= -700)
					camy -= 2;
				velcam.y = -2;
			}
			break;
		case 3:
			if (pos.x - 50 >= 0) {
				pos.x -= 2;
				velcam.x = 0;
			} else {
				if (camx <= -5)
					camx += 2;
				velcam.x = 2;
			}
			break;
		case 4:
			if (pos.x + 50 <= app.width - 50) {
				pos.x += 2;
				velcam.x = 0;
			} else {
				if (camx >= -1200)
					camx -= 2;
				velcam.x = -2;
			}
			break;
		}
//		app.image(sai[2], pos.x, pos.y);
		if (invul == true) {
			contador++;
			if (contador == 90) {
				invul = false;
				contador = 0;
			}
		}
	}

	public void mover() {

		switch (app.keyCode) {
		case PApplet.UP:
			sain = 1;
			mover = 1;
			break;
		case PApplet.DOWN:
			sain = 1;
			mover = 2;
			break;
		case PApplet.RIGHT:
			sain = 2;
			mover = 4;
			break;
		case PApplet.LEFT:
			sain = 3;
			mover = 3;
			break;
		}

//		if (app.keyPressed == true) {
//			if (app.keyCode == app.UP) {
//				sain = 1;
//				if (pos.y - 40 >= 40) {
//					pos.y -= vel.y;
//				} else {
//					camy += 2;
//				}
//
//			}
//			if (app.keyCode == app.DOWN) {
//				sain = 1;
//				if (pos.y + 40 <= app.height - 40) {
//					pos.y += vel.y;
//				} else {
//					camy -= 2;
//				}
//			}
//			if (app.keyCode == app.LEFT) {
//				sain = 3;
//				if (pos.x - 50 >= 50) {
//					pos.x -= vel.x;
//				} else {
//					camx += 2;
//				}
//			}
//			if (app.keyCode == app.RIGHT) {
//				sain = 2;
//				if (pos.x + 50 <= app.width - 50) {
//					pos.x += vel.x;
//
//				} else {
//					camx -= 2;
//				}
//			}
//		}
	}

	public void noMover() {
		if (app.keyPressed == false) {
			mover = 0;
			velcam.x = 0;
			velcam.y = 0;
		}
	}

	public void run() {

	}

	public int getCamx() {
		return camx;
	}

	public int getSain() {
		return sain;
	}

	public void setSain(int sain) {
		this.sain = sain;
	}

	public void setCamx(int camx) {
		this.camx = camx;
	}

	public int getCamy() {
		return camy;
	}

	public void setCamy(int camy) {
		this.camy = camy;
	}

	public float getX() {
		return pos.x;
	}

	public float getY() {
		return pos.y;
	}

	public float getVelCamX() {
		return velcam.x;
	}

	public float getVelCamY() {
		return velcam.y;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public boolean isInvul() {
		return invul;
	}

	public void setInvul(boolean invul) {
		this.invul = invul;
	}

}
