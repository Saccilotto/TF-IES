package main.java.model;

import java.awt.Point;
import java.util.ArrayList;

import main.java.logic.Regras;

public class Tabuleiro {

	public Tabuleiro() {
		contents = new Piece[8][8];
		turn = WHITE;
		allMoves = new ArrayList();

		/* Set up the board */
		newBoard();

		whiteKing = new Point(0, 4);
		blackKing = new Point(7, 4);
		whiteKingMoved = false;
		blackKingMoved = false;
		whiteKRookMoved = false;
		whiteQRookMoved = false;
		blackKRookMoved = false;
		blackQRookMoved = false;
		legalMoves = new ArrayList<>();
	}

	/* constructor for making copy */
	public Tabuleiro(Regras r)
	{
		int rank,file;
		Point p = new Point();
		contents = new Piece[8][8];
		turn = r.getTurn();
		for (rank = 0;rank < 8;rank++)
			for (file=0;file<8;file++)
			{
				p.setLocation( rank, file);
				if (b.isOccupied(p))
					contents[rank][file] = b.getPiece(p);
			}
		whiteKing = b.getKing(WHITE);
		blackKing = b.getKing(BLACK);
		
		/* Castling info */
		whiteKingMoved = b.whiteKingMoved;
		whiteKRookMoved = b.whiteKRookMoved;
		whiteQRookMoved = b.whiteQRookMoved;
		blackKingMoved = b.blackKingMoved;
		blackKRookMoved = b.blackKRookMoved;
		blackQRookMoved = b.blackQRookMoved;
		
		/* copy the moves vector */
		//allMoves = new Vector();
		Enumeration enum = b.allMoves.elements();
		while (enum.hasMoreElements())
			allMoves.addElement(enum.nextElement());
		
		/* copy the legal moves vector */
		legalMoves = new Vector();
		enum = b.legalMoves.elements();
		while (enum.hasMoreElements())
			legalMoves.addElement(enum.nextElement());
		
		
	}

	public void newBoard() {
		int i;
		/* erase pieces from middle */
		int rank, file;
		for (rank = 2; rank < 6; rank++)
			for (file = 0; file < 8; file++)
				contents[rank][file] = null;

		/* pawns */
		for (i = 0; i < 8; i++) {
			contents[1][i] = new Pawn(WHITE);
			contents[6][i] = new Pawn(BLACK);
		}

		contents[0][0] = new Rook(WHITE);
		contents[0][1] = new Knight(WHITE);
		contents[0][2] = new Bishop(WHITE);
		contents[0][3] = new Queen(WHITE);
		contents[0][4] = new King(WHITE);
		contents[0][5] = new Bishop(WHITE);
		contents[0][6] = new Knight(WHITE);
		contents[0][7] = new Rook(WHITE);

		contents[7][0] = new Rook(BLACK);
		contents[7][1] = new Knight(BLACK);
		contents[7][2] = new Bishop(BLACK);
		contents[7][3] = new Queen(BLACK);
		contents[7][4] = new King(BLACK);
		contents[7][5] = new Bishop(BLACK);
		contents[7][6] = new Knight(BLACK);
		contents[7][7] = new Rook(BLACK);

		turn = WHITE;

	}
}
