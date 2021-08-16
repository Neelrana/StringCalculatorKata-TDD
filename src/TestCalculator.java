import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class TestCalculator {
    Calculator c = new Calculator();
    @Test
    public void TestEmptyString(){
        assertEquals(0,c.Add(""));
    }

    @Test
    public void TestOneNumString(){
        assertEquals(10,c.Add("10"));
    }

    @Test
    public void TestTwoNumString(){
        assertEquals(15,c.Add("5,10"));
    }
}
