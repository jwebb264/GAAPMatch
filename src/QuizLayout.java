import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class QuizLayout implements ActionListener {
    /**
     * GUI components
     */
    String[][] options = {{"English", "Deutsch"},{"Student", "Host"}};
    protected JFrame frame = new JFrame();
    protected JTextField textfield = new JTextField();
    protected JTextArea textArea = new JTextArea();
    protected JButton english = new JButton();
    protected JButton german = new JButton();

    protected char index;

    protected JLabel answer_labelA = new JLabel();
    protected JLabel answer_labelB = new JLabel();

    protected JTextArea possibleMatched = new JTextArea();    //show possible matches

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
        textfield.setText("Welcome! Herzlich Willkommen!");

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

        english.setBounds(150, 200,100,50);
        english.setBackground(new Color(186,186,186));
        english.setBorder(BorderFactory.createSoftBevelBorder(1));
        english.setFont(new Font("Monospaced", Font.PLAIN, 20));
        english.setFocusable(false);
        english.addActionListener(this);

        german.setBounds(400, 200,100,50);
        german.setBackground(new Color(186,186,186));
        german.setBorder(BorderFactory.createSoftBevelBorder(1));
        german.setFont(new Font("Monospaced", Font.PLAIN, 20));
        german.setFocusable(false);
        german.addActionListener(this);


        frame.add(english);
        frame.add(german);

        frame.add(textArea);
        frame.add(textfield);
        frame.setVisible(true);

        nextQuestion();

    }

    public void nextQuestion(){
        english.setEnabled(true);
        german.setEnabled(true);

        english.setText(options[index][0]);
        german.setText(options[index][1]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        english.setEnabled(false);
        german.setEnabled(false);

        if(e.getSource()==english){
            index++;
            nextQuestion();
            if(e.getSource()==english){
                ExchangeStudent student = new ExchangeStudent();
            }
            if(e.getSource()==german){
                HostFamily host = new HostFamily();
            }
        }
        if(e.getSource()==german){          //ADD TRANSLATIONS HERE
            index++;
            nextQuestion();
            if(e.getSource()==english){
                ExchangeStudent student = new ExchangeStudent();
            }
            if(e.getSource()==german){
                HostFamily host = new HostFamily();
            }
        }
        index++;
        nextQuestion();
    }
}
