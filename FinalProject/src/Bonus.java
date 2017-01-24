
public class Bonus {
String name;
String points;
String combine;
int numPoints;
public Bonus (String n, String p,int num){
	name = n;
	points = p;
	numPoints = num;
}
public String getDetails(){
	combine = name + " Points: "+points;
	return combine;
}
}
