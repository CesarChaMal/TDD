import java.util.List;


public class Minesweeper {

	private List<String> fields;
	private char MINE = '*';
	private MineField currentMineField;

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

	public String getSolution() {
		String solution = "";
		
		for (int i = 0; i < fields.size(); i++) {
			currentMineField = new MineField(i+1, fields.get(i));
			solution += currentMineField.getHeader();
			solution += getFieldSolution();
		}
		
		return solution;
	}

	private String getFieldSolution() {
		String fieldSolution = "";
		char[] rowPositions;
		int rowNumber = 0;
		
		for (String row : currentMineField.getRows()) {
			rowPositions = getRowPositions(row);
			fieldSolution += getRowSolution(rowPositions, rowNumber);			
			fieldSolution += "\n";
			rowNumber++;
		}
		
		return fieldSolution;
	}

	private char[] getRowPositions(String row) {
		char[] rowPositions = new char[row.length()];
		row.getChars(0, row.length(), rowPositions, 0);
		return rowPositions;
	}

	private String getRowSolution(char[] rowPositions, int rowNumber) {
		String rowSolution = "";
		
		for (int columnNumber = 0; columnNumber < rowPositions.length; columnNumber++) {
			if(isMine(rowPositions[columnNumber]))
				rowSolution += MINE;
			else
				rowSolution += getNearMines(rowNumber, columnNumber);
		}
		
		return rowSolution;
	}

	private boolean isMine(char rowPosition) {
		return MINE == rowPosition;
	}

	private int getNearMines(int rowNumber, int columnNumber) {
		int nearMines = 0;
		
		nearMines += getNearMinesByRow(rowNumber - 1, columnNumber);
		nearMines += getNearMinesByRow(rowNumber, columnNumber);
		nearMines += getNearMinesByRow(rowNumber + 1, columnNumber);
		
		return nearMines;
	}
	
	private int getNearMinesByRow(int rowNumber, int columnNumber) {
		int minesFound = 0;
		if(isMinedPosition(rowNumber, columnNumber-1)) minesFound++;
		if(isMinedPosition(rowNumber, columnNumber)) minesFound++;
		if(isMinedPosition(rowNumber, columnNumber+1)) minesFound++;
		return minesFound;
	}

	private boolean isMinedPosition(int rowNumber, int columnNumber) {
		if(rowNumber < 0 || rowNumber >= currentMineField.getFieldHeigth())
			return false;
		if(columnNumber < 0 || columnNumber >= currentMineField.getFieldWidth())
			return false;
		
		return currentMineField.getPosition(rowNumber, columnNumber) == MINE;
	}

}
