package main.java.model;

import java.awt.Point;
import java.util.Vector;

import main.java.logic.Move;

public class King extends Piece {
	private static King instance;

	public King(boolean c) {
		super(c);
		Move m = super.m;
		Vector<String> str = super.vecStr;
		Vector<Point> pnt = super.vecPnt;
		setValue(1000);
	}

	@Override
	public Vector<Move> getLegalMoves(Point from) {
		Vector v = new Vector();
		int dx, dy;
		Point tempPoint = new Point();

		/* Check normal moves */
		if (getColor() == m.getTurn())
			for (dx = -1; dx <= 1; dx++)
				for (dy = -1; dy <= 1; dy++) {
					tempPoint.file = from.file + dx;
					tempPoint.rank = from.rank + dy;

					if (!tempPoint.onBoard())
						;
					else if (!(b.isOccupied(tempPoint)) || (b.getPiece(tempPoint).getColor() != getColor()))
						v.addElement(new Move(from, tempPoint));
				}
		return v;
	}

	public static King getInstance() {
		if (instance == null) {
			instance = new King();
		}
		return instance;
	}

	@Override
	public void drawPiece(int x, int y) {
		int[] X = { 10, 20, 22, 22, 24, 25, 25, 24, 22, 20, 18, 17, 15, 13, 12, 10, 8, 6, 5, 5, 6, 8, 8, 10 };
		int[] Y = { 5, 5, 6, 10, 13, 15, 17, 18, 20, 20, 18, 22, 23, 22, 18, 20, 20, 18, 17, 15, 13, 10, 6, 5 };
		int i;
		for (i = 0; i < X.length; i++) {
			X[i] += x;
			Y[i] = y - Y[i];
		}

		g.fillPolygon(X, Y, X.length);
		g.drawLine(x + 13, y - 25, x + 17, y - 25);
		g.drawLine(x + 15, y - 27, x + 15, y - 23);
	}
}
