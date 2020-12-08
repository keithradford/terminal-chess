package src.main;

import java.lang.*;

public class Piece {
    private char piece;
    private char colour;
    private int rank;
    private char file;

    public Piece(char piece, int rank, char file){
        this.piece = Character.toLowerCase(piece);
        if(Character.isUpperCase(piece))
            this.colour = 'w';
        else
            this.colour = 'b';
        this.rank = rank;
        this.file = file;
    }

    public char getColour() {
        return colour;
    }

    public char getFile() {
        return file;
    }

    public char getPiece() {
        return piece;
    }

    public int getRank() {
        return rank;
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
