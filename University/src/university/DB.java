package university;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import static university.DB.connt;

public class DB {
    private static Object ps;
    
    
    public static Connection connt()
    {
        Connection con = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
               con = DriverManager.getConnection("jdbc:ucanaccess://University.accdb");
               JOptionPane.showMessageDialog(null, "is Connection");
        }
            catch (Exception e)
                {
                       JOptionPane.showMessageDialog(null, "is Not Connection");
            
        }
        return con;
//    } 
//   public static boolean insert(String table,int id ,String fname,String lname,
//            String date_birt,String gender,int clss,String deper,String address,String phone)
//    {
//      Connection con= connt();
//        try {
//            PreparedStatement ps =con.prepareStatement("insert into"+table+"Vaules('"+id+"','"+fname+"',"
//                    + "'"+lname+"','"+date_birt+"'"
//                    + ",'"+gender+"','"+clss+"'"
//                    + ",'"+deper+"','"+address+"','"+phone+"')");
//        } 
//        catch (Exception e) {
//            if (table.equals("std"))
//            {
//                JOptionPane.showMessageDialog(null,"Filed user find");
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null,"Filed user find");
//                
//        }
//        }
//finally
//        {
//            try {
//                            con.close();
//
//                
//            } catch (Exception e) {
//            }
//        }
//           return ps.execute();
//     
  }
   
    public static void main(String age[])
    {
        connt();
    }
}
