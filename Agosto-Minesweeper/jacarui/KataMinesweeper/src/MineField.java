import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MineField {

	private int fieldNumber;
	private List<String> rows;
	private int fieldHeigth;
	private int fieldWidth;

	public MineField(int fieldNumber, String mineField) {
		this.fieldNumber = fieldNumber;
		setRows(mineField);
	}

	private void setRows(String mineField) {
		String[] rows = mineField.split("\n");
		String[] fieldDimensions = rows[0].split(" ");
		
		fieldHeigth = Integer.parseInt(fieldDimensions[0]);
		fieldWidth = Integer.parseInt(fieldDimensions[1]);
		
		this.rows = new ArrayList<String>(Arrays.asList(rows));
		this.rows.remove(0);
	}

	public String getHeader() {
		return "Field #" + (fieldNumber) + ":\n";
	}

	public int getFieldWidth() {
		return fieldWidth;
	}

	public int getFieldHeigth() {
		return fieldHeigth;
	}
	
	public String getRow(int index) {
		return this.getRows().get(index);
	}

	public List<String> getRows() {
		return rows;
	}

	public char getPosition(int rowNumber, int columnNumber) {
		return this.getRow(rowNumber).charAt(columnNumber);
	}

}
