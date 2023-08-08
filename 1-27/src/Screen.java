import javax.swing.JPanel;
import javax.swing.JTextArea;

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


public class Screen extends JPanel implements ActionListener {
    
    
    private JButton addButton;
    private JButton removeButton;
    private JButton clearButton;
    private JTextField addField;
    private JTextField removeField;

    private BinaryTree<Integer> tree;


    
    public Screen() {

        tree = new BinaryTree<Integer>();

        addButton = new JButton();
        addButton.setFont(new Font("Arial", Font.BOLD, 20));
        addButton.setHorizontalAlignment(SwingConstants.CENTER);
        addButton.setBounds(593, 273, 200, 30);
        addButton.setText("Add");
        this.add(addButton);
        addButton.addActionListener(this);

        removeButton = new JButton();
        removeButton.setFont(new Font("Arial", Font.BOLD, 20));
        removeButton.setHorizontalAlignment(SwingConstants.CENTER);
        removeButton.setBounds(593, 425, 200, 30);
        removeButton.setText("Remove");
        this.add(removeButton);
        removeButton.addActionListener(this);

        clearButton = new JButton();
        clearButton.setFont(new Font("Arial", Font.BOLD, 20));
        clearButton.setHorizontalAlignment(SwingConstants.CENTER);
        clearButton.setBounds(593, 551, 200, 30);
        clearButton.setText("Clear Tree");
        this.add(clearButton);
        clearButton.addActionListener(this);

        addField = new JTextField();
        addField.setFont(new Font("Arial", Font.PLAIN, 20));
        addField.setHorizontalAlignment(SwingConstants.LEFT);
        addField.setBounds(593, 229, 200, 30);
        addField.setText("");
        this.add(addField);

        removeField = new JTextField();
        removeField.setFont(new Font("Arial", Font.PLAIN, 20));
        removeField.setHorizontalAlignment(SwingConstants.LEFT);
        removeField.setBounds(593, 373, 200, 30);
        removeField.setText("");
        this.add(removeField);


        setLayout(null);


        setFocusable(true);


    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(800,600);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        tree.drawMe(g);

    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == addButton){    
            tree.add(Integer.parseInt(addField.getText()));
        }
        if(e.getSource() == removeButton){
            tree.remove(Integer.parseInt(removeField.getText()));
        }
        if(e.getSource() == clearButton){
            tree.clear();
        }

        repaint();
    }
    
    
}