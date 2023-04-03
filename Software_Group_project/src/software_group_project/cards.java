/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package software_group_project;

/**
 *
 * @author Kanwarraj Singh Batth
 * @author Sonam Kaur Matharu
 * @author Simranveer Kaur
 * @author Daljit Kaur
 * 
 */
public class cards {
        public enum Color{RED, YELLOW, GREEN, BLUE};
        public enum Rank{ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, SKIP, REVERSE, DRAW_TWO, WILDCARD, DRAW_FOUR};
        private final Color color;
        private final Rank rank;
        
        public cards(Color s, Rank gVal)
        {
           color =s;
           rank= gVal;
        }
	public Rank getRank() {
		return this.rank;
	}

	
	public Color getColor() {
		return this.color;
        }
}
