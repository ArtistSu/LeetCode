package Hard;

import org.junit.Assert;
import org.junit.Test;

public class temp {
    public int calculatePoints(double value, boolean dutyFree, int numFlights) {
        int points = 0;
        if (dutyFree) {
            if (value > 25)
                points += 3;
            else if (value > 20)
                points += 2;
            else if (value > 10)
                points += 1;
        } else {
            points += 1;
        }
        if (points > 2 && !dutyFree) {
            points += 1;
        }
        return points;
    }

    /**
     * 25< value <= Double.MAX_VALUE
     * dutyFree = true
     * Integer.MIN_VALUE <= numFlights <= Integer.MAX_VALUE
     */
    @Test
    public void test01() {
        int points = calculatePoints(26, true, 12);
        Assert.assertEquals(points, 3);
        System.out.println(points);
    }

    /**
     * 20< value <= 25
     * dutyFree = true
     * Integer.MIN_VALUE <= numFlights <= Integer.MAX_VALUE
     */
    @Test
    public void test02() {
        int points = calculatePoints(25, true, 12);
        Assert.assertEquals(points, 2);
        points = calculatePoints(21, true, 12);
        Assert.assertEquals(points, 2);
    }

    /**
     * Double.MIN_VALUE < value <= 20
     * dutyFree = true
     * Integer.MIN_VALUE <= numFlights <= Integer.MAX_VALUE
     */
    @Test
    public void test03() {
        int points = calculatePoints(20, true, 12);
        Assert.assertEquals(points, 1);
        points = calculatePoints(11, true, 12);
        Assert.assertEquals(points, 1);
    }

    /**
     * Double.MIN_VALUE < value <= 10
     * dutyFree = true
     * Integer.MIN_VALUE <= numFlights <= Integer.MAX_VALUE
     */
    @Test
    public void test04() {
        int points = calculatePoints(10, true, 12);
        Assert.assertEquals(points, 0);
        points = calculatePoints(-1, true, 12);
        Assert.assertEquals(points, 0);
    }

    /**
     * Double.MIN_VALUE < value <= Double.MAX_VALUE
     * dutyFree = false
     * Integer.MIN_VALUE <= numFlights <= Integer.MAX_VALUE
     */
    @Test
    public void test05() {
        int points = calculatePoints(-1, false, 12);
        Assert.assertEquals(points, 1);
        points = calculatePoints(200, false, 12);
        Assert.assertEquals(points, 1);
    }
}
