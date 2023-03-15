package university;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class Corse extends Application{
  
    @Override
    public void start(Stage ps) 
    {

	
    HBox l1 = new HBox(24);
 	Label no_doctor = new Label("Id-Corse :       ");
	 TextField no_do = new TextField();
          no_do.setPromptText("Id is aout Number");
         no_do.setDisable(true);
            no_do.setStyle("-fx-background-radius: 24");
         VBox v = new VBox(35);
  v.getChildren().addAll(l1);
  v.setLayoutX(40);
  v.setLayoutY(45);
         l1.getChildren().addAll(no_doctor,no_do);

         
             HBox l2 = new HBox(24);
       Label first_name = new Label("Corse-Name :     ");
	TextField f_name = new TextField();
         f_name.setStyle("-fx-background-radius: 24");
        VBox v1 = new VBox(35);
   v1.getChildren().addAll(l2);
   v1.setLayoutX(17);
      v1.setLayoutY(95);
         l2.getChildren().addAll(first_name,f_name);
	
   HBox l3 = new HBox(24);
         Label last_name = new Label("Techer :     ");
	 TextField l_name = new TextField();
         l_name.setStyle("-fx-background-radius: 24");
        VBox v2 = new VBox(35);
v2.getChildren().addAll(l3);
   v2.setLayoutX(56);
      v2.setLayoutY(145);
         l3.getChildren().addAll(last_name,l_name);
         
            VBox bv = new VBox(8);
         
         	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Add $$$$$$$$$$$$$$$$$$$$$$$//
       Button Add  =new Button("Add",new ImageView("image/addd.png"));
          Add.setOnAction(e-> {
        
         PreparedStatement pstmt= null;
          
       try{
    		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    		Connection con = DriverManager.getConnection("jdbc:ucanaccess://University.accdb");
    String sql="insert into course(course_name,teacher)"
        + " Values (? ,?)";
    		  pstmt= con.prepareStatement(sql);  	    		
//	pstmt.setInt(1,Integer.parseInt(id_cours.getText()));
	//pstmt.setString(1,no_do.getText());
	pstmt.setString(1,f_name.getText());
	 pstmt.setString(2,l_name.getText());

        
	int i=pstmt.executeUpdate();

	if(i>0)
	{
		JOptionPane.showMessageDialog(null,"Data is Saved ^_^");
		
		no_do.setText("");
    
        f_name.setText("");
       
        l_name.setText("");
        
      
	}
	else
	{
		JOptionPane.showMessageDialog(null,"Data is Not Saved...!");
		con.close();
    		
	}
	
    	}
    	catch(Exception ex)
    	{
			JOptionPane.showMessageDialog(null,ex.getMessage());
	   
    	}
        });
 
//                	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Update $$$$$$$$$$$$$$$$$$$$$$$//
//  
       Button Update  =new Button("Update",new ImageView("image/update.png"));
    
       Update.setOnAction(e-> {
               
           PreparedStatement pstmt= null;
              
       try{
    		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                	Connection con = DriverManager.getConnection("jdbc:ucanaccess://University.accdb");
    		String sql="update  course set course_name=?,teacher=? where id_cours ='"+no_do.getText()+"'";
	    		pstmt= con.prepareStatement(sql);	
	//pstmt.setInt(1,Integer.parseInt(no_do.getText()));
	pstmt.setString(1,f_name.getText());
	pstmt.setString(2,l_name.getText());
	
	int i=pstmt.executeUpdate();

	if(i>0)
	{
		JOptionPane.showMessageDialog(null,"Data is Update ^_^");
		
		no_do.setText("");
    
        f_name.setText("");
       
        l_name.setText("");
        
	}
	else
	{
		JOptionPane.showMessageDialog(null,"Data is Not Saved...!");
		con.close();
    		
	}
	
    	}
    	catch(Exception ex)
    	{
			JOptionPane.showMessageDialog(null,ex.getMessage());
	   
    	}
                        

                        });
////////////////  Delete /////////////////////////
    Button Delete  =new Button("Delete",new ImageView("image/delete.png"));
           Delete.setOnAction(e->
           {

               try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                	Connection con = DriverManager.getConnection("jdbc:ucanaccess://University.accdb");
  		   	String sql="delete from course where id_cours ='"+no_do.getText()+"'";
		   	PreparedStatement pstmt= con.prepareStatement(sql);  	    		
		       pstmt.execute();
			
	   		JOptionPane.showMessageDialog(null,"Data is deleted...");
	
	   		no_do.setText("");
	   	    
	         f_name.setText("");
	       
	         l_name.setText("");
	        
	      
	       con.close();

			 }
		 
		 catch(Exception ep)
		   	{
					JOptionPane.showMessageDialog(null,ep.getMessage());		   
		   	}
				
    });     
        
        
        ////////////////////////  Search ////////////////////////////////////
        Button Search  =new Button("Search",new ImageView("image/sear.png"));
	
        Search.setOnAction(e->{
	 String in = JOptionPane.showInputDialog("  Enter Your id_cours : ");
		 Add.setDisable(false);
		 try{
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    		Connection con = DriverManager.getConnection("jdbc:ucanaccess://University.accdb");
    		String sql="select * from course where id_cours =?";
                       	PreparedStatement pstmt= con.prepareStatement(sql);  	    		
		   		pstmt.setString(1, in);	
		   	 ResultSet rs = pstmt.executeQuery();
		   	 if(rs.next())
		   	 {
		   		String id=rs.getString("id_cours");
		   		no_do.setText(id);
		   		
		        String fn=rs.getString("course_name");
		        f_name.setText(fn);
		        	        
		        String lm=rs.getString("teacher");
		        l_name.setText(lm);
		        
		  	   	
		   	 con.close();
		   	 }
		        
		   	 else
		   	 {
		   		JOptionPane.showMessageDialog(null,"NOT Found Data...! ");		   
				 Add.setVisible(true);
				   		 
		   	 }
		   	 }
		   	catch(Exception ep)
		   	{
					JOptionPane.showMessageDialog(null,ep.getMessage());		   
                        }
                 
        
    
});
         
         
         Button Refresh  =new Button("Refresh",new ImageView("image/ref.png"));
//        Refresh.setOnAction(e->{
//    
//            f_name.setText("");
//       
//        l_name.setText("");
//        
//      
//        d_h.setText("");
//      
//      
//	    bd.getSelectionModel().selectedIndexProperty();
//   
//       /// dayy.setSelectedIndex(-1);
//        
//        ///tim.setSelectedIndex(-1);
//        
//       add.setText("");
//        
//       phone.setText("");
//    
//        });
	Button Back  =new Button("Back",new ImageView("image/backk.png"));
        Back.setOnAction(e->{
        try {
            Main otb = new Main();
            Corse obb = new Corse();
            obb.stop();
            otb.start(ps);
        } catch (Exception ex) {
            Logger.getLogger(Std.class.getName()).log(Level.SEVERE, null, ex);
        }
      
            });
          
bv.getChildren().addAll(Add,Update,Delete,Search,Refresh,Back);
bv.setLayoutX(599);

Pane p = new Pane();
	 
        p.getChildren().addAll(v,v1,v2,bv);
        Scene scene = new Scene(p, 750, 500); 
        ps.setScene(scene);
        scene.getStylesheets().add("css/cors.css");
        ps.setTitle("Std Page");
        ps.setResizable(false);
        ps.show();
     
}
    public static void main(String[] args) {
        launch(args);
    }
}