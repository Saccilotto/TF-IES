import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

abstract public class Piece {
	public final static boolean WHITE = true;
	public final static boolean BLACK = false;

	private boolean color;
	private int value;

	public Piece(boolean c) {
		color = c;
		value = 0;
	}

	/*
	 * getLegalMoves does not test for checks. Therefore, the calling statement
	 * should filter the moves through an isCheck() function
	 */
	abstract public Vector getLegalMoves(Point from, Tabuleiro b);

	/* draw a piece given the lower left corner of the square */
	abstract public void drawPiece(int x, int y, Graphics g);

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

class King extends Piece {
	public King(boolean c) {
		super(c);
		setValue(1000);
	}

	@Override
	public Vector getLegalMoves(Point from, Tabuleiro b) {
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

	@Override
	public void drawPiece(int x, int y, Graphics g) {
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
