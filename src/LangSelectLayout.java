package com.amazonaws.gapp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LangSelectLayout extends QuizLayout implements ActionListener {
    /**
     * GUI components
     */
    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
   
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    
    /**
     * Layout copied from QuizLayout
     */
    LangSelectLayout(){
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(230,230,230));       //lightest color
        frame.setLayout(null);
        frame.setResizable(true);

        textfield.setBounds(0,0,650,50);
        textfield.setBackground(new Color(186,186,186));                                       //second lightest color
        textfield.setForeground(new Color(20,20,20));                                           //darkest color
        textfield.setFont(new Font("Monospaced", Font.ITALIC, 30));
        textfield.setBorder(BorderFactory.createSoftBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);
        textfield.setText("TESTING");

        textArea.setBounds(0, 50, 650, 100);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(186,186,186));
        textArea.setForeground(new Color(20, 20, 20));
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        textArea.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        textArea.setEditable(false);
        textArea.setText("Sample Testing");

        buttonA.setBounds(150, 200,50,50);
        buttonA.setBackground(new Color(186,186,186));
        buttonA.setBorder(BorderFactory.createSoftBevelBorder(1));
        buttonA.setFont(new Font("Monospaced", Font.PLAIN, 20));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);

        buttonB.setBounds(400, 200,50,50);
        buttonB.setBackground(new Color(186,186,186));
        buttonB.setBorder(BorderFactory.createSoftBevelBorder(1));
        buttonB.setFont(new Font("Monospaced", Font.PLAIN, 20));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);

        frame.add(buttonB);
        frame.add(buttonA);
        frame.add(textArea);
        frame.add(textfield);
        frame.setVisible(true);
    }
    
    /**
     * Language selection popup -- need to figure out how to get the buttons to display
     * the text and not just "..." -- I think they need to be resized? Will revisit later
     */
    public void selectLanguage() {
    	
    	
    	buttonA.setEnabled(true);
    	buttonB.setEnabled(true);
    	
    	textfield.setText("Language");
    	textArea.setText("Select language / Sprache auswaehlen: ");
    	
    	buttonA.setText("English");
    	buttonB.setText("Deutsch");
    	answer_labelA.setText("English");
        answer_labelB.setText("Deutsch");
        
        frame.add(buttonA);
        frame.add(buttonB);  
        frame.add(textArea);
        frame.add(textfield);
        frame.setVisible(true);
        
        
    	// What to do after button A is pressed
    	buttonA.addActionListener(new ActionListener() {
    		public void actionPerformed (ActionEvent e) {
    			buttonAPressed();
			QuizLayout quiz = new QuizLayout();
        		quiz.nextQuestion();
    			
    		}
    	});
    	
    	// What to do after button B is pressed
    	buttonB.addActionListener(new ActionListener() {
    		public void actionPerformed (ActionEvent e) {
    			buttonBPressed();
    			QuizLayout quiz = new QuizLayout();
        		quiz.nextQuestion();
    		}
    	});
    	
    }
    
    	/** If button A is pressed, return true English boolean
    	 * and move on to the next Quiz question
    	 * @return English a true boolean indicating language to be used
    	 */
    	protected boolean buttonAPressed() {
    		boolean English = true;
    		
			return English;
    	}
    	
    	/**
    	 * If button B is pressed, return false English boolean
    	 * and move on to next Quiz question 
    	 * @return English a false boolean indicating German should be used
    	 */
    	protected boolean buttonBPressed() {
    		boolean English = false;
    	
			return English;
    	}
     
/**
 * The program wouldn't run unless I had this empty method    
 */
public void actionPerformed(ActionEvent e) {
}
}

