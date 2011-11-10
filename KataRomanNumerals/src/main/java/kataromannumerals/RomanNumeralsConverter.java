package main.java.kataromannumerals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralsConverter {

	private Map<String, Integer> romanNumerals;
	private Map<String, String> sustitutos;
	
	public RomanNumeralsConverter(){
		
		romanNumerals = new LinkedHashMap<String, Integer>();
		romanNumerals.put("M", 1000);
		romanNumerals.put("D", 500);
		romanNumerals.put("C", 100);
		romanNumerals.put("L", 50);
		romanNumerals.put("X", 10);
		romanNumerals.put("V", 5);
		romanNumerals.put("I", 1);
		
		sustitutos = new HashMap<String, String>();
		sustitutos.put("IIII", "IV");
		sustitutos.put("XXXX", "XL");
		sustitutos.put("CCCC", "CD");
		sustitutos.put("VIV", "IX");
		sustitutos.put("LXL", "XC");
		sustitutos.put("DCD", "CM");
	}
	
	public String convertToRomanNumeral(Integer number){
		
		String conversion = "";
		Integer rest = number;
		
		for(String numeral:romanNumerals.keySet()){
			conversion = getNumeral(rest, numeral, conversion);
			rest = getResto(rest, numeral);
		}
		
		while(conversion != corregirRepetidos(conversion)){
			conversion = corregirRepetidos(conversion);			
		}
		
		return conversion;
	}


	private Integer getResto(Integer number, String numeral) {
		
		return number % romanNumerals.get(numeral);
	}

	private String getNumeral(Integer number, String numeral, String conversion) {
		
		Integer division = number / romanNumerals.get(numeral);
		
		for(int i=0;i<division;i++) {
			conversion += numeral;
		}
		
		return conversion;
	}
	
	private String corregirRepetidos(String conversion) {
		
		for(String repetido:sustitutos.keySet()) {
			if(conversion.indexOf(repetido)!=-1) {
				conversion = conversion.replace(repetido, sustitutos.get(repetido));
			}
		}
		
		return conversion;
	}
}
