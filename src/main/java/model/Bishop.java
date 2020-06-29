package main.java.model;

import java.util.Vector;

import main.java.logic.Move;

public class Bishop extends Piece {
	public Bishop(boolean c) {
		super(c);
		setValue(3);
	}

	public Vector getLegalMoves(Point from, Tabuleiro b) {

		Vector v = new Vector();
		int dx, dy;
		Point tempPoint = new Point();
		int distance;
		boolean blocked;

		if (getColor() == b.getTurn())
			for (dx = -1; dx <= 1; dx += 2)
				for (dy = -1; dy <= 1; dy += 2) {
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

	public void drawPiece(int x, int y, Graphics g) {
		int[] X = { 5, 13, 17, 25, 25, 17, 18, 20, 20, 19, 17, 18, 14, 13, 12, 11, 10, 10, 11, 12, 5, 5 };
		int[] Y = { 5, 7, 7, 5, 8, 8, 10, 15, 17, 20, 25, 16, 25, 23, 21, 18, 15, 12, 10, 8, 8, 5 };
		int i;
		for (i = 0; i < X.length; i++) {
			X[i] += x;
			Y[i] = y - Y[i];
		}
		g.fillPolygon(X, Y, X.length);
	}
}
