/**
 * Author: J. Huff
 * Date 6/5/2022
 * CIS 111B
 */
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class ExchangeStudent implements ActionListener, Student {

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
            {"Male", "Female"},
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
     * GUI
     */
    protected JFrame frame = new JFrame();
    protected JTextField textfield = new JTextField();
    protected JTextArea textArea = new JTextArea();
    protected JButton buttonA = new JButton();
    protected JButton buttonB = new JButton();
    protected JButton home = new JButton();

    protected JLabel answer_labelA = new JLabel();
    protected JLabel answer_labelB = new JLabel();
    /**
     * additional variables needed for construction of quiz
     */
    char index;
    int total_questions = questions.length;

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

        textArea.setBounds(0, 50, 650, 100);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(186,186,186));
        textArea.setForeground(new Color(20, 20, 20));
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        textArea.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        textArea.setEditable(false);
        textArea.setText("Sample Testing");

        buttonA.setBounds(150, 200,75,50);
        buttonA.setBackground(new Color(186,186,186));
        buttonA.setBorder(BorderFactory.createSoftBevelBorder(1));
        buttonA.setFont(new Font("Monospaced", Font.PLAIN, 20));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);

        buttonB.setBounds(400, 200,90,50);
        buttonB.setBackground(new Color(186,186,186));
        buttonB.setBorder(BorderFactory.createSoftBevelBorder(1));
        buttonB.setFont(new Font("Monospaced", Font.PLAIN, 20));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);

        home.setBounds(500, 550,75,40);
        home.setBackground(new Color(186,186,186));
        home.setBorder(BorderFactory.createSoftBevelBorder(1));
        home.setFont(new Font("Monospaced", Font.BOLD, 15));
        home.setFocusable(true);
        home.addActionListener(this);
        home.setText(" Home ");

        frame.add(buttonB);
        frame.add(buttonA);
        frame.add(textArea);
        frame.add(textfield);
        frame.add(home);
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

    protected int yes=0;
    protected int no=0;

    /**
     * @param e disables buttons, fills hostResponses array, increments y/n, moves to next question
     *          increments index, and calls nextQuestion() method
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);

        /**
         * Checks data and fills studentResponses
         */

       if(e.getSource()==buttonA){
            studentResponses.put(index+1, "Y");       //Y = Male
            yes++;
        }

        if(e.getSource()==buttonB){
            studentResponses.put(index+1, "N");       //N = Female
            no++;
        }
        if(e.getSource()==home){
            frame.dispose();
            QuizLayout quiz = new QuizLayout();
        }

        index++;
        nextQuestion();
        studentResponses.toString();
    }

    /**
     * Ends quiz, calls addToDatabase() method
     */
    public void results(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);

        textfield.setText("GAPP");
        textArea.setText(" Thank you for your input. ");

        addToDatabase();
    }
    /**
     * Connect to local database.
     * Generate unique ID
     * Add responses to database
     */
    public void addToDatabase(){
        UUID ID = UUID.randomUUID();
        String id = ID.toString();
        final String uriString = "mongodb://localhost:27017";
        MongoClient client = MongoClients.create(uriString);
        MongoDatabase db = client.getDatabase("GAPP");
        MongoCollection collection = db.getCollection("Students");
        Document sampleDoc = new Document("_id", id)
                .append("type", "Student")
                .append("gender", studentResponses.get(1))
                .append("pet_allergies",studentResponses.get(2))
                .append("food_allergies",studentResponses.get(3))
                .append("religious",studentResponses.get(4))
                .append("medical_conditions",studentResponses.get(5))
                .append("separate_room",studentResponses.get(6))
                .append("smokes", studentResponses.get(7))
                .append("stay_with_smoker",studentResponses.get(8))
                .append("stay_with_other_gender",studentResponses.get(9))
                .append("dietary_restrictions", studentResponses.get(10));

        collection.insertOne(sampleDoc);
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
