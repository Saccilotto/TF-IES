package main.java.model;

import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import main.java.gui.Jogo;

public abstract class Piece {
	public final static boolean WHITE = true;
	public final static boolean BLACK = false;

	public Jogo game;
	public Tabuleiro t;
	private static Piece instance;

	private Map<Point, Jogo> mp;
	private boolean color;
	private int value;

	public Piece(boolean c) {
		mp = new HashMap<Point, Jogo>();
		color = c;
		value = 0;
	}

	/*
	 * getLegalMoves does not test for checks. Therefore, the calling statement
	 * should filter the moves through an isCheck() function
	 */

	abstract Map<Point, Jogo> getLegalMoves();

	abstract Map<Point, Jogo> getLegalMoves(Point from, Jogo game);

	/* draw a piece given the lower left corner of the square */
	public abstract void drawPiece(int x, int y, Graphics g);

	public boolean getColor() {
		return color;
	}

	public int getValue() {
		return value;
	}

	protected void setValue(int v) {
		value = v;
	}

	public Map<Point, Jogo> getMp() {
		return mp;
	}
}
