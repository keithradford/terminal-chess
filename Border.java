public class Border {

    private int height;
    private int width;
    private char[][] board;

    public Border(int width, int height) {
        this.height = height;
        this.width = width;
        this.board = new char[this.width][this.height];
    }

    public void border() {
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                if ((x == 0 || x == (this.width) - 1) && (y == 0 || y == (this.height) - 1)) {
                    this.board[x][y] = '+';
                } else if ((y == 0 || y == (this.height) - 1) && (x != 0 || x != (this.width) - 1)) {
                    this.board[x][y] = '-';
                } else if ((y != 0 || y != (this.height) - 1) && (x == 0 || x == (this.width) - 1)) {
                    this.board[x][y] = '|';
                } else
                    this.board[x][y] = ' ';
            }
        }
    }

    public void render() {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                if (x == 0)
                    System.out.print("\n" + this.board[x][y]);
                else
                    System.out.print(this.board[x][y]);
            }
        }
    }

    public void replace(int x, int y, char ch){
        this.board[x][y] = ch;
    }

    public void snake(int x, int y){
        this.board[x][y] = 'X';
    }

    public void food(int x, int y){
        this.board[x][y] = 'O';
    }
 
} 
