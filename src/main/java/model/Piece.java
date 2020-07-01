package main.java.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import main.java.logic.Move;

abstract public class Piece {
	public final static boolean WHITE = true;
	public final static boolean BLACK = false;

	private Move m = Move.getInstance();
	private IteratorConvert itera;
	private Vector<String> vecStr;
	private Vector<Point> vecPnt;

	private boolean color;
	private int value;

	public Piece(boolean c) {
		List<Point> aux = setPoints(m.getRankChars(), m.getFileChars());
		vecPnt = new Vector<Point>(aux);
		vecStr = new Vector<String>(m.getCoord());

		color = c;
		value = 0;
	}

	public List<Point> setPoints(List<Character> rank, List<Character> file) {
		List<Point> lst = new ArrayList<Point>();

		List<Integer> lstInt = new LinkedList<Integer>();
		Iterator<Integer> iter = lstInt.iterator();

		for (char a : rank) {
			for (char b : file) {
				int auxC = Character.getNumericValue(a);

				Integer i = null;
				if (iter.hasNext()) {
					i = iter.next();

					// retorna os valores de chars como inteiros segundo a edicao em Iterator
					i = Integer.valueOf(b);
				}

				int tipeI = i.intValue();
				Point pt = new Point(auxC, tipeI);
				lst.add(pt);
			}

		}

		return lst;

	}

	public void getPoints(List<Point> points) {

	}

	/*
	 * getLegalMoves does not test for checks. Therefore, the calling statement
	 * should filter the moves through an isCheck() function
	 */
	abstract public Vector<Point> getLegalMoves(Point from);

	public boolean getColor() {
		return color;
	}

	public int getValue() {
		return value;
	}

	protected void setValue(int v) {
		value = v;
	}

}

/*
 * draw a piece given the lower left corner of the square abstract public void
 * drawPiece(int x, int y, Graphics g);
 * 
 * 
 * @Override public void drawPiece(int x, int y, Graphics g) { int[] X = { 10,
 * 20, 22, 22, 24, 25, 25, 24, 22, 20, 18, 17, 15, 13, 12, 10, 8, 6, 5, 5, 6, 8,
 * 8, 10 }; int[] Y = { 5, 5, 6, 10, 13, 15, 17, 18, 20, 20, 18, 22, 23, 22, 18,
 * 20, 20, 18, 17, 15, 13, 10, 6, 5 }; int i; for (i = 0; i < X.length; i++) {
 * X[i] += x; Y[i] = y - Y[i]; }
 * 
 * g.fillPolygon(X, Y, X.length); g.drawLine(x + 13, y - 25, x + 17, y - 25);
 * g.drawLine(x + 15, y - 27, x + 15, y - 23); }
 */
