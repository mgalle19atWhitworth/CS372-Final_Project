/**
 * Creates a Offensive bonus and extends the bonus clas
 * @author Mckenna
 *	@see Bonus
 */
public class Offensive extends Bonus {

	/**
	 * THe constructor for this class
	 * @param n The name of the Offensive bonus
	 * @param p The string point value for the offensive bonus
	 * @param num the int point value
	 */
	public Offensive(String n, String p, int num) {
		super(n, p, num);
		name = n;
		points = p;
		numPoints = num;
	}

}
