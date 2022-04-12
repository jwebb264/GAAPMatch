import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//TODO: Get GUI up and working
//TODO: Get quiz matching up and working
public class ExchangeStudent implements ActionListener {

    String[] questions = {
            "What is your gender?",
            "Do you smoke or live with someone who does?",
            "Do you have any environmental allergies?",
            "Do you have any food allergies?",
            "Are you religious?",
            "Do you have any medical conditions that will need regular treatment? (asthma, diabetes, etc)",
            "Do you prefer to have a separate room?",
            "If you do not smoke, can you stay in a home with smoking?",
            "Will you stay with someone of another gender from you? (You must have separate rooms then.)",
            "Do you have any dietary restrictions?"

    };

    /**
     * Possible answers - most are yes/no. Will include a section to allow them to add in more info
     */
    String[][] options = {
            {"M", "F"},     //need to add other option, need to make button nums variable
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

    char answers;
    char index;
    int total_question = questions.length;

    /**
     * Create GUI
     */
    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();    //Set to "Welcome" + Student name
    JTextArea textArea = new JTextArea();       //Set to question being asked
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();

    JTextField responses = new JTextField();        //show them their responses

    JTextArea possibleMatched = new JTextArea();    //show possible matches


    public ExchangeStudent(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.setLayout(null);

        frame.setVisible(true);
    }

    public void nextQuestion(){

    }

    /**
     * Implement method from ActionListener for button clicks
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void displayAnswers(){

    }




}
