
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
public String getDetails(){
	combine = name +" Points: "+ points +" Hull: "+hull +" Speed: "+speed;
	return combine;
}
 
}
