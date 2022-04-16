import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Host implements ActionListener{
    String[] questions = {
            "What is your student's gender?",

            "Do you have any pets at home?",
            "Are you able to accommodate a student who has food allergies?",
            "Are you religious?",
            "Are you able to accommodate a student's chronic medical conditions, such as asthma or diabetes?",
            "Do you have a separate room available for your guest to stay in?",
            "Do you smoke or do you live with someone who does?",
            "If you smoke, will you do so outside the home?",
            "Will you accept a student of another gender from your student?",
            "Does your family follow any dietary restrictions?"
    };

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
    ArrayList<Character> hostAnswers = new ArrayList<>();
    char index;
    int total_questions = questions.length;

    JTextField responses = new JTextField();        //show them their responses
    JTextArea possibleMatched = new JTextArea();    //show possible matches

    /**
     * Constructor
     */

    Host(){
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
     * TODO: Include confirmation?
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
            // answer_labelC.setText(options[index][2]);
        }
    }

    int yes = 0;
    int no = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);

        if(e.getSource()==buttonA){
            hostAnswers.add('Y');       //Y = Male
            yes++;
        }

        if(e.getSource()==buttonB){
            hostAnswers.add('N');       //N = Female
            no++;
        }

        index++;
        nextQuestion();

    }

    public void results(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);

        textfield.setText("RESULTS");
        textArea.setText("Your yes answers: " + yes + "\n"+"No answers: "+no);
    }
}
//end program
