package main.resources;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;

public class LoadImages {
	private static LoadImages instance;
	private String dir = new File("").getAbsolutePath() + ("\\Pieces");
	private Map<String, Image> imgs;
	// private boolean isWhite = true;

	public LoadImages() {
		imgs = new HashMap<String, Image>();
		LoadPieces();
	}

	// retorna a instancia pra classe LoadImages.
	public static LoadImages getInstance() {
		if (instance == null) {
			instance = new LoadImages();
		}
		return instance;
	}

	// retorna o map imgs
	public Map<String, Image> getImgs() {
		return imgs;
	}

	// adiciona ao Map todas as imagens e seus nomes
	public void LoadPieces() {
		File fileDir = new File(dir);
		File[] files = fileDir.listFiles();

		String name = null;
		Image img = null;
		for (File f : files) {
			name = f.getName() + ".png";
			img = new Image(getClass().getResourceAsStream(name));

			imgs.put(name, img);
		}
		/*
		 * System.out.println(name); System.out.println(img); System.out.println(imgs);
		 * 
		 */
	}

	public Image getImagePiece(String nome, boolean branca) {
		String color;
		if (branca == true) {
			color = "B";
		} else {
			color = "P";
		}
		return imgs.get(nome + color);
	}
}