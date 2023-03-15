package university;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class Login extends Application {
      Stage s1;
    @Override
    public void start(Stage ps) {
     //   Stage s1 = null;
      Pane p = new Pane();
      
      Pane p2 = new Pane();
    
      p2.setStyle("-fx-background-color:#2196f3");
      p2.setPrefSize(335, 650);
      p2.setTranslateX(2);
      p2.setTranslateY(5);
       
        Label si = new Label("SIGN IN ");
        p2.getChildren().add(si);
      si.setStyle("-fx-text-fill: white;-fx-font-size:35");
        si.setLayoutX(118);
        si.setLayoutY(224);
      
            
       
 
         HBox h = new HBox(15);      
        Label user = new Label("UserName");
        TextField us = new TextField();
        us.setPromptText("Enter Username");
        us.setAlignment(Pos.CENTER);
       us.setTooltip(new Tooltip("Plase Enter Username"));
      us.setStyle("-fx-background-radius: 24");
        h.getChildren().addAll(user,us);
        
         HBox h1 = new HBox(15);      
        Label pass = new Label("Password  ");
         PasswordField pss = new PasswordField();
        pss.setPromptText("Enter Password");
       pss.setAlignment(Pos.CENTER);
      pss.setStyle("-fx-background-radius: 24");
       pss.setTooltip(new Tooltip("Plase Enter Password"));
  
         h1.getChildren().addAll(pass,pss);
        
        VBox v =new VBox(15);
      v.setLayoutX(340);
      v.setLayoutY(190);
      v.getChildren().addAll(h,h1);
  
         HBox h2 = new HBox(45);      
       Button login = new Button("Login",new ImageView("image/MLogIn.png"));
          login.setOnAction(e->{
        Main ob = new Main();
        Login obb = new Login();
       
                try 
           { 
    
       if(us.getText().trim().equals("admin") && pss.getText().equals("9988"))
       {
         
           JOptionPane.showMessageDialog(null, "Login Sucessfully...");
           JOptionPane.showMessageDialog(null, "Welcom To University Management System");
      
        obb.stop();
        ob.start(ps);
        
       }    
       
      else
       {
          
	JOptionPane.showMessageDialog(null, "Incorrect UserName and Password...!");
       
       }
           
           }
           catch (Exception ex) {
           }
      });
       Button logout = new Button("Exit",new ImageView("image/MLogOut.png"));
       logout.setOnAction(e->
       {
     if(JOptionPane.showConfirmDialog(null, "if you want to exit","University MANAGEMENT SYSTEM", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)

		System.exit(0);
});
       
       h2.setLayoutX(420);
       h2.setLayoutY(330);
       h2.getChildren().addAll(login,logout);
    
          Label sign = new Label("University Manager",new ImageView("image/mtr.gif"));
          sign.setLayoutX(380);
          sign.setLayoutY(45);
          sign.setStyle(" -fx-font-size:24");
      
        p.getChildren().addAll(p2,v,h2,sign);
     
        Scene scene = new Scene(p, 750, 500); 
        ps.setScene(scene);
        scene.getStylesheets().add("css/Stylelogin.css");
        ps.setTitle("Login Page");
        ps.setResizable(false);
        ps.show();
        s1=ps;
}
}

