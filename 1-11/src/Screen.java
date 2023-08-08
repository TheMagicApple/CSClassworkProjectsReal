import javax.swing.JPanel;
import javax.transaction.xa.Xid;

import javax.swing.JTextArea;

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
public class Screen extends JPanel implements ActionListener{

    private JButton viewButton;
    private JTextField nameField;
    private JTextField idField;
    private JButton removeButton;
    private JButton addButton;
    private boolean viewing=false;
    private SortedSet<Profile> set=new TreeSet<>();
    public Screen(){
       set.add(new Profile("bob",24566));
       set.add(new Profile("joe",12345));
       set.add(new Profile("bill",99999));
    	setLayout(null);
        viewButton = new JButton();
        viewButton.setFont(new Font("Arial", Font.BOLD, 20));
        viewButton.setHorizontalAlignment(SwingConstants.CENTER);
        viewButton.setBounds(582, 342, 200, 30);
        viewButton.setText("View TreeSet");
        this.add(viewButton);
        viewButton.addActionListener(this);

        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 20));
        nameField.setHorizontalAlignment(SwingConstants.LEFT);
        nameField.setBounds(583, 98, 200, 30);
        nameField.setText("Name");
        this.add(nameField);

        idField = new JTextField();
        idField.setFont(new Font("Arial", Font.PLAIN, 20));
        idField.setHorizontalAlignment(SwingConstants.LEFT);
        idField.setBounds(583, 142, 200, 30);
        idField.setText("ID");
        this.add(idField);

        removeButton = new JButton();
        removeButton.setFont(new Font("Arial", Font.BOLD, 20));
        removeButton.setHorizontalAlignment(SwingConstants.CENTER);
        removeButton.setBounds(584, 234, 200, 30);
        removeButton.setText("Remove Profile");
        this.add(removeButton);
        removeButton.addActionListener(this);

        addButton = new JButton();
        addButton.setFont(new Font("Arial", Font.BOLD, 20));
        addButton.setHorizontalAlignment(SwingConstants.CENTER);
        addButton.setBounds(582, 188, 200, 30);
        addButton.setText("Add Profile");
        this.add(addButton);
        addButton.addActionListener(this);

    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(1000,1000);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
       if(viewing) {
    	   
       
        int y=100;
        for(Profile p:set) {
        	g.drawString(p.toString(), 100, y);
        	y+=30;
        }
       }
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == removeButton){
        	set.remove(new Profile(nameField.getText(),Integer.parseInt(idField.getText())));
        }
        if(e.getSource() == addButton){
        	set.add(new Profile(nameField.getText(),Integer.parseInt(idField.getText())));
        }
        if(e.getSource() == viewButton){
        	viewing=!viewing;
        }
        repaint();
    }
}
