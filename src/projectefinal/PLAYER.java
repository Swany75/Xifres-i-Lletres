/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectefinal;

/**
 *
 * @author Juan
 */

public class PLAYER {
    
    private MS name;
    private int score;
    private boolean cpu;
    
    // Constructor per jugador humà
    public PLAYER(char[] nom) {
        this.name = new MS(nom);
        this.score = 0;
        this.cpu = false;
    }
    
    // Constructor per CPU
    public PLAYER() {
        this.name = new MS("CPU".toCharArray());
        this.score = 0;
        this.cpu = true;
    }
    
    public MS getName() {
        return name;
    }
    
    public int getScore() {
        return score;
    }
    
    public boolean isCPU() {
        return cpu;
    }
    
    // Mètode per sumar punts
    public void addScore(int pts) {
        score += pts;
    }
    
    public void resetScore() {
        score = 0;
    }
}
