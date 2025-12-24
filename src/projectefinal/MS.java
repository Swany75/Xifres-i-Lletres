/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectefinal;

/**
 *
 * @author Juan
 */

public class MS { // My String
    
    // private final int llarginicial = 20;
    private char[] characters;  
    private int tamany;
    
    public MS(char[] p) {
        characters = p;
        tamany = p.length;
    }
    
    public void add(char c) {
        if (tamany == characters.length) {
            char[] aux = new char[characters.length + 5];
        
            for (int i = 0; i < characters.length; i++) {
                aux[i] = characters[i];
            }
        
            characters = aux;
        }
        
        characters[tamany++] = c;
    }
    
    public void add(char[] fr) {
        for (int i = 0; i < fr.length; i++) {
            add(fr[i]);
        }
    }
    
    public char get(int i) {
        return characters[i];
    }
    
    public int getTam() {
        return tamany;
    }
    
    
    // Metodes de transformació ////////////////////////////////////////////////
    
    public void toUpper() {
        for (int i = 0; i < tamany; i++) {
            if (characters[i] >= 'a' && characters[i] <= 'z') {
                characters[i] = (char)(characters[i] - ('a' - 'A'));
            }
        }
    }
    
    public void toLower() {
        for (int i = 0; i < tamany; i++) {
            if (characters[i] >= 'A' && characters[i] <= 'Z') {
                characters[i] = (char)(characters[i] + ('a' - 'A'));
            }
        }
    }
    
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < tamany; i++) {
            res = res + characters[i];
        }
        return res;
    }
    
    /// Metodes Avançats de la classe MyString /////////////////////////////////
    
    public boolean isLetter(char c, char lang) {

        switch (lang) {

            case 'C': // Catalan
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) return true;
                if (c == 'à' || c == 'è' || c == 'é' || c == 'í' || c == 'ò' || c == 'ó' || c == 'ú'
                 || c == 'À' || c == 'È' || c == 'É' || c == 'Í' || c == 'Ò' || c == 'Ó' || c == 'Ú'
                 || c == 'ç' || c == 'Ç') return true;
                return false;

            case 'S': // Spanish
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) return true;
                if (c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú'
                 || c == 'Á' || c == 'É' || c == 'Í' || c == 'Ó' || c == 'Ú'
                 || c == 'ñ' || c == 'Ñ' || c == 'ü' || c == 'Ü') return true;
                return false;

            case 'E': // English
                return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');

            default:
                return false;
        }
    }
    
    public MS[] split(char lang) {
        MS[] res;
        int compt = 0;
        int p = 0;

        // Comptar les paraules
        while (p < getTam()) {
            while (p < getTam() && !isLetter(get(p), lang)) {
                p++;
            }
            if (p < getTam() && isLetter(get(p), lang)) {
                while (p < getTam() && isLetter(get(p), lang)) {
                    p++;
                }
                compt++;
            }
        }

        res = new MS[compt];
        compt = 0;
        p = 0;

        // Construir la paraula
        while (p < getTam()) {
            while (p < getTam() && !isLetter(get(p), lang)) {
                p++;
            }
            if (p < getTam() && isLetter(get(p), lang)) {
                res[compt] = new MS(new char[5]);
                while (p < getTam() && isLetter(get(p), lang)) {
                    res[compt].add(get(p));
                    p++;
                }
                compt++;
            }
        }

        return res;
    }
    
    /// Clone Arrays ///////////////////////////////////////////////////////////
    
    public static int[] cloneIntArray(int[] original) {
        int[] copia = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i];
        }
        return copia;
    }
    
    public static char[] cloneCharArray(char[] original) {
        char[] copia = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i];
        }
        return copia;
    }
}