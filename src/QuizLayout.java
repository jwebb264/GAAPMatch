/**
 * Authors: J. Huff, Brad S, Riannon C
 * Date 5/5/2022
 * CIS 111B
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class QuizLayout implements ActionListener {
    /**
     * GUI components
     * 2D array options holds answers to the questions as they're asked
     */
    String[][] options = {{"English", "Deutsch"},{"Applicant", "Teacher"},{"Student", "Host"}};

    protected JFrame frame = new JFrame();
    protected JTextField textfield = new JTextField();
    protected JTextArea textArea = new JTextArea();
    protected JButton first = new JButton();
    protected JButton second = new JButton();
    protected JButton home = new JButton();

    protected char index;
    protected int total_questions = options.length;

    /**
     * Constructor
     * Creates GUI for quiz
     * Calls nextQuestion method
     */
    public QuizLayout() {
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
        textfield.setText("Welcome!"+"\n"+"Herzlich Willkommen!");

        textArea.setBounds(0, 50, 650, 100);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(186,186,186));
        textArea.setForeground(new Color(20, 20, 20));
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        textArea.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        textArea.setEditable(false);
        textArea.setText("Please make your selections" + "\n" +
                "Bitte treffen Sie Ihre Auswahl");

        /**
         * First button. Contains values for english, applicant, and student
         */
        first.setBounds(100, 200,150,50);
        first.setBackground(new Color(186,186,186));
        first.setBorder(BorderFactory.createSoftBevelBorder(1));
        first.setFont(new Font("Monospaced", Font.PLAIN, 20));
        first.setFocusable(false);
        first.addActionListener(this);

        /**
         * Second button. Contains values for german, teacher, and host
         */
        second.setBounds(400, 200,150,50);
        second.setBackground(new Color(186,186,186));
        second.setBorder(BorderFactory.createSoftBevelBorder(1));
        second.setFont(new Font("Monospaced", Font.PLAIN, 20));
        second.setFocusable(false);
        second.addActionListener(this);

        /**
         * Home button
         */
        home.setBounds(500, 550,75,40);
        home.setBackground(new Color(186,186,186));
        home.setBorder(BorderFactory.createSoftBevelBorder(1));
        home.setFont(new Font("Monospaced", Font.BOLD, 15));
        home.setFocusable(true);
        home.addActionListener(this);
        home.setText(" Home ");

        frame.add(first);
        frame.add(second);
        frame.add(textArea);
        frame.add(textfield);
        frame.add(home);
        frame.setVisible(true);

        nextQuestion();

    }

    /**
     * Creates String array to store answers to first round of questions
     */
    String[] type = new String[total_questions+1];

    /**
     * nextQuestion method
     * no params
     * Loops through 2D array "options"
     * If index gets to end, calls startQuiz() method
     * Else, if the index of array type at position 1 is a teacher, new GAPP class created, and will be able to
     * query database
     */
    public void nextQuestion(){
        first.setEnabled(true);
        second.setEnabled(true);

        if(index == total_questions){
            startQuiz();
        }else if(type[1]=="second"){                  //teacher
            frame.dispose();
            GAPP n = new GAPP();
        }
        else {
            first.setText(options[index][0]);
            second.setText(options[index][1]);
        }
    }

    /**
     * Disables buttons briefly to prevent double clicks
     * Adds answers to type array
     * @param e - the ActionEvent performed, in this case, a button click
     * Calls nextQuestion method to loop through all questions
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        first.setEnabled(false);
        second.setEnabled(false);
        if(e.getSource()==first){
            type[index]="first";
            index++;
            nextQuestion();

        }if(e.getSource()==second){          //ADD TRANSLATIONS HERE
            type[index]="second";
            index++;
            nextQuestion();
        }if(e.getSource()==home){
            frame.dispose();
            QuizLayout quiz = new QuizLayout();
        }
    }

    /**
     * Called when all questions are answered. Determines if student or host,
     * creates appropriate GUI
     */
    public void startQuiz(){
        first.setEnabled(false);
        second.setEnabled(false);

        if(type[2].equalsIgnoreCase("first")){                 //student
            frame.dispose();
            ExchangeStudent student = new ExchangeStudent();
        }
        else if(type[2].equalsIgnoreCase("second")){             //host
            frame.dispose();
            HostFamily host = new HostFamily();
        }
    }
}//end program
