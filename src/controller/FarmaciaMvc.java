
package controller;

import controller.view.Interface;
import javax.swing.JFrame;

public class FarmaciaMvc {

    public static void main(String[] args) {
       
        Interface inter = new Interface(); 
        inter.setSize(805, 422);
        inter.setVisible(true);
        inter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
