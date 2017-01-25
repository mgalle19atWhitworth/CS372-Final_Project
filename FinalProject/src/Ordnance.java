/**
 * Creates an ordinance bonus and extends the Bonus class
 * @author Mckenna
 * @see Bonus
 */
public class Ordnance extends Bonus {
/**
 * The constructor for the class
 * @param n the name of the ordinance bonus 
 * @param p the string value of the points
 * @param num the int value of the points
 */
	public Ordnance(String n, String p, int num) {
		super(n, p, num);
		name =n;
		points =p;
		numPoints = num;
}

}
