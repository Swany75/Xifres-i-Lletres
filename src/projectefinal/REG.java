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

        MS dificultatMS;
        if (p2.isCPU()) {
            switch (p2.getDifficulty()) {
                case 1 -> dificultatMS = new MS("1".toCharArray());
                case 2 -> dificultatMS = new MS("2".toCharArray());
                case 3 -> dificultatMS = new MS("3".toCharArray());
                default -> dificultatMS = new MS("4".toCharArray());
            }
        } else {
            dificultatMS = new MS("0".toCharArray()); // jugador humà
        }
        
        int tamanyTotal = nom1.getTam() + nom2.getTam() + rondesMS.getTam() + idiomaMS.getTam()
                 + punts1.getTam() + punts2.getTam() + tempsMS.getTam() + dificultatMS.getTam() + 7;

        char[] linea = new char[tamanyTotal];
        int pos = 0;

        pos = copiarCamp(nom1, linea, pos, true);
        pos = copiarCamp(nom2, linea, pos, true);
        pos = copiarCamp(rondesMS, linea, pos, true);
        pos = copiarCamp(idiomaMS, linea, pos, true);
        pos = copiarCamp(punts1, linea, pos, true);
        pos = copiarCamp(punts2, linea, pos, true);
        pos = copiarCamp(tempsMS, linea, pos, true);
        pos = copiarCamp(dificultatMS, linea, pos, false);

        WF wf = new WF(new MS("files/registre.txt".toCharArray()), true);
        wf.open();
        wf.writeLine(new MS(linea));
        wf.close();
    }

    private static int copiarCamp(MS camp, char[] desti, int pos, boolean posarSeparador) {
        for (int i = 0; i < camp.getTam(); i++) {
            desti[pos++] = camp.get(i);
        }
        if (posarSeparador) {
            desti[pos++] = '#';
        }
        return pos;
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

            // Guardem els camps
            MS[] camps = new MS[8];
            for (int j = 0; j < 8; j++) {
                camps[j] = new MS(new char[0]);
                while (pos < linia.getTam() && linia.get(pos) != '#') {
                    camps[j].add(linia.get(pos++));
                }
                pos++; // botar #
            }

            // Determinar dificultat
            MS dificultat = new MS("humana".toCharArray());
            if (camps[1].toString().equals("CPU")) {
                switch (camps[7].toString()) {
                    case "1" -> dificultat = new MS("facil".toCharArray());
                    case "2" -> dificultat = new MS("normal".toCharArray());
                    case "3" -> dificultat = new MS("dificil".toCharArray());
                    default -> dificultat = new MS("aleatori".toCharArray()); // No pasara mai aquest cas
                }
            }

            // Determinar idioma
            MS idiomaStr;
            char id = camps[3].get(0);
            switch (id) {
                case 'C':
                    idiomaStr = new MS("Catalan".toCharArray());
                    break;
                case 'S':
                    idiomaStr = new MS("Spanish".toCharArray());
                    break;
                case 'E':
                    idiomaStr = new MS("English".toCharArray());
                    break;
                default:
                    idiomaStr = new MS("?".toCharArray());
                    break;
            }

            // Construir la String amb .add()
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
