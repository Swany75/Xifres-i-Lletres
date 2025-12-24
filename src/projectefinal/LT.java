/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package projectefinal;

/**
 *
 * @author Juan
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LT { // Lectura Teclat i Clear Screen :)

    // He decidit posar el clearScreen aqui perque LT l'empr per tot
    public void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    
    public void ptc () { // Press to Continue
        System.out.println();
        System.out.print("[i] Press ENTER to continue...");
        System.out.flush();  // assegura que s'imprimeixi abans d'esperar
        char[] buffer = llegirLiniaC();  // llegim la línia sencera
        // no cal fer res amb buffer, només esperàvem ENTER
        System.out.println();
    }
    
    public char[] llegirLiniaC() {
        String res = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
            res = br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res.toCharArray();
    }

    public Integer llegirSencer() {
        Integer res = 0;
        try {
            char[] pal = llegirLiniaC();
            res = Integer.valueOf(new String(pal));
        } catch (Exception e) {
            res = null;
        }
        return res;
    }

    public Double llegirReal() {
        Double res;
        try {
            char[] pal = llegirLiniaC();
            res = Double.valueOf(new String(pal));
        } catch (Exception e) {
            res = null;
        }
        return res;
    }

    public Character llegirCaracter() {
        Character res;
            char[] pal = llegirLiniaC();
            String s = new String(pal);
            if (s.length()==0) {
                res = null;
            } else {
                res = s.charAt(0);
            }
        return res;
    }
}


/*
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⢆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⢠⠳⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⢸⢸⢳⡙⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠖⡏⠀⠀⠀⢸⠀⠐⡜⣆⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢞⠵⢸⠀⠀⢀⡇⣸⠀⡆⠘⣌⢆⠀⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⢞⡵⠁⡆⡇⠀⡠⠋⡼⠀⠀⡇⠀⠘⠈⢧⡏⡄⢠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⢠⠀⠀⠀⠀⢀⡴⣡⡯⠀⢀⡇⣧⠞⠁⡰⠃⠀⠀⣧⠀⠀⠀⢸⡇⢃⢸⢇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⢸⡀⠀⠀⢠⢎⡜⡿⠁⠀⢸⣇⡵⠁⠀⠀⠀⠀⠀⣿⠀⠀⠀⠈⠀⢸⣸⠘⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⢸⢣⠀⡴⣡⣿⠁⠃⠀⢀⣾⡿⠁⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠈⡏⠀⢇⠀⠀⠀⠀⠀⠀⠀⠀ NetBeans beware! I am going Super Saiyan, ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⢸⠈⢇⡇⣿⡏⠀⠀⠀⣼⣿⠃⠀⠀⠀⠀⢀⠇⡰⣿⠀⠀⠀⠀⠀⡇⠁⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀ and not even exceptions can stop me!⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠸⠐⠄⠀⠏⡇⠀⠀⣧⣿⡇⡀⡜⢰⠀⠀⡘⡐⠁⠏⡆⠀⠀⡄⢠⡇⡄⠀⠈⡆⠀⠀⠀⠀⠀⠀Java, prepare to get KAMEHAMEHA'd!⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠈⠦⢠⣧⠀⣆⣿⣿⢁⣷⣇⡇⠀⣴⣯⠀⠀⠀⡇⠀⣸⡇⣾⡿⠁⠀⡀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⢀⠀⠀⠀⢀⢀⢠⠀⠸⣿⣆⢹⣿⣿⣾⣿⣿⣠⢾⠛⠁⠀⠀⠀⡇⡠⡟⣿⣿⠃⠀⠀⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠘⡶⣄⠀⢸⠸⣼⣧⡀⣿⣿⣾⣿⣿⣿⣿⣿⡇⠘⠀⡀⠀⠀⢠⠟⠀⠃⢹⣥⠃⠀⢠⢏⣜⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠙⡌⠳⢄⣣⠹⣿⣿⣿⣿⣿⣿⣿⡿⢿⣿⡇⠀⠀⢀⣄⣴⡢⠀⠀⠀⡿⣯⠀⠐⠁⠘⣻⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠘⢎⢶⣍⣀⠈⢿⣿⣿⣿⣿⣿⣿⣦⠑⣤⡀⠀⣰⠟⡿⠁⠀⠀⠈⠀⠁⠀⠀⡀⡰⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠈⢣⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠘⣷⣾⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⡵⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠑⣝⠻⠿⣿⣿⣿⣿⣿⣿⣿⣇⠀⣿⣿⣿⣇⣀⣤⠆⠀⠁⠀⠉⠀⠸⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠈⠉⡇⢸⣿⣿⣿⣿⣿⣿⣿⣼⣿⣿⣿⣿⣿⠋⠀⠀⠀⠀⠀⠐⢤⡀⠙⢦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠱⢬⣙⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⡄⠀⠀⠀⠀⠀⠀⠈⠻⠆⠀⠈⠑⠒⣿⣦⣆⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠑⠲⣼⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⣀⣀⣀⠀⠀⣀⣀⣠⣴⣾⣾⣿⣿⣿⣿⣿⣷⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣘⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⠤⣀⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⢘⣿⠟⣡⣶⣶⣤⡄⠙⣿⣿⣿⣿⣿⣿⣟⡛⠿⠿⣿⣿⣿⣿⣿⣿⣿⡿⠿⢿⣿⣿⣿⡿⠟⣩⣿⣿⣿⣿⡀⠀⠀⢏⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⣶⣿⢋⣼⢿⠿⢛⣿⠷⢶⣶⠂⠿⣿⣿⣿⣿⣿⣷⣶⣤⣀⡀⠉⠉⠀⠀⣀⣀⡀⠀⠀⠀⠠⢾⣿⣿⣿⣿⣿⠇⠀⠀⣘⠢⡀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⢀⣽⠁⠘⠁⠀⠀⠁⠀⠠⠟⠛⣿⣄⡩⢉⣿⣿⣿⣿⣿⡿⠋⠀⡠⣶⣶⣶⡶⣶⣶⣾⠿⠶⠀⠀⠻⣿⣿⣿⣿⠀⠀⠠⣿⣷⡘⢆⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⡸⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⣿⣿⣤⡈⣿⣿⣿⣿⡟⠁⣠⣾⡇⠀⣿⣿⣆⠀⠀⠀⠀⣀⣠⣆⠀⢹⣿⣿⡿⠀⠀⢠⣿⣿⣿⡘⡆⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⠁⣺⣿⣿⣿⡿⠀⢰⡟⠛⠇⠘⠿⣿⣇⠀⠀⣀⠀⢀⣽⣿⡀⠀⣿⣿⠃⠀⠀⢸⣿⣿⣿⣧⢸⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⢣⠀⠀⠀⠀⠀⠀⠀⢀⣴⠟⣿⠃⢰⠨⣿⣿⣿⠃⠀⣿⡇⢀⠀⢰⠀⠛⠛⠀⠀⠛⠀⠈⠉⠹⠇⠀⣿⡏⠀⠀⠀⣹⣿⣿⣿⣿⠘⢦⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠈⡆⠀⠀⠀⠀⣠⡶⠋⠁⡼⠃⠀⣾⠃⣿⣿⣿⠀⠀⡟⢀⡜⠀⢋⣠⣶⠀⠀⠒⠒⠀⠀⣶⡾⠀⢠⠏⠀⠀⣠⣾⣿⣿⣿⣿⢿⠁⠀⣣⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⣼⣷⢤⣤⢶⠟⠁⠀⠀⠀⠀⢀⣼⡏⣸⣿⣿⣿⣇⠀⢻⣿⡇⠀⣿⣿⣿⠀⠀⣶⣶⠀⢸⣿⠃⠀⠎⠀⠀⠀⠿⣿⣿⣿⣿⡿⠀⠀⢀⣯⢇⠀⠀
⠀⠀⠀⠀⠀⠀⢰⣿⣿⠘⠁⠁⠀⠀⢀⣠⣴⣾⣿⠟⣰⣿⣿⣿⣿⣿⡄⠀⠻⠀⣠⣿⣿⣿⠀⠀⠉⠉⠀⠘⠁⢀⠌⠀⠀⠀⢀⠀⠀⠈⠉⠀⠀⠀⢀⣾⣿⡿⠀⠀
⠀⠀⠀⠀⠀⠀⡟⣿⡏⠀⠀⢀⣠⣾⣿⣿⡿⠛⣡⠀⣿⣿⣿⣿⣿⣿⣿⣦⣀⠈⠙⠻⠿⠿⠶⠾⠟⠃⠀⢀⠔⠁⠀⠀⠀⠀⣾⣆⠀⠀⠀⠀⣰⢀⣾⣿⣿⣧⡇⠀
⠀⠀⠀⠀⠀⢸⠁⣿⠃⢀⣴⣿⣿⣿⠟⢻⢁⣾⣿⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣤⣄⣀⡀⠠⠤⠐⠊⠀⠀⠀⠀⠀⢀⡰⣿⣿⡆⠀⠀⣿⣧⣿⣿⣿⣿⣿⡇⠀
⠀⠀⠀⠀⠀⣌⠀⠘⢠⣿⣿⣿⡟⠁⢀⣏⣾⣿⡇⣸⣿⣿⣿⣿⣿⣟⠛⠛⠛⠛⠛⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡰⠋⢱⣿⣿⣧⠀⢠⣿⣿⣿⣿⣿⣿⡏⢱⠀
⠀⠀⠀⠀⠀⠈⠑⠢⢿⣿⣿⡟⠀⢀⣾⣿⣿⡟⢠⣿⣿⣿⣿⡿⠿⢿⣿⣷⣶⣤⣤⣤⣄⣤⣤⣤⠤⠖⠂⠀⠀⣠⠊⠀⠀⠀⢿⣿⣿⠀⢸⣿⣿⣿⣿⣿⣿⠇⢸⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⠣⢤⣈⣿⣿⠏⣰⣿⣿⣿⣷⣭⣍⣑⠂⠀⠀⠈⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⢀⡼⠁⠀⠀⠀⠀⠈⢿⢿⠀⣼⣿⣿⣿⣿⣿⣧⢴⣾⡄
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠑⠚⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠶⠶⠶⠖⠒⠂⠀⠀⠀⠀⢠⠞⠀⠀⠀⠀⠀⠀⠀⠘⡄⠀⣿⣿⣿⣿⣿⣿⣡⣿⣿⡇
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠓⠒⠒⠒⠒⠒⠒⠒⠒⠊⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠱⠤⠛⠛⠿⠯⠭⠭⠙⠒⠚⠁

*/