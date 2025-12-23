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
    private PLAYER player1;
    private PLAYER cpu;
    private int roundNum;
    private LANG idioma;
    
    // GAME CODE ///////////////////////////////////////////////////////////////
    public GAME() {
        /* Inicialització de les Dades dels Jugadors */
        init();
        
        /* Codi del Joc */
        
    }
    
    private void init() {
        setPlayers();
        setGameLang();
        setRoundNum();
    }
    
    private void setPlayers() {
        // Jugador Humà
        System.out.print("[+] Introdueix el teu nom: ");
        char[] nomP1 = lt.llegirLiniaC();
        player1 = new PLAYER(nomP1); // només nom, no pas boolean

        // Jugador CPU
        cpu = new PLAYER();
    }
    
    private void setGameLang() {
        System.out.print("\n[i] Selecciona l'idioma per jugar:\n\tE ) English\n\tS ) Spanish\n\tC ) Catalan\n[+] Introdueix una opcio: ");
        idioma = new LANG(lt.llegirCaracter());
        // idioma.getLang();
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
