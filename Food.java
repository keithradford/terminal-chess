public class Food{
    
    private int x;
    private int y;

    public Food(){
        this.x = 0;
        this.y = 0;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void randomizer(int w, int h){
        this.x = (int)(Math.random() * ((w - 2) + 1)) + 1;
        this.y = (int)(Math.random() * ((h - 2) + 1)) + 1;
    }
}