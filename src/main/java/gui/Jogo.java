package main.java.gui;

import java.awt.Insets;
import java.util.List;
import java.util.ResourceBundle.Control;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import main.java.logic.Move;
import main.java.model.Tabuleiro;

public class Jogo {

	private Tabuleiro tab;
	private static Jogo instance;
	private private Scene scene;

	/*
	 * used to make sure the timer doesn't start two threads for the same move
	 */
	private boolean thinking;

	/* For getting promotions */
	private Move tempMove;

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

		pane.setCenterShape(true);
		pane.setCenter(root);

		this.scene = new Scene(pane);
	}

	public void setTabuleiro() {
		// t = new Tabuleiro();

	}

	public Tabuleiro getTabuleiro() {
		return t;
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

	/* Once it is determined that is time for the AI to make a move */
	private void playAI() {
		List<> v;
		/* Random Play */
		if ((tab.getTurn() && whiteCh.getSelectedItem().equals("Random"))
				|| (!tab.getTurn() && blackCh.getSelectedItem().equals("Random")))
			v = tab.getAllLegalMoves();

		/* Search moves to depth */
		else if (tab.getTurn() && whiteCh.getSelectedIndex() > 1)
			v = tab.getBestMoves(whiteCh.getSelectedIndex() - 2);
		else if (!tab.getTurn() && blackCh.getSelectedIndex() > 1)
			v = tab.getBestMoves(blackCh.getSelectedIndex() - 2);

		else
			return;

		Move m = (Move) v.getIndex((int) (Math.random() * v.size()));
		/* Automatic promotion to queen */

		tab.makeMove(m);
		readyNextMove();

	}

	public void moveHandler(Move m) {
		if (isPromoting)
			return;

		/* make a copy of the current board */
		if (tab.isLegal(m) && tab.isCheckLegal(m)) {
			/*
			 * If a promotion is involved, the program needs to know what the promotion is.
			 * The program then exits, and picks up at promotionHandler
			 */
			if (m.promotion) {
				tempMove = new Move(m.from, m.to);
				messageLbl.setText("Enter 'Q','R','B', or 'N'");
				messageLbl.repaint();
				isPromoting = true;
			}

			/* all other moves */
			else {
				board.makeMove(m);
				readyNextMove();

			}
		} else
			messageLbl.setText(m.getMessage());
	}

	public void readyNextMove() {
		tab.findAllLegalMoves();

		/*
		 * I don't know why this is necessary, but the program keeps trying to shrink
		 * this label
		 */
		messageLbl.setSize(120, 20);
		canvas.repaint(50);
		if (tab.getAllLegalMoves().isEmpty()) {
			if (tab.isInCheck(tab.getTurn()))
				messageLbl.setText("Checkmate!");
			else
				messageLbl.setText("Stalemate!");
			timer.suspend();
		} else if (tab.isInCheck(tab.getTurn()))
			messageLbl.setText("Check");
		else if (tab.getTurn())
			messageLbl.setText("white's move...");
		else
			messageLbl.setText("black's move...");

	}

}