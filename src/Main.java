import java.util.HashMap;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Main implements Host, Student{
    public static void main(String[] args) throws Exception{
    	String login = "Host";

            ExchangeStudent student = new ExchangeStudent();
            student.studentResponses.put(1, "N");
            student.studentResponses.put(2, "Y");
            student.studentResponses.put(3, "Y");
            student.studentResponses.put(4, "Y");
            student.studentResponses.put(5, "Y");
            student.studentResponses.put(6, "Y");
            student.studentResponses.put(7, "N");
            student.studentResponses.put(8, "N");
            student.studentResponses.put(9, "Y");
            student.studentResponses.put(10, "Y");

           /* HostFamily host = new HostFamily();
                host.hostResponses.put(1, "Y");
                host.hostResponses.put(2, "N");
                host.hostResponses.put(3, "Y");
                host.hostResponses.put(4, "Y");
                host.hostResponses.put(5, "Y");
                host.hostResponses.put(6, "N");
                host.hostResponses.put(7, "N");
                host.hostResponses.put(8, "Y");
                host.hostResponses.put(9, "N");
                host.hostResponses.put(10, "Y");

        if(studentResponses.size()>=10){
        System.out.println(studentResponses);}
        //System.out.println(hostResponses.size());*/

        //connect to mongodb
        MongoClient client = MongoClients.create("mongodb+srv://GappUser:123456Password@gapp.dpgom.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");

        MongoDatabase db = client.getDatabase("GAPP");

        MongoCollection collection = db.getCollection("GAPPCollection");

        Document sampleDoc = new Document("_id", "1")
        		.append("Name", "Johnny B Good")
        		.append("type", login)
        		.append("gender", "Yes")
        		.append("pet_allergies","Yes")
        		.append("food_allergies","Yes")
        		.append("religious","No")
        		.append("medical_conditions","No")
        		.append("seperate_room","Yes")
        		.append("smokes", "No")
        		.append("stay_with_smoker","No")
        		.append("stay_with_other_gender","Yes")
        		.append("dietary_restrictions", "No");
        	
        collection.insertOne(sampleDoc);      
    }

	@Override
	public HashMap getStudentResponses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap getHostResponses() {
		// TODO Auto-generated method stub
		return null;
	}
    
}//end of program
