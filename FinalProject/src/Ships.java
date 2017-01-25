/** 
 * This class creates ships and can access there data
 * @author Mckenna
 *
 */
public class Ships {
String name;
String points;
char hull;
char speed;
boolean officer;
boolean support; 
boolean weapons;
boolean offensive;
boolean defensive;
boolean defensive2;
boolean ordnance;
private String combine;
int p;
int numPoints;

/**
 * The constructor for the class 
 * @param n name of the ship
 * @param p string for how many points it is
 * @param num int to keep track of the points 
 * @param h the hull of the ship
 * @param s the speed of the ship
 * @param o checks if the ship can have officers
 * @param sup checks if the ship can have support bonuses
 * @param w checks if the ship can have weapon bonuses
 * @param off checks if the ship can have offensive bonuses
 * @param d	checks if the ship can have defensive bonuses
 * @param d2 checks if the ship can have two defensive bonuses
 * @param or checks if the ship can have ordinance bonuses
 */
public Ships(String n,String p, int num, char h, char s,boolean o,boolean sup,boolean w,boolean off, boolean d, boolean d2, boolean or){
	name =n;
	points = p;
	numPoints = num;
	hull = h;
	speed=s;
	officer = o;
	support = sup;
	weapons =w;
	offensive = off;
	defensive = d;
	defensive2 =d2;
	ordnance=or;
	
}
/**
 * Combines the details of the ship into one string and returns the string
 * @return returns the details of the ship
 */
public String getDetails(){
	combine = name +" Points: "+ points +" Hull: "+hull +" Speed: "+speed;
	return combine;
}
 
}
