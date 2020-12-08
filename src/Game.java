package src;

import java.util.Scanner;

public class Game {

    private static int WIDTH = 20;
    private static int HEIGHT = 10;

    private static Scanner scanner = new Scanner(System.in);
    private static char input;
    private static String sInput;
    private static boolean run = false;
    // private static boolean appleInSnake = true;

    public static void start() {
        System.out.println("--------------------");
        System.out.println("Welcome to SNAKE!");
        System.out.println("--------------------");
        System.out.println(
                "You are the 'X', the food is the 'O'.\n Run into the wall or yourself and it's game over. \nPRESS ENTER after EVERY input to move. \n TYPE 'START' then hit ENTER to begin ");
        System.out.println("W = up");
        System.out.println("A = left");
        System.out.println("S = down");
        System.out.println("D = right");
        switch (sInput = scanner.nextLine().strip()) {
            case "START":
                run = true;
                break;
        }
    }

    public static void main(String[] args) {
        Border area = new Border(WIDTH, HEIGHT); // Create new game area
        Snake s = new Snake(); // Create new snake
        Food f = new Food(); // Create new food

        // Original rendering of the game
        f.randomizer(WIDTH - 1, HEIGHT - 1);
        s.enqueue(WIDTH / 4, HEIGHT / 4);
        area.border();
        area.snake(WIDTH / 4, HEIGHT / 4);
        area.food(f.getX(), f.getY());

        start();

        while (run == true) {
            area.render(s);
            if ((s.getHead().getX() == f.getX()) && (s.getHead().getY() == f.getY())) {
                s.enqueue((s.getTail().getX()) - 1, s.getTail().getY());
                s.sizeUp();
                // while(appleInSnake = true){
                f.randomizer(WIDTH - 1, HEIGHT - 1);
                // appleInSnake = f.checkSnake(s);
                // }
                area.food(f.getX(), f.getY());
            } // Snake eats the food
            try {
                switch (input = scanner.nextLine().charAt(0)) {
                    case 'a':
                        s.left(area, s.getHead().getX(), s.getHead().getY());
                        break;// A pressed

                    case 's':
                        s.down(area, s.getHead().getX(), s.getHead().getY());
                        break;// S pressed

                    case 'd':
                        s.right(area, s.getHead().getX(), s.getHead().getY());
                        break;// D pressed

                    case 'w':
                        s.up(area, s.getHead().getX(), s.getHead().getY());
                        break;// W pressed
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("-------ERROR!-------");
                System.out.println("Press W,A,S, or D");
                System.out.println("--------------------");
                continue;
            }
        }
    }

}
