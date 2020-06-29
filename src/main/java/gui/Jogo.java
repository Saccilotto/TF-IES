package main.java.gui;

import java.util.ResourceBundle.Control;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import main.java.model.Tabuleiro;

public class Jogo {

	private Tabuleiro tab;
	private GridPane grid;

	private static Jogo instance;
	private Scene scene;

	/*
	 * used to make sure the timer doesn't start two threads for the same move
	 * 
	 * private boolean thinking;
	 * 
	 * For getting promotions private Move tempMove;
	 */
	public Jogo() {
		BorderPane pane = new BorderPane();
		pane.autosize();
		pane.setPadding(new Insets(25, 25, 25, 25));
		pane.setVisible(true);
		pane.setStyle("-fx-background-color: BURLYWOOD; -fx-text-fill: BURLYWOOD;");

		// Cria grid tabuleiro
		GridPane root = new GridPane();
		final int size = 8;
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				StackPane square = new StackPane();
				String color;
				if ((row + col) % 2 == 0) {
					color = "white";
				} else {
					color = "gray";
				}
				square.setStyle("-fx-background-color: " + color + ";");
				root.add(square, col, row);
			}
		}

		for (int i = 0; i < size; i++) {
			root.getColumnConstraints().add(new ColumnConstraints(5, Control.TTL_DONT_CACHE, Double.POSITIVE_INFINITY,
					Priority.ALWAYS, HPos.CENTER, true));
			root.getRowConstraints().add(new RowConstraints(5, Control.TTL_DONT_CACHE, Double.POSITIVE_INFINITY,
					Priority.ALWAYS, VPos.CENTER, true));
		}

		HBox hbBut = new HBox();
		hbBut.setSpacing(20);
		Button butVoltarMenu = new Button("Voltar para o menu");
		Button butSair = new Button("Sair");
		butVoltarMenu.setOnAction(e -> JanelaFX.setScene(Menu.getInstance().getScene()));
		butSair.setOnAction(e -> JanelaFX.close());
		hbBut.getChildren().add(butSair);
		hbBut.getChildren().add(butVoltarMenu);

		setGrid(root);
		// setTabuleiro(tab);
		// pane.setCenterShape(true);
		pane.setTop(hbBut);
		pane.setCenter(root);

		this.scene = new Scene(pane);
	}

	public void setGrid(GridPane grid) {
		this.grid = grid;
	}

	/*
	 * public void setTabuleiro(Tabuleiro tab) { this.tab = new Tabuleiro(grid); }
	 */
	public Tabuleiro getTabuleiro() {
		return tab;
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