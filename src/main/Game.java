package src.main;

import java.io.IOException;
import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);
    private static String sInput;
    private static boolean run = false;

    private static Player white = new Player(0);
    private static Player black = new Player(1);
    // private static boolean appleInSnake = true;

    public static void start() {
        System.out.println(
                "--------------------\n" +
                "Welcome to CHESS!\n" +
                "--------------------\n" +
                "The WHITE pieces are the uppercase letters, the BLACK pieces are the lowercase letters.\n" +
                "talk about rules\n" +
                "PRESS ENTER after EVERY input to move.\n " +
                "TYPE 'START' then hit ENTER to begin"
        );
        switch (sInput = scanner.nextLine().strip()) {
            case "START":
                run = true;
                break;
            case "start":
                run = true;
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        Board board = new Board("./resources/board.txt"); // Create new game area
        int toMove = 0;
//        Player white = new Player();
//        Player black = new Player();

        // Original rendering of the game


//        f.randomizer(WIDTH - 1, HEIGHT - 1);
//        s.enqueue(WIDTH / 4, HEIGHT / 4);
//        board.border();
//        board.snake(WIDTH / 4, HEIGHT / 4);
//        board.food(f.getX(), f.getY());

        start();

        board.initialize();

        while (run == true) {
            board.render();
//            if ((s.getHead().getX() == f.getX()) && (s.getHead().getY() == f.getY())) {
//                s.enqueue((s.getTail().getX()) - 1, s.getTail().getY());
//                s.sizeUp();
//                // while(appleInSnake = true){
//                f.randomizer(WIDTH - 1, HEIGHT - 1);
//                // appleInSnake = f.checkSnake(s);
//                // }
//                area.food(f.getX(), f.getY());
//            } // src.main.Snake eats the food
//            try {
            if(toMove == 0){
                System.out.println("\nWhite to move: ");
                toMove = 1;
                sInput = scanner.nextLine().strip();
                Move move = new Move(sInput, white, board);
                System.out.println("Move: " + move.getMove() + " " + move.getMove().length() + " is a valid move?: " + move.isValid());
                move.makeMove();
            }
            else{
                System.out.println("\nBlack to move: ");
                toMove = 0;
                sInput = scanner.nextLine().strip();
                Move move = new Move(sInput, black, board);
                System.out.println("Move: " + move.getMove() + " Is a valid move?: " + move.isValid());
                move.makeMove();
            }

//            } catch (StringIndexOutOfBoundsException e) {
//                System.out.println("-------ERROR!-------");
//                System.out.println("Press W,A,S, or D");
//                System.out.println("--------------------");
//                continue;
//            }
        }
    }

}
