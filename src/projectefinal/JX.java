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
public class JX {

    // Classes /////////////////////////////////////////////////////////////////
    private LT lt = new LT();
    private Random random = new Random();

    /// RONDA XIFRES ///////////////////////////////////////////////////////////
    
    public void rondaXifres(PLAYER player1, PLAYER player2, LANG idioma) {
        RF file = new RF(idioma.getXifres());
        int[] xifres = llegirXifres(file);
        int objectiu = generaObjectiu();

        tornJugadorXifres(xifres, objectiu, player1);
        
        lt.clearScreen();
        
        if (player2.isCPU() == true) {
            tornCPUXifres(xifres, objectiu, player2);
        } else {
            tornJugadorXifres(xifres, objectiu, player2);
        }

    }

    private void tornJugadorXifres(int[] xifres, int objectiu, PLAYER p) {
        int[] xifresPartida = getXifresPartida(xifres);
        int resultatRonda = 0;
        char operacio = ' ';

        System.out.println("[+] Torn de: " + p.getName());

        for (int ronda = 0; ronda < 5; ronda++) {
            mostraEstatXifres(xifresPartida, objectiu, resultatRonda);
            operacio = llegirOperacio();

            if (operacio == ' ') {
                ronda--;
                continue;
            }
            if (operacio == '=') {
                break;
            }

            int n1 = llegirNumero(xifresPartida);
            xifresPartida = eliminarXifra(xifresPartida, n1);

            int n2 = llegirNumero(xifresPartida);
            xifresPartida = eliminarXifra(xifresPartida, n2);

            int resultat = calcula(n1, operacio, n2);
            System.out.println("[i] Resultat operació: " + resultat);

            xifresPartida = actualitzaResultat(xifresPartida, resultat);
            resultatRonda = resultat;
        }

        // Comprovam el Score amb valor absolut, per evitar numeros negatius
        int score = checkScore(objectiu - resultatRonda);
        p.addScore(score);

        System.out.println("[i] Resultat final de la ronda: " + resultatRonda);
        lt.ptc();
    }

    private void tornCPUXifres(int[] xifres, int objectiu, PLAYER cpu) {

        int[] xifresPartida = getXifresPartida(xifres);
        int resultatRonda = 0;

        System.out.println("[+] Torn de: CPU");
        System.out.println("[.] Objectiu: " + objectiu);
        System.out.print("\n[i] Xifres: ");
        mostraXifres(xifresPartida);
        System.out.println();
        
        
        int dificultat = cpu.getDifficulty();

        for (int ronda = 0; ronda < 5; ronda++) {
            int n1 = 0, n2 = 0;
            char op = ' ';

            switch (dificultat) {
                case 1 -> {
                    // FACIL
                    n1 = xifresPartida[random.nextInt(xifresPartida.length)];
                    xifresPartida = eliminarXifra(xifresPartida, n1);

                    n2 = xifresPartida[random.nextInt(xifresPartida.length)];
                    op = randomOp();
                }
                case 2 -> {
                    // NORMAL
                    n1 = xifresPartida[random.nextInt(xifresPartida.length)];
                    xifresPartida = eliminarXifra(xifresPartida, n1);
                    
                    n2 = buscaMillor(n1, xifresPartida, objectiu, resultatRonda);
                    op = opInt(n1, n2, objectiu, resultatRonda);
                }

            }
            System.out.print("\n[i] Xifres: ");
            mostraXifres(xifresPartida);
            System.out.println();
            int resultat = calcula(n1, op, n2);
            System.out.println("[*] " + n1 + " " + op + " " + n2 + " = " + resultat);

            xifresPartida = eliminarXifra(xifresPartida, n2);
            xifresPartida = actualitzaResultat(xifresPartida, resultat);

            resultatRonda = resultat;
            if (objectiu == resultatRonda) break;

        }

        int score = checkScore(objectiu - resultatRonda);
        cpu.addScore(score);
        System.out.println("[i] Resultat final CPU: " + resultatRonda);
        lt.ptc();
    }

    /// Gestio de les xifres
    
    private int[] llegirXifres(RF fitxer) {
        fitxer.open();
        MS line = fitxer.readLine();
        fitxer.close();

        int count = 1;
        for (int i = 0; i < line.getTam(); i++) {
            if (line.get(i) == ' ') {
                count++;
            }
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

    private void mostraXifres(int[] xifres) {
        for (int i = 0; i < xifres.length; i++) {
            System.out.print(xifres[i] + " ");
        }
    }

    private void mostraEstatXifres(int[] xifres, int objectiu, int resultat) {
        System.out.print("\n[i] Xifres disponibles: ");
        mostraXifres(xifres);
        System.out.println(
                "\n[*] Objectiu: " + objectiu
                + "\n[*] Resultat actual: " + resultat
                + "\n\t· Operacions disponibles: (+|-|*|/|=)"
        );
    }

    /// Lectura d'operacions i nombres
    
    private char llegirOperacio() {
        System.out.print("[+] Selecciona una operacio: ");
        char op = lt.llegirCaracter();

        if (!esOpValida(op)) {
            System.out.println("[!] Operacio no valida");
            return ' '; // indicador d’error
        }
        return op;
    }

    private int llegirNumero(int[] xifresPartida) {
        int num;
        while (true) {
            System.out.print("[-] Introdueix un numero de la llista: ");
            num = lt.llegirSencer();

            boolean trobat = false;
            for (int i = 0; i < xifresPartida.length; i++) {
                if (xifresPartida[i] == num) {
                    trobat = true;
                    break;
                }
            }
            if (trobat) {
                break;
            }
            System.out.println("[!] Número no disponible, torna-ho a provar");
        }

        // Elimina el número seleccionat de xifresPartida
        return num;
    }

    private int[] eliminarXifra(int[] arr, int valor) {
        int count = 0;
        boolean trobat = false;

        for (int i = 0; i < arr.length; i++) {
            if (!trobat && arr[i] == valor) {
                trobat = true;
                continue;
            }
            count++;
        }

        if (!trobat) return arr;

        int[] res = new int[count];
        int idx = 0;
        trobat = false;
        
        for (int i = 0; i < arr.length; i++) {
            if (!trobat && arr[i] == valor) {
                trobat = true;
                continue;
            }
            res[idx++] = arr[i];
        }

        return res;
    }
    
    private int[] actualitzaResultat(int[] arr, int resultat) {
        int[] res = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        res[arr.length] = resultat;
        return res;
    }

    private int calcula(int x, char op, int y) {
        int res = 0;

        switch (op) {
            case '+' ->
                res = x + y;
            case '-' ->
                res = x - y;
            case '*' ->
                res = x * y;
            case '/' -> {
                if (y != 0 && x % y == 0) {
                    res = x / y;
                } else {
                    return 0; // invalida la operació
                }
            }
        }

        return res;

    }

    private boolean esOpValida(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '=';
    }

    // CPU /////////////////////////////////////////////////////////////////////
    
    private char randomOp() {
        char[] ops = {'+', '-', '*', '/'};
        return ops[random.nextInt(4)];
    }

    private int buscaMillor(int n1, int[] xifres, int objectiu, int resultatRonda) {
        int millor = xifres[0];
        int millorDiff = 1000000; // Numero exageradament gran

        for (int i = 0; i < xifres.length; i++) {
            int n2 = xifres[i];
            char[] ops = {'+', '-', '*', '/'};
            
            for (int j = 0; j < ops.length; j++) {
                int r = calcula(n1, ops[j], n2);
                if (r == 0 && ops[j] == '/') continue; // saltar divisió invalida

                int diff = objectiu - resultatRonda - r;
                if (diff < 0) diff = -diff;
                
                if (diff < millorDiff) {
                    millorDiff = diff;
                    millor = n2;
                }
            }
        }

        return millor;
    }

    private char opInt(int n1, int n2, int objectiu, int resultatRonda) {
        char millorOp = '+';
        int millorDiff = 1000000;

        char[] ops = {'+', '-', '*', '/'};
        for (int i = 0; i < ops.length; i++) {
            int r = calcula(n1, ops[i], n2);
            if (r == 0 && ops[i] == '/') continue;

            int diff = objectiu - resultatRonda - r;
            if (diff < 0) diff = -diff;

            if (diff < millorDiff) {
                millorDiff = diff;
                millorOp = ops[i];
            }
        }

        return millorOp;
    }

    /// METODES GENERALS ///////////////////////////////////////////////////////
    
    private int checkScore(int diff) {
        if (diff == 0) {
            return 25;
        }
        if (diff == 1) {
            return 18;
        }
        if (diff == 2) {
            return 15;
        }
        if (diff == 3) {
            return 12;
        }
        if (diff == 4) {
            return 10;
        }
        if (diff == 5) {
            return 8;
        }
        if (diff <= 10) {
            return 5;
        }
        if (diff <= 15) {
            return 2;
        }
        return 0;
    }

}
