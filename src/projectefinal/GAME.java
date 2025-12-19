/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectefinal;

/**
 *
 * @author Juan
 */

public class GAME {
    // Classes /////////////////////////////////////////////////////////////////
    private LT lt = new LT();    
    
    // VARIABLES ///////////////////////////////////////////////////////////////
    private MS p1;
    private int roundNum;
    private LANG idioma;
    private MS fDicc;
    private MS fLlet;
    private MS fCifr;
    
    // GAME CODE ///////////////////////////////////////////////////////////////
    public GAME() {
        /* Inicialització de les Dades dels Jugadors */
        init();
        
        /* Codi del Joc */
        
    }
    
    private void init() {
        setPlayerName();
        setGameLang();
        setDictionaries();
        setRoundNum();
        
    }
    
    private void setPlayerName() {
        System.out.print("[+] Introdueix el teu nom: ");
        char[] nomPlayer1 = lt.llegirLiniaC();
        p1 = new MS(nomPlayer1);
        // System.out.println(p1.toString());
    }
    
    private void setGameLang() {
        System.out.print("\n[i] Selecciona l'idioma per jugar:\n\tE ) English\n\tS ) Spanish\n\tC ) Catalan\n[+] Introdueix una opcio: ");
        idioma = new LANG(lt.llegirCaracter());
        // idioma.getLang();
    }
    
    private void setDictionaries() {
        
        switch(idioma.getCode()) {
            
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
    
    private void setRoundNum() {
        System.out.print("\n[+] Introdueix el numero de rondes a jugar (MAX 10 rondes): ");
        int res = lt.llegirSencer();
        
        if (res >= 1 && res <= 10) {
            roundNum = res;
        } else {
            System.out.println("[!] Valor introduït no valid: El numero de rondes sera 1");
            roundNum = 1;
        }
    }
}
