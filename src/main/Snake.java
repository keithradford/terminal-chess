//package src.main;
//
//public class Snake {
//
//    private Node head;
//    private Node tail;
//    private int size;
//    private int score;
//
//    public Snake() {
//        head = null;
//        tail = null;
//        size = 1;
//        score = 0;
//    }// constructor
//
//    public Node getHead() {
//        return head;
//    }
//
//    public Node getTail() {
//        return tail;
//    }
//
//    public int getScore() {
//        return this.score;
//    }
//
//    public void sizeUp() {
//        this.size += 1;
//        this.score = (this.score * (this.size / 2)) + 10;
//    }// let src.main.Snake class know it got bigger
//
//    public void gameOver() {
//        int sc = this.score;
//        System.out.println("--------------------");
//        System.out.println("     GAME OVER!     ");
//        System.out.println("--------------------");
//        System.out.println("You finished with a score of: " + sc + "!");
//        System.out.println("Rerun the code to try again!");
//        System.exit(0);
//    }
//
//    public void enqueue(int x, int y) {
//        Node tmp = new Node(x, y);
//
//        if (head == null) {
//            head = tail = tmp;
//        } else {
//            tmp.next = tail;
//            tail = tmp;
//        }
//    }// enqueue new coordinates
//
//    public void move(int x, int y) {
//        Node tmp = new Node(x, y);
//
//        if (head == null) {
//            head = tail = tmp;
//        } else {
//            head.next = tmp;
//            head = tmp;
//        }
//    }
//
//    public void dequeue(Board game) {
//        game.replace(tail.getX(), tail.getY(), ' ');
//        tail = tail.next;
//    }
//
//    public void render(Board game) {
//        if (head.getX() == 0 || head.getX() == game.getWidth() - 1)
//            gameOver();
//
//        else if (head.getY() == 0 || head.getY() == game.getHeight() - 1)
//            gameOver();
//
//        if (size == 1) {
//            game.snake(head.getX(), head.getY());
//        } else {
//            Node tmp = tail;
//            for (int i = 0; i < size; i++) {
//                // if((head.getX() == tmp.getX()) && head.getY() == tmp.getY())
//                // gameOver();
//                // else{
//                game.snake(tmp.getX(), tmp.getY());
//                tmp = tmp.next;
//            }
//        }
//    }
//    // }
//
//    public void right(Board game, int prevX, int prevY) {
//        int x = (prevX + 1);
//        move(x, prevY);
//        dequeue(game);
//        render(game);
//    }// move right
//
//    public void left(Board game, int prevX, int prevY) {
//        int x = (prevX - 1);
//        move(x, prevY);
//        dequeue(game);
//        render(game);
//    }// move left
//
//    public void up(Board game, int prevX, int prevY) {
//        int y = (prevY - 1);
//        move(prevX, y);
//        dequeue(game);
//        render(game);
//    }// move up
//
//    public void down(Board game, int prevX, int prevY) {
//        int y = (prevY + 1);
//        move(prevX, y);
//        dequeue(game);
//        render(game);
//    }// move down
//}
