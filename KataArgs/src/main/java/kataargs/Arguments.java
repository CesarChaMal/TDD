package main.java.kataargs;

import java.util.HashMap;


public class Arguments {

	public HashMap<String, String> esquema = null;
	
	public Arguments(HashMap<String, String> esquema){
		this.esquema = esquema;
	}
	public HashMap<String, String> parse(String cadena){
	
		HashMap<String, String> result = new HashMap<String, String>();
		
		if(cadena==null || cadena.equals("")) {
			return result;
		}
		
		String[] flags = cadena.split("-");
		
		for (int i = 1; i < flags.length; i++) {
			String flag = ((String)flags[i]).trim();
			
	
			if(!esquema.containsKey(flag))
			{
				return result;
			}
			
			if(!result.containsKey(flag))
			{
				//String valor = flag.substring(1, flag.length());
				String tipoValor = esquema.get(flag.substring(0, 1));
				
				if(tipoValor.equals("boolean"))
				{
					result.put(flag, "True");
				}
			}
			else
			{
				result.clear();
				return result;
			}
			
		}		

		return result;
	}
}
