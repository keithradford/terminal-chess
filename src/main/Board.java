package src.main;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Board {
    private static int SIZE = 18;

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
        int c, i, j, k;
        i = 0;
        j = 0;
        k = 0;

        // TODO: Fix new line problem to be more flexible
        while ((c = fileReader.read()) != -1) {
            Character[] piecesArray = new Character[] { 'r', 'n', 'b', 'q', 'k', 'p' };
            List<Character> pieces = Arrays.asList(piecesArray);

            char character = (char) c;
            Piece p = new Piece(character, this);
            Square s = new Square(j, intToFile(k), p);
            if (character == '\r') {
                i = 0;
                k = 0;
                j++;
                continue;
            }
            if (character == '\n') {
                continue;
            }
            if (pieces.contains(Character.toLowerCase(p.getPiece()))) {
                squares.add(s);
                k++;
            }
            this.board[i][j] = s;
            i++;
        }
    }// algorithm to create outline

    public void render() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                if (this.board[x][y] == null) {
                    return;
                }
                Piece p = this.board[x][y].getOccupant();
                char toPut = p.getPiece();
                if (x == 0) {
                    System.out.print("\n" + toPut);
                    continue;
                }
                if (p.getColour() == 'w')
                    toPut = Character.toUpperCase(toPut);

                System.out.print(toPut);
            }
        }
        // System.out.println("\nScore: " + s.getScore());
    }// prints border

    private char intToFile(int n) {
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
}
