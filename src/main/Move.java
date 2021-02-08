// package src.main;

// import java.util.List;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

// public class Move {
// private String move;
// private Player player;
// private Board board;

// public Move(String move, Player player, Board board) {
// this.move = move;
// this.player = player;
// this.board = board;
// }

// private char getFile() {
// Pattern pattern = Pattern.compile("(?:[KQNBR]|[a-h])([a-h])",
// Pattern.CASE_INSENSITIVE);
// Matcher matcher = pattern.matcher(this.move);
// char match = '\0';
// while (matcher.find()) {
// // Get the group matched using group() method
// match = matcher.group(1).charAt(0);
// }
// System.out.println("file to move to: " + match);
// return match;
// }

// private int getRank() {
// Pattern pattern = Pattern.compile("[1-8]", Pattern.CASE_INSENSITIVE);
// Matcher matcher = pattern.matcher(this.move);
// int match = 0;
// while (matcher.find()) {
// // Get the group matched using group() method
// match = Character.getNumericValue(matcher.group().charAt(0));
// }
// System.out.println("rank to move to: " + match);
// return match;
// }

// private char getPiece() {
// Pattern pattern =
// Pattern.compile("(?:([KQNBR][a-h]?)[a-h][1-8]|(?:[a-h][a-h]?[1-8]))",
// Pattern.CASE_INSENSITIVE);
// Matcher matcher = pattern.matcher(this.move);
// char match = '\0';
// while (matcher.find()) {
// // Get the group matched using group() method
// match = (matcher.group().charAt(0));
// break;
// }
// System.out.println("piece to move: " + match);
// return match;
// }

// public void makeMove() {
// if (!this.isValid() || this.player.isInCheck())
// return;

// int rank = this.getRank();
// char file = this.getFile();
// char piece = this.getPiece();

// Piece p = new Piece(piece, board);
// Square toMove = new Square(rank, file, p);
// List<Square> squares = this.board.getSquares();
// Square s = null;
// Square tmp = null;

// Square[][] board = this.board.getBoard();

// int size = squares.size();
// for (int i = 0; i < size; i++) {
// s = squares.get(i);
// tmp = s;
// tmp.setOccupant(null);
// p = s.getOccupant();
// if (s.isEqual(toMove)) {
// squares.set(i, toMove);
// board[Character.getNumericValue(tmp.getFile()) - 9][tmp.getRank()] = tmp;
// board[Character.getNumericValue(s.getFile()) - 9][s.getRank()] = s;

// this.board.setBoard(board);
// this.board.setSquares(squares);
// break;
// }
// }
// }

// public Boolean isValid() {
// Pattern pattern =
// Pattern.compile("(?:[KQNBR][a-h]?[a-h][1-8]|(?:[a-h][a-h]?[1-8]))",
// Pattern.CASE_INSENSITIVE);
// Matcher matcher = pattern.matcher(this.getMove());
// boolean matchFound = matcher.find();

// return matchFound;
// }

// public String getMove() {
// return this.move;
// }
// }
