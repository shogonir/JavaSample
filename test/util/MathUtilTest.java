package util;

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
}