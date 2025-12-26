/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package projectefinal;

import java.util.Random;

public class JL {
    private LT lt = new LT();
    private Random random = new Random();

    /// RONDA LLETRES
    public void rondaLletres(PLAYER player1, PLAYER player2, LANG idioma) {

        RF diccionari = new RF(idioma.getDicc());
        RF lletres = new RF(idioma.getLletres());

        tornJugadorLletres(diccionari, lletres, player1);

        lt.clearScreen();

        if (player2.isCPU()) {
            tornCPULletres(diccionari, lletres, player2);
        } else {
            tornJugadorLletres(diccionari, lletres, player2);
        }
    }

    /// TORN HUMÀ
    private void tornJugadorLletres(RF diccionari, RF lletres, PLAYER jugador) {
        System.out.println("[+] Torn de: " + jugador.getName());

        // Llegim tota la línia de la bossa
        lletres.open();
        MS lletresLine = lletres.readLine();
        lletres.close();

        char[] bossa = generaBossaLletres(lletresLine);

        // Mostrem les lletres disponibles
        System.out.print("[i] Lletres disponibles: ");
        for (int i = 0; i < bossa.length; i++) System.out.print(bossa[i] + " ");
        System.out.println();

        MS paraula = null;
        boolean valid = false;

        while (!valid) {
            System.out.print("[+] Introdueix la teva paraula (ENTER per passar): ");
            char[] input = lt.llegirLiniaC();
            paraula = new MS(input);

            if (paraula.getTam() == 0) {
                System.out.println("[i] Has passat el torn.");
                break; // jugador passa el torn
            }

            if (!esPotFormar(paraula, bossa)) {
                System.out.println("[!] La paraula no es pot formar amb les lletres disponibles.");
                continue;
            }

            if (!estaParaula(paraula, diccionari)) {
                System.out.println("[!] La paraula no existeix al diccionari.");
                continue;
            }

            valid = true;
        }

        if (valid) {
            int punts = paraula.getTam();
            jugador.addScore(punts);
            System.out.println("[i] Longitud " + punts + ": +" + punts + " punts.");
        }

        System.out.println("\n[i] Press ENTER to continue...");
        lt.llegirLiniaC(); // pausa abans de continuar
    }

    /// TORN CPU
    private void tornCPULletres(RF diccionari, RF lletres, PLAYER cpu) {
        System.out.println("[+] Torn de: CPU");

        // Llegim 10 lletres
        lletres.open();
        MS lletresLine = lletres.readLine();
        lletres.close();

        char[] bossa = generaBossaLletres(lletresLine);

        System.out.print("\n[+] Lletres: ");
        
        for (int i = 0; i < bossa.length; i++) {
            System.out.print(bossa[i] + " ");
        }
        
        System.out.println();
        
        // Cercam la millor paraula possible
        diccionari.open();
        MS line;
        MS millorParaula = new MS("".toCharArray());

        while ((line = diccionari.readLine()) != null) {
            if (line.getTam() <= millorParaula.getTam()) continue;
            if (esPotFormar(line, bossa)) millorParaula = line;
        }
        diccionari.close();

        if (millorParaula.getTam() > 0) {
            cpu.addScore(millorParaula.getTam());
            System.out.println("[i] Paraula seleccionada per CPU: " + millorParaula.toString());
            System.out.println("[i] Longitud " + millorParaula.getTam() + ": +" + millorParaula.getTam() + " punts.");
        } else {
            System.out.println("[i] CPU no ha pogut formar cap paraula amb les lletres disponibles.");
        }

        System.out.println("\n[i] Press ENTER to continue...");
        lt.llegirLiniaC();
    }

    private char[] generaBossaLletres(MS lletresLine) {
        // Convertim tota la línia en un array de caràcters disponibles
        char[] totales = new char[lletresLine.getTam()];
        for (int i = 0; i < lletresLine.getTam(); i++) {
            totales[i] = lletresLine.get(i);
        }

        // Seleccionem 10 lletres aleatòries
        char[] bossa = new char[10];
        int mida = totales.length;
        for (int i = 0; i < 10; i++) {
            int idx = random.nextInt(mida);
            bossa[i] = totales[idx];

            // Eliminem la lletra seleccionada del conjunt temporal
            totales[idx] = totales[mida - 1];
            mida--;
        }

        return bossa;
    }
    
    /// COMPROVACIÓ PARAULA
    private boolean esPotFormar(MS paraula, char[] bossa) {
        char[] temp = MS.cloneCharArray(bossa);

        for (int i = 0; i < paraula.getTam(); i++) {
            char c = paraula.get(i);
            boolean trobat = false;
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == c) {
                    temp[j] = 0;
                    trobat = true;
                    break;
                }
            }
            if (!trobat) return false;
        }

        return true;
    }

    private boolean estaParaula(MS paraula, RF diccionari) {
        diccionari.open();
        MS line;
        boolean igual;

        while ((line = diccionari.readLine()) != null) {
            if (line.getTam() != paraula.getTam()) continue;

            igual = true;
            for (int i = 0; i < paraula.getTam(); i++) {
                if (paraula.get(i) != line.get(i)) {
                    igual = false;
                    break;
                }
            }

            if (igual) {
                diccionari.close();
                return true;
            }
        }

        diccionari.close();
        return false;
    }
}