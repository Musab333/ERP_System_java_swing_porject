package university;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Main  extends Application {  
    @Override
    public void start(Stage stage) {

          // يمثل شريط القوائم الذي سنضعه في أعلا النافذة MenuBar هنا قمنا بإنشاء كائن من الكلاس
    MenuBar menuBar = new MenuBar();

    // هنا قمنا بإنشاء القائمة الرئيسية التي سنضعها في شريط القوائم
   // Menu menu = new Menu("Menu");
    
    Menu std = new Menu("Student"); 
   std.setStyle("-fx-text-fill: white;-fx-font-size:16");
   Menu cor = new Menu("Corse");
   cor.setStyle("-fx-text-fill: white;-fx-font-size:16");
   Menu tec = new Menu("Teacher");
     tec.setStyle("-fx-text-fill: white;-fx-font-size:16");
   Menu exit = new Menu("EXIT");
    exit.setStyle("-fx-text-fill: white;-fx-font-size:16");
      // هنا قمنا بوضع القائمة في شريط القوائم
   
    menuBar.getMenus().addAll(std,cor,tec,exit);

      // تمثل العناصر التي سنضعها في القوائم مع وضع صورة مختلفة لكل عنصر MenuItem هنا قمنا بإنشاء 4 كائنات من الكلاس
    MenuItem ast = new MenuItem("Add stduden", new ImageView(new Image("image/std.png")));
    
    MenuItem aco = new MenuItem("Add Corse", new ImageView(new Image("image/cor.png")));
        
    MenuItem atea = new MenuItem("Add Techer", new ImageView(new Image("image/tech.png")));
   
   MenuItem ex = new MenuItem("Exit", new ImageView(new Image("image/logout.png")));
   

            std.getItems().add(ast);
            cor.getItems().add(aco);
            tec.getItems().add(atea);
            exit.getItems().add(ex);
    
       ast.setOnAction(e->
       {
        try {
            Std ob = new Std();
            Main obb = new Main();
            obb.stop();
            ob.start(stage);
        } catch (Exception ex1) {
        }
       
       });
              cor.setOnAction(e->
       {
        try {
            Corse ob = new Corse();
            Main obb = new Main();
            obb.stop();
            ob.start(stage);
        } catch (Exception ex1) {
        }
       
       });
                  tec.setOnAction(e->
       {
        try {
            Teach ob = new Teach();
            Main obb = new Main();
            obb.stop();
            ob.start(stage);
        } catch (Exception ex1) {
        }
       
       });


               ex.setOnAction(e->
       {
     if(JOptionPane.showConfirmDialog(null, "if you want to exit","University MANAGEMENT SYSTEM", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)

		System.exit(0);
});
               
       
// هنا قمنا بجعل عرض شريط القوائم يساوي عرض النافذة حتى يظهر مطابق لها
        menuBar.setPrefWidth(310);
       
exit.setOnAction((ActionEvent e) -> {
     
    if(JOptionPane.showConfirmDialog(null, "if you want to exit","Scool MANAGEMENT SYSTEM", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)

		System.exit(0);
});

        // في النافذة Root Node لأننا ننوي جعله الـ Group هنا قمنا بإنشاء كائن من الكلاس
        Pane p = new Pane();

 p.setStyle("-fx-background-image:url('image/te.jpg')");
        
        // root في الكائن menuBar هنا قمنا بإضافة الكائن
        p.getChildren().add(menuBar);
    
        // فيها و تحديد حجمها Node كأول root هنا قمنا بإنشاء محتوى النافذة مع تعيين الكائن
        Scene scene = new Scene(p, 626, 436);
        scene.getStylesheets().add("css/cssmain.css");
    
        // هنا وضعنا عنوان للنافذة
        stage.setTitle("Menu_Page");

        // أي وضعنا محتوى النافذة الذي قمنا بإنشائه للنافذة .stage في كائن الـ scene هنا وضعنا كائن الـ
        stage.setScene(scene);

        // هنا قمنا بإظهار النافذة
        stage.show();

    }

    // هنا قمنا بتشغيل التطبيق
    public static void main(String[] args) {
        launch(args);
    }

}


