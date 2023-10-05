package car_dealership;

import javafx.application.Application; 
import javafx.geometry.Insets; 
import javafx.scene.Scene; 
import javafx.scene.layout.GridPane; 
import javafx.scene.control.Button;
import javafx.scene.paint.Color; 
import javafx.scene.text.Font; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text; 
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.geometry.*;
import javafx.scene.text.FontPosture;


public class Window1 extends Application 
{ 
      public void start(Stage stage) 
      { 
      GridPane   pane1   = new GridPane(); 
      HBox        pane   = new HBox();
      StackPane   pane2  = new StackPane();
      
      
      Text text = new Text("Welcome to our car inventory system !");
      text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
      text.setFill(Color.BROWN); 
      Button btn1     = new Button("Add Car");
      Scene scene     = new Scene(pane1,600,500); 
      
      Button btn2     = new Button("Find Car");
      pane.getChildren().addAll(btn1, btn2);
      pane2.getChildren().add(text);
      pane1.setAlignment(Pos.CENTER);
      pane1.add(pane2 , 0 ,0);
      pane1.add(pane  , 0 ,1); 
      
      AddCars addCars = new AddCars();
      FindCars findCars = new FindCars();
      
      btn1.setOnAction(e -> 
      { 
        try{
        addCars.start(stage); }
        catch(Exception eee){
                System.out.println("Exception");
            }
        
      });
      
      
       btn2.setOnAction(e -> 
      { 
        try{
        findCars.start(stage); }
        catch(Exception eeee){
                System.out.println("Exception");
            }
        
      });
      
      

      stage.setTitle("Window 1"); 
      stage.setScene(scene); 
      stage.show(); 
      
    }
   
}