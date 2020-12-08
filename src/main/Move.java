package src.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Move {
    private String move;
    private Player player;

    public Move(String move, Player player){
        this.move = move;
        this.player = player;
    }

    public Boolean isValid(){
        Pattern pattern = Pattern.compile("[KQNBR][a-h]?x?[a-h]x?[1-8]|(?:[a-h]x?[a-h]?[1-8])", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(this.move);
        boolean matchFound = matcher.find();

        return matchFound;
    }

    public String getMove() {
        return move;
    }
}
