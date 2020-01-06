import java.util.ArrayList;

public class Points {
    private ArrayList<Point> points;

    public Points() {
        this.points = new ArrayList<>();
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public Point get(int i) {
        return points.get(i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Point point : points) {
            sb.append(point.toString());
        }
        return new String(sb);
    }
}
