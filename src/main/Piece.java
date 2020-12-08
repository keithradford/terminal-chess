package src.main;

import java.lang.*;

public class Piece {
    private char piece;
    private char colour;
    private char rank;
    private int file;

    public Piece(char piece, char rank, int file){
        this.piece = Character.toLowerCase(piece);
        if(Character.isUpperCase(piece))
            this.colour = 'w';
        else
            this.colour = 'b';
        this.rank = rank;
        this.file = file;
    }
}
