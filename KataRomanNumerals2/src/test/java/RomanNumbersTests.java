package test.java;

import junit.framework.TestCase;
import main.java.kataromannumerals.RomanNumeralsConverter;

import org.junit.Test;

public class RomanNumbersTests extends TestCase {
	@Test
    public void testSimple() {
		RomanNumeralsConverter converter = new RomanNumeralsConverter();

		assertEquals("I",converter.convertToRomanNumeral(1));
		assertEquals("V",converter.convertToRomanNumeral(5));
		assertEquals("X",converter.convertToRomanNumeral(10));
	}
	
	@Test
    public void testSuma() {
		RomanNumeralsConverter converter = new RomanNumeralsConverter();

		assertEquals("II",converter.convertToRomanNumeral(2));
		assertEquals("CCC",converter.convertToRomanNumeral(300));
		assertEquals("VII",converter.convertToRomanNumeral(7));
		assertEquals("XXXV",converter.convertToRomanNumeral(35));
		
	}
	

	@Test
	public void testResta(){
		RomanNumeralsConverter converter = new RomanNumeralsConverter();

		assertEquals("IV",converter.convertToRomanNumeral(4));
		
	}

}