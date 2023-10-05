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
import javafx.scene.*;

public class ComboBoxEventHandler implements EventHandler<ActionEvent>
{
    Car c;
	Label make;
	Label company;
	Label milage;
    Label color;
    Label transmission;
	HashMap<String,Car> map;
    ComboBox<String> box;

    public ComboBoxEventHandler(Label make,Label company, Label milage,Label color , Label transmission,HashMap<String,Car> map, ComboBox<String> box) 
    {
		this.make =make;
		this.company =company;
		this.milage= milage;
        this.color = color;
        this.transmission = transmission;
        this.box = box;
		this.map = map;
    }  
        public void handle(ActionEvent event) 
        {
             c = map.get(box.getValue());
             make.setText(c.make);
             company.setText("Company : " + c.company);
             milage.setText( "Milage  : " + "" + c.milage);
             color.setText("Color  : " + c.color );
        }
    
}
