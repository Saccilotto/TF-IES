package main.resources;

import javafx.scene.image.Image;

public class Icons {

	private static Icons instance;
	private Image mainIcon;

	public Icons() {
		mainIcon = new Image(getClass().getResourceAsStream("ic8.png"));
	}

	public Image getMainIcon() {
		return mainIcon;
	}

	public static Icons getInstance() {
		if (instance == null) {
			instance = new Icons();
		}

		return instance;
	}
}
