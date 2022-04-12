import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class QuizLayout extends ExchangeStudent implements ActionListener {
    /**
     * GUI components
     */
    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();

    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();

    int index;
    char answer;
    int total_questions = questions.length;

    QuizLayout(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(232,228,213));       //lightest color
        frame.setLayout(null);
        frame.setResizable(true);

        textfield.setBounds(0,0,650,50);
        textfield.setBackground(new Color(196,186,167));                                       //second lightest color
        textfield.setForeground(new Color(20,20,20));                                           //darkest color
        textfield.setFont(new Font("Monospaced", Font.BOLD, 30));
        textfield.setBorder(BorderFactory.createSoftBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);
        textfield.setText("TESTING");

//        textArea.setBounds(0, 50, 650, 50);
//        textArea.setLineWrap(true);
//        textArea.setWrapStyleWord(true);
//        textArea.setBackground(new Color(232,228,213));
//        textArea.setForeground(new Color(20, 20, 20));
//        textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
//        textArea.setBorder(BorderFactory.createRaisedSoftBevelBorder());
//        textArea.setEditable(false);
//        textArea.setText("Sample Testing");

        buttonA.setBounds(50, 50,50,50);
        buttonA.setBackground(new Color(196,186,167));
        buttonA.setBorder(BorderFactory.createSoftBevelBorder(1));
        buttonA.setFont(new Font("Helvetica", Font.PLAIN, 30));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);

        buttonB.setBounds(500, 100,50,50);
        buttonB.setBackground(new Color(196,186,167));
        buttonB.setBorder(BorderFactory.createSoftBevelBorder(1));
        buttonB.setFont(new Font("Helvetica", Font.PLAIN, 30));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);

        frame.add(buttonB);
        frame.add(buttonA);
        //frame.add(textArea);
        frame.add(textfield);
        frame.setVisible(true);

        nextQuestion();
    }

    public void nextQuestion(){
        if (index >= total_questions){
            results();
        } else {
            textfield.setText(questions[index]);
            textArea.setText(questions[index]);

            buttonA.setText(options[index][0]);
            buttonB.setText(options[index][1]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
        }
    }

    public void results(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
