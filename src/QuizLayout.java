import javax.swing.*;
import java.awt.*;

public class QuizLayout {
    /**
     * GUI components
     */
    protected JFrame frame = new JFrame();
    protected JTextField textfield = new JTextField();
    protected JTextArea textArea = new JTextArea();


    protected JLabel answer_labelA = new JLabel();
    protected JLabel answer_labelB = new JLabel();

    protected JTextArea possibleMatched = new JTextArea();    //show possible matches
    public QuizLayout(JFrame frame, JTextField textfield, JTextArea textArea) {
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


        frame.add(textArea);
        frame.add(textfield);
        frame.setVisible(true);

    }

}
