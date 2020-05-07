public class Node {

    private int x;
    private int y;
    protected Node next;

    public Node() {
        this.x = 0;
        this.y = 0;
        this.next = null;
    }

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.next = null;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}