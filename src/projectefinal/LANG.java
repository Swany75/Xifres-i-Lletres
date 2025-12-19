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
    
    public LANG(char idioma) {
        if (idioma == 'C' || idioma == 'E' || idioma == 'S') {
            langCode = idioma;
        } else {
            langCode = 'C';
        }
    }
    
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
    
}

