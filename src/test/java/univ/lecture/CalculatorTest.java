package univ.lecture;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class CalculatorTest {
    @Test
    public void testCalculatorAdd () {
    	Application calc = new Application();
        int output = (int) calc.calculator("1+1");
        assertThat(output, is(2));
    }
}