package src.main;

public class Player {
    private int player;

    public Player(int player){
        this.player = player;
    }

    public String getPlayer(){
        if(this.player == 0){
            return "White";
        }
        else
            return "Black";
    }
}
