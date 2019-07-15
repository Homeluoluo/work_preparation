package junit.learn.test;

import junit.learn.MyMath;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Classname MyMathTest
 * @Description TODO
 * @Date 2019/4/24 8:24
 * @Created by luojia
 */
public class MyMathTest {
    MyMath math=new MyMath();
    @Test
    public void abs() {
        assertEquals(0,math.abs(0));
        assertEquals(1,math.abs(-1));
        assertEquals(1,math.abs(1));
    }

    @Test
    public void add() {
    }
}