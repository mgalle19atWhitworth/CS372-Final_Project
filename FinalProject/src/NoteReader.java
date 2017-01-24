import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoteReader  extends JFrame {
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
	static ArrayList<Officer> Officers = new ArrayList<Officer>();
	static ArrayList<Support> supports = new ArrayList<Support>();
	static ArrayList<Weapons> weapon = new ArrayList<Weapons>();
	static ArrayList<Offensive> off = new ArrayList<Offensive>();
	static ArrayList<Defensive> def= new ArrayList<Defensive>();
	static ArrayList<Defensive> def2 = new ArrayList<Defensive>();
	static ArrayList<Ordnance> or = new ArrayList<Ordnance>();
	static JList<String>OfficerList = new JList<String>();
	static JList<String> OrdnanceList = new JList<String>();
	static JList<String> SupportList=new JList<String>();
	static JList<String> WeaponsList= new JList<String>();
	static JList<String> OffensiveList=new JList<String>();
	static JList<String> DefensiveList= new JList<String>();
	static JList<String> DefensiveList2=new JList<String>();
	
public static void main(String[] args){
DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
DefaultListModel<String> model2 = new DefaultListModel<String>();
DefaultListModel<String> model3 = new DefaultListModel<String>();
DefaultListModel<String>model4 = new DefaultListModel<String>();
DefaultListModel<String>model5 = new DefaultListModel<String>();
DefaultListModel<String>model6 = new DefaultListModel<String>();
DefaultListModel<String>model7 = new DefaultListModel<String>();
DefaultListModel<String>model8 = new DefaultListModel<String>();


JFrame frame = new JFrame("Hello");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
                       if(line.contains("Ship")){
                           
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
                       }
                       else if(line.contains("Officer")){
                    	   int s = line.indexOf('"');
                      		int e = line.indexOf('"', s+1);
                      		if (s >= 0 && e >= 0)
                      		name = line.substring(s+1, e);                     		
                      		points = line.substring(34, 36);
                      			
                       }
                       else if (line.contains("Support")){                   	 
                    	   int s = line.indexOf('"');
                      		int e = line.indexOf('"', s+1);
                      		if (s >= 0 && e >= 0)
                      		name = line.substring(s+1, e);                     		
                      		points = line.substring(36, 37);
                      		
                 		}
                       else if (line.contains("Weapons")){ 
                    	   int s = line.indexOf('"');
                      		int e = line.indexOf('"', s+1);
                      		if (s >= 0 && e >= 0)
                      		name = line.substring(s+1, e);                     		
                      		points = line.substring(30, 31);
                      		
                 		}
                       else if (line.contains("Offensive")){ 
                    	   int s = line.indexOf('"');
                      		int e = line.indexOf('"', s+1);
                      		if (s >= 0 && e >= 0)
                      		name = line.substring(s+1, e);                     		
                      		points = line.substring(36, 37);
                      		
                 		}
                       else if (line.contains("Defensive")){ 
                    	   int s = line.indexOf('"');
                      		int e = line.indexOf('"', s+1);
                      		if (s >= 0 && e >= 0)
                      		name = line.substring(s+1, e);                     		
                      		points = line.substring(39, 40);
                      		
                 		}
                       else if(line.contains("Ordnance")){
                    	   int s = line.indexOf('"');
                     		int e = line.indexOf('"', s+1);
                     		if (s >= 0 && e >= 0)
                     		name = line.substring(s+1, e);                     		
                     		points = line.substring(39, 41);
                       }
                    if(line.contains("Ship")){
                    Ships S= new  Ships( name, points, hull, speed, officer, support,weapons,offensive, defensive,defensive2, ordnance);
                    ship.add(S);
                    }
                    else if (line.contains("Officer")){
                    	Officer o = new Officer(name,points);
                    	Officers.add(o);
                    }
                    else if(line.contains("Support")){
                    	Support s = new Support(name,points);
                    	supports.add(s);
                    }
                    else if(line.contains("Weapons")){
                    	Weapons w = new Weapons(name,points);
                    	weapon.add(w);
                    }
                    else if(line.contains("Offensive")){
                    	Offensive o = new Offensive(name,points);
                    	off.add(o);
                    }
                    else if(line.contains("Defensive")){
                    	Defensive d = new Defensive(name,points);
                    	def.add(d);
                    	def2.add(d);
                    }
                    else if(line.contains("Ordnance")){
                    	Ordnance o = new Ordnance(name,points);
                    	or.add(o);
                    }
                    line = rdr.readLine();
                }
            }

            catch (Exception ex) { System.out.printf("Failed: %s\n", ex.getMessage());}
}
}
    for(Ships s: ship){
    	model.addElement(s.name);
  
    }
    for(Officer officer: Officers){
    	model2.addElement(officer.name);
    }
    for(Support s: supports){
    	model3.addElement(s.name);
    }
    for(Weapons w: weapon){
    	model4.addElement(w.name);
    }
    for(Offensive o: off){
    	model5.addElement(o.name);
    }
    for(Defensive d : def){
    	model6.addElement(d.name);
    }
    for (Defensive d: def2){
    	model7.addElement(d.name);
    }
    for (Ordnance o: or){
    	model8.addElement(o.name);
    }
    JComboBox comboBox = new JComboBox(model);
    JList<String> ShipList = new JList<String>(comboBox.getModel());
    
   
    
    JButton button = new JButton("Info");
    JButton b = new JButton("Select");
    b.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		String selection =  (String) comboBox.getSelectedItem();
    		for (int i = 0; i < ship.size();i++){
    			if (selection == ship.get(i).name){
    				if(ship.get(i).officer == true){
    					OfficerList = new JList<String>(model2);
    					frame.add(OfficerList);
    					System.out.println("officer");
    				}
    				if (ship.get(i).support == true){
    					SupportList=new JList<String>(model3);
    					System.out.println("support");
    				}
    				if (ship.get(i).weapons == true){
    					WeaponsList= new JList<String>(model4);
    					System.out.println("weapons");
    				}
    				if (ship.get(i).offensive == true){
    					OffensiveList=new JList<String>(model5);
    					System.out.println("offensive");
    				}
    				if(ship.get(i).defensive == true){
    					DefensiveList= new JList<String>(model6);
    					System.out.println("defensive");
    				}
    				if (ship.get(i).defensive2 == true)
    				{
    					DefensiveList2=new JList<String>(model7);
    					System.out.println("d2");
    				}
    				if(ship.get(i).ordnance ==true){
    					OrdnanceList = new JList<String>(model8);
    					System.out.println("ordnance");
    				}	
    			}
    		}
    	}
    	
    });
    button.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		String selection =  (String) comboBox.getSelectedItem();
    		for(int i = 0; i< ship.size(); i++){
    			if(selection == ship.get(i).name){
    				System.out.printf("%s,Points: %s, Hull: %c, Speed: %s\n", ship.get(i).name,ship.get(i).points,ship.get(i).hull,ship.get(i).speed);
    }
    		}
    	}
    });
    
    JPanel comboPanel = new JPanel();
    comboPanel.add(comboBox);
    frame.add(comboPanel);
    frame.add(button);
    frame.add(b);
    
    frame.add(OfficerList);
    frame.add(SupportList);
    frame.add(WeaponsList);
    frame.add(OffensiveList);
    frame.add(DefensiveList);
    frame.add(DefensiveList2);
    frame.add(OrdnanceList);
    frame.setLayout(new FlowLayout());
    frame.setSize(800,800);
    frame.setVisible(true);
}
}