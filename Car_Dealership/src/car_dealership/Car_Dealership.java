package car_dealership;

import java.io.Serializable;

public class Car_Dealership implements Serializable
{
    public String make;
	public String company;
	public double milage;
    public String color;
    public String transmission;
    
    public Car(String make , String company , double milage,String color,String transmission) 
    {
		
		this.make = make;
		this.company = company;
		this.milage = milage;
        this.color = color;
        this.transmission = transmission;
        
    }
}