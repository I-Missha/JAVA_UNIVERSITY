package task3.View.GraphicView.Figures;

import java.awt.*;

public class FigureEight implements FigureNumber{
    int x, y, width, height, line_width;

    public FigureEight(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.line_width = height / 7;
    }

    @Override
    public void draw(Graphics g) {
        int[] xPoints1 = {
                (int) (width * (double) 4 / 20),
                (int) (width * (double)4 / 20),
                (int) (width * (double)5 / 20),
                (int) (width * (double)12 / 20),
                (int) (width * (double)13 / 20),
                (int) (width * (double)13 / 20),
                (int) (width * (double)12 / 20),
                (int) (width * (double)5 / 20)
               };

        int[] yPoints1 = {
                (int) (width * (double) 4 / 20),
                (int) (height * (double)14 / 20),
                (int) (height * (double)15 / 20),
                (int) (height * (double)15 / 20),
                (int) (width * (double)14 / 20),
                (int) (width * (double)4 / 20),
                (int) (width * (double)3 / 20),
                (int) (width * (double)3 / 20)

        };
        int[] xPoints2 = {
                (int) (width * (double) 6 / 20),
                (int) (width * (double) 11 / 20),
                (int) (width * (double) 11 / 20),
                (int) (width * (double)6 / 20),
        };
        int[] yPoints2 = {
                (int) (height * (double)6 / 20),
                (int) (height * (double)6 / 20),
                (int) (height * (double)8 / 20),
                (int) (height * (double)8 / 20),
        };
        int[] xPoints3 = {
                (int) (width * (double)6 / 20),
                (int) (width * (double)11 / 20),
                (int) (width * (double)11 / 20),
                (int) (width * (double)6 / 20)
        };
        int[] yPoints3 = {
                (int) (height * (double)11 / 20),
                (int) (height * (double)11 / 20),
                (int) (height * (double)13 / 20),
                (int) (height * (double)13 / 20),
        };
        FigureNumber.setGraphics((Graphics2D) g, xPoints1, yPoints1, x, y, Color.getHSBColor((float) 0.1, 1F, (float) 0.9));
        FigureNumber.setGraphics((Graphics2D) g, xPoints2, yPoints2, x, y, Color.getHSBColor((float) 0.8, 0.1F, (float) 0.93));
        FigureNumber.setGraphics((Graphics2D) g, xPoints3, yPoints3, x, y, Color.getHSBColor((float) 0.8, 0.1F, (float) 0.93));
    }
}
