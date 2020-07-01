package main.java.model;

import java.awt.Point;
import java.util.Vector;

import main.java.logic.Info;
import main.java.logic.Move;
import main.resources.LoadImages;

public class King extends Piece {
	private LoadImages load = LoadImages.getInstance();
	private Move mov = Move.getInstance();

	public King(boolean c) {
		super(c);
		Info f = super.f;
		Vector<String> str = super.vecStr;
		Vector<Point> pnt = super.vecPnt;
		setValue(1000);
	}

	@Override
	public Vector<Move> getLegalMoves(Point from) {
		Vector<Move> v = new Vector<Move>();
		int dx, dy;
		Point tempPoint = new Point();

		/* Check normal moves */
		if (getColor() == f.getTurn())
			for (dx = -1; dx <= 1; dx++)
				for (dy = -1; dy <= 1; dy++) {
					tempPoint.x = from.x + dx;
					tempPoint.y = from.y + dy;
					// !tempPoint.getLocation() ==
					if (mov.isOccupied(tempPoint)) {
						;
					} else if (!(mov.isOccupied(tempPoint)) || (mov.getPiece(tempPoint).getColor() != getColor()))
						v.addElement(new Move(from, tempPoint));
				}
		return v;
	}

	@Override
	public void drawPiece() {

	}

}
