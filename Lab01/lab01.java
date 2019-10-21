public class lab01 {
    public static void draw_line(double x0, double y0, double x1, double y1) {
        double x = x0;
        double y = y0;

        double x_dist = x1 - x0;
        double y_dist = y1 - y0;

        double x_step = x_dist / 100.0;
        double y_step = y_dist / 100.0;

        for (int i = 0; i < 100; i++) {
            x += x_step;
            y += y_step;
            System.out.println(x + " " + y); 
        }
    }

    public static void draw_circle(double x0, double y0, double r) {
        double alphaStep = 0.1;
        for (double i = 0.0; i <= 2 * Math.PI; i += alphaStep) {
            double x = x0 + r * Math.sin(i);
            double y = y0 + r * Math.cos(i);
            System.out.println(x + " " + y);
        }
    }
    public static void main(String args[]) {
        draw_line(28,65,28,84);
        draw_line(28,84,34,83);
        draw_line(34,83,38,79);
        draw_line(38,79,37,76);
        draw_line(37,76,34,73);
        draw_line(28,72,37,76);
        draw_line(58,25,53,23);
        draw_line(53,23,47,23);
        draw_line(47,23,44,25);
        draw_line(74,65,63,65);
        draw_line(63,65,73,74);
        draw_line(73,74,73,79);
        draw_line(73,79,70,82);
        draw_line(70,82,66,82);
        draw_line(66,82,63,80);
        draw_circle(50,74,9);
        draw_circle(50,29,14);
        draw_circle(55,34,2);
        draw_circle(46,34,2);
    }
}