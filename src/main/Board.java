package src.main;

import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class Board {
    private static int SIZE = 10;
    private String path;
    private char[][] board;
    private List<Piece> pieces = new LinkedList<Piece>();

    public Board(String path) {
        this.path = path;
        this.board = new char[SIZE][SIZE];
    }// constructor

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
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
                System.out.println("character: " + character + " " + j + " " + intToRank(i - 1));
                Piece p = new Piece(character, j, intToRank(i - 1));
                pieces.add(p);
            }
            this.board[i][j] = character;
            i++;
        }
        int size = this.pieces.size();
        for(int h = 0; h < size; h++){
            Piece p = this.pieces.get(h);
            // System.out.println(p.getPiece() + " " + p.getFile() + " " + p.getRank());
        }
    }// algorithm to create outline

    public void render() {
        int size = this.pieces.size();
        for(int i = 0; i < size; i++){
            Piece p = this.pieces.get(i);
            char toPut;
            if(p.getColour() == 'w'){
                toPut = Character.toUpperCase(p.getPiece());
            }
            else{
                toPut = Character.toLowerCase(p.getPiece());
            }
            // System.out.println(p.getPiece() + " " + (Character.getNumericValue(p.getRank()) - 9) + " " + p.getFile());
            this.board[Character.getNumericValue(p.getRank()) - 9][p.getFile()] = toPut;
        }

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (x == 0)
                    System.out.print("\n" + this.board[x][y]);
                else
                    System.out.print(this.board[x][y]);
            }
        }
//        System.out.println("\nScore: " + s.getScore());
    }// prints border

    private char intToRank(int n){
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
