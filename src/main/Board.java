package src.main;

import java.io.*;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Board {

    private String path;
    private char[][] board;

    public Board(String path) {
        this.path = path;
        this.board = new char[10][10];
    }// constructor

    public void initialize() throws IOException {
        URL path = Board.class.getResource(this.path);
        File file = new File(path.getFile());
        FileReader fileReader = new FileReader(file);
        int c, i, j;
        i = 0;
        j = 0;

        //TODO: Fix new line problem to be more flexible
        while((c = fileReader.read()) != -1){
            char character = (char) c;
            if(character == '\r'){
                i = 0;
                j++;
                continue;
            }
            if(character == '\n'){
                continue;
            }
            this.board[i][j] = character;
            i++;
        }
    }// algorithm to create outline

    public void render() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (x == 0)
                    System.out.print("\n" + this.board[x][y]);
                else
                    System.out.print(this.board[x][y]);
            }
        }
//        System.out.println("\nScore: " + s.getScore());
    }// prints border
//
//    public void replace(int x, int y, char ch) {
//        this.board[x][y] = ch;
//    }// replace location with new char
//
//    public void snake(int x, int y) {
//        this.board[x][y] = 'X';
//    }// place snake
//
//    public void food(int x, int y) {
//        this.board[x][y] = 'O';
//    }// place food

}
