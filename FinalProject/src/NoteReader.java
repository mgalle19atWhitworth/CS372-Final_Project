import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NoteReader  {
	public static String name;
	public static String points;
	public static char hull;
	public static char speed;
	public static boolean officer;
	public static boolean support;
	public static boolean weapons;
	public static boolean offensive;
	public static boolean defensive;
	public static boolean defensive2;
	public static boolean ordnance;
	static ArrayList<Ships> ship= new ArrayList<Ships>();
	
public static void main(String[] args){


	String curdir = System.getProperty("user.dir") + "\\src";
	System.out.println(curdir);
    File cd = new File(curdir);
    File[] files = cd.listFiles();
    for (File f: files) {
        if (f.getName().equals("Armada.csv")) {
            try (FileInputStream is = new FileInputStream(f)) {
                InputStreamReader ir = new InputStreamReader(is);
                BufferedReader rdr = new BufferedReader(ir);
                String line = rdr.readLine();
                while (line != null) {
                    String[] parts = line.split(",");
                    for (String p: parts) {                    
                       if(line.contains("Ship")){
                            System.out.printf("%s\t", p); 
                       int s = line.indexOf('"');
                   		int e = line.indexOf('"', s+1);
                   		if (s >= 0 && e >= 0){
                   		name = line.substring(s+1, e);
                   		}
                   		
                   		points = line.substring(43, 46);
                   		hull=line.charAt(53);
                   		speed=line.charAt(55);
                   		char check=line.charAt(59);                   		
                   		if(check=='E')
                   			officer=true;
                   		check=line.charAt(61);
                   		if(check =='E')
                   			support=true;
                   		else if (check =='-')
                   			support =false;
                   		check =line.charAt(63);
                   		if(check=='E')
                   			weapons=true;
                   		else if (check =='-')
                   			weapons =false;
                   		check =line.charAt(65);
                   		if(check=='E')
                   			offensive=true;
                   		else if (check =='-')
                   			offensive =false;
                   		check =line.charAt(67);
                   		if(check=='E')
                   			defensive=true;
                   		else if (check =='-')
                   			defensive =false;
                   		check =line.charAt(69);
                   		if(check=='E')
                   			defensive2=true;
                   		else if (check =='-')
                   			defensive2 =false;
                   		check =line.charAt(69);
                   		if(check=='E')
                   			ordnance=true;
                   		else if (check =='-')
                   			ordnance =false;
                   		Ships S= new  Ships( name, points, hull, speed, officer, support,weapons,offensive, defensive,defensive2, ordnance);
                        ship.add(S);
               
                       }
                       
                      
                    }
                    
                    System.out.println();
                    line = rdr.readLine();
                }
                for(int i =0;i<ship.size();i++){
					System.out.printf("%s.%s, %c, %c,%b,%b,%b,%b,%b,%b,%b\n",ship.get(i).name,ship.get(i).points,ship.get(i).hull,ship.get(i).speed,ship.get(i).officer,ship.get(i).support,ship.get(i).weapons,ship.get(i).offensive,ship.get(i).defensive,ship.get(i).defensive2,ship.get(i).ordnance);
					
				}

            }

            catch (Exception ex) { System.out.printf("Failed: %s\n", ex.getMessage());}

}
}
}
}