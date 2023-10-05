package car_dealership;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import java.util.HashMap;
import javafx.event.*;
import java.io.*;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Font; 
import javafx.scene.text.Text; 
import javafx.scene.paint.Color; 


public class FindCars extends Application
{
    public void start (Stage PrimaryStage) throws Exception
    {
        
        File file   = new File("C:\\Users\\Hardeep\\Desktop\\Java final project\\Cars\\cars.bin");
        GridPane pane              = new GridPane();
        ComboBox<String> box       = new ComboBox<>();
        HashMap<String,Car> map    = new HashMap<>();
        
         
       /* Text text2 = new Text("Welcome to our car inventory system !");
        text2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        text2.setFill(Color.BROWN); */
        
        Label make         = new Label();
        Label company      = new Label();
        Label milage       = new Label();
        Label color        = new Label();
        Label transmission = new Label();
        FindCars findCar   = new FindCars();
        map = findCar.readCars(file);
        
        
        box.getItems().addAll(map.keySet()); 
        ComboBoxEventHandler handler = new ComboBoxEventHandler(make,company,milage,color,transmission,map,box);
        box.setOnAction(handler);
        
        pane.add(box     ,0,0);
        pane.add(make    ,1,0);
        pane.add(company ,1,1);
        pane.add(milage  ,1,2);
        pane.add(color   ,1,3);
        pane.add(transmission,1,4);

        
        
        Scene scene = new Scene(pane,500,400);
        PrimaryStage.setScene(scene);
        PrimaryStage.setTitle("Find Cars");
        PrimaryStage.show();
        
       
    }
    
     public HashMap<String,Car> readCars(File file) throws Exception{
        
        FileInputStream    stream   = new FileInputStream(file);
        ObjectInputStream  stream1  = new ObjectInputStream(stream);
        @SuppressWarnings("unchecked")
        HashMap<String,Car> cars = (HashMap<String,Car>)  stream1.readObject();

        stream1.close();
        stream.close();
        return cars;
    }
}
