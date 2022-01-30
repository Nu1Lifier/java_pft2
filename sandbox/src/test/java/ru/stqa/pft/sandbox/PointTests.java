package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

@Test
  public void testDistancePositive(){

    Point p1 = new Point(15,10);
    Point p2 = new Point(30,15);

    Assert.assertEquals(p1.distance(p2),15.811388300841896);
  }

@Test
  public void testDistanceNegative(){

    Point p1 = new Point(15,10);
    Point p2 = new Point(30,15);

    Assert.assertEquals(p1.distance(p2),4);
  }
}
