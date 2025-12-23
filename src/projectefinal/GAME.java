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
    
    // VARIABLES ///////////////////////////////////////////////////////////////
    private PLAYER player1;
    private PLAYER cpu;
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
            rondaXifres();
            
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
        // Jugador Humà
        System.out.print("[+] Introdueix el teu nom: ");
        char[] nomP1 = lt.llegirLiniaC();
        player1 = new PLAYER(nomP1); // només nom, no pas boolean

        // Jugador CPU
        cpu = new PLAYER();
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
   
    
    /// RONDA XIFRES ///////////////////////////////////////////////////////////
    
    private void rondaXifres() {
        RF file = new RF(idioma.getXifres());
        int[] xifres = llegirXifres(file);
        int objectiu = generaObjectiu();
        
        tornJugadorXifres(xifres, objectiu, player1);
        tornCPUXifres(xifres, objectiu, cpu);
    }
    
    private int[] llegirXifres(RF fitxer) {
        fitxer.open();
        MS line = fitxer.readLine();
        fitxer.close();
        
        int count = 1;
        for (int i = 0; i < line.getTam(); i++) {
            if (line.get(i) == ' ') count++;
        }
        
        int[] xifres = new int[count];
        
        int numIndex = 0;
        int valor = 0;
        for (int i = 0; i < line.getTam(); i++) {
            char c = line.get(i);
        
            if (c >= '0' && c <= '9') {
                valor = valor * 10 + (c - '0');
            
            } else if (c == ' ') {
                xifres[numIndex++] = valor;
                valor = 0;
                
            }
            
        }
        
        xifres[numIndex] = valor;        
        return xifres;
    }
    
    private void mostraXifres(int[] xifres) {
        for (int i = 0; i < xifres.length; i++) {
            System.out.print(xifres[i] + " ");
        }
    }
    
    private void tornJugadorXifres(int[] xifres, int objectiu, PLAYER p) {
        char operacio = ' ';
        System.out.println("[+] Torn de: " + player1.getName());
        
        int[] xifresPartida = getXifresPartida(xifres); 
        
        while (operacio != '=') {
            System.out.print("\n[i] Xifres disponibles: ");
            mostraXifres(xifresPartida);
            
            System.out.println("\n[*] Objectiu: " + objectiu
                + "\n\t· Operacions disponibles: (+|-|*|/|=)"
            );
            System.out.print("Selecciona una operació: ");
            operacio = lt.llegirCaracter();
        }
        
        lt.ptc();
    }

    private void tornCPUXifres(int[] xifres, int objectiu, PLAYER cpu) {
        System.out.println("[+] Torn de: CPU");
    }

    private boolean esOpValida(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '=';
    }
    
    private int[] getXifresPartida(int[] original) {
        int[] res = new int[6];
        int[] copia = MS.cloneIntArray(original);
        int mida = copia.length;

        for (int i = 0; i < 6; i++) {
            int idx = random.nextInt(mida);
            res[i] = copia[idx];

            copia[idx] = copia[mida - 1];
            mida--;
        }

        return res;
    }
    
    private int generaObjectiu() {
        return 100 + random.nextInt(900);
    }
    
    /// METODES GENERALS ///////////////////////////////////////////////////////
    
    private void showScore() {
        System.out.print("\n\n### Resultats #######################################"
            + "\n[+] Jugador " + player1.getName() + " te: " + player1.getScore() + " punts"
            + "\n[-] Jugador CPU te: " + cpu.getScore() + " punts"
            + "\n[i] La partida ha durat: " + gameTime + " milisegons"
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
