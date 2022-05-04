import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.UUID;

public class HostFamily implements ActionListener, Host{
    String[] questions = {
            "1. What is your student's gender?",
            "2. Do you have any pets at home?",
            "3. Are you able to accommodate a student who has food allergies?",
            "4. Are you religious?",
            "5. Are you able to accommodate a student's chronic medical conditions, such as asthma or diabetes?",
            "6. Do you have a separate room available for your guest to stay in?",
            "7. Do you smoke or do you live with someone who does?",
            "8. If you smoke, will you do so outside the home?",
            "9. Will you accept a student of another gender from your student?",
            "10. Does your family follow any dietary restrictions?"
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
    char index;
    int total_questions = questions.length;

    JTextField responses = new JTextField();        //show them their responses
    JTextArea possibleMatched = new JTextArea();    //show possible matches

    /**
     * Constructor
     */

    HostFamily(){
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

    int yes = 0;
    int no = 0;

    /**
     * disables buttons, fills array, increments y/n, moves to next question
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);

      if(e.getSource()==buttonA){
            hostResponses.put(index+1, "Y");       //Y = Male
            yes++;
        }

        if(e.getSource()==buttonB){
            hostResponses.put(index+1, "N");       //N = Female
            no++;
        }

        index++;
        nextQuestion();

    }
    /**
     * shows results of what was answered - testing, makes sure hashmap is being filled
     */
    public void results(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);

        textfield.setText("RESULTS");
        textArea.setText("Answers: "+hostResponses);
        addToDatabase();
    }

    public void addToDatabase(){
        UUID ID = UUID.randomUUID();
        String id = ID.toString();
        final String uriString = "mongodb://localhost:27017";
        MongoClient client = MongoClients.create(uriString);
        MongoDatabase db = client.getDatabase("GAPP");
        MongoCollection collection = db.getCollection("Hosts");
        Document sampleDoc = new Document("_id", id)
                .append("type", "Host")
                .append("gender", hostResponses.get(1))
                .append("pet_allergies",hostResponses.get(2))
                .append("food_allergies",hostResponses.get(3))
                .append("religious",hostResponses.get(4))
                .append("medical_conditions",hostResponses.get(5))
                .append("separate_room",hostResponses.get(6))
                .append("smokes", hostResponses.get(7))
                .append("stay_with_smoker",hostResponses.get(8))
                .append("stay_with_other_gender",hostResponses.get(9))
                .append("dietary_restrictions", hostResponses.get(10));

        collection.insertOne(sampleDoc);

        System.out.print(collection.find());
    }

    /**
     * from interface
     * @return hashmap
     */
    @Override
    public HashMap getHostResponses() {
        return hostResponses;
    }
}
//end program
