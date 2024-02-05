package com.criticalthinking3.csc372;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class criticalThinking3 extends JFrame { //Turns out you can extend JFrame
	//Did this just to get the warning off of my screen
	private static final long serialVersionUID = 1L;
	
	JTextArea textArea;
	private Color greenHue;
	
	public criticalThinking3() { //Create frame inside constructor
		setTitle("Critical Thinking 3");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create menu bar
		JMenuBar menuBar = new JMenuBar();
		
		//Create menu
		JMenu menu = new JMenu("Options");
		
		//Create Menu Items
		JMenuItem menuItem1 = new JMenuItem("Show Date and Time");
	    JMenuItem menuItem2 = new JMenuItem("Save to Log");
	    JMenuItem menuItem3 = new JMenuItem("Change Background Color");
	    JMenuItem menuItem4 = new JMenuItem("Exit");
	    
	    //Add items to menu
	    menu.add(menuItem1);
	    menu.add(menuItem2);
	    menu.add(menuItem3);
	    menu.add(menuItem4);
	    
	    //Add the menu to menu bar
	    menuBar.add(menu);
	    
	    //Add menu bar to frame
	    setJMenuBar(menuBar);
	    
	    textArea = new JTextArea();
	    add(textArea, BorderLayout.CENTER);
	    
	    greenHue = generateRandomGreen();
	    
	 // Adding action listeners
        menuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDateTime();
            }
        });

        menuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveToLog();
            }
        });

        menuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeBackgroundColor();
            }
        });

        menuItem4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
	}
	
	//Uses system time
	private void showDateTime() {
		String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		textArea.setText(dateTime);
	}
	
	//Saves whatever is written to log
	private void saveToLog() {
        try (PrintWriter out = new PrintWriter("log.txt")) {
            out.println(textArea.getText());
            System.out.println("Saved to 'log.txt'");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error when trying to save to 'log.txt'");
        }
    }
	
	//Changes background color, had some difficulties and found that changing the text area was the best for me
	private void changeBackgroundColor() {
		textArea.setOpaque(true);
		textArea.setBackground(greenHue);
		repaint();
	}
	
	//Generates a random green
	private Color generateRandomGreen() {
	    Random random = new Random();
	    int hue = random.nextInt(256);
	    return new Color(0, hue, 0);
	}

	public static void main(String[] args) {
		new criticalThinking3().setVisible(true);
	}
}