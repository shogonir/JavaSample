package util;

import model.Line2;
import model.Point2;
import org.junit.Test;

/**
 * Created by shogo on 2017/11/30.
 */
public class MathUtilTest {

    @Test
    public void calculateExternalAngle() throws Exception {
        Point2 one = new Point2(1.0, 0.0);
        Point2 zero = new Point2(0.0, 0.0);
        for (int angleDegree = 0; angleDegree <= 360; angleDegree += 10) {
            double angleRadian = angleDegree / 180f * Math.PI;
            Point2 point = new Point2(Math.cos(angleRadian), Math.sin(angleRadian));
            double externalAngleDegree = MathUtil.calculateExternalAngle(one, zero, point);
            System.out.println(String.format("%4d -> %8.3f", angleDegree, externalAngleDegree));
        }
    }

    @Test
    public void lineIntersection() throws Exception {
        Point2 intersection = new Point2(0, 0);
        Line2 l1 = new Line2(new Point2(0, 0), new Point2(1, 1));
        Line2 l2 = new Line2(new Point2(0, 1), new Point2(1, 0));
        MathUtil.lineIntersection(l1, l2, intersection);
        System.out.println(intersection.toString());
    }
}
