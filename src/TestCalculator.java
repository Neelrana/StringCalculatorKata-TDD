import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class TestCalculator {
    Calculator c = new Calculator();
    @Test
    public void TestEmptyString(){
        assertEquals(0,c.Add(""));
    }
}
