package util;

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
}
