/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package software_group_project;

/**
 *
 * @author Kanwarraj Singh Batth
 * @author Sonam Kaur Matharu
 * @author Simranveer Kaur
 * @author Daljit Kaur
 */
public class Software_Group_project {

    public static void main(String[] args) {
         handgenerator ch = new handgenerator();
                ch.generateHand();
                for(cards c: ch.cards)
                {
                    System.out.println(c.getRank() + " of " + c.getColor());
                }
         
    }

}
