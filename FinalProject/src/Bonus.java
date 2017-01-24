
public class Bonus {
String name;
String points;
String combine;
public Bonus (String n, String p){
	name = n;
	points = p;
}
public String getDetails(){
	combine = name + " Points: "+points;
	return combine;
}
}
