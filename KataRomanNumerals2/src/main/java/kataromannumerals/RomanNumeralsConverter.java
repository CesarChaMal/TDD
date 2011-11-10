package main.java.kataromannumerals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralsConverter {

	Map<Integer, String> romanNumerals;
	Map<String, String> sustitutions;

	public RomanNumeralsConverter() {
		romanNumerals = new LinkedHashMap<Integer, String>();
		romanNumerals.put(1000, "M");
		romanNumerals.put(500, "D");
		romanNumerals.put(100, "C");
		romanNumerals.put(50, "L");
		romanNumerals.put(10, "X");
		romanNumerals.put(5, "V");
		romanNumerals.put(1, "I");
		
		sustitutions = new LinkedHashMap<String, String>();
		sustitutions.put("IIII", "IV");
		sustitutions.put("VIV", "IX");
		sustitutions.put("XXXX", "XL");
		sustitutions.put("LXL", "XC");
		sustitutions.put("CCCC", "CD");
		sustitutions.put("DCD", "CM");
	}

	public String convertToRomanNumeral(int numEntero) {
		String numRomano = "";
		
		for (int i: romanNumerals.keySet())
		{
			//System.out.println(i);
			numRomano += restaNumeroRomano(i, numEntero);
			numEntero=numEntero%i;
		}
		
		for (String reemplazo: sustitutions.keySet())
		{
			numRomano=numRomano.replace(reemplazo, sustitutions.get(reemplazo));		
		}
		
		return numRomano;
	}

	private String restaNumeroRomano(int numeroResta, int numEntero) {
		String numRomano = "";
		
		while (numEntero > numeroResta-1) {
			numRomano += romanNumerals.get(numeroResta);
			numEntero -= numeroResta;
		}
		
		return numRomano;
	}

}
