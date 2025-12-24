/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package projectefinal;
import java.util.Random; 

/**
 *
 * @author Juan
 */

public class GAME {
    // Classes /////////////////////////////////////////////////////////////////
    private LT lt = new LT();    
    private Random random = new Random();
    private JX jocXifres = new JX();
    private JL jocLletres = new JL();
    
    // VARIABLES ///////////////////////////////////////////////////////////////
    private PLAYER player1;
    private PLAYER player2;
    private int roundNum;
    private LANG idioma;
    private int partidaActual = 0;
    private long gameTime;
    private long startTime;
    private long endTime;
    
    // GAME CODE ///////////////////////////////////////////////////////////////
    public GAME() {
        /* Inicialització de les Dades dels Jugadors */
        init();
        
        /* Codi del Joc */
        while (partidaActual < roundNum) {
            lt.clearScreen();
            
            // Ronda Xifres
            jocXifres.rondaXifres(player1, player2, idioma);
            
            // Ronda Lletres
            
            partidaActual++;
        }
        
        finalMethod();
        
    }
    
    /// INICIALITZACIÓ /////////////////////////////////////////////////////////
    
    private void init() {
        startTime = System.currentTimeMillis();
        setPlayers();
        setGameLang();
        setRoundNum();
    }
    
    /// SETTERS ////////////////////////////////////////////////////////////////
    // Els setters estableixen valors
    
    private void setPlayers() {
        
        System.out.print("[+] Tria el numero de jugadors: ");
        int playerNum = lt.llegirSencer();
        
        if (playerNum == 1) {
            // Jugador Humà
            char[] nomP1 = askPlayerName();
            player1 = new PLAYER(nomP1);

            // Jugador CPU
            int mode = setDifficulty();
            player2 = new PLAYER(mode);
                       
        } else if (playerNum == 2) {
            // Jugador 1
            char[] nomP1 = askPlayerName();
            player1 = new PLAYER(nomP1);
            
            // Jugador 2
            char[] nomP2 = askPlayerName();
            player2 = new PLAYER(nomP2);
        }
        
    }
    
    private char[] askPlayerName() {
        System.out.print("[+] Introdueix el teu nom: ");
        char[] name = lt.llegirLiniaC();
        return name;
    }
    
    private void setGameLang() {
        System.out.print("\n[i] Selecciona l'idioma per jugar:\n\tE ) English\n\tS ) Spanish\n\tC ) Catalan\n\n[+] Introdueix una opcio: ");
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
    
    private int setDifficulty() {
        System.out.print("\n[i] Dificultat CPU"
            + "\n\t 1) Normal"
            + "\n\t 2) Dificil"
            + "\n\t 3) Aleatori"
            + "\n\n[+] Selecciona una opció: "
        );
        
        int res = lt.llegirSencer();
        
        if (res == 3 || res < 1 || res > 2) {
            res = random.nextInt(2) + 1;
        }
        
        return res;
    }
    
    private void showScore() {
        
        double minuts = gameTime / 60000.0;
        minuts = (int)(minuts * 100) / 100.0;
        
        System.out.print("\n\n### Resultats #######################################"
            + "\n[+] Jugador 1 " + player1.getName() + " te: " + player1.getScore() + " punts"
            + "\n[-] Jugador 2 " + player2.getName() + " te: " + player2.getScore() + " punts"
            + "\n[i] La partida ha durat: " + minuts + " minuts"
        );
        
        lt.ptc();
    }
    
    /// FINAL //////////////////////////////////////////////////////////////////
    
    private void finalMethod() {
        endTime = System.currentTimeMillis();
        gameTime = endTime - startTime;
        showScore();
    }
    
}
