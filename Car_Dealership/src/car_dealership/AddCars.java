package car_dealership;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.geometry.Insets;
import javafx.event.*;
import java.io.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class AddCars extends Application
{
    
    
	public void start(Stage stage) throws Exception
	{
		GridPane pane     = new GridPane();
		Button sellButton = new Button("Add to Inventory");
        Button btn1       = new Button ("HOME");
        Button btn2       = new Button ("EXIT");
        Button btn3     = new Button("Find Car");

        @SuppressWarnings("unchecked")
        
        
        File                file    = new File("C:\\Users\\Hardeep\\Desktop\\Find Cars\\Cars\\cars.bin");
        Text text = new Text();
		Font font = new Font("freehand", 34);
		
		text.setText("Enter your car information:");
		text.setFont(font);
		
		TextField           make          = new TextField();
		TextField           model         = new TextField();
		TextField           average       = new TextField();
		TextField           color         = new TextField();
		
        Label               makeLabel     = new Label("Make :");
        Label               ModelLabel    = new Label("Model:");
        Label               AverageLabel  = new Label("Average:");
        Label               ColorLabel    = new Label("Color:");
        Label               TLabel   	  = new Label("Transmission:");
		
		ComboBox 		transmission 		  = new ComboBox();
        transmission.getItems().addAll("Automatic","Mannual");
        transmission.getSelectionModel().selectFirst();

        pane.setPadding(new Insets(10,10,10,10)); 
        pane.setHgap(5);
        pane.setVgap(5);
		
		pane.add(text,0,0);
		pane.add(makeLabel, 0,1);
		pane.add(ModelLabel,0,2);
		pane.add(AverageLabel,0,3);
		pane.add(ColorLabel,0,4);
		pane.add(TLabel,0,5);
		pane.add(make,1,1);
		pane.add(model,1,2);
		pane.add(average,1,3);
		pane.add(color,1,4);
		pane.add(transmission,1,5);
		pane.add(sellButton,0,7);
		pane.add(btn1,0,15);
		pane.add(btn2,1,15);
        pane.add(btn3,1,16);
        
		Scene scene = new Scene(pane, 600, 500);
		
		stage.setScene(scene);
		stage.setTitle("ADD CAR");
		stage.show();
		
		sellButton.setOnAction(e ->
		{
            
           
            try
            {
            if(make.getText() == ""){
                System.out.println("Please Enter make name");
                
            }
            if(model.getText() == ""){
              System.out.println("Please Enter model name");
            }
             if(average.getText() == ""){
              System.out.println("Please Enter Average");
            }  
             if(color.getText() == ""){
              System.out.println("Please Enter Color");
            }  
            if((!(make.getText() == "") && ! (model.getText() == "" )&&
            !(average.getText() == "")&& ! (color.getText() ==""))){
            
            Car c  = new Car(make.getText(),model.getText(),Double.valueOf(average.getText()),color.getText(),(String)transmission.getValue());
            AddCars addCars = new AddCars();
            FindCars findCars = new FindCars();
            HashMap<String,Car> cc;
            try{
             cc  = findCars.readCars(file);
            }
            catch(EOFException ee) {
               cc = new HashMap<>(); 
            }
            addCars.writeCars(cc,file,c);
            System.out.println(findCars.readCars(file));
            System.out.println("Car added successfully");
            }
            }
            catch(NumberFormatException ee){
                System.out.println("Please enter average in number");
            }
            catch(Exception ee){
                
                System.out.println("Could not add car");
                System.out.println(ee);
                
            }
           
			
		});
        FindCars findCars = new FindCars();
        
        btn3.setOnAction(e -> 
       { 
        try{
        findCars.start(stage); }
        catch(Exception eeee){
                System.out.println("Exception");
            }
        
       });
        
        
        btn2.setOnAction( e ->{
            
            stage.close();
        });
		
	}
        /*stream.writeObject(cars);
        stream.close();
        stream1.close();*/
	
	public static void main(String[] args)
	{
		launch (args);
	}
    
    
    
    // Read Car from object File
   
    
    // Write Car to Object file
    public void writeCars(HashMap<String,Car> cc,File file,Car car) throws Exception{
        FileOutputStream    stream   = new FileOutputStream(file);
        ObjectOutputStream  stream1  = new ObjectOutputStream(stream);
        cc.put(car.make,car);
        stream1.writeObject(cc);
        stream1.close();
        stream.close();
    }
    
    
        
}