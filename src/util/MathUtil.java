package util;

import model.Line2;
import model.Point2;

/**
 * Created by shogo on 2017/11/30.
 */
public class MathUtil {

    public static double calculateExternalAngle(Point2 p1, Point2 p2, Point2 p3) {
        Point2 v1 = p2.subtract(p1);
        Point2 v2 = p2.subtract(p3);
        double angleRadian = Math.acos(v1.innerProduct(v2) / (v1.magnitude() * v2.magnitude()));
        double angleDegree = angleRadian * 180 / Math.PI;
        if (v1.outerProduct(v2) > 0) {
            return angleDegree - 180;
        } else {
            return 180 - angleDegree;
        }
    }

    public static boolean lineIntersects(Line2 l1, Line2 l2) {
        return lineIntersects(l1, l2, false);
    }

    public static boolean lineIntersects(Line2 l1, Line2 l2, boolean includesEndPoints) {
        double ax = l1.getS().getX();
        double ay = l1.getS().getY();
        double bx = l1.getT().getX();
        double by = l1.getT().getY();
        double cx = l2.getS().getX();
        double cy = l2.getS().getY();
        double dx = l2.getT().getX();
        double dy = l2.getT().getY();
        double ta = (cx - dx) * (ay - cy) + (cy - dy) * (cx - ax);
        double tb = (cx - dx) * (by - cy) + (cy - dy) * (cx - bx);
        double tc = (ax - bx) * (cy - ay) + (ay - by) * (ax - cx);
        double td = (ax - bx) * (dy - ay) + (ay - by) * (ax - dx);

        if (includesEndPoints) {
            return tc * td <= 0 && ta * tb <= 0;
        }

        return tc * td < 0 && ta * tb < 0;
    }

    public static boolean lineIntersection(Line2 l1, Line2 l2, Point2 intersection) {
        return lineIntersection(l1, l2, intersection, false);
    }

    public static boolean lineIntersection(Line2 l1, Line2 l2, Point2 intersection, boolean includesEndPoints) {
        if (!lineIntersects(l1, l2, includesEndPoints)) {
            intersection = null;
            return false;
        }

        double ax = l1.getS().getX();
        double ay = l1.getS().getY();
        double bx = l1.getT().getX();
        double by = l1.getT().getY();
        double cx = l2.getS().getX();
        double cy = l2.getS().getY();
        double dx = l2.getT().getX();
        double dy = l2.getT().getY();
        double d = (bx - ax) * (dy - cy) - (by - ay) * (dx - cx);
        double u = ((cx - ax) * (dy - cy) - (cy - ay) * (dx - cx)) / d;
        double v = ((cx - ax) * (by - ay) - (cy - ay) * (bx - ax)) / d;

        if ((!includesEndPoints && (u <= 0 || u >= 1 || v <= 0 || v >= 1)) ||
                (includesEndPoints && (u < 0 || u > 1 || v < 0 || v > 1))) {
            intersection = null;
            return false;
        }

        double x = ax + u * (bx - ax);
        double y = ay + u * (by - ay);
        intersection.set(x, y);
        return true;
    }
}
