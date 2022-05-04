import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import org.bson.*;
import java.util.*;

public class GAPP extends Document implements Student, Host {

protected int compatibilityCounter = 0;

    /**
     * Connect to database
     */
    final String uriString = "mongodb://localhost:27017";
    private MongoClient client = MongoClients.create(uriString);
    private MongoDatabase db = client.getDatabase("GAPP");
    private MongoCollection<Document> studentCollection = db.getCollection("Students");
    private MongoCollection<Document> hostCollection = db.getCollection("Hosts");

    private BasicDBObject s = new BasicDBObject("medical_conditions", "N"); //find female students
    private FindIterable studentQuery = studentCollection.find(s);

    private BasicDBObject q = new BasicDBObject("medical_conditions", "N"); //find female hosts
    private FindIterable hostsQuery = hostCollection.find(q);

    public GAPP(){
        System.out.println(q.toString());
        System.out.println(s.toString());

        if(s==q){System.out.println("FOUND");}
        else System.out.println("Fail");
    }

    /*public int medicalIssues(){

        //if student has medical issues && host can accommodate
        if (studentResponses.get(5) == hostResponses.get(5)){
            compatibilityCounter++;
        }
        //if student has issues and host cannot accommodate - end program, no match
        if (studentResponses.get(5)== "Y" && hostResponses.get(5)== "N"){
            compatibilityCounter = -1;
            noMatch();
        }
        return compatibilityCounter;
    }

    public int environmentalAllergies(){
        if(studentResponses.get(2) == "Y" && hostResponses.get(2) == "Y"){
            compatibilityCounter++;
        }else if (studentResponses.get(2) == hostResponses.get(2)){
            compatibilityCounter=compatibilityCounter;
        } else compatibilityCounter--;
        return compatibilityCounter;
    }

    public int foodAllergies(){
        //student has no food allergies
        if(studentResponses.get(3) == "N"){
            compatibilityCounter++;
        }
        //student has food allergies and host can accommodate
        else if (studentResponses.get(3)== hostResponses.get(3)){
            compatibilityCounter++;
        }
        //student has food allergies, host cannot accommodate - no match
        else if (studentResponses.get(3) == "Y" && hostResponses.get(3)== "N");
            compatibilityCounter = -1;
        noMatch();
        return compatibilityCounter;
    }

    public int religious(){
        //If both are religious/not religious, increase compatibility
        if(studentResponses.get(4) == hostResponses.get(4)){
            compatibilityCounter++;
        }
        //If one is religious and the other isn't, leave compatibility
        if(studentResponses.get(4) != hostResponses.get(4)){
            compatibilityCounter=compatibilityCounter;
        } return compatibilityCounter;
    }

    public int StudentSmoker(){
        //if student and host smoke
        if(studentResponses.get(7)==hostResponses.get(7)){
            compatibilityCounter=compatibilityCounter+2;
        }
        //if student doesn't smoke but will stay with someone who does
        if(studentResponses.get(7)== "N" && studentResponses.get(8)== "Y"){
            compatibilityCounter++;
        }
        //if student doesn't smoke, won't stay w/ smoker and host is a smoker
        if(studentResponses.get(7)== "N" && studentResponses.get(8)== "N" && hostResponses.get(7)== "Y")
            compatibilityCounter=-1;
            endProgram();
        return compatibilityCounter;
    }

    public int Sex(){
        //if student and host sibling are same sexes, +2
        if(studentResponses.get(1) == hostResponses.get(1)){
            compatibilityCounter=compatibilityCounter+2;
        }if (studentResponses.get(1)!=hostResponses.get(1)){
            //if student & host sibling are != same sexes && no separate rooms, no match
            if(hostResponses.get(6)=="N"){
                compatibilityCounter = -1;
                noMatch();
            }
            //If different sexes and separate rooms available
            if(hostResponses.get(6)=="Y"){
                //if host won't accept a student of different sex
                if(hostResponses.get(9)=="N"){
                    compatibilityCounter=-1;
                    noMatch();
                    //If both host and student are ok with other gender
                }else if(hostResponses.get(9)=="Y"&&studentResponses.get(9)=="Y"){
                    compatibilityCounter++;
                }
            }
        }
        return compatibilityCounter;
    }

    public void setCounter(int compatibilityCounter){this.compatibilityCounter = compatibilityCounter;}
    public int getCounter(){return compatibilityCounter;}
    public void noMatch(){
        if (compatibilityCounter == -1){
            //do something - end program, move on to next host to find match
            //TODO: figure out how to import hosts/students from database
        }
    }*/
    public void endProgram(){
        //System.out.print("ERROR");
        System.out.println(studentResponses +"and "+ hostResponses);
    }

    @Override
    public HashMap getHostResponses() {
        return hostResponses;
    }

    @Override
    public HashMap getStudentResponses() {
        return studentResponses;
    }

}//end program
