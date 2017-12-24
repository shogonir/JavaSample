package model;

/**
 * Created by shogo on 2017/11/30.
 */
public class Point2 {

    private double x;
    private double y;

    public Point2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public Point2 subtract(Point2 point) {
        return new Point2(this.x - point.x, this.y - point.y);
    }

    public double innerProduct(Point2 point) {
        return this.x * point.x + this.y * point.y;
    }

    public double outerProduct(Point2 point) {
        return this.x * point.y - this.y * point.x;
    }

    @Override
    public String toString() {
        return String.format("Point2(x=%f, y=%f)", this.x, this.y);
    }
}
