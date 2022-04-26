import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.*;
import javax.swing.*;

public class ExchangeStudent implements ActionListener, Serializable, Student {

    /**
     * Array of questions designed for students spending time in another country
     */
    String[] questions = {
            "1. What is your gender?",
            "2. Do you have any pet allergies?",
            "3. Do you have any food allergies?",
            "4. Are you religious?",
            "5. Do you have any medical conditions that will need regular treatment? (asthma, diabetes, etc)",
            "6. Do you prefer to have a separate room?",
            "7. Do you smoke or do you live with someone who does?",
            "8. If you do not smoke, can you stay in a home with smoking?",
            "9. Will you stay with someone of another gender from you? (Seperate rooms are required.)",
            "10. Do you have any dietary restrictions?"

    };

    /**
     * Possible answers */

    String[][] options = {
            {"M", "F"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"}
    };

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
     * additional variables needed for construction of quiz
     */
    char index;
    int total_questions = questions.length;

    JTextField responses = new JTextField();        //show them their responses
    JTextArea possibleMatched = new JTextArea();    //show possible matches

    /**
     * Constructor
     */
    public ExchangeStudent(){
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

        nextQuestion();
    }

    /**
     * Will take us to next question when button is clicked
     *
     */
    public void nextQuestion(){
        buttonA.setEnabled(true);
        buttonB.setEnabled(true);

        if (index >= total_questions){
            results();
        } else {
            textfield.setText("Question " + (index+1));
            textArea.setText(questions[index]);

            buttonA.setText(options[index][0]);
            buttonB.setText(options[index][1]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
        }
    }


    int yes=0;
    int no=0;

    /**
     * disable buttons when clicked, increment yes/no answers, move to next question, fill array
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);

       if(e.getSource()==buttonA){
            studentResponses.put(index+1, "Yes");       //Y = Male
            yes++;
        }

        if(e.getSource()==buttonB){
            studentResponses.put(index+1, "No");       //N = Female
            no++;
        }

        index++;
        nextQuestion();
        studentResponses.toString();

    }

    /**
     * show results - prove that array is being filled
     */
    public void results(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);

        textfield.setText("RESULTS");
        textArea.setText("Answers: "+ studentResponses);

    }

    /**
     * from interface
     * @return hashmap
     */
    @Override
    public HashMap getStudentResponses() {
        return studentResponses;
    }


}
//end program
