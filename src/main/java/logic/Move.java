package main.java.logic;

import java.util.ArrayList;
import java.util.List;

import main.java.gui.Jogo;

public class Move {

	private static Move instance;
	Jogo game = Jogo.getInstance();

	private static String rankStr = "1,2,3,4,5,6,7,8,";
	private static String fileStr = "a,b,c,d,e,f,g,h";
	private static int count = 1;
	private boolean turn;
	private List<Character> rankChars;
	private List<Character> fileChars;
	private List<String> coord;

	public Move() {
		// false para brancas true para pretas
		setTurn();
		setRank(rankChars);
		setFile(fileChars);
		setCasa();
		setCoord(coord);
	}

	// retorna a instancia pra classe Move.
	public static Move getInstance() {
		if (instance == null) {
			instance = new Move();
		}
		return instance;
	}

	/*
	 * public getonBoard() { }
	 */

	public void setTurn() {
		if (count % 2 != 0) {
			turn = false;
		} else {
			turn = true;
		}
	}

	public boolean getTurn() {
		return turn;
	}

	public void setRank(List<Character> e) {
		e = new ArrayList<Character>();

		for (char c : fileStr.toCharArray()) {
			e.add(c);
		}
	}

	public void setFile(List<Character> e) {
		e = new ArrayList<Character>();
		for (char c : rankStr.toCharArray()) {
			fileChars.add(c);
		}
	}

	public List<String> setCasa() {
		List<String> casa = new ArrayList<String>();
		for (char c : fileChars) {
			for (char d : rankChars) {
				String ponto = "" + c + d;
				casa.add(ponto);
			}
		}
		return casa;
	}

	public void setCoord(List<String> e) {
		e = setCasa();
	}

	public List<String> getCoord() {
		return coord;
	}

	public String getFileStr() {
		return fileStr;
	}

	public String getRankStr() {
		return rankStr;
	}

	public List<Character> getRankChars() {
		return rankChars;
	}

	public List<Character> getFileChars() {
		return fileChars;
	}

}