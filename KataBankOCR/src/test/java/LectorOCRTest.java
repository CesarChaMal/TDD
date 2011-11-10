package test.java;

import junit.framework.TestCase;
import main.java.katabankocr.LectorOCR;

import org.junit.Test;

public class LectorOCRTest extends TestCase {

	@Test
    public void testLectorOCRCeros() {
        StringBuilder sb = new StringBuilder();
        sb.append(" _  _  _  _  _  _  _  _  _ \n");
        sb.append("| || || || || || || || || |\n");
        sb.append("|_||_||_||_||_||_||_||_||_|\n");
        sb.append("                           ");

        assertEquals(new LectorOCR().leerCodigo(sb.toString()),"000000000 ERR");
    }

    @Test
    public void testLectorOCRUnos() {
        StringBuilder sb = new StringBuilder();
        sb.append("                           \n");
        sb.append("  |  |  |  |  |  |  |  |  |\n");
        sb.append("  |  |  |  |  |  |  |  |  |\n");
        sb.append("                           ");

        assertEquals (new LectorOCR().leerCodigo(sb.toString()),"111111111 ERR");
    }

    @Test
    public void testLectorOCRDoses() {
        StringBuilder sb = new StringBuilder();
        sb.append(" _  _  _  _  _  _  _  _  _ \n");
        sb.append(" _| _| _| _| _| _| _| _| _|\n");
        sb.append("|_ |_ |_ |_ |_ |_ |_ |_ |_ \n");
        sb.append("                           ");

        assertEquals(new LectorOCR().leerCodigo(sb.toString()),"222222222 ERR");
    }

    @Test
    public void testLectorOCRTreses() {
        StringBuilder sb = new StringBuilder();
        sb.append(" _  _  _  _  _  _  _  _  _ \n");
        sb.append(" _| _| _| _| _| _| _| _| _|\n");
        sb.append(" _| _| _| _| _| _| _| _| _|\n");
        sb.append("                           ");

        assertEquals(new LectorOCR().leerCodigo(sb.toString()),"333333333 ERR");
    }

    @Test
    public void testLectorOCRCuatros() {
        StringBuilder sb = new StringBuilder();
        sb.append("                           \n");
        sb.append("|_||_||_||_||_||_||_||_||_|\n");
        sb.append("  |  |  |  |  |  |  |  |  |\n");
        sb.append("                           ");
        
        assertEquals(new LectorOCR().leerCodigo(sb.toString()),"444444444 ERR");
    }

    @Test
    public void testLectorOCRCincos() {
        StringBuilder sb = new StringBuilder();
        sb.append(" _  _  _  _  _  _  _  _  _ \n");
        sb.append("|_ |_ |_ |_ |_ |_ |_ |_ |_ \n");
        sb.append(" _| _| _| _| _| _| _| _| _|\n");
        sb.append("                           ");

        assertEquals (new LectorOCR().leerCodigo(sb.toString()),"555555555 ERR");
    }

    @Test
    public void testLectorOCRSeises() {
        StringBuilder sb = new StringBuilder();
        sb.append(" _  _  _  _  _  _  _  _  _ \n");
        sb.append("|_ |_ |_ |_ |_ |_ |_ |_ |_ \n");
        sb.append("|_||_||_||_||_||_||_||_||_|\n");
        sb.append("                           ");

        assertEquals (new LectorOCR().leerCodigo(sb.toString()),"666666666 ERR");
    }

    @Test
    public void testLectorOCRSietes() {
        StringBuilder sb = new StringBuilder();
        sb.append(" _  _  _  _  _  _  _  _  _ \n");
        sb.append("  |  |  |  |  |  |  |  |  |\n");
        sb.append("  |  |  |  |  |  |  |  |  |\n");
        sb.append("                           ");

        assertEquals (new LectorOCR().leerCodigo(sb.toString()),"777777777 ERR");
    }

    @Test
    public void testLectorOCROchos() {
        StringBuilder sb = new StringBuilder();
        sb.append(" _  _  _  _  _  _  _  _  _ \n");
        sb.append("|_||_||_||_||_||_||_||_||_|\n");
        sb.append("|_||_||_||_||_||_||_||_||_|\n");
        sb.append("                           ");

        assertEquals (new LectorOCR().leerCodigo(sb.toString()),"888888888 ERR");
    }

    @Test
    public void testLectorOCRNueves() {
        StringBuilder sb = new StringBuilder();
        sb.append(" _  _  _  _  _  _  _  _  _ \n");
        sb.append("|_||_||_||_||_||_||_||_||_|\n");
        sb.append(" _| _| _| _| _| _| _| _| _|\n");
        sb.append("                           ");

        assertEquals (new LectorOCR().leerCodigo(sb.toString()),"999999999 ERR");
    }

    @Test
    public void testLectorOCRTodos() {
        StringBuilder sb = new StringBuilder();
        sb.append("    _  _     _  _  _  _  _ \n");
        sb.append("  | _| _||_||_ |_   ||_||_|\n");
        sb.append("  ||_  _|  | _||_|  ||_| _|\n");
        sb.append("                           ");

        assertEquals(new LectorOCR().leerCodigo(sb.toString()),"123456789");
    }

    @Test
    public void testCaso3_1() {
        StringBuilder sb = new StringBuilder();
        sb.append(" _  _  _  _  _  _  _  _    \n");
        sb.append("| || || || || || || ||_   |\n");
        sb.append("|_||_||_||_||_||_||_| _|  |\n");
        sb.append("                           ");

        assertEquals(new LectorOCR().leerCodigo(sb.toString()),"000000051");
    }

    @Test
    public void testCaso3_2() {
        StringBuilder sb = new StringBuilder();
        sb.append("    _  _  _  _  _  _     _ \n");
        sb.append("|_||_|| || ||_   |  |  | _ \n");
        sb.append("  | _||_||_||_|  |  |  | _|\n");
        sb.append("                           ");

        assertEquals(new LectorOCR().leerCodigo(sb.toString()),"49006771? ILL");
    }

    @Test
    public void testCaso3_3() {
        StringBuilder sb = new StringBuilder();
        sb.append("    _  _     _  _  _  _  _ \n");
        sb.append("  | _| _||_| _ |_   ||_||_|\n");
        sb.append("  ||_  _|  | _||_|  ||_| _ \n");
        sb.append("                           ");

        assertEquals(new LectorOCR().leerCodigo(sb.toString()),"1234?678? ILL");
    }

}
