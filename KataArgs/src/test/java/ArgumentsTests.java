package test.java;

import java.util.HashMap;

import junit.framework.TestCase;
import main.java.kataargs.Arguments;

import org.junit.Test;


public class ArgumentsTests extends TestCase {
	
	private HashMap<String, String> esquema = null;
	private HashMap<String, String> resultado = null;
		
	@Test
	public void testEsquema()
	{
		esquema = new HashMap<String, String>();
		esquema.put("d", "boolean");
		
		Arguments args = new Arguments(esquema);
		
		assertEquals(true, args.esquema != null);	
	
	}
	
	@Test
	public void testFlag(){
		esquema = new HashMap<String, String>();
		esquema.put("d", "boolean");
		
		Arguments args = new Arguments(esquema);
		
		resultado = args.parse("-d");
		
		assertEquals(resultado.containsKey("d"), true);
	}
	
	@Test
	public void testFlagEsquema()
	{
		esquema = new HashMap<String, String>();
		esquema.put("d", "boolean");
		
		Arguments args = new Arguments(esquema);
		resultado = args.parse("-d");
		
		assertEquals(resultado.containsKey("e"), false);
	}
	
	
	@Test
	public void testDosFlags(){
		esquema = new HashMap<String, String>();
		esquema.put("d", "boolean");
		esquema.put("e", "boolean");
		
		Arguments args = new Arguments(esquema);
		resultado = args.parse("-d -e");
		
		assertEquals(resultado.containsKey("d"), true);
		assertEquals(resultado.containsKey("e"), true);
	}
	
	@Test
	public void testDosIguales(){
		esquema = new HashMap<String, String>();
		esquema.put("d", "boolean");
		esquema.put("e", "boolean");
		
		Arguments args = new Arguments(esquema);
		resultado = args.parse("-d -d");
		
		assertEquals(resultado.isEmpty(), true);
		
	}
	
	@Test
	public void testFlagTrue(){
		esquema = new HashMap<String, String>();
		esquema.put("d", "boolean");
		esquema.put("e", "boolean");
				
		Arguments args = new Arguments(esquema);
		resultado = args.parse("-d");
		
		assertEquals(resultado.isEmpty(), false);
		assertEquals(resultado.get("d"), "True");
		
	}
	
	@Test
	public void testFlagFalse(){
		esquema = new HashMap<String, String>();
		esquema.put("d", "boolean");
		esquema.put("e", "boolean");
				
		Arguments args = new Arguments(esquema);
		resultado = args.parse("");
		
		assertEquals(resultado.isEmpty(), true);
		assertEquals(resultado.get("d"), "False");
		
	}
	
}

	