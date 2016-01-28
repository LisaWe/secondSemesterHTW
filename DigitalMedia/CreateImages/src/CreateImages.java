// Copyright (C) 2015 Prof. Dr. Kai Uwe Barthel
// http://www.f4.fhtw-berlin.de/~barthel/veranstaltungen/GLDM/uebungen/uebung1/uebung1.htm

import gdmvalidation.Ueb1Validation;
import ij.ImageJ;
import ij.ImagePlus;
import ij.gui.GenericDialog;
import ij.gui.NewImage;
import ij.plugin.PlugIn;
import ij.process.ImageProcessor;
import java.lang.Math;

// erste Uebung (elementare Bilderzeugung)
// TODO refactor the class name
public class CreateImages implements PlugIn {

	final static String[] choices = { "Schwarzes Bild", "Gelbes Bild",
			"Schwarz/Weiss Verlauf",
			"Horiz. Schwarz/Rot vert. Schwarz/Blau Verlauf",
			"Italienische Fahne", "Kegelschnitt", "Japanische Fahne",
			"Japanische Fahne mit weichen Kanten", "Streifenmuster" };

	private String choice;

	public static void main(String args[]) {
		ImageJ ij = new ImageJ(); // neue ImageJ Instanz starten und anzeigen
		ij.exitWhenQuitting(true);

		CreateImages imageGeneration = new CreateImages();
		imageGeneration.run("");
	}

	public void run(String arg) {

		int width = 566; // Breite
		int height = 400; // Hoehe

		// RGB-Bild erzeugen
		ImagePlus imagePlus = NewImage.createRGBImage("DM_U1", width, height,
				1, NewImage.FILL_BLACK);
		ImageProcessor ip = imagePlus.getProcessor();

		// Arrays fuer den Zugriff auf die Pixelwerte
		int[] pixels = (int[]) ip.getPixels();

		dialog();

		if (choice.equals("Schwarzes Bild")) {
			int r,g,b;
			r = g = b = 0;
			setImageToColor(pixels, width, height,r, g, b);
		} else if (choice.equals("Gelbes Bild")) {
			int r,g,b;
			r = 255;
			g = 255;
			b = 0;
			//TODO set the color to yellow
			setImageToColor(pixels, width, height,r, g, b);
		} else if (choice.equals("Schwarz/Weiss Verlauf")) {
			blackToWhite(pixels, width, height);
			Ueb1Validation.validateBlackToWhite(pixels, width, height);
		} else if (choice.equals("Horiz. Schwarz/Rot vert. Schwarz/Blau Verlauf")) {
			black2RedAndBlack2Blue(pixels, width, height);
			Ueb1Validation.validateBlack2RedAndBlack2Blue(pixels, width, height);
		} else if (choice.equals("Italienische Fahne")) {
			flagItalian(pixels, width, height);
			Ueb1Validation.validateFlagItalian(pixels, width, height);
		} else if (choice.equals("Kegelschnitt")) {
			conicSection(pixels, width, height);
		} else if (choice.equals("Japanische Fahne")) {
			flagOfJapan(pixels, width, height);
		} else if (choice.equals("Japanische Fahne mit weichen Kanten")) {
			flagOfJapanSmooth(pixels, width, height);
		} else if (choice.equals("Streifenmuster")) {
			stripes(pixels, width, height);
		}

		// neues Bild anzeigen
		imagePlus.show();
		imagePlus.updateAndDraw();
	}
	
	private void blackToWhite(int[] pixels, int width, int height) {
		// TODO set some values here
		// Schleife ueber die y-Werte
		for (int y = 0; y < height; y++) {
			// Schleife ueber die x-Werte
			for (int x = 0; x < width; x++) {
				int pos = y * width + x; // Arrayposition bestimmen
				int r,g,b;
				//TODO code for the image.
				r = g = b = 255*x/(width-1);
				pixels[pos] = 0xFF000000 | (r << 16) | (g << 8) | b;
			}
		}
	}

	private void black2RedAndBlack2Blue(int[] pixels, int width, int height) {
		// TODO set some values here
		// Schleife ueber die y-Werte
		for (int y = 0; y < height; y++) {
			// Schleife ueber die x-Werte
			for (int x = 0; x < width; x++) {
				int pos = y * width + x; // Arrayposition bestimmen
				int r,g,b;
				//TODO code for the image.
				r = g = b = 0;
				r = 255*x/(width-1);
				b = 255*y/(height-1);
				pixels[pos] = 0xFF000000 | (r << 16) | (g << 8) | b;
			}
		}
	}

	private void flagItalian(int[] pixels, int width, int height) {
		// TODO set some values here
		// Schleife ueber die y-Werte
		for (int y = 0; y < height; y++) {
			// Schleife ueber die x-Werte
			for (int x = 0; x < width; x++) {
				int pos = y * width + x; // Arrayposition bestimmen
				int r,g,b;
				//TODO code for the flag.
				r = g = b = 0;
				
				if(x < width/3){
					r = 0;
					g = 255;
					b = 0;
				}else if(x < width/3*2){
					r = g = b = 255;
				}else{
					r = 255;
					g = 0;
					b = 0;
				}
				
				pixels[pos] = 0xFF000000 | (r << 16) | (g << 8) | b;
			}
		}
	}

	private void conicSection(int[] pixels, int width, int height) {
		// TODO set some values here
		int xF=width/3;
		int yF = height/2;
		
		// Schleife ueber die y-Werte
		for (int y = 0; y < height; y++) {
			// Schleife ueber die x-Werte
			for (int x = 0; x < width; x++) {
				int pos = y * width + x; // Arrayposition bestimmen
				int r,g,b;
				//TODO code for the flag.
				r = g = b = 0;
				double dist = Math.sqrt(Math.pow((x-xF),2)+Math.pow((y-yF),2));
				//sqrt: zieht die Wurzel
				//pow(a,b):a=Term; b=Exponent(hier hoch 2)
				//(x-xF)*(x-xF)+(y-yF)*(y-yF)
				if((dist-1.0)<=x && (dist+1.0)>=x){
					r=g=b=0;
				}else{
					r=g=b=255;
				}

				pixels[pos] = 0xFF000000 | (r << 16) | (g << 8) | b;
			}
		}
	}

	private void flagOfJapan(int[] pixels, int width, int height) {
		// TODO set some values here
		int radius = 100; // vorher festegelegt
		int mpX=width/2; //relativ an der Breite
		int mpY=height/2; // relativ an der Hˆhe
		int a=0; //Satz des Pythagoras: a≤ + d≤ [b schon vergeben] = c≤
		int d=0;
		int c=0; // f¸r c≤
		int rad=(radius*radius); //rad f¸r radius≤
		// Schleife ueber die y-Werte
		for (int y = 0; y < height; y++) {
			// Schleife ueber die x-Werte
			for (int x = 0; x < width; x++) {
				int pos = y * width + x; // Arrayposition bestimmen
				int r,g,b;
				//TODO code for the flag.
				r=g=b=0;
				a=mpX-x;
				d=mpY-y;
				c=(a*a)+(d*d); // c steht f¸r c≤

				if(c<=rad){
					r=255;
				}else{
					r=255;
					g=255;
					b=255;
				}

				pixels[pos] = 0xFF000000 | (r << 16) | (g << 8) | b;
			}
		}
	}

	private void flagOfJapanSmooth(int[] pixels, int width, int height) {
		// TODO set some values here
		
		int mpX = width/2; //relativ an der Breite
		int mpY = height/2; // relativ an der Hˆhe
		
		int radius = 100; // Radius innerer Kreis
		int radius2 = 120; // Radius ‰uﬂerer Kreis
		
		int radiusQuadrat1 = (radius * radius); //r≤ innerer Kreis
		int radiusQuadrat2 = (radius2 * radius2); // r≤ ‰uﬂerer Kreis
		
		// Schleife ueber die y-Werte
		for (int y = 0; y < height; y++) {
			// Schleife ueber die x-Werte
			for (int x = 0; x < width; x++) {
				int pos = y * width + x; // Arrayposition bestimmen
				int r,g,b;
				
				//TODO code for the flag.
				r=g=b=0;
				
				int deltaX = x - mpX; //Breite, Satz des Pythagoras
				int deltaY = y - mpY; //Hˆhe, Satz des Pythagoras
				int radiusGesamtQuadrat = (deltaX) * (deltaX) + (deltaY) * (deltaY); // r≤ = radiusGesamtQuadrat , s. Satz des Pythagoras
				
				if(radiusQuadrat1 > radiusGesamtQuadrat){//innerer Kreis -> rot
					r = 255;
					g = 0;
					b = 0;
				}else if(radiusQuadrat2 > radiusGesamtQuadrat){ //‰uﬂerer Kreis  transparenter Verlauf->  rot -weiﬂ
					double gruenUndBlau = ((Math.sqrt(radiusGesamtQuadrat) - radius) / (radius2 - radius)) * 255; //Math.sqrt() zieht Wurzel
					int gruenUndBlauInt = (int) gruenUndBlau; // Umwandlung in Integer, da r,g,b Integer benˆtigen
					r = 255;
					g = gruenUndBlauInt; //variabel im Transparenzverlauf
					b = gruenUndBlauInt;//variabel im Transparenzverlauf
				}else{ // Rest -> weiﬂ
					r = 255;
					g = 255;
					b = 255;
				}

				pixels[pos] = 0xFF000000 | (r << 16) | (g << 8) | b;
			}
		}
	}
	
	private void stripes(int[] pixels, int width, int height) {
		// TODO set some values here
		// Schleife ueber die y-Werte
		for (int y = 0; y < height; y++) {
			// Schleife ueber die x-Werte
			for (int x = 0; x < width; x++) {
				int pos = y * width + x; // Arrayposition bestimmen
				int r,g,b;
				//TODO code for the flag.
				r = g = b = 0;
				
				int viertelHoehe = height / 4; // 100
				int achtelHoehe = height / 8; // 50

				if ((y % viertelHoehe) < (achtelHoehe)) { 
					r = 0;
					g = 0;
					b = 0;
				} else {
					r = 255;		
					g = 255;
					b = 255;
				}
				
				pixels[pos] = 0xFF000000 | (r << 16) | (g << 8) | b;
			}
		}
	}
	private void setImageToColor(int[] pixels, int width, int height,int r, int g, int b) {
	int color = 0xFF000000 | (r << 16) | (g << 8) | b;
	// Schleife ueber die y-Werte
	for (int y = 0; y < height; y++) {
		// Schleife ueber die x-Werte
		for (int x = 0; x < width; x++) {
			int pos = y * width + x; // Arrayposition bestimmen
			// Werte zurueckschreiben
			pixels[pos] = color;
		}
	}
	}
	
	private void dialog() {
		// Dialog fuer Auswahl der Bilderzeugung
		GenericDialog gd = new GenericDialog("Bildart");
		gd.addChoice("Bildtyp", choices, choices[0]);
		gd.showDialog(); // generiere Eingabefenster
		choice = gd.getNextChoice(); // Auswahl uebernehmen

		if (gd.wasCanceled())
			System.exit(0);
	}
}