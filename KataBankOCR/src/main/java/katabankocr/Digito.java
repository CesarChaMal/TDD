package main.java.katabankocr;

class Digito {

    private String valor = "";

    Digito(String[] filas) {
        this.valor = leerValor(filas);
    }

    @Override
    public String toString() {
        return this.valor;
    }

    private String leerValor(String[] filas) {

    	boolean arriba = filas[0].equals(" _ ");
    	boolean arribaIzq = filas[1].substring(0, 1).equals("|");
    	boolean arribaDcha = filas[1].substring(2,3).equals("|");
    	boolean medio = filas[1].substring(1, 2).equals("_");
    	boolean bajoIzq = filas[2].substring(0, 1).equals("|");
    	boolean bajoDcha = filas[2].substring(2, 3).equals("|");
    	boolean bajoMedio = filas[2].substring(1, 2).equals("_");
    	
    	if(arriba && arribaIzq && arribaDcha && medio && bajoIzq && bajoDcha && bajoMedio)
    		return "8";
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
        if (filas[0].equals(" _ ")) {
            //Pueden ser 0,2,3,5,6,7,8,9
            if (filas[1].equals("  |") && filas[2].equals("  |")) {
                return "7";
            } else if (filas[1].equals("|_|")) {
                //Pueden ser 8,9
                if (filas[2].equals("|_|")) {
                    return "8";
                } else if (filas[2].equals(" _|")){
                    return "9";
                }
            } else if (filas[1].equals(" _|")) {
                //Pueden ser 2,3
                if (filas[2].equals(" _|")) {
                    return "3";
                } else {
                    return "2";
                }
            } else if (filas[1].equals("|_ ")) {
                //Pueden ser 5,6
                if (filas[2].equals(" _|")) {
                    return "5";
                } else {
                    return "6";
                }
            } else if (filas[1].equals("| |")) {
                return "0";
            }
        } else {
            //Pueden ser 1,4
            if (filas[1].equals("  |") && filas[2].equals("  |")) {
                return "1";
            } else if (filas[1].equals("|_|") && filas[2].equals("  |")) {
                return "4";
            }
        }
        return "?";
    }

}
