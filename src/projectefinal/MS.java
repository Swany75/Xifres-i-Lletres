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

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < tamany; i++) {
            res = res + characters[i];
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
