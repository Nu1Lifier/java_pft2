package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

@Test
  public void testDistance1(){

    Point p1 = new Point(15,10);
    Point p2 = new Point(30,15);

    Assert.assertEquals(p1.distance(p2),15.811388300841896);
  }

@Test
  public void testDistance2(){

    Point p1 = new Point(5,2);
    Point p2 = new Point(10,5);

    Assert.assertEquals(p1.distance(p2),5.830951894845301);
  }
}
