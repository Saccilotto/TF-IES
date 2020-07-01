package main.java.logic;

import java.awt.Point;

import main.java.gui.Jogo;

public class Move {
	int rowFrom;
	int rowPoint;
	int colFrom;
	int colPoint;

	private static Move instance;
	private Jogo game = Jogo.getInstance();

	public Move(Point from, Point tempPoint) {
		rowFrom = (int) from.getX();
		colFrom = (int) from.getY();
		rowPoint = (int) tempPoint.getX();
		colPoint = (int) tempPoint.getY();

	}

	// retorna a instancia pra classe Move.
	public static Move getInstance() {
		return instance;
	}

	public String getPiece(Point p) {
		// Piece peca = peca.get;
		String s;
		if ((p.getX() == rowFrom) && (p.getY() == colFrom)) {
			s = peca.getClass().getName();
		}
		return peca
	}

	public void getonBoard() {
	}

	public boolean isOccupied(Point e) {
		if ((game.getTabuleiro().getLayoutX() == e.getX() && game.getTabuleiro().getLayoutY() == e.getY())) {
			return true;
		} else {
			return false;
		}
	}
}