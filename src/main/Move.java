package src.main;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Move {
    private String move;
    private Player player;
    private Board board;

    public Move(String move, Player player, Board board){
        this.move = move;
        this.player = player;
        this.board = board;
    }

    private char getFile(){
        Pattern pattern = Pattern.compile("[1-8]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(this.move);
        char match = '\0';
        while (matcher.find()) {
            // Get the group matched using group() method
            match = matcher.group().charAt(0);
        }
        System.out.println("rank to move to: " + match);
        return match;
    }

    private int getRank(){
        Pattern pattern = Pattern.compile("(?:[KQNBR]|[a-h])([a-h])", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(this.move);
        int match = 0;
        while (matcher.find()) {
            // Get the group matched using group() method
            match = Character.getNumericValue(matcher.group(1).charAt(0));
        }
        System.out.println("file to move to: " + match);
        return match - 9;
    }

    private char getPiece(){
        Pattern pattern = Pattern.compile("([KQNBR]|[a-h])", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(this.move);
        char match = '\0';
        while (matcher.find()) {
            // Get the group matched using group() method
            match = (matcher.group().charAt(0));
            break;
        }
        System.out.println("piece to move: " + match);
        return match;
    }

    public void makeMove(){
        if(!this.isValid() || this.player.isInCheck())
            return;

        int rank = this.getRank();
        char file = this.getFile();
        char piece = this.getPiece();

        Piece toMove = new Piece(piece, rank, file);
        List<Piece> pieces = this.board.getPieces();
        Piece p = null;

        char[][] board = this.board.getBoard();

        int size = pieces.size();
        for(int i = 0; i < size; i++){
            p = pieces.get(i);
            if(p.isEquals(toMove)){
                pieces.set(i, toMove);
                board[Character.getNumericValue(p.getRank()) - 9][p.getFile()] = ' ';

                this.board.setBoard(board);
                this.board.setPieces(pieces);
                break;
            }
        }
    }

    public Boolean isValid(){
        Pattern pattern = Pattern.compile("(?:[KQNBR][a-h]?[a-h][1-8]|(?:[a-h][a-h]?[1-8]))", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(this.getMove());
        boolean matchFound = matcher.find();

        return matchFound;
    }

    public String getMove() {
        return this.move;
    }
}
