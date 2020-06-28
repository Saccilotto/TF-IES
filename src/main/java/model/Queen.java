package main.java.model;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

import main.java.logic.Move;

public class Queen extends Piece {

	public Queen(boolean c) {
		super(c);
		setValue(9);
	}

	public Vector getLegalMoves(Point from, ChessBoard b) {

		Vector v = new Vector();
		int dx, dy;
		Point tempPoint = new Point();
		int distance;
		boolean blocked;

		if (getColor() == b.getTurn())
			for (dx = -1; dx <= 1; dx++)
				for (dy = -1; dy <= 1; dy++) {
					distance = 1;
					blocked = false;
					while (!blocked) {
						tempPoint.file = from.file + dx * distance;
						tempPoint.rank = from.rank + dy * distance;

						if (!tempPoint.onBoard())
							blocked = true;
						else if (!(b.isOccupied(tempPoint)))
							v.addElement(new Move(from, tempPoint));
						else if (b.getPiece(tempPoint).getColor() != getColor()) {
							v.addElement(new Move(from, tempPoint));
							blocked = true;
						} else
							blocked = true;
						distance++;
					}
				}
		return v;
	}

	@Override
	public void drawPiece(int x, int y, Graphics g) {

		int[] X = { 10, 20, 20, 28, 19, 20, 15, 10, 11, 2, 10, 10 };
		int[] Y = { 5, 5, 10, 18, 14, 25, 16, 25, 14, 18, 10, 5 };
		int i;
		for (i = 0; i < X.length; i++) {
			X[i] += x;
			Y[i] = y - Y[i];
		}

		g.fillPolygon(X, Y, X.length);
	}
}
