/**
 * Creates a Weapon bonus and extends the class Bonus
 * @author Mckenna
 * @see Bonus
 */
public class Weapons extends Bonus {
/**
 * The constructor for the weapons class
 * @param n the name of the weapon bonus
 * @param p the string point value of the weapons bonus
 * @param num the int point value of the weapons bonus
 */
	public Weapons(String n, String p, int num) {
		super(n, p, num);
		name = n;
		points =p;
		numPoints = num;
	}
	
}
