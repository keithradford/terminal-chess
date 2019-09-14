public class Snake{

    private Node head;
    private Node tail;
    private int size;

    public Snake(){
        head = null;
        tail = null;
        size = 1;
    }

    public Node getHead(){
        return head;
    }

    public Node getTail(){
        return tail;
    }

    public void sizeUp(){
        this.size += 1;
    }

    public void enqueue(int x, int y){
        Node tmp = new Node(x, y);

        if(head == null){
            head = tail = tmp;
        }
        else{
          tmp.next = tail;
          tail = tmp;
        }
    }

    public void move(int x, int y){
        Node tmp = new Node(x, y);

        if(head == null){
            head = tail = tmp;
        }
        else{
            head.next = tmp;
            head = tmp;
        }
    }

    public void dequeue(Border game){
        game.replace(tail.getX(), tail.getY(), ' ');
        tail = tail.next;
    }

    public void render(Border game){
        if(size == 1){
            game.snake(head.getX(), head.getY());
        }
        else{
            Node tmp = tail;
            for(int i = 0; i < size; i++){
                game.snake(tmp.getX(), tmp.getY());
                tmp = tmp.next;
            }
        }
    }

    public void right(Border game, int prevX, int prevY){
        int x = (prevX + 1);
        move(x, prevY);
        dequeue(game);
        render(game);
    }

    public void left(Border game, int prevX, int prevY){
        int x = (prevX - 1);
        move(x, prevY);
        dequeue(game);
        render(game);
    }

    public void up(Border game, int prevX, int prevY){
        int y = (prevY - 1);
        move(prevX, y);
        dequeue(game);
        render(game);
    }

    public void down(Border game, int prevX, int prevY){
        int y = (prevY + 1);
        move(prevX, y);
        dequeue(game);
        render(game);
    }
}