/**
 * Creates a support bonus and extends the class Bonus
 * @author Mckenna
 * @see Bonus
 */
public class Support extends Bonus{
/**
 * The constructor for the class
 * @param n the name of the bonus
 * @param p the string point value of the bonus
 * @param num the int point value
 */
	public Support(String n, String p, int num) {
		super(n, p, num);
		name = n;
		points = p;
		numPoints = num;
	}

}
