/**
 * This class is the parent class for all the different bonuses 
 * @author Mckenna
 *
 */
public class Bonus {
String name;
String points;
String combine;
int numPoints;
/**
 * The constructor for the class
 * @param n the name of the bonus
 * @param p the string value of the points
 * @param num the int value of the points
 */
public Bonus (String n, String p,int num){
	name = n;
	points = p;
	numPoints = num;
}
/**
 * combines all the details of the bonus into one string and returns the string
 * @return the details of the bonus
 */
public String getDetails(){
	combine = name + " Points: "+points;
	return combine;
}
}
