package main.java.model;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Vector;

import main.java.logic.Move;

public class Rook extends Piece {
	public Rook(boolean c) {
		super(c);
		setValue(5);
	}

	@Override
	public Vector getLegalMoves(Point from, Tabuleiro b) {

		Vector v = new Vector();
		int dx, dy;
		Point tempPoint = new Point();
		int distance;
		boolean blocked;

		if (getColor() == b.getTurn()) {
			/* Check the horizontals */
			for (dx = -1; dx <= 1; dx += 2) {
				distance = 1;
				blocked = false;
				while (!blocked) {
					tempPoint.file = from.file + dx * distance;
					tempPoint.rank = from.rank;

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
			/* Check the verticals */
			for (dy = -1; dy <= 1; dy += 2) {
				distance = 1;
				blocked = false;
				while (!blocked) {
					tempPoint.file = from.file;
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
		}
		return v;
	}

	@Override
	public void drawPiece(int x, int y, Graphics g) {
		Polygon polyrook = new Polygon();
		polyrook.addPoint(5 + x, -25 + y);
		polyrook.addPoint(5 + x, -18 + y);
		polyrook.addPoint(10 + x, -18 + y);
		polyrook.addPoint(10 + x, -8 + y);
		polyrook.addPoint(5 + x, -8 + y);
		polyrook.addPoint(5 + x, -5 + y);
		polyrook.addPoint(25 + x, -5 + y);
		polyrook.addPoint(25 + x, -8 + y);
		polyrook.addPoint(20 + x, -8 + y);
		polyrook.addPoint(20 + x, -18 + y);
		polyrook.addPoint(25 + x, -18 + y);
		polyrook.addPoint(25 + x, -25 + y);
		polyrook.addPoint(22 + x, -25 + y);
		polyrook.addPoint(22 + x, -22 + y);
		polyrook.addPoint(18 + x, -22 + y);
		polyrook.addPoint(18 + x, -25 + y);
		polyrook.addPoint(12 + x, -25 + y);
		polyrook.addPoint(12 + x, -22 + y);
		polyrook.addPoint(8 + x, -22 + y);
		polyrook.addPoint(8 + x, -25 + y);
		polyrook.addPoint(5 + x, -25 + y);

		g.fillPolygon(polyrook);

	}
}
