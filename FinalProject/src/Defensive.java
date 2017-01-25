/**
 * Creates a Defensive bonus and extends Bonus
 * @author Mckenna
 * @see Bonus
 */
public class Defensive extends Bonus {

	/**
	 * The constructor for this class 
	 * @param n the name of the defensive bonus
	 * @param p	the string point value
	 * @param num the int point value
	 */
	public Defensive(String n, String p, int num) {
		super(n, p,num);
		name = n;
		points = p;
		numPoints = num;
		}

}
