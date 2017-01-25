/**
 * Creates an officer bonus extends the Bonus class
 * @author Mckenna
 * @see Bonus
 */
public class Officer extends Bonus {
/**
 * THe constructor for the class
 * @param n the name of the officer bonus
 * @param p the string value of the bonus
 * @param num the int value of the bonus
 */
	public Officer(String n, String p, int num) {
		super(n, p,num);
		name = n;
		points =p;
		numPoints =num;
	}

}	
