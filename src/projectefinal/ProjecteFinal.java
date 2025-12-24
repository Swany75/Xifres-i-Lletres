/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectefinal;

/**
 *
 * @author Juan
 */

/* 
Ascii Art template
╔═╦═╗
║ ║ ║
╠═╬═╣
╚═╩═╝
*/

public class ProjecteFinal {

    /**
     * @param args the command line arguments
     */
    
    /* Lectura Teclat */
    LT lt = new LT();
    
    public static void main(String[] args) {
        // TODO code application logic here
        (new ProjecteFinal()).run();
    }
    
    private void run() {
        boolean primeraVegada = false;
        Character selection = ' ';
        
        while (selection != 'q' && selection != 'Q') {
            
            lt.clearScreen();
            
            if (!primeraVegada) {
                mainMenu();
                System.out.println("\n[*] Programa fet per: Juan Dalmau\n");
                primeraVegada = true;
            }
            
            System.out.println("[+] Executant: Xifres i Lletres"
                + "\n\t- 'Q/q' per sortir (quit)"
                + "\n\t- 'R/r' per veurer el registres"
                + "\n\t- 'C/c' per continuar (continue)"
            );
            System.out.print("\n[+] Introdueix una opció valida: ");
            selection = lt.llegirCaracter();
            
            if (selection == 'c' || selection == 'C') {
                /* Execució del codi Principal */
                lt.clearScreen();
                System.out.println("[i] Jugant a Xifres i Lletres");
                GAME partida = new GAME();
            
            } else if (selection == 'r' || selection == 'R') {
                System.out.println("[i] Mostrant el registre de partides");
                
            } else if (selection == 'q' || selection == 'Q') {
                System.out.println("[i] Has sortit correctament del programa");
                
            } else {
                System.out.println("[!] Valor introduït no valid!\n\n");
                
            }   
        }
        lt.clearScreen();
        System.out.println("[*] Fi del joc: Gracies per jugar!\n[i] Repositori official: https://github.com/Swany75/Xifres-i-Lletres");
        
    }
    
    private void mainMenu() {
        System.out.println(
            " __   ___  __                 _   _     _      _                 \n" +
            " \\ \\ / (_)/ _|               (_) | |   | |    | |                \n" +
            "  \\ V / _| |_ _ __ ___  ___   _  | |   | | ___| |_ _ __ ___  ___ \n" +
            "  /   \\| |  _| '__/ _ \\/ __| | | | |   | |/ _ \\ __| '__/ _ \\/ __|\n" +
            " / /^\\ \\ | | | | |  __/\\__ \\ | | | |___| |  __/ |_| | |  __/\\__ \\\n" +
            " \\/   \\/_|_| |_|  \\___||___/ |_| \\_____/_|\\___|\\__|_|  \\___||___/\n" +   
            "═════════════════════════════════════════════════════════════════════════════"
        );
    }
    
}
