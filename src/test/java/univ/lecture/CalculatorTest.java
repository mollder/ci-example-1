package univ.lecture;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class CalculatorTest {
    @Test
    public void testCalculatorAdd () {
    	Application calc = new Application();
        double output = calc.calculator("2+3");
        assertThat(output, is(5.0));
    }
    @Test
    public void testCalculator2 () {
    	Application calc = new Application();
        double output = calc.calculator("2+3*(3-1)");
        assertThat(output, is(7.0));
    }
    @Test
    public void testCalculator3 () {
    	Application calc = new Application();
        double output = calc.calculator("2+3*(3-1)-((7-3)/2)");
        assertThat(output, is(7.0));
    }
}
