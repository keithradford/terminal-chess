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

    public char getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }

    public void setOccupant(Piece occupant) {
        this.occupant = occupant;
    }

    public Boolean isEqual(Square s){
        if (s.getFile() == this.file && s.getRank() == this.rank)
            return true;
        return false;
    }
}
