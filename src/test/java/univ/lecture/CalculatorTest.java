package univ.lecture;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class CalculatorTest {
    @Test
    public void testCalculatorAdd () {
    	Application calc = new Application();
        double output = calc.calculator("1+1");
        assertThat(output, is(2));
    }
    @Test
    public void testCalculatorAdd2 () {
    	Application calc = new Application();
        double output = calc.calculator("1+5");
        assertThat(output, is(6));
    }
    @Test
    public void testCalculator1 () {
    	Application calc = new Application();
        double output = calc.calculator("(1+5)*4");
        assertThat(output, is(24));
    }
}
