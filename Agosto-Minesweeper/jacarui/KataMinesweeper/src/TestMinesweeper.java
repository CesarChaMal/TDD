
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class TestMinesweeper {

	private List<String> fields;
	private Minesweeper minesweeper;

	@Before
	public void setUp() throws Exception {
		fields = new ArrayList<String>();
		minesweeper = new Minesweeper();
	}
	
	@Test
	public void testOutputPerFieldMinesweeper() throws Exception {
		StringBuilder field1 = new StringBuilder("2 2\n");
		field1.append("..\n");
		field1.append("..\n");
		fields.add(field1.toString());
		StringBuilder field2 = new StringBuilder("2 2\n");
		field2.append("..\n");
		field2.append("..\n");
		fields.add(field2.toString());
		minesweeper.setFields(fields);		
		String firstFieldSolution = "Field #1:\n";
		String secondFieldSolution = "Field #2:\n";
		
		String solution = minesweeper.getSolution();

		System.out.println(solution);
		
		Assert.assertTrue(solution.contains(firstFieldSolution));
		Assert.assertTrue(solution.contains(secondFieldSolution));
	}
	
	@Test
	public void testBlankOneSizedField() {
		StringBuilder blankField = new StringBuilder("1 1\n");
		blankField.append(".\n");
		fields.add(blankField.toString());
		minesweeper.setFields(fields);

		String solution = minesweeper.getSolution();
		
		Assert.assertEquals("Field #1:\n0\n", solution);
	}
	
	@Test
	public void testBlankTwoSizedField() {
		StringBuilder blankField = new StringBuilder("2 2\n");
		blankField.append("..\n");
		blankField.append("..\n");
		fields.add(blankField.toString());
		minesweeper.setFields(fields);
		
		String solution = minesweeper.getSolution();
		
		Assert.assertEquals("Field #1:\n00\n00\n", solution);
	}

	@Test
	public void testOneMineOneSizedField() {
		StringBuilder blankField = new StringBuilder("1 1\n");
		blankField.append("*\n");
		fields.add(blankField.toString());
		minesweeper.setFields(fields);

		String solution = minesweeper.getSolution();
		
		Assert.assertEquals("Field #1:\n*\n", solution);
	}

	@Test
	public void testOneMineTwoSizedField() {
		StringBuilder blankField = new StringBuilder("2 2\n");
		blankField.append("*.\n");
		blankField.append("..\n");
		fields.add(blankField.toString());
		minesweeper.setFields(fields);
		
		String solution = minesweeper.getSolution();
		
		Assert.assertEquals("Field #1:\n*1\n11\n", solution);
	}
	
	@Test
	public void testEightMinesIrregularSizedField() {
		StringBuilder blankField = new StringBuilder("2 5\n");
		blankField.append("*..**\n");
		blankField.append("*****\n");
		fields.add(blankField.toString());
		minesweeper.setFields(fields);
		
		String solution = minesweeper.getSolution();
		
		Assert.assertEquals("Field #1:\n*44**\n*****\n", solution);
	}

}
/*
Problem Description

Input:
- Arbitrary number of fields.
- The first line of each field contains two integers n and m (0 < n,m <= 100) 
which stands for the number of lines and columns of the field respectively. 
- The next n lines contains exactly m characters and represent the field. 
- Each safe square is represented by an "." character (without the quotes) and each mine 
square is represented by an "*" character (also without the quotes). 
- The first field line where n = m = 0 represents the end of input and should not be processed.

Output:
- For each field, you must print the following message in a line alone Where x stands for the number of the field (starting from 1).
	Field #x:
- The next n lines should contain the field with the "." characters replaced by the 
number of adjacent mines to that square. 
- There must be an empty line between field outputs.


Clues

As you may have already noticed, each square may have at most 8 adjacent squares.

Suggested Test Cases

This is the acceptance test input:

4 4
*...
....
.*..
....
3 5
**...
.....
.*...
0 0
and output:
Field #1:
*100
2210
1*10
1110

Field #2:
**100
33200
1*100

*/