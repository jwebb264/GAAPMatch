/**
 * Author: J. Huff, Brad S, Riannon C
 * Date 5/5/2022
 * CIS 111B
 */
import com.mongodb.client.*;
import org.bson.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.function.Consumer;

public class GAPP extends Document implements ActionListener {


    /**
     * GUI components
     */
    String queryType;
    String queryCriteria;

    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textfield2 = new JTextArea();
    JTextField typeinput = new JTextField();
    JTextField query = new JTextField();
    JButton submit = new JButton();
    JButton home = new JButton();

    /**
     * Constructor
     * Creates gui base, calls startGUI() method
     */

    public GAPP(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 650);
        frame.getContentPane().setBackground(new Color(230,230,230));       //lightest color
        frame.setLayout(null);
        frame.setResizable(true);

        textfield.setBounds(20,0,650,50);
        textfield.setBackground(new Color(186,186,186));                                       //second lightest color
        textfield.setForeground(new Color(20,20,20));                                           //darkest color
        textfield.setFont(new Font("Monospaced", Font.ITALIC, 30));
        textfield.setBorder(BorderFactory.createSoftBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        textfield2.setBackground(new Color(186,186,186));                                       //second lightest color
        textfield2.setForeground(new Color(20,20,20));                                           //darkest color
        textfield2.setFont(new Font("Monospaced", Font.ITALIC, 15));
        textfield2.setBorder(BorderFactory.createSoftBevelBorder(1));
        textfield2.setEditable(false);
        textfield2.setLineWrap(true);

        typeinput.setBounds(20,205,650,100);
        typeinput.setBackground(new Color(186,186,186));                                       //second lightest color
        typeinput.setForeground(new Color(20,20,20));                                           //darkest color
        typeinput.setFont(new Font("Monospaced", Font.ITALIC, 30));
        typeinput.setBorder(BorderFactory.createSoftBevelBorder(1));
        typeinput.setHorizontalAlignment(JTextField.CENTER);
        typeinput.setEditable(true);

        query.setBounds(20,305,650,100);
        query.setBackground(new Color(186,186,186));                                       //second lightest color
        query.setForeground(new Color(20,20,20));                                           //darkest color
        query.setFont(new Font("Monospaced", Font.ITALIC, 30));
        query.setBorder(BorderFactory.createSoftBevelBorder(1));
        query.setHorizontalAlignment(JTextField.CENTER);
        query.setEditable(true);

        submit.setBounds(250, 450,150,50);
        submit.setBackground(new Color(186,186,186));
        submit.setBorder(BorderFactory.createSoftBevelBorder(1));
        submit.setFont(new Font("Monospaced", Font.BOLD, 20));
        submit.setFocusable(true);
        submit.addActionListener(this);

        home.setBounds(600, 550,75,40);
        home.setBackground(new Color(186,186,186));
        home.setBorder(BorderFactory.createSoftBevelBorder(1));
        home.setFont(new Font("Monospaced", Font.BOLD, 15));
        home.setFocusable(true);
        home.addActionListener(this);
        home.setText(" Home ");

        startGUI();
    }

    public void startGUI(){
        textfield.setText(" Enter search criteria ");

        textfield2.setBounds(20,50,650,100);
        textfield2.setText(" Search criteria should be in this format: " +"\n"+
                " Student Female \n" + " Host Smoker");
        typeinput.setEnabled(true);
        query.setEnabled(true);
        submit.setText(" Submit ");

        frame.add(textfield);
        frame.add(textfield2);
        frame.add(typeinput);
        frame.add(query);
        frame.add(submit);
        frame.add(home);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        submit.setEnabled(false);
        queryType = typeinput.getText();    //host or student
        queryCriteria = query.getText();    //smoker, gender, allergies, etc

        if(e.getSource()==submit){
        searchResults();}
        else if(e.getSource()==home){
            frame.dispose();
            QuizLayout quiz = new QuizLayout();
        }
    }
    /**
     * Connect to database
     */
    final String uriString = "mongodb://localhost:27017";
    protected MongoClient client = MongoClients.create(uriString);
    protected MongoDatabase db = client.getDatabase("GAPP");
    protected MongoCollection<Document> studentCollection = db.getCollection("Students");
    protected MongoCollection<Document> hostCollection = db.getCollection("Hosts");
    protected MongoCollection<Document> GAPPCollection = db.getCollection("GAPPCollection");

    String key="";
    String value="";
    int num=0;

    /**
     * searchResults takes input from user, and pulls those documents from the database.
     * Calls displayResults at end
     */
    public void searchResults(){
        if (queryCriteria.contains("female")){key = "gender"; value="N";}
        else if (queryCriteria.contains("male")){key = "gender"; value="Y";}
        else if(queryCriteria.contains("no pet")){key = "pet_allergies"; value="N";}
        else if(queryCriteria.contains("pet")){key = "pet_allergies"; value="Y";}
        else if(queryCriteria.contains("religiou")){key = "religious";value="Y";}
        else if(queryCriteria.contains("religion")){key = "religious";value="N";}
        else if (queryCriteria.contains("food")){key = "food_allergies";value="N";}
        else if (queryCriteria.contains("food restrict")){key = "food_allergies";value="Y";}
        else if (queryCriteria.contains("med")){key="medical_conditions";value="N";}
        else if (queryCriteria.contains("no med")){key="medical_conditions";value="Y";}
        else if (queryCriteria.contains("no room")){key = "separate_room";value="N";}
        else if (queryCriteria.contains("room")){key = "separate_room";value="Y";}
        else if (queryCriteria.contains("no smok")){key="smokes";value="N";}
        else if (queryCriteria.contains("smok")){key="smokes";value="Y";}
        else if (queryCriteria.contains("diet")){key="dietary_restrictions";value="Y";}
        else if (queryCriteria.contains("no diet")){key="dietary_restrictions";value="N";}
        else {key = " "; value=" ";}

        if(queryType.contains("stu")) {
            Document q = new Document(key, value);
            FindIterable query = studentCollection.find(q);
            Consumer<Document> print = new Consumer<Document>() {
                @Override
                public void accept(Document q) {
                    num++;
                    textfield2.setText(q.toJson());
                    System.out.println(q.toJson());
                }
            };  query.forEach(print);
            //textfield2.setText(q +" "+ num);

        }else if(queryType.contains("host")) {
            Document q = new Document(key, value);
            FindIterable query = hostCollection.find(q);
            Consumer<Document> print = new Consumer<Document>() {
                @Override
                public void accept(Document q) {
                    num++;
                    textfield2.setText(q.toJson());
                    System.out.println(q.toJson());

                }
            };  query.forEach(print);

        }else {
            Document a = new Document();
            FindIterable query = GAPPCollection.find(a);
            Consumer<Document> print = new Consumer<Document>() {
                @Override
                public void accept(Document q) {
                    num++;
                    textfield2.setText(q.toJson());
                    System.out.println(q.toJson());
                }
            };  query.forEach(print);
        }
        textfield.setText(" There are "+ num +" matches."+"\n");
        textfield2.setBounds(25,50,650,300);

        frame.add(textfield);
        frame.add(textfield2);
        frame.remove(query);
        frame.remove(typeinput);
        frame.setVisible(true);
    }

}//end program
