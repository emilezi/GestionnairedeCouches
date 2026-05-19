package Class;

import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author emilezimmer
 */
public class Database {
    
    static String DBhost = "localhost";
    static String DBname = "gestionnairedecouches";
    static String DBuser = "root";
    static String DBpassword = "htgh7@!25t";
    
    public static Connection getDB()
    {
        try{
            
           Connection conn = DriverManager.getConnection(
           "jdbc:mysql://"+DBhost+":3306/"+DBname, DBuser, DBpassword); 
           return conn;
           
        }catch(Exception e){
          
            return null;
          
        } 
        
        
        
    }
    
    public static int checkDB()
    {
        int value = 0;
        
        try
            {
                
            Connection conn = getDB();
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet rs1 = meta.getTables(null, null, null,new String[] {"TABLE"});
            int count = 0;
            while (rs1.next())
            {
            count = count + 1;
            }
            
            if(count > 30)
            {
                value = 1;
            }else{
                value = 0;
            }
            
            conn.close();
            
            
            }
        catch(Exception e){ 
          
            value = 2;
          
        }
        
        return value;
        
    }
    
    public static void newDatabase()
    {
        
        try{
            
           Connection conn = getDB();
           Statement statement = conn.createStatement();
           String sql = "CREATE TABLE `gc_order` (" +
            "  `id` int(11) NOT NULL," +
            "  `wording` varchar(255) NOT NULL," +
            "  `quantity` int(11) NOT NULL," +
            "  `category` varchar(255) NOT NULL," +
            "  `price` int(11) NOT NULL" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;";
           statement.executeUpdate(sql);
           sql = "ALTER TABLE `gc_order`" +
                 "  ADD PRIMARY KEY (`id`);";
           statement.executeUpdate(sql);
           sql = "ALTER TABLE `gc_order`" +
                 "  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;";
           statement.executeUpdate(sql);
           
           conn.close();
           
           
        }catch(Exception e){
          
            System.out.println(e);
          
        }
        
    }
    
}
