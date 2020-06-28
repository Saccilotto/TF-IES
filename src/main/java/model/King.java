package main.java.model;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.gui.Jogo;
import main.java.logic.Move;

public class King extends Piece {
	Map map;

	public King(boolean c) {
		super(c);
		Map map = super.getMp();
		Tabuleiro tab = super.t;
		setValue(1000);
	}

	@Override
	public Map<Point, Jogo> getLegalMoves(Point from, Jogo g) {
		List<Point> house = new ArrayList<Point>();
		int dx, dy;
		Point tempPoint = new Point();

		/* Check for castling */
		if (t.canCastle(t.getTurn(), 'Q'))
			house.addAll(new Move(from, new Point(from.rank, 2), 'Q'));

		if (t.canCastle(b.getTurn(), 'K'))
			house.add(new Move(from, new Point(from.rank, 6), 'K'));

		/* Check normal moves */
		if (getColor() == t.getTurn())
			for (dx = -1; dx <= 1; dx++)
				for (dy = -1; dy <= 1; dy++) {
					tempPoint.file = from.file + dx;
					tempPoint.rank = from.rank + dy;

					if (!tempPoint.onBoard()) {
						// tempPoint.getClass().equals();
					} else if (!(b.isOccupied(tempPoint)) || (b.getPiece(tempPoint).getColor() != getColor()))
						v.addElement(new Move(from, tempPoint));
				}
		Map.entry(house, g);
		Map<Point, Jogo> map;
		return map;
	}

	@Override
	public void drawPiece(int x, int y, Graphics g) {

	}

	@Override
	Map<Point, Jogo> getLegalMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}