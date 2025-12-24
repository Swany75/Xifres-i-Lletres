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
    private int mode;
    
    // Constructor per jugador humà
    public PLAYER(char[] nom) {
        this.name = new MS(nom);
        this.score = 0;
        this.cpu = false;
    }
    
    // Constructor per CPU
    public PLAYER(int difficulty) {
        this.name = new MS("CPU".toCharArray());
        this.score = 0;
        this.cpu = true;
        this.mode = difficulty;
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
    
    public int getDifficulty() {
        return mode;
    }
    
    // Mètode per sumar punts
    public void addScore(int pts) {
        score += pts;
    }
    
    public void resetScore() {
        score = 0;
    }
    
}
