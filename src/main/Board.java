package src.main;

import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class Board {
    private static int SIZE = 10;
    private String path;
    private Square[][] board;
    private List<Square> squares = new LinkedList<Square>();

    public Board(String path) {
        this.path = path;
        this.board = new Square[SIZE][SIZE];
    }// constructor

    public List<Square> getSquares() {
        return squares;
    }

    public void setSquares(List<Square> squares) {
        this.squares = squares;
    }

    public Square[][] getBoard() {
        return board;
    }

    public void setBoard(Square[][] board) {
        this.board = board;
    }

    public void initialize() throws IOException {
        URL path = Board.class.getResource(this.path);
        File file = new File(path.getFile());
        FileReader fileReader = new FileReader(file);
        int c, i, j;
        i = 0;
        j = 0;

        //TODO: Fix new line problem to be more flexible
        while((c = fileReader.read()) != -1){
            char character = (char) c;
            Piece p = new Piece(character, this);
            Square s = new Square(j, intToFile(i - 1), p);
            if(character == '\r'){
                i = 0;
                j++;
                continue;
            }
            if(character == '\n'){
                continue;
            }
            if(
                character != ' ' &&
                character != '+' &&
                character != '-' &&
                character != '|' &&
                character != ' '
            ){
                squares.add(s);
            }
            this.board[i][j] = s;
            i++;
        }
    }// algorithm to create outline

    public void render() {
        // int size = this.squares.size();
        // for(int i = 0; i < size; i++){
        //     Square s = this.squares.get(i);
        //     char toPut;
        //     if(p.getColour() == 'w'){
        //         toPut = Character.toUpperCase(p.getPiece());
        //     }
        //     else{
        //         toPut = Character.toLowerCase(p.getPiece());
        //     }
        //     // System.out.println(p.getPiece() + " " + (Character.getNumericValue(p.getFile()) - 9) + " " + p.getRank());
        //     this.board[Character.getNumericValue(p.getFile()) - 9][p.getRank()] = toPut;
        // }

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                Piece p = this.board[x][y].getOccupant();
                if (x == 0)
                    System.out.print("\n" + p.getPiece());
                else
                    System.out.print(p.getPiece());
            }
        }
//        System.out.println("\nScore: " + s.getScore());
    }// prints border

    private char intToFile(int n){
        switch (n) {
            case 0:
                return 'a';

            case 1:
                return 'b';

            case 2:
                return 'c';

            case 3:
                return 'd';

            case 4:
                return 'e';

            case 5:
                return 'f';

            case 6:
                return 'g';

            case 7:
                return 'h';

            default:
                break;
        }
        return '\0';
    }
//
//    public void replace(int x, int y, char ch) {
//        this.board[x][y] = ch;
//    }// replace location with new char
//
//    public void snake(int x, int y) {
//        this.board[x][y] = 'X';
//    }// place snake
//
//    public void food(int x, int y) {
//        this.board[x][y] = 'O';
//    }// place food

}
