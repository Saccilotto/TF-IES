package main.java.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import main.java.logic.Move;

public class Convert implements Conversor {
	// private static IteratorConvert instance;
	private LinkedList<Character> lst;
	private Move m = Move.getInstance();
	private List<Integer> result;

	public Convert(LinkedList<Character> lst) {
		result = new ArrayList<Integer>();
		this.lst = lst;
		charInteger(lst);
	}

	@Override
	public List<Integer> charInteger(List<Character> listC) {
		List<Integer> lst = new ArrayList<Integer>();
		int i = 0;
		int aux1;
		char aux = m.getFileChars().get(i);
		Integer inte = 0;
		while (listC.get(i) == aux) {
			// transforma char em numero
			aux1 = Character.getNumericValue(aux);
			inte = inte.intValue();
			lst.add(inte);
			i++;
		}
		return lst;
	}
	/*
	 * public static IteratorConvert getInstance() { if (instance == null) {
	 * instance = new IteratorConvert(); } return instance; }
	 */
}
