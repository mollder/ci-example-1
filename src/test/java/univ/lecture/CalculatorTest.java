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
        assertThat(output, is(6.0));
    }
    @Test
    public void testCalculator4 () {
    	Application calc = new Application();
        double output = calc.calculator("2+3*(3-1)-(((7-3)/2)+6/3)+3+1");
        assertThat(output, is(8.0));
    }
    @Test
    public void testCalculator5 () {
    	Application calc = new Application();
        double output = calc.calculator("6/3");
        assertThat(output, is(2.0));
    }
    @Test
    public void testCalculator6 () {
    	Application calc = new Application();
        double output = calc.calculator("6/3+(2+1)");
        assertThat(output, is(5.0));
    }
    @Test
    public void testCalculator7 () {
    	Application calc = new Application();
        double output = calc.calculator("6/3+(2+1)-(1/2)");
        assertThat(output, is(4.5));
    }
}
