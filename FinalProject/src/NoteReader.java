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
	public static String combine8;
	public static String combineAll;
	public static int x =0;
	public static int p;
	public static int totalPoints = 400;
	public static String stringPoints;
	
	
	static ArrayList<Ships> ship= new ArrayList<Ships>();
	static ArrayList<Officer> OfficersArray = new ArrayList<Officer>();
	static ArrayList<Support> supportsArray = new ArrayList<Support>();
	static ArrayList<Weapons> weaponArray = new ArrayList<Weapons>();
	static ArrayList<Offensive> offArray = new ArrayList<Offensive>();
	static ArrayList<Defensive> defArray= new ArrayList<Defensive>();
	static ArrayList<Defensive> def2Array = new ArrayList<Defensive>();
	static ArrayList<Ordnance> orArray = new ArrayList<Ordnance>();
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
DefaultListModel<String>model9= new DefaultListModel<String>();


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
                   		p = Integer.parseInt(line.substring(43, 45));
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
                      		p = Integer.parseInt(line.substring(34,35));
                      			
                       }
                       else if (line.contains("Support")){                   	 
                    	   int s = line.indexOf('"');
                      		int e = line.indexOf('"', s+1);
                      		if (s >= 0 && e >= 0)
                      		name = line.substring(s+1, e);                     		
                      		points = line.substring(37, 38);
                      		p = Integer.parseInt(line.substring(37,38));
                 		}
                       else if (line.contains("Weapons")){ 
                    	   int s = line.indexOf('"');
                      		int e = line.indexOf('"', s+1);
                      		if (s >= 0 && e >= 0)
                      		name = line.substring(s+1, e);                     		
                      		points = line.substring(30, 31);
                      		p = Integer.parseInt(line.substring(30,31));
                 		}
                       else if (line.contains("Offensive")){ 
                    	   int s = line.indexOf('"');
                      		int e = line.indexOf('"', s+1);
                      		if (s >= 0 && e >= 0)
                      		name = line.substring(s+1, e);                     		
                      		points = line.substring(36, 37);
                      		p = Integer.parseInt(line.substring(36,37));
                 		}
                       else if (line.contains("Defensive")){ 
                    	   int s = line.indexOf('"');
                      		int e = line.indexOf('"', s+1);
                      		if (s >= 0 && e >= 0)
                      		name = line.substring(s+1, e);                     		
                      		points = line.substring(39, 40);
                      		p = Integer.parseInt(line.substring(39,40));
                 		}
                       else if(line.contains("Ordnance")){
                    	   int s = line.indexOf('"');
                     		int e = line.indexOf('"', s+1);
                     		if (s >= 0 && e >= 0)
                     		name = line.substring(s+1, e);                     		
                     		points = line.substring(39, 41);
                     		p = Integer.parseInt(line.substring(39,40));
                       }
                    if(line.contains("Ship")){
                    Ships S= new  Ships( name, points,p, hull, speed, officer, support,weapons,offensive, defensive,defensive2, ordnance);
                    ship.add(S);
                    }
                    else if (line.contains("Officer")){
                    	Officer o = new Officer(name,points,p);
                    	OfficersArray.add(o);
                    }
                    else if(line.contains("Support")){
                    	Support s = new Support(name,points,p);
                    	supportsArray.add(s);
                    }
                    else if(line.contains("Weapons")){
                    	Weapons w = new Weapons(name,points,p);
                    	weaponArray.add(w);
                    }
                    else if(line.contains("Offensive")){
                    	Offensive o = new Offensive(name,points,p);
                    	offArray.add(o);
                    }
                    else if(line.contains("Defensive")){
                    	Defensive d = new Defensive(name,points,p);
                    	defArray.add(d);
                    	def2Array.add(d);
                    }
                    else if(line.contains("Ordnance")){
                    	Ordnance o = new Ordnance(name,points,p);
                    	orArray.add(o);
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
    for(Officer officer: OfficersArray){
    	model2.addElement(officer.name);
    }
    for(Support s: supportsArray){
    	model3.addElement(s.name);
    }
    for(Weapons w: weaponArray){
    	model4.addElement(w.name);
    }
    for(Offensive o: offArray){
    	model5.addElement(o.name);
    }
    for(Defensive d : defArray){
    	model6.addElement(d.name);
    }
    for (Defensive d: def2Array){
    	model7.addElement(d.name);
    }
    for (Ordnance o: orArray){
    	model8.addElement(o.name);
    }
    JComboBox shipBox = new JComboBox(model);
    JComboBox officerBox = new JComboBox(model2);
    JComboBox supportBox = new JComboBox(model3);
    JComboBox weaponsBox = new JComboBox(model4);
    JComboBox offensiveBox = new JComboBox(model5);
    JComboBox defBox = new JComboBox(model6);
    JComboBox def2Box = new JComboBox(model7);
    JComboBox ordnanceBox = new JComboBox(model8);
   
	JPanel comboPanel = new JPanel();
    JPanel comboPanel2 = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel buttonPanel2 = new JPanel();
    comboPanel.add(shipBox);

    
    JButton button = new JButton("Ship Info");
    JButton button2 = new JButton("Officer Info");
    JButton button3 = new JButton("Support Info");
    JButton button4 = new JButton("Weapons Info");
    JButton button5 = new JButton("Offensive Info");
    JButton button6 = new JButton("Defensive Info");
    JButton button7 = new JButton("Ordinance Info");
    JButton b = new JButton("Select");
    JButton b2 = new JButton("Clear");
    JButton b3 = new JButton("Add");
    JButton b4 = new JButton("Update List");
    JLabel l = new JLabel("Ships");
    stringPoints = "Points: "+String.valueOf(totalPoints);
    JLabel l2 = new JLabel(stringPoints);
    Box buttonBox =Box.createHorizontalBox();
    Box buttonBox2 =Box.createHorizontalBox();
    
  
    
    b.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		String selection =  (String) shipBox.getSelectedItem();
    		for (int i = 0; i < ship.size();i++){
    			if (selection == ship.get(i).name){
    				if(ship.get(i).officer == true){
    					comboPanel2.add(officerBox);
    				}
    				if (ship.get(i).support == true){
    					comboPanel2.add(supportBox);    					
    				}
    				if (ship.get(i).weapons == true){
    					comboPanel2.add(weaponsBox);
    				}
    				if (ship.get(i).offensive == true){
    					comboPanel2.add(offensiveBox);    					
    				}
    				if(ship.get(i).defensive == true){
    					comboPanel2.add(defBox);
    				}
    				if (ship.get(i).defensive2 == true)
    				{
    					comboPanel2.add(def2Box);    					
    				}
    				if(ship.get(i).ordnance ==true){
    					comboPanel2.add(ordnanceBox);
    				}	
    				comboPanel2.setBounds(0, 250, 1000, 100);
    				frame.add(comboPanel2);
    				frame.setVisible(true);
    			}
    		}
    	}
    	
    });
    b2.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		String selection =  (String) shipBox.getSelectedItem();
    		for (int i = 0; i < ship.size();i++){
    			if (selection == ship.get(i).name){
    				if(ship.get(i).officer == true){
    					comboPanel2.remove(officerBox);	
    				}
    				if (ship.get(i).support == true){
    					comboPanel2.remove(supportBox);
    					
    				}
    				if (ship.get(i).weapons == true){
    					comboPanel2.remove(weaponsBox);
    				}
    				if (ship.get(i).offensive == true){
    					comboPanel2.remove(offensiveBox);
    					
    				}
    				if(ship.get(i).defensive == true){
    					 comboPanel2.remove(defBox);
    				}
    				if (ship.get(i).defensive2 == true){
    					 comboPanel2.remove(def2Box);
    				}
    				if(ship.get(i).ordnance ==true){
    					comboPanel2.remove(ordnanceBox);
    				}
    				l.setText("ship");
    				comboPanel2.setBounds(0, 0, 0, 0);
    				frame.add(comboPanel2);
    				frame.setVisible(true);
    			}
    		}
    	}
    	
    });
    button.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		String selection;    		
    		 selection =  (String) shipBox.getSelectedItem();
    		for(int i = 0; i< ship.size(); i++){
    			if(selection == ship.get(i).name)
    				l.setText(ship.get(i).getDetails());

    		}
    	}
    });
    button3.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		
				String selection =(String) supportBox.getSelectedItem();				
				for ( int i = 0; i < supportsArray.size();i++){
					if (selection == supportsArray.get(i).name)
						l.setText(supportsArray.get(i).getDetails());
				}
    	}
    });
    button2.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		String selection =(String) officerBox.getSelectedItem();				
			for ( int i = 0; i < OfficersArray.size();i++){
				if (selection == OfficersArray.get(i).name)
					l.setText(OfficersArray.get(i).getDetails());
			}
    		
    	}
    });
    button4.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
			String selection =(String) weaponsBox.getSelectedItem();				
			for ( int i = 0; i < weaponArray.size();i++){
				if (selection == weaponArray.get(i).name)
					l.setText(weaponArray.get(i).getDetails());
			}
    	}
    });
    button5.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
		String selection =(String) offensiveBox.getSelectedItem();				
			for ( int i = 0; i < offArray.size();i++){
				if (selection == offArray.get(i).name)
					l.setText(offArray.get(i).getDetails());
			}
    	}
    });
    button6.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
			String selection =(String) defBox.getSelectedItem();				
			for ( int i = 0; i < defArray.size();i++){
				if (selection == defArray.get(i).name)
					l.setText(defArray.get(i).getDetails());
			}
    	}
    });
    button7.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		String selection =(String) ordnanceBox.getSelectedItem();				
			for ( int i = 0; i < orArray.size();i++){
				if (selection == orArray.get(i).name)
					l.setText(orArray.get(i).getDetails());
			}
    	}
    });
    b3.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		String selection =  (String) shipBox.getSelectedItem();
    		for(int i = 0; i< ship.size(); i++){
    				combineAll = "";
    			if(selection == ship.get(i).name){
    				combine = ship.get(i).getDetails();
    				combineAll = combine;
    				if(totalPoints <= 0 || totalPoints - ship.get(i).numPoints <= 0)
						System.out.printf("Not enough points for %s\n",ship.get(i).name);
					else
    				totalPoints = totalPoints -ship.get(i).numPoints;
    			
    			if(ship.get(i).officer == true){
    				String selection2 =(String) officerBox.getSelectedItem();
    				for ( int i2 = 0; i2 < OfficersArray.size();i2++){
    					if (selection2 == OfficersArray.get(i2).name){
    						combine2 = " Officer: "+OfficersArray.get(i2).name;
    						combineAll = combineAll +combine2;
    						if(totalPoints <= 0 || totalPoints - OfficersArray.get(i2).numPoints <= 0)
    							System.out.printf("Not enough points for %s\n",OfficersArray.get(i2).name);
    						else
    						totalPoints = totalPoints -OfficersArray.get(i2).numPoints;
    					}
    				}
    			}
    			
    				if (ship.get(i).support == true){
    				String selection3 =(String) supportBox.getSelectedItem();
        				for ( int i3 = 0; i3 <supportsArray.size();i3++){
        					if (selection3 == supportsArray.get(i3).name){
        						combine3 =" Supports: "+supportsArray.get(i3).name;
        						combineAll = combineAll +combine3;
        						if(totalPoints <= 0 || totalPoints - supportsArray.get(i3).numPoints <= 0)
        							System.out.printf("Not enough points for %s\n",supportsArray.get(i3).name);
        						else
        						totalPoints = totalPoints -supportsArray.get(i3).numPoints;
        					}
        				}
    					
    				}
    				
    				if (ship.get(i).weapons == true){
    				String	selection4 =(String) weaponsBox.getSelectedItem();
        				for ( int i4 = 0; i4 < weaponArray.size();i4++){
        					if (selection4 == weaponArray.get(i4).name){
        						combine4 = " Weapon: "+weaponArray.get(i4).name;
        						combineAll= combineAll +combine4;
        						if(totalPoints <= 0 || totalPoints - weaponArray.get(i4).numPoints <= 0)
        							System.out.printf("Not enough points for %s\n",weaponArray.get(i4).name);
        						else
        						totalPoints = totalPoints -weaponArray.get(i4).numPoints;
        					}
        				}
    				}
    				if (ship.get(i).offensive == true){
    					String selection5 =(String) offensiveBox.getSelectedItem();
        				for ( int i5 = 0; i5 < offArray.size();i5++){
        					if (selection5 == offArray.get(i5).name){
        						combine5 =" Offensive: "+offArray.get(i5).name;
        						combineAll = combineAll + combine5;
        						if(totalPoints <= 0 || totalPoints - offArray.get(i5).numPoints <= 0)
        							System.out.printf("Not enough points for %s\n",offArray.get(i5).name);
        						else
        						totalPoints = totalPoints -offArray.get(i5).numPoints;
        					}
        				}
    					
    				}
    				if(ship.get(i).defensive == true){
    					String selection6 =(String) defBox.getSelectedItem();
        				for ( int i6 = 0; i6 < defArray.size();i6++){
        					if (selection6 == defArray.get(i6).name){
        						combine6 =" Defensive: "+defArray.get(i6).name;
        						combineAll = combineAll + combine6;
        						if(totalPoints <= 0 || totalPoints - defArray.get(i6).numPoints <= 0)
        							System.out.printf("Not enough points for %s\n",defArray.get(i6).name);
        						else
        						totalPoints = totalPoints -defArray.get(i6).numPoints;
        						
        					}
        				}
    				}
    				if (ship.get(i).defensive2 == true){
    					String selection7 =(String) def2Box.getSelectedItem();
        				for ( int i7 = 0; i7 < def2Array.size();i7++){
        					if (selection7 == def2Array.get(i7).name){
        						combine7 =" Defensive2: "+def2Array.get(i7).name;
        						combineAll = combineAll + combine7;
        						if(totalPoints <= 0 || totalPoints - def2Array.get(i7).numPoints <= 0)
        							System.out.printf("Not enough points for %s\n",def2Array.get(i7).name);      
        						else
        						totalPoints = totalPoints -def2Array.get(i7).numPoints;
        					}
        				}
    				}
    				if(ship.get(i).ordnance ==true){
    					String selection8 =(String) ordnanceBox.getSelectedItem();
        				for ( int i8 = 0; i8 < orArray.size();i8++){
        					if (selection8 == orArray.get(i8).name){
        						combine8 =" Ordnance: "+orArray.get(i8).name;
        						combineAll = combineAll+combine8;
        						if(totalPoints <= 0 || totalPoints - orArray.get(i8).numPoints <= 0){
        							System.out.printf("Not enough points for %s\n",orArray.get(i8).name);
        						}
        						else
        						totalPoints = totalPoints -orArray.get(i8).numPoints;
        					}
        				}
   				}
    				selected.add(combineAll);	
    			}		    								
    }		
    		stringPoints ="Points: "+ String.valueOf(totalPoints); 		
    		l2.setText(stringPoints);
    		x++;
    	}	   	 
    });
    b4.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		for (String s: selected){
    			
    				if (model9.contains(s)){}
    				
    				else
    			model9.addElement(s);	
    	    }
    		JList selected2 = new JList(model9);
    		selected2.setBounds(0, 0, 1400, 200);
    		frame.add(selected2);
    	}	   	 
    });
   
    buttonBox.add(button);
    buttonBox.add(button2);
    buttonBox.add(button3);
    buttonBox.add(button5);
    buttonBox.add(button6);
    buttonBox.add(button7);
    buttonPanel.add(buttonBox);
    
    buttonBox2.add(b);
    buttonBox2.add(b3);
    buttonBox2.add(b2);
    buttonBox2.add(b4);
    buttonPanel2.add(buttonBox2); 
    
    frame.setLayout(null);
    buttonPanel2.setBounds(750, 550, 300, 60);
    buttonPanel.setBounds(0,550,700,60);
    comboPanel.setBounds(300,200,400,60);
    l.setBounds(0,300,1250,120);
    l2.setBounds(0,400,1250,60);
    
    frame.add(comboPanel);
    frame.add(buttonPanel);
    frame.add(buttonPanel2);
    frame.add(l);
    frame.add(l2);
   
    frame.setSize(1400,700);
    frame.setVisible(true);
}

}