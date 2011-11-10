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
		assertEquals("L",converter.convertToRomanNumeral(50));
		assertEquals("C",converter.convertToRomanNumeral(100));
		assertEquals("D",converter.convertToRomanNumeral(500));
		assertEquals("M",converter.convertToRomanNumeral(1000));
	}
	
	@Test
    public void testSum() {
		RomanNumeralsConverter converter = new RomanNumeralsConverter();

		assertEquals("II",converter.convertToRomanNumeral(2));
		assertEquals("III",converter.convertToRomanNumeral(3));
		assertEquals("VI",converter.convertToRomanNumeral(6));
		assertEquals("XVI",converter.convertToRomanNumeral(16));
		assertEquals("LXVI",converter.convertToRomanNumeral(66));
		assertEquals("CLX",converter.convertToRomanNumeral(160));
		assertEquals("DX",converter.convertToRomanNumeral(510));
		assertEquals("MI",converter.convertToRomanNumeral(1001));
	}
	
	@Test
    public void testRest() {
		RomanNumeralsConverter converter = new RomanNumeralsConverter();

		assertEquals("IV",converter.convertToRomanNumeral(4));
		assertEquals("XIV",converter.convertToRomanNumeral(14));
		assertEquals("XIX",converter.convertToRomanNumeral(19));
		assertEquals("XLVII",converter.convertToRomanNumeral(47));
		assertEquals("XC",converter.convertToRomanNumeral(90));
		assertEquals("MMDCCLI",converter.convertToRomanNumeral(2751));
		assertEquals("CCCLXIX",converter.convertToRomanNumeral(369));
		assertEquals("IX",converter.convertToRomanNumeral(9));
		assertEquals("CM",converter.convertToRomanNumeral(900));
		
	}
}

	