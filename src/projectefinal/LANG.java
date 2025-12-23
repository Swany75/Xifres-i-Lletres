/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectefinal;

/**
 *
 * @author Juan
 */
public class LANG {
    
    private char langCode;
    private MS fDicc;
    private MS fLlet;
    private MS fCifr = new MS("files/cifras.txt".toCharArray());
    
    public LANG(char idioma) {
        if (idioma == 'C' || idioma == 'E' || idioma == 'S') {
            langCode = idioma;
        } else {
            langCode = 'C';
        }
        
        // Assignació dels fitxers segons l'idioma
        setFiles();
    }
    
    private void setFiles() {
        
        switch(langCode) {
            
            case 'S':
                fDicc = new MS("files/dic_es.txt".toCharArray());
                fLlet = new MS("files/letras_es.txt".toCharArray());
                break;
                
            case 'C':
                fDicc = new MS("files/dic_ca.txt".toCharArray());
                fLlet = new MS("files/letras_ca.txt".toCharArray());
                break;
                
            case 'E':
                fDicc = new MS("files/dic_en.txt".toCharArray());
                fLlet = new MS("files/letras_en.txt".toCharArray());
                break;
                
        }
    }
    
    /// GETTERS ////////////////////////////////////////////////////////////////
    
    public void getLang() {
        switch (langCode) {
            case 'C': System.out.print("Catalan"); break;
            case 'E': System.out.print("English"); break;
            case 'S': System.out.print("Spanish"); break;
        }
    }
    
    public char getCode() {
        return langCode;
    }
    
    public MS getDicc() {
        return fDicc;
    }

    public MS getLletres() {
        return fLlet;
    }
    
    public MS getXifres() {
        return fCifr;
    }    
}
