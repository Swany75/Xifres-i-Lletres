/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectefinal;

/**
 *
 * @author Juan
 */
public class REG {
    
    /* Lectura Teclat */
    LT lt = new LT();
    
    
    public static void guardarPartida(PLAYER p1, PLAYER p2, int rondes, LANG idioma, double gameTime) {
        
        MS nom1 = p1.getName();
        MS nom2 = p2.getName();
        MS rondesMS = new MS(Integer.toString(rondes).toCharArray());
        MS idiomaMS = new MS(new char[]{idioma.getCode()});
        MS punts1 = new MS(Integer.toString(p1.getScore()).toCharArray());
        MS punts2 = new MS(Integer.toString(p2.getScore()).toCharArray());
        MS tempsMS = new MS(Double.toString(gameTime).toCharArray());
        
        int tamanyTotal = nom1.getTam() + nom2.getTam() + rondesMS.getTam() + idiomaMS.getTam() + punts1.getTam() + punts2.getTam() + tempsMS.getTam() + 6;
        
        char[] linea = new char[tamanyTotal];
        int pos = 0;
        
        for (int i = 0; i < nom1.getTam(); i++) linea[pos++] = nom1.get(i); linea[pos++] = '#';
        for (int i = 0; i < nom2.getTam(); i++) linea[pos++] = nom2.get(i); linea[pos++] = '#';
        for (int i = 0; i < rondesMS.getTam(); i++) linea[pos++] = rondesMS.get(i); linea[pos++] = '#';
        for (int i = 0; i < idiomaMS.getTam(); i++) linea[pos++] = idiomaMS.get(i); linea[pos++] = '#';
        for (int i = 0; i < punts1.getTam(); i++) linea[pos++] = punts1.get(i); linea[pos++] = '#';
        for (int i = 0; i < punts2.getTam(); i++) linea[pos++] = punts2.get(i); linea[pos++] = '#';
        for (int i = 0; i < tempsMS.getTam(); i++) linea[pos++] = tempsMS.get(i);
        
        WF wf = new WF(new MS("files/registre.txt".toCharArray()), true);
        wf.open();
        wf.writeLine(new MS(linea));
        wf.close();
    }
    
    public static void showPartides() {

        RF rf = new RF(new MS("files/registre.txt".toCharArray()));
        rf.open();

        MS linia;
        int compt = 0;

        System.out.println("\n[i] Mostrant totes les partides guardades:\n");

        while ((linia = rf.readLine()) != null) {
            compt++;
            int pos = 0;

            // Guardem els 7 camps
            MS[] camps = new MS[7];
            for (int j = 0; j < 7; j++) {
                camps[j] = new MS(new char[0]);
                while (pos < linia.getTam() && linia.get(pos) != '#') {
                    camps[j].add(linia.get(pos++));
                }
                pos++; // saltar #
            }

            // Determinar dificultat
            MS dificultat = new MS("normal".toCharArray());
            if (camps[1].toString().equals("CPU")) {
                if (camps[2].toString().equals("1")) dificultat = new MS("normal".toCharArray());
                else if (camps[2].toString().equals("2")) dificultat = new MS("dificil".toCharArray());
                else dificultat = new MS("aleatori".toCharArray());
            }

            // Determinar idioma
            MS idiomaStr;
            char id = camps[3].get(0);
            if (id == 'C') idiomaStr = new MS("Catalan".toCharArray());
            else if (id == 'S') idiomaStr = new MS("Spanish".toCharArray());
            else if (id == 'E') idiomaStr = new MS("English".toCharArray());
            else idiomaStr = new MS("?".toCharArray());

            // Construir línia amb .add()
            MS output = new MS(new char[0]);
            output.add(camps[0].toString().toCharArray());
            output.add(": ".toCharArray());
            output.add(camps[4].toString().toCharArray());
            output.add("P VS ".toCharArray());
            output.add(camps[1].toString().toCharArray());
            output.add(": ".toCharArray());
            output.add(camps[5].toString().toCharArray());
            output.add("P | MODE: ".toCharArray());
            output.add(dificultat.toString().toCharArray());
            output.add(" | IDIOMA: ".toCharArray());
            output.add(idiomaStr.toString().toCharArray());
            output.add(" | Duració: ".toCharArray());
            output.add(camps[6].toString().toCharArray());
            output.add(" minuts".toCharArray());

            System.out.println(output);
        }

        rf.close();

        if (compt == 0) {
            System.out.println("[i] No hi ha partides guardades.");
        }
        
    }

    
}
