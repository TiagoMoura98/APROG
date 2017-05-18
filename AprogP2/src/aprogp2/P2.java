/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aprogp2;

import javax.swing.JOptionPane;

/**
 *
 * @author Tiago Moura
 */
public class AprogP2 {
    public static void main(String[] args){
        
       String inputData = "";
        
       int menu1;
       
            
     do{
         
      
        
        inputData = JOptionPane.showInputDialog("Introduza o sexo do paciente com um M ou F.");
        
         String menu = JOptionPane.showInputDialog(""); 
            menu1 = Integer.parseInt(menu);
            
             }while(menu1=1);//nao sei porque é que está a dar erro .......
    }
}