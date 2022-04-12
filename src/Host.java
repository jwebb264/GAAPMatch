import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Host extends QuizLayout implements ActionListener{
    String[] questions = {
            "What is your gender?",                                                             //1
            "Do you smoke or live with someone who does?",                                      //2
            "Do you have any pets?",                                                            //3
            "Do you have any food allergies?",                                                  //4
            "Are you religious?",                                                               //5
            "Are you able to work with a student's medical conditions?",                        //6
            "Do you have a separate room available?",                                           //7
            "If you smoke, can you do so outside the home?",                                    //8
            "Will you accept a student of another gender from your student?",                   //9
            "Does your family follow any dietary restrictions?"                                 //10

    };

    String[][] options = {
            {"Male, Female"},
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
        char answers;
        char index;
        int total_question = questions.length;

    /**
     * Constructor
     */

    Host(){

    }

    public void nextQuestion(){

    }

    public void displayAnswers(){

    }

    public void results(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
