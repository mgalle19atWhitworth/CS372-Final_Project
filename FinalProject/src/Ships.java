
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

public Ships(String n,String p, char h, char s,boolean o,boolean sup,boolean w,boolean off, boolean d, boolean d2, boolean or){
	name =n;
	points = p;
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
}
