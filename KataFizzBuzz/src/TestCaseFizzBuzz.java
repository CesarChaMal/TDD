
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCaseFizzBuzz {

	FizzBuzz fizzBuzz;
	
	@Before
	public void setUp() throws Exception {
		fizzBuzz = new FizzBuzz();
	}
	
	@Test
	public void testNumero() {
		assertEquals("1", fizzBuzz.parseNumber(1));
		assertEquals("2", fizzBuzz.parseNumber(2));
		assertEquals("14", fizzBuzz.parseNumber(14));
		assertEquals("22", fizzBuzz.parseNumber(22));
		assertEquals("52", fizzBuzz.parseNumber(52));
	}
	
	@Test
	public void testFizz() {
		assertEquals("Fizz", fizzBuzz.parseNumber(3));
	}
	
	@Test
	public void testBuzz() {
		assertEquals("Buzz", fizzBuzz.parseNumber(5));
	}
	
	@Test
	public void testFizzBuzz() {
		assertEquals("FizzBuzz", fizzBuzz.parseNumber(15));
	}
}
