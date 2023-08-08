import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Screen extends JPanel implements ActionListener{
	private MyHashSet<Item> cart=new MyHashSet<>();
	private JTextField n;
	private JTextField p;
	private JTextField q;
	private JButton a;
	private JButton r;
	private JButton c;
	public Screen() {
		setLayout(null);
		cart.add(new Item("Milk",0.99,1));
		cart.add(new Item("Burger",5,1));
		cart.add(new Item("Apple",99.99,1));
		n=new JTextField();
		p=new JTextField();
		q=new JTextField();
		a=new JButton("Add");
		r=new JButton("Remove");
		c=new JButton("Clear");
		n.setBounds(350,250,100,50);
		p.setBounds(350,310,100,50);
		q.setBounds(350,380,100,50);
		a.setBounds(390,440,100,50);
		r.setBounds(270,440,100,50);
		c.setBounds(100,400,100,50);
		add(n);
		add(p);
		add(q);
		add(a);
		add(r);
		add(c);
		a.addActionListener(this);
		r.addActionListener(this);
		c.addActionListener(this);
	}
	public Dimension getPreferredSize() {
		return new Dimension(500,500);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Cart size: "+cart.size(), 10,20);
		g.drawString("Item name: ", 280,280);
		g.drawString("Item price: ", 280,340);
		g.drawString("Item quantity: ", 280,400);
		Iterator<Item> i=(Iterator<Item>)cart.toIterator();
		int y=50;
		double price=0;
		while(i.hasNext()) {
			Object o=i.next();
			if(o!=null) {
				g.drawString(o.toString().toString(), 100,y);
				Item iii=(Item)o;
				price+=iii.getPrice()*iii.getQuantity();
				y+=40;
			}
		}
		g.drawString("Cart price: "+Math.round(price*100.0)/100.0f, 100,20);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==a) {
			if(cart.contains(new Item(n.getText(),Double.parseDouble(p.getText()),0))) {
				cart.remove(new Item(n.getText(),Double.parseDouble(p.getText()),0));
			}
			cart.add(new Item(n.getText(),Double.parseDouble(p.getText()),Integer.parseInt(q.getText())));
		}
		if(e.getSource()==r) {
			cart.remove(new Item(n.getText(),Double.parseDouble(p.getText()),0));
		}
		if(e.getSource()==c) {
			cart.clear();
		}
		repaint();

		
		
	}
	
}
