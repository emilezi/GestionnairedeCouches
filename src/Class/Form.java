/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author emilezimmer
 */
public class Form {
    
    public static int checkInput(String[] input){
        
        if(input[0].isEmpty()==true
                ||
                input[1].isEmpty()==true
                ||
                input[2].isEmpty()==true
                ||
                input[3].isEmpty() == true
                ){
            return 1;
        }else{
            return 0;
        }
        
    }
    
}
