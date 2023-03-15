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


public class Teach extends Application{
  
    @Override
    public void start(Stage ps) 
    {

    String[] depp={"1","2","3","4","5"};
    String[] dep={"it","cs","ict","NW","is"};
	
    HBox l1 = new HBox(24);
 	Label no_doctor = new Label("Id-teach :       ");
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
       Label first_name = new Label("Frist-Name :     ");
	TextField f_name = new TextField();
            f_name.setStyle("-fx-background-radius: 24");
     VBox v1 = new VBox(35);
v1.getChildren().addAll(l2);
   v1.setLayoutX(38);
      v1.setLayoutY(95);
         l2.getChildren().addAll(first_name,f_name);
	
   HBox l3 = new HBox(24);
         Label last_name = new Label("Last-Name :     ");
	 TextField l_name = new TextField();
               l_name.setStyle("-fx-background-radius: 24");
  VBox v2 = new VBox(35);
v2.getChildren().addAll(l3);
   v2.setLayoutX(38);
      v2.setLayoutY(145);
         l3.getChildren().addAll(last_name,l_name);
   
         HBox l5 = new HBox(24);	
   	 Label date_h = new Label("Date-of-Birth :");
   	  TextField d_h = new TextField();
                     d_h.setStyle("-fx-background-radius: 24");
       VBox v4 = new VBox(35);
v4.getChildren().addAll(l5);
   v4.setLayoutX(38);
      v4.setLayoutY(195);
         l5.getChildren().addAll(date_h,d_h);


       HBox l11 = new HBox(24);
       Label gender = new Label("Gender :");
      ToggleGroup ob = new ToggleGroup();
  	 RadioButton rad1 = new RadioButton("1-Male"); 
        RadioButton rad2 = new RadioButton("2-Female");
        rad1.setToggleGroup(ob);
        rad2.setToggleGroup(ob);
     VBox v11 = new VBox(35);
v11.getChildren().addAll(l11);
v11.setLayoutX(97);
v11.setLayoutY(260);
l11.getChildren().addAll(gender,rad1,rad2);
     
         HBox l9= new HBox(24);
  	 Label de = new Label("Department :");
    	  ChoiceBox bd = new ChoiceBox(FXCollections.observableArrayList(dep));
    VBox v9= new VBox(35);
v9.getChildren().addAll(l9);
     v9.setLayoutX(180);
      v9.setLayoutY(320);
         l9.getChildren().addAll(de,bd);
         
       	 
    HBox l7= new HBox(24);
  	 Label address = new Label("Address :");
	 TextField add = new TextField();
              add.setStyle("-fx-background-radius: 24");
       VBox v6= new VBox(35);
v6.getChildren().addAll(l7);
v6.setLayoutX(84);
v6.setLayoutY(370);
l7.getChildren().addAll(address,add);

  HBox l8= new HBox(24);
         Label phone_number = new Label("Phone-Number :");
	 TextField phone = new TextField();
         phone.setStyle("-fx-background-radius: 24");
      VBox v7= new VBox(35);
      v7.getChildren().addAll(l8);
      v7.setLayoutX(36);
      v7.setLayoutY(427);
         l8.getChildren().addAll(phone_number,phone);
 
         VBox bv = new VBox(8);
         
             	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Add $$$$$$$$$$$$$$$$$$$$$$$//
       Button Add  =new Button("Add",new ImageView("image/addd.png"));
          Add.setOnAction(e-> {
        
         PreparedStatement pstmt= null;
          
       try{
    		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    		Connection con = DriverManager.getConnection("jdbc:ucanaccess://University.accdb");
      String sql="insert into teach(first_name,last_name,date_birt,gender,deprr,address,phone)"
        + " Values (? ,? ,? ,? ,? ,? ,?)";
    		  pstmt= con.prepareStatement(sql);  	    		
//	pstmt.setInt(1,Integer.parseInt(no_do.getText()));
	pstmt.setString(1,f_name.getText());
	pstmt.setString(2,l_name.getText());
	pstmt.setString(3,d_h.getText());

         String g = null;
	if(rad1.isSelected()){
		g = rad1.getText();
	}
	if(rad2.isSelected()){
		g = rad2.getText();
	}
	pstmt.setString(4,g);

	String tmm;
	   tmm = bd.getSelectionModel().getSelectedItem().toString();

        pstmt.setString(5,tmm);
	
	pstmt.setString(6,add.getText());
	pstmt.setInt(7,Integer.parseInt(phone.getText()));
    
	int i=pstmt.executeUpdate();

	if(i>0)
	{
		JOptionPane.showMessageDialog(null,"Data is Saved ^_^");
		
		no_do.setText("");
    
        f_name.setText("");
       
        l_name.setText("");
      
        d_h.setText("");
       
       add.setText("");
        
       phone.setText("");
    
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
       Button Update  =new Button("Update",new ImageView("image/update.png"));
	   Update.setOnAction(e-> {
            PreparedStatement pstmt= null;
              
       try{
    		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                	Connection con = DriverManager.getConnection("jdbc:ucanaccess://University.accdb");
    		String sql="update  teach set first_name=?,last_name=? ,date_birt=? ,gender=?,deprr=? ,address=?,phone=? where id_teach ='"+no_do.getText()+"'";
	    		pstmt= con.prepareStatement(sql);	
	//pstmt.setInt(1,Integer.parseInt(no_do.getText()));
	pstmt.setString(1,f_name.getText());
	pstmt.setString(2,l_name.getText());
	pstmt.setString(3,d_h.getText());
       String gen = null;
	if(rad1.isSelected()){
		gen = rad1.getText();
	}
	if(rad2.isSelected()){
		gen = rad2.getText();
	}
	pstmt.setString(4,gen);
	
	String tmm;
	   tmm = bd.getSelectionModel().getSelectedItem().toString();

        pstmt.setString(5,tmm);
	
	pstmt.setString(6,add.getText());
	pstmt.setString(7,phone.getText());
    
	int i=pstmt.executeUpdate();

	if(i>0)
	{
		JOptionPane.showMessageDialog(null,"Data is Update ^_^");
		
		no_do.setText("");
    
        f_name.setText("");
       
        l_name.setText("");
        
      
        d_h.setText("");
      
       
       add.setText("");
        
       phone.setText("");
    
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
       
      
            ////////// Delete //////////////////////////////////////////////////
           
           Button Delete  =new Button("Delete",new ImageView("image/delete.png"));
           Delete.setOnAction(e->{

               try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                	Connection con = DriverManager.getConnection("jdbc:ucanaccess://University.accdb");
  		   		String sql="delete from teach where id_teach ='"+no_do.getText()+"'";
		   		PreparedStatement pstmt= con.prepareStatement(sql);  	    		
		       pstmt.execute();
			
	   		JOptionPane.showMessageDialog(null,"Data is deleted...");
	
	   		no_do.setText("");
	   	    
	        f_name.setText("");
	       
	        l_name.setText("");
	        
	        d_h.setText("");
	      	        
	       add.setText("");
	        
	       phone.setText("");
	    
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
	 String in = JOptionPane.showInputDialog("  Enter Your id_teach : ");
		 Add.setDisable(false);
		 try{
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    		Connection con = DriverManager.getConnection("jdbc:ucanaccess://University.accdb");
    		String sql="select * from teach where id_teach =?";
                       	PreparedStatement pstmt= con.prepareStatement(sql);  	    		
		   		pstmt.setString(1, in);	
		   	 ResultSet rs = pstmt.executeQuery();
		   	 if(rs.next())
		   	 {
		   		String id=rs.getString("id_teach");
		   		no_do.setText(id);
		   		
		        String fn=rs.getString("first_name");
		        f_name.setText(fn);
		        	        
		        String lm=rs.getString("last_name");
		        l_name.setText(lm);
		        
		        String ge = rs.getString("gender");
		        if(ge.equals("1-Male"))
		        {
		        	rad1.setSelected(true);	
		        }
		          else{
		        	rad2.setSelected(true);	 
		          }
		        
		        String dh=rs.getString("date_birt");
		        d_h.setText(dh);
		        
		       String ar = rs.getString("address");
		       add.setText(ar);
		       
		       String no = rs.getString("phone");
		       phone.setText(no);
		  	   	
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

         
         
           //////////////////  Refresh  ////////////////////////////////////////
         
         Button Refresh  =new Button("Refresh",new ImageView("image/ref.png"));
        Refresh.setOnAction(e->{
    
            f_name.setText("");
       
            l_name.setText("");
        
            d_h.setText("");
        
         add.setText("");
        
         phone.setText("");
    
        });
	Button Back  =new Button("Back",new ImageView("image/backk.png"));
        Back.setOnAction(e->{
        try {
            Main otb = new Main();
            Teach obb = new Teach();
            obb.stop();
            otb.start(ps);
        } catch (Exception ex) {
            Logger.getLogger(Std.class.getName()).log(Level.SEVERE, null, ex);
        }
      
            });
          
bv.getChildren().addAll(Add,Update,Delete,Search,Refresh,Back);
bv.setLayoutX(599);

Pane p = new Pane();
	 
        p.getChildren().addAll(v,v1,v2,v4,v6,v11,v7,v9,bv);
        Scene scene = new Scene(p, 750, 500);
        ps.setScene(scene);
       
        scene.getStylesheets().add("css/teach.css");
        ps.setTitle("Teach");
        ps.setResizable(false);
        ps.show();
     
}
    // هنا قمنا بتشغيل التطبيق
    public static void main(String[] args) {
        launch(args);
    }
}