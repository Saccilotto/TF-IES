package main.java.logic;

import java.awt.Point;

import main.java.gui.Jogo;
import main.java.model.Piece;

public class Move {

	private Jogo game = Jogo.getInstance();
	private static Move instance;

	public Move(Point from, Point tempPoint) {

	}

	}

	// retorna a instancia pra classe Move.
	public static Move getInstance() {
		return instance;
	}

	/*
	 * public String getPiece(Point p) { // Piece peca = peca.get; String s; if
	 * ((p.getX() == rowFrom) && (p.getY() == colFrom)) { s =
	 * peca.getClass().getName(); } return peca }
	 * 
	 * public void getonBoard() { }
	 * 
	 * public boolean isOccupied(Point e) { if ((game.getTabuleiro().getLayoutX() ==
	 * e.getX() && game.getTabuleiro().getLayoutY() == e.getY())) { return true; }
	 * else { return false; } }
	 */
}