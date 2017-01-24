import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
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
	public static String combine;
	public static String combine2;
	public static String combine3;
	public static String combine4;
	public static String combine5;
	public static String combine6;
	public static String combine7;
	public static String combineAll;
	
	static String s[] ={"Officer"};
	static ArrayList<Ships> ship= new ArrayList<Ships>();
	static ArrayList<Officer> Officers = new ArrayList<Officer>();
	static ArrayList<Support> supports = new ArrayList<Support>();
	static ArrayList<Weapons> weapon = new ArrayList<Weapons>();
	static ArrayList<Offensive> off = new ArrayList<Offensive>();
	static ArrayList<Defensive> def= new ArrayList<Defensive>();
	static ArrayList<Defensive> def2 = new ArrayList<Defensive>();
	static ArrayList<Ordnance> or = new ArrayList<Ordnance>();
	static ArrayList<String> selected = new ArrayList<String>();
	
	
public static void main(String[] args){
DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<String>();
DefaultComboBoxModel<String> model3 = new DefaultComboBoxModel<String>();
DefaultComboBoxModel<String>model4 = new DefaultComboBoxModel<String>();
DefaultComboBoxModel<String>model5 = new DefaultComboBoxModel<String>();
DefaultComboBoxModel<String>model6 = new DefaultComboBoxModel<String>();
DefaultComboBoxModel<String>model7 = new DefaultComboBoxModel<String>();
DefaultComboBoxModel<String>model8 = new DefaultComboBoxModel<String>();


JFrame frame = new JFrame("FinalProject");
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
    JComboBox combo = new JComboBox(model2);
    JComboBox support = new JComboBox(model3);
    JComboBox weapons = new JComboBox(model4);
    JComboBox offensive = new JComboBox(model5);
    JComboBox defn = new JComboBox(model6);
    JComboBox defn2 = new JComboBox(model7);
    JComboBox ordnance = new JComboBox(model8);
   // JList<String>OfficerList = new JList<String>(combo.getModel());
   // JList<String> ShipList = new JList<String>(comboBox.getModel());
   // JList<String> OrdnanceList = new JList<String>(comboBox.getModel());
   // JList<String> SupportList=new JList<String>(comboBox.getModel());
//	JList<String> WeaponsList= new JList<String>(comboBox.getModel());
	//JList<String> OffensiveList=new JList<String>(comboBox.getModel());
	//JList<String> DefensiveList= new JList<String>(comboBox.getModel());
	//JList<String> DefensiveList2=new JList<String>(comboBox.getModel());
   
	JPanel comboPanel = new JPanel();
    JPanel comboPanel2 = new JPanel();
    comboPanel.add(comboBox);
       
    JButton button = new JButton("Info");
    JButton b = new JButton("Select");
    JButton b2 = new JButton("Clear");
    JButton b3 = new JButton("Add");
    JLabel l = new JLabel("Ships");
    b.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		String selection =  (String) comboBox.getSelectedItem();
    		for (int i = 0; i < ship.size();i++){
    			if (selection == ship.get(i).name){
    				if(ship.get(i).officer == true){
    					comboPanel2.add(combo);
    				}
    				if (ship.get(i).support == true){
    					comboPanel2.add(support);    					
    				}
    				if (ship.get(i).weapons == true){
    					comboPanel2.add(weapons);
    				}
    				if (ship.get(i).offensive == true){
    					comboPanel2.add(offensive);    					
    				}
    				if(ship.get(i).defensive == true){
    					comboPanel2.add(defn);
    				}
    				if (ship.get(i).defensive2 == true)
    				{
    					comboPanel2.add(defn2);    					
    				}
    				if(ship.get(i).ordnance ==true){
    					comboPanel2.add(ordnance);
    				}	
    				frame.add(comboPanel2);
    				frame.setVisible(true);
    			}
    		}
    	}
    	
    });
    b2.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		String selection =  (String) comboBox.getSelectedItem();
    		for (int i = 0; i < ship.size();i++){
    			if (selection == ship.get(i).name){
    				if(ship.get(i).officer == true){
    					comboPanel2.remove(combo);	
    				}
    				if (ship.get(i).support == true){
    					comboPanel2.remove(support);
    					
    				}
    				if (ship.get(i).weapons == true){
    					comboPanel2.remove(weapons);
    				}
    				if (ship.get(i).offensive == true){
    					comboPanel2.remove(offensive);
    					
    				}
    				if(ship.get(i).defensive == true){
    					 comboPanel2.remove(defn);
    				}
    				if (ship.get(i).defensive2 == true){
    					 comboPanel2.remove(defn2);
    				}
    				if(ship.get(i).ordnance ==true){
    					comboPanel2.remove(ordnance);
    				}
    				frame.add(comboPanel2);
    				frame.setVisible(true);
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
    b3.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		String selection =  (String) comboBox.getSelectedItem();
    		for(int i = 0; i< ship.size(); i++){
    			combine = " ";
    			if(selection == ship.get(i).name){
    				combine = ship.get(i).getDetails();
    			}
    			if(ship.get(i).officer == true){
    				selection =(String) combo.getSelectedItem();
    				for ( int i2 = 0; i2 < Officers.size();i2++)
    					if (selection == Officers.get(i2).name){
    						combine = combine+ " Officer: "+Officers.get(i2).name;
    					}
    				
    			}
    			
    				if (ship.get(i).support == true){
    					selection =(String) support.getSelectedItem();
        				for ( int i3 = 0; i3 <supports.size();i3++){
        					if (selection == supports.get(i3).name){
        						combine =combine +" Supports: "+supports.get(i3).name;
        					}
        				}
    					
    				}

    				if (ship.get(i).weapons == true){
    					selection =(String) weapons.getSelectedItem();
        				for ( int i2 = 0; i2 < weapon.size();i2++){
        					if (selection == weapon.get(i2).name){
        						combine =combine + " Weapon: "+weapon.get(i2).name;
        					}
        				}
    				}
    				if (ship.get(i).offensive == true){
    					selection =(String) offensive.getSelectedItem();
        				for ( int i2 = 0; i2 < off.size();i2++){
        					if (selection == off.get(i2).name){
        						combine =combine +" Offensive: "+off.get(i2).name;
        					}
        				}
    					
    				}
    				if(ship.get(i).defensive == true){
    					selection =(String) defn.getSelectedItem();
        				for ( int i2 = 0; i2 < def.size();i2++){
        					if (selection == Officers.get(i2).name){
        						combine =combine + " Defensive: "+def.get(i).name;
        					}
        				}
    				}
    				if (ship.get(i).defensive2 == true){
    					selection =(String) defn2.getSelectedItem();
        				for ( int i2 = 0; i2 < def2.size();i2++){
        					if (selection == def2.get(i2).name){
        						combine =combine +" Defensive2: "+def2.get(i2).name;
        					}
        				}
    				}
    				if(ship.get(i).ordnance ==true){
    					selection =(String) ordnance.getSelectedItem();
        				for ( int i2 = 0; i2 < or.size();i2++){
        					if (selection == or.get(i2).name){
        						combine =combine+ " Ordnance: "+or.get(i2).name;
        					}
        				}
    				}
    				
    				selected.add(combine);	
    				System.out.println(combine);
    }	
    	}	
    	
    });
   
    
    frame.add(comboPanel);
    frame.add(button);
    frame.add(b);
    frame.add(b2);
    frame.add(b3);
    frame.add(l);
    frame.setLayout(new FlowLayout());
    frame.setSize(800,800);
    frame.setVisible(true);
}
}