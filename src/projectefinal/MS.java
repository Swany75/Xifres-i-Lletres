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
    
    public void afegir(char c) {
        if (tamany == characters.length) {
            char[] aux = new char[characters.length + 5];
        
            for (int i = 0; i < characters.length; i++) {
                aux[i] = characters[i];
            }
        
            characters = aux;
        }
        
        characters[tamany++] = c;
    }
    
    public void afegir(char[] fr) {
        for (int i = 0; i < fr.length; i++) {
            afegir(fr[i]);
        }
    }
    
    public char get(int i) {
        return characters[i];
    }
    
    public int getTam() {
        return tamany;
    }
    
    
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
    
}
