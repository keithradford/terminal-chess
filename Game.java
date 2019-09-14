import java.util.Scanner;

public class Game{

    private static int WIDTH = 20;
    private static int HEIGHT = 10;

      public static void main(String[] args) {
        Border area = new Border(WIDTH, HEIGHT);
        Snake s = new Snake();
        Food f = new Food();
        f.randomizer(WIDTH - 1, HEIGHT - 1);
        s.enqueue(WIDTH / 4, HEIGHT / 4);
        area.border();
        area.snake(WIDTH / 4, HEIGHT / 4);
        area.food(f.getX(), f.getY());

        Scanner scanner = new Scanner(System.in);
        char input;
        
        boolean run = true;

        while(run == true){
            area.render();
            if((s.getHead().getX() == f.getX()) && (s.getHead().getY() == f.getY())){
                s.enqueue((s.getTail().getX())-1, s.getTail().getY());
                s.sizeUp();
                f.randomizer(WIDTH - 1, HEIGHT - 1);
                area.food(f.getX(), f.getY());
            }//eat
            switch (input = scanner.nextLine().charAt(0)) {
                case 'a':
				    s.left(area, s.getHead().getX(), s.getHead().getY());
                break;

                case 's':
				    s.down(area, s.getHead().getX(), s.getHead().getY());
                break;
                
                case 'd':
				    s.right(area, s.getHead().getX(), s.getHead().getY());
                break;
                
                case 'w':
				    s.up(area, s.getHead().getX(), s.getHead().getY());
				break;
            }
            
        }
    }

}