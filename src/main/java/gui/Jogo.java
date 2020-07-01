package main.java.gui;

import java.awt.Point;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import main.java.model.Piece;

public class Jogo implements MouseController {

	private static Jogo instance;
	private Scene scene;

	private final int sizeWidth = 90;
	private final int sizeHeight = 90;

	private String styleWhite = "white";
	private String styleBlack = "gray";

	public final int size = 8;

	private GridPane board;

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

	public GridPane getTabuleiro() {
		board = new GridPane();
		board.setPadding(new Insets(5, 5, 5, 5));

		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				StackPane square = new StackPane();
				square.setPrefSize(sizeWidth, sizeHeight);

				String color = ((row + col) % 2 == 0) ? styleWhite : styleBlack;
				square.setStyle("-fx-background-color: " + color + ";");
				board.add(square, col, row);
			}
		}

		board.addEventFilter(MouseEvent.MOUSE_PRESSED, (EventHandler<MouseEvent>) (MouseEvent e) -> onMousePressed(e));
		board.addEventFilter(MouseEvent.MOUSE_DRAGGED, (EventHandler<MouseEvent>) (MouseEvent e) -> onMouseDragged(e));
		board.addEventFilter(MouseEvent.MOUSE_RELEASED,
				(EventHandler<MouseEvent>) (MouseEvent e) -> onMouseReleased(e));

		return board;
	}

	private Point getCoordBoard(MouseEvent e) {
		for (Node node : board.getChildren()) {
			if (node instanceof StackPane) {
				if (node.getBoundsInParent().contains(e.getSceneX(), e.getSceneY())) {
					return new Point(GridPane.getRowIndex(node), GridPane.getColumnIndex(node));
				}
			}
		}
		return null;
	}

	// TODO Alterar para entidade piece
	private void adicionarPeca(Piece e, int row, int col) {
		Image aux = e.getPecaImg();
		ImageView imageView = new ImageView(aux);

		imageView.setFitHeight(sizeHeight);
		imageView.setFitWidth(sizeWidth);

		this.board.add(imageView, row, col);
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

	@Override
	public void onMouseReleased(MouseEvent event) {
		Point coords = getCoordBoard(event);

		if (coords == null) {
			return;
		}

		System.out.println("MOUSE_RELEASED: " + coords.x + "/" + coords.y);
	}

	@Override
	public void onMouseDragged(MouseEvent event) {
		Point coords = getCoordBoard(event);

		if (coords == null) {
			return;
		}

		System.out.println("MOUSE_DRAGGED: " + coords.x + "/" + coords.y);
	}

	@Override
	public void onMousePressed(MouseEvent event) {
		Point coords = getCoordBoard(event);

		if (coords == null) {
			return;
		}

		System.out.println("MOUSE_PRESSED: " + coords.x + "/" + coords.y);
	}

	public GridPane getBoard() {
		return board;
	}
}