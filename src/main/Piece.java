package src.main;

import java.util.LinkedList;
import java.util.List;

public class Piece {
    private char piece;
    private char colour;
    private Board board;
    private List<String> possibleMoves;

    public Piece(char piece, Board board){
        this.piece = Character.toLowerCase(piece);
        if(Character.isUpperCase(piece))
            this.colour = 'w';
        else
            this.colour = 'b';
        this.board = board;
    }

    public List<String> getPossibleMoves() {
        if(this.piece == 'p')
            return pawnMoves();
        return possibleMoves;
    }

    // check 1 ahead, 2 ahead if on 2nd/7th rank
    // check diagonals for captures
    public List<String> pawnMoves() {
        List<String> m = new LinkedList<String>();
        // char[][] b = this.board.getBoard();
        // String tmp = "";
        // StringBuilder sb = new StringBuilder(tmp);
        // if(this.colour == 'w'){
        //     if(b[Character.getNumericValue(this.file) - 9][this.rank + 1] == ' '){
        //         sb.setCharAt(0, this.file);
        //     }
        // }
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

    public Boolean isEquals(Piece p){
        if(
            p.getPiece() == this.piece
        )
            return true;

        return false;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
