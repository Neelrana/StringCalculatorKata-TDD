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

    @Test
    public void TestAllowManyNumString(){
        assertEquals(30,c.Add("5,10,15"));
    }

    @Test
    public void TestNewLineManyNumString(){
        assertEquals(6,c.Add("1\n2,3"));
    }

    @Test
    public void TestDiffDelimiterManyNumString(){
        assertEquals(3,c.Add("//*\n1*2"));
    }

    @Test
    public void TestNegativeNumberIsUsedString(){
        try{
            c.Add("-6,-5,4");
        }
        catch(IllegalArgumentException e){
            assertEquals("Negative numbers are not allowed -6,-5",e.getMessage());
        }
    }

    @Test
    public void TestIgnoredGreaterThan1000Num(){
        assertEquals(2,c.Add("2,1001"));
    }

    @Test
    public void TestManyDelimiterManyNumString(){
        assertEquals(6,c.Add("//[***]\n1***2***3"));
    }



}
