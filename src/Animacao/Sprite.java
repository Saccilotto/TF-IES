package Animacao;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sprite {
	Image image;
	String color;
	File imgFile;
	
	public Sprite(String color,File imgFile){
		setImage(this.imgFile);;
		setImage(this.color);		
		setImage(image);
		
	}
	
	private void setImage(String corHex) {
		corHex = color;		
	}
	
	private void setImage(File arquivo) {
		arquivo = imgFile;		
	}
	
	private void setImage(Image img) {
		try {
			img = ImageIO.read(getClass().getResource("/images/" + imgFile.getName()));
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}
	
}
