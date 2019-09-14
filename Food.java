public class Food{
    
    private int x;
    private int y;

    public Food(){
        this.x = 0;
        this.y = 0;
    }//constructor

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

   /* public boolean checkSnake(Snake s){
        Node tmp = s.getTail();
        if(s.getTail() == s.getHead()){
            if((s.getHead().getX() == this.x) && (this.y == s.getHead().getX()))
                return true;
        }
        else{
            if((tmp.getX() == this.x) && (this.y == tmp.getY()))
                return true;
            else    
                if(tmp.next != null)
                    tmp = tmp.next;
        }
        return false;
    }*/

    public void randomizer(int w, int h){
        this.x = (int)(Math.random() * ((w - 2) + 1)) + 1;
        this.y = (int)(Math.random() * ((h - 2) + 1)) + 1;
    }//randomize location
}
