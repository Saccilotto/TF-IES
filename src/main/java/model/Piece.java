package main.java.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javafx.scene.image.Image;
import main.java.logic.Info;

abstract public class Piece {
	public final static boolean WHITE = true;
	public final static boolean BLACK = false;

	public Info f = Info.getInstance();
	public Vector<String> vecStr;
	public Vector<Point> vecPnt;

	// False para brancas, true para pretas
	private boolean color;
	private int value;
	private Convert conv;

	public Piece(boolean c) {
		List<Point> aux = setPoints(f.getRankChars(), f.getFileChars());
		vecPnt = new Vector<Point>(aux);
		vecStr = new Vector<String>(f.getCoord());

		color = c;
		value = 0;
	}

	public List<Point> setPoints(List<Character> rank, List<Character> file) {
		// instancia Arraylst de Point
		List<Point> lst = new ArrayList<Point>();
		int i;
		int x;
		int y;

		Integer j;
		Integer k;
		/*
		 * instancia ArrayList de Integer para fazer conversao alfabeto para numero para
		 * adicionar valores int,int em point relativo as coordenadas
		 */
		List<Integer> convertidoFile = conv.charInteger(f.getRankChars());
		for (char a : rank) {
			for (char b : file) {
				i = 0;
				// Integer k= Integer.valueOf(a);
				// adiciona os valores convertidos de chars para inteiros segundo a classe
				// Conversor
				j = convertidoFile.get(i);
				// cast para de Integer para int referente a x(rank)
				x = j.intValue();
				// cast para de char para int referente a y(files)
				y = Character.getNumericValue(b);

				Point pt = new Point(x, y);
				lst.add(pt);

				i++;
			}
		}
		return lst;
	}

	public Vector<Point> getVPoint() {
		return vecPnt;
	}

	public abstract void adicionarPeca();

	public abstract Image getPecaImg();

	public abstract void drawPiece();

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
