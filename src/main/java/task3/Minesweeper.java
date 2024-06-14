package task3;

import task3.Controller.GraphicController;

import java.io.IOException;

public class Minesweeper {
    public static void main(String[] args) throws IOException {
        GraphicController controller = new GraphicController();
        controller.newGame();
    }
}

