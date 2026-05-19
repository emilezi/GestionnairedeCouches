/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import static Class.Database.getDB;
import java.sql.*;

/**
 *
 * @author emilezimmer
 */
public class Order {
    
    public static String[][] getOrder(){
        
        String[][] order = {
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
        };
        
        try{
            Connection conn = Database.getDB();
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM gc_order");
            int i = 0;
            while(res.next()){
                
            String wording = res.getString("wording");
            int quantity = res.getInt("quantity");
            String  category = res.getString("category");
            int price = res.getInt("price");
                
                
            order[i][0] = wording;
            order[i][1] = Integer.toString(quantity);
            order[i][2] = category;
            order[i][3] = Integer.toString(price);
            
            i++;
            
            }
            conn.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return order;
    }
    
    public static void newOrder(String[] Input)
    {
        
        try{
            
           Connection conn = getDB();
           Statement statement = conn.createStatement();
           String sql = "INSERT INTO `gc_order` (`wording`, `quantity`, `category`, `price`) VALUES ('"+Input[0]+"','"+Input[1]+"','"+Input[2]+"','"+Input[3]+"');";
           statement.executeUpdate(sql);
           
           conn.close();
           
           
        }catch(Exception e){
          
            System.out.println(e);
          
        }
        
    }
    
    public static void deleteOrder(String number)
    {
        
        try{
            
           Connection conn = getDB();
           Statement statement = conn.createStatement();
           String sql = "DELETE FROM gc_order WHERE `gc_order`.`number` = "+number+";";
           statement.executeUpdate(sql);
           
           conn.close();
           
           
        }catch(Exception e){
          
            System.out.println(e);
          
        }
        
    }
    
}
