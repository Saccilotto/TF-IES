package main.java.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class Jogo {

	private static Jogo instance;
	private Scene scene;

	private final int sizeWidth = 90;
	private final int sizeHeight = 90;

	private String styleWhite = "white";
	private String styleBlack = "gray";

	private final int size = 8;

	private GridPane tabuleiro;

	private HBox getHeader() {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);
		hbox.setStyle("-fx-background-color: #336699;");

		Button buttonMenu = new Button("Voltar");
		buttonMenu.setPrefSize(100, 20);
		buttonMenu.setOnAction(event -> JanelaFX.setScene(Menu.getInstance().getScene()));

		hbox.getChildren().addAll(buttonMenu);

		return hbox;
	}

	private GridPane getTabuleiro() {
		tabuleiro = new GridPane();
		tabuleiro.setPadding(new Insets(5, 5, 5, 5));

		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				StackPane square = new StackPane();
				square.setPrefSize(sizeWidth, sizeHeight);

				String color = ((row + col) % 2 == 0) ? styleWhite : styleBlack;
				square.setStyle("-fx-background-color: " + color + ";");
				tabuleiro.add(square, col, row);
			}
		}

		return tabuleiro;
	}

	// TODO Alterar para entidade piece
	private void adicionarPeca(Image image, int row, int col) {
		ImageView imageView = new ImageView(image);

		imageView.setFitHeight(sizeHeight);
		imageView.setFitWidth(sizeWidth);

		this.tabuleiro.add(imageView, row, col);
	}

	public Jogo() {
		BorderPane border = new BorderPane();
		border.setStyle("-fx-background-color: BURLYWOOD; -fx-text-fill: BURLYWOOD;");

		border.setTop(getHeader());
		border.setCenter(getTabuleiro());

		this.scene = new Scene(border, 730, 785);
	}

	public Scene getScene() {
		return this.scene;
	}

	public static Jogo getInstance() {
		if (instance == null) {
			instance = new Jogo();
		}

		return instance;
	}

}