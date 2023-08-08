import javax.swing.JPanel;
import javax.swing.JPanel;
import javax.transaction.xa.Xid;

import javax.swing.JTextArea;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;
import java.time.Year;

import javax.imageio.ImageIO;

public class Screen extends JPanel implements ActionListener {
    

    private JButton displayButton;
    private JButton addStateButton;
    private JButton deleteStateButton;
    private JButton searchButton;
    private JTextField abbrevField2;
    private JTextField popField;
    private JTextField abbrevField;
    private JTextField nameField;
    private JTextField capitalField;
    private HashMap<State2,Info> map;
    private SortedSet<State2> treeSet;
    private Info display=null;

    public Screen() {

        map = new HashMap<State2,Info>();
        treeSet = new TreeSet<State2>();

        displayButton = new JButton();
        displayButton.setFont(new Font("Arial", Font.BOLD, 20));
        displayButton.setHorizontalAlignment(SwingConstants.CENTER);
        displayButton.setBounds(580, 322, 200, 30);
        displayButton.setText("Display States");
        //this.add(displayButton);
       // displayButton.addActionListener(this);
        
        addStateButton = new JButton();
        addStateButton.setFont(new Font("Arial", Font.BOLD, 20));
        addStateButton.setHorizontalAlignment(SwingConstants.CENTER);
        addStateButton.setBounds(581, 217, 200, 30);
        addStateButton.setText("Add State");
        this.add(addStateButton);
        addStateButton.addActionListener(this);
        
        deleteStateButton = new JButton();
        deleteStateButton.setFont(new Font("Arial", Font.BOLD, 20));
        deleteStateButton.setHorizontalAlignment(SwingConstants.CENTER);
        deleteStateButton.setBounds(361, 323, 200, 30);
        deleteStateButton.setText("Delete State");
        this.add(deleteStateButton);
        deleteStateButton.addActionListener(this);
        
        searchButton = new JButton();
        searchButton.setFont(new Font("Arial", Font.BOLD, 20));
        searchButton.setHorizontalAlignment(SwingConstants.CENTER);
        searchButton.setBounds(581, 177, 200, 30);
        searchButton.setText("Search For");
        this.add(searchButton);
        searchButton.addActionListener(this);
        
        abbrevField2 = new JTextField();
        abbrevField2.setFont(new Font("Arial", Font.PLAIN, 20));
        abbrevField2.setHorizontalAlignment(SwingConstants.LEFT);
        abbrevField2.setBounds(362, 281, 200, 30);
        abbrevField2.setText("Abbreviation");
        this.add(abbrevField2);
        
        popField = new JTextField();
        popField.setFont(new Font("Arial", Font.PLAIN, 20));
        popField.setHorizontalAlignment(SwingConstants.LEFT);
        popField.setBounds(575, 120, 200, 30);
        popField.setText("Population");
        this.add(popField);
        
        abbrevField = new JTextField();
        abbrevField.setFont(new Font("Arial", Font.PLAIN, 20));
        abbrevField.setHorizontalAlignment(SwingConstants.LEFT);
        abbrevField.setBounds(576, 75, 200, 30);
        abbrevField.setText("Abbreviation");
        this.add(abbrevField);
        
        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 20));
        nameField.setHorizontalAlignment(SwingConstants.LEFT);
        nameField.setBounds(577, 36, 200, 30);
        nameField.setText("Name");
        this.add(nameField);
        
        capitalField = new JTextField();
        capitalField.setFont(new Font("Arial", Font.PLAIN, 20));
        capitalField.setHorizontalAlignment(SwingConstants.LEFT);
        capitalField.setBounds(577, 0, 200, 25);
        capitalField.setText("Capital");
        this.add(capitalField);
        
        setLayout(null);
        setFocusable(true);
        
        map.put(new State2("California","ca"), new Info("California","Sacramento",40000000));
		map.put(new State2("Hawaii","hi"),new Info("Hawaii","Honolulu",2000000000));
		map.put(new State2("Wyoming","wy"), new Info("Wyoming","Cheyenne",0));
		treeSet.add(new State2("California","ca"));
		treeSet.add(new State2("Hawaii","hi"));
		treeSet.add(new State2("Wyoming","wy"));
		
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(800,400);
    }

    @Override
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	int y=100;
    	for(State2 state:treeSet) {
        	g.drawString(state.toString(), 50, y);
        	y+=30;
        }
    	if(display!=null) {
    		g.drawString(display.toString(), 400,190);
    	}
    		
    }
    

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == searchButton){
        	String abbreviation=abbrevField.getText();
        	display=map.get(new State2("",abbreviation));
        }
        if(e.getSource() == deleteStateButton){
        	String abbreviation=abbrevField2.getText();
        	treeSet.remove(new State2(map.get(new State2("",abbreviation)).name,abbreviation));
        	map.remove(new State2("",abbreviation));
        	
        	
        }
        if(e.getSource() == addStateButton){
        	String name=nameField.getText();
        	String abbreviation=abbrevField.getText();
        	String capital=capitalField.getText();
        	int population=Integer.parseInt(popField.getText());
        	map.put(new State2(name,abbreviation), new Info(name,capital,population));
        	treeSet.add(new State2(name,abbreviation));
        }
        if(e.getSource() == displayButton){
        	
        }
        repaint();
    }


    
}
    