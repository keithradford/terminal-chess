package src.main;

public class Square {
    private char file;
    private int rank;
    private Piece occupant;

    public Square(int rank, char file){
        this.file = file;
        this.rank = rank;
        this.occupant = null;
    }

    public Square(int rank, char file, Piece occupant){
        this.file = file;
        this.rank = rank;
        this.occupant = occupant;
    }

    public Piece getOccupant() {
        return occupant;
    }
}
