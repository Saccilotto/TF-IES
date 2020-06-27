package main.java.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.resources.Icons;

public class JanelaFX extends Application {

	private static Stage mainStage;
	private Menu menu;

	@Override
	public void start(Stage stage) throws Exception {
		mainStage = stage;
		setup();
	}

	private void setup() {
		Icons icons = Icons.getInstance();

		mainStage.getIcons().add(icons.getMainIcon());
		mainStage.setTitle("Chess Battles");

		menu = Menu.getInstance();
		setScene(menu.getScene());
	}

	@Override
	public void stop() {
		mainStage.close();
	}

	public static void close() {
		mainStage.close();
	}

	public static void setScene(Scene scene) {
		mainStage.setScene(scene);
		mainStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
