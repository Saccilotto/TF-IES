package main.resources;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.image.Image;

public class LoadImages {
	public static int count = 0;
	private static LoadImages instance;
	private String pack = new File("").getAbsolutePath() + ("\\Pieces");
	private Map<String, Image> imgs;
	private boolean isWhite = true;

	public LoadImages() {
		imgs = new HashMap<String, Image>();
		LoadKing();

	}

	public Image LoadKing(boolean color) {
		isWhite = color;
		Image img;
		String fil;
		if (isWhite == true) {
			fil = (pack + "\\KingB");
			img = new Image(getClass().getResourceAsStream(fil + ".png"));
		} else {
			fil = (pack + "\\KingP");
			img = new Image(getClass().getResourceAsStream(fil + ".png"));
		}
		/*
		 * if (count < 32) { imgs.put(fil, img); }
		 */
		return img;
	}

	public List<Image> LoadKing() {
		// isWhite = color;
		int i = 0;
		Image img1 = null;
		Image img2 = null;
		String fil;
		String kb = "KingB";
		String kp = "KingP";
		while (i < 2) {
			if (isWhite == true) {
				fil = (pack + "\\" + kb + ".png");
				img1 = new Image(getClass().getResourceAsStream(fil));
			} else {
				fil = (pack + "\\" + kp + ".png");
				img2 = new Image(getClass().getResourceAsStream(fil));
			}

			if (count < 32) {
				imgs.put(fil, img1);
				imgs.put(fil, img2);
			}
			i++;
		}
		ArrayList<Image> lst = new ArrayList<Image>();
		lst.add(img1);
		lst.add(img2);

		return lst;

	}

	public Map<String, Image> getImgs() {
		return imgs;
	}

}
