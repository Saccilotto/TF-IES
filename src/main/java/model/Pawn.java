package main.java.model;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

import main.java.logic.Move;

public class Pawn extends Piece {
	public Pawn(boolean c) {
		super(c);
		setValue(1);
	}

	@Override
	public Vector getLegalMoves(Point from, Tabuleiro b) {
		Vector v = new Vector();
		int dx, dy;
		Point tempPoint = new Point();

		if (getColor() == b.getTurn()) {
			/* Find the direction for the pawn */
			if (b.getTurn() == WHITE)
				dy = 1;
			else
				dy = -1;

			/* Check for straight ahead move */
			tempPoint.file = from.file;
			tempPoint.rank = from.rank + dy;

			if (!(b.isOccupied(tempPoint))) {
				/* forward promotion */
				if (tempPoint.rank == 0 || tempPoint.rank == 7)
					v.addElement(new Move(from, tempPoint, true));

				else
					v.addElement(new Move(from, tempPoint));

				/* Also check for double move */
				tempPoint.rank = from.rank + 2 * dy;
				tempPoint.file = from.file;
				if (tempPoint.onBoard() && !(b.isOccupied(tempPoint)) && (from.rank == 1 || from.rank == 6))
					v.addElement(new Move(from, tempPoint));
			}

			/* Check for attack */
			for (dx = -1; dx <= 1; dx += 2) {
				tempPoint.file = from.file + dx;
				tempPoint.rank = from.rank + dy;

				if (tempPoint.onBoard() && b.isOccupied(tempPoint) && b.getPiece(tempPoint).getColor() != getColor()) {
					if (tempPoint.rank > 0 && tempPoint.rank < 7)
						v.addElement(new Move(from, tempPoint));

					/* capture promotion */
					else
						v.addElement(new Move(from, tempPoint, true));

				}

				/* Check for en passant */
				else if (getColor() == BLACK && tempPoint.rank == 2) {
					Point capPoint = new Point(3, tempPoint.file);
					Move lastMove = b.getLastMove();
					if (tempPoint.onBoard() && b.isOccupied(capPoint) && b.getPiece(capPoint).getColor() == WHITE
							&& b.getPiece(capPoint).getValue() == 1
							&& lastMove.equals(new Move(new Point(1, tempPoint.file), capPoint)))
						v.addElement(new Move(from, tempPoint, capPoint));
				} else if (getColor() == WHITE && b.allMoves.size() > 0 && tempPoint.rank == 5) {
					Point capPoint = new Point(4, tempPoint.file);
					Move lastMove = b.getLastMove();
					if (tempPoint.onBoard() && b.isOccupied(capPoint) && b.getPiece(capPoint).getColor() == BLACK
							&& b.getPiece(capPoint).getValue() == 1
							&& lastMove.equals(new Move(new Point(6, tempPoint.file), capPoint)))
						v.addElement(new Move(from, tempPoint, capPoint));
				}

			}
		}
		return v;
	}

	@Override
	public void drawPiece(int x, int y, Graphics g) {
		int[] X = { 5, 25, 23, 21, 18, 20, 20, 18, 22, 20, 17, 13, 10, 8, 12, 10, 10, 12, 9, 7, 5 };
		int[] Y = { 5, 5, 7, 8, 9, 11, 14, 16, 16, 17, 18, 18, 17, 16, 16, 14, 11, 9, 8, 7, 5 };
		int i;
		for (i = 0; i < X.length; i++) {
			X[i] += x;
			Y[i] = y - Y[i];
		}

		g.fillPolygon(X, Y, X.length);
		g.fillOval(x + 12, y - 23, 6, 6);

	}
}
