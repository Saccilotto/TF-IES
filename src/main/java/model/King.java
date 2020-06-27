package main.java.model;

import java.awt.Point;
import java.util.Vector;

public class King extends Piece {

	public King(boolean c) {
		super(c);
		setValue(1000);
	}

	@Override
	public Vector getLegalMoves(Point from, ChessBoard b) {
		Vector v = new Vector();
		int dx, dy;
		Point tempPoint = new Point();

		/* Check for castling */
		if (b.canCastle(b.getTurn(), 'Q'))
			v.addElement(new Move(from, new Point(from.rank, 2), 'Q'));

		if (b.canCastle(b.getTurn(), 'K'))
			v.addElement(new Move(from, new Point(from.rank, 6), 'K'));

		/* Check normal moves */
		if (getColor() == b.getTurn())
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
}