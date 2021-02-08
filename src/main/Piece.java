package src.main;

import java.util.LinkedList;
import java.util.List;

public class Piece {
    private char piece;
    private char colour;
    private char file;
    private int rank;
    private Board board;
    private List<String> possibleMoves;

    public Piece(char piece, int rank, char file, Board board) {
        this.piece = Character.toLowerCase(piece);
        if (Character.isUpperCase(piece))
            this.colour = 'w';
        else
            this.colour = 'b';
        this.board = board;
        this.rank = rank;
        this.file = file;
    }

    public List<String> getPossibleMoves() {
        switch (this.piece) {
            case 'p':
                return pawnMoves();

            default:
                break;
        }

        return possibleMoves;
    }

    // check 1 ahead, 2 ahead if on 2nd/7th rank
    // check diagonals for captures
    public List<String> pawnMoves() {
        List<String> m = new LinkedList<String>();
        if (this.colour == 'b') {
            // for(int j = )
        }
        return possibleMoves;
    }

    public List<String> knightMoves() {
        return possibleMoves;
    }

    public List<String> bishopMoves() {
        return possibleMoves;
    }

    public List<String> rookMoves() {
        return possibleMoves;
    }

    public List<String> queenMoves() {
        return possibleMoves;
    }

    public List<String> kingMoves() {
        return possibleMoves;
    }

    public char getColour() {
        return colour;
    }

    public char getPiece() {
        return piece;
    }

    public Boolean isEquals(Piece p) {
        if (p.getPiece() == this.piece)
            return true;

        return false;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
