import java.util.HashMap;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;

public class Main implements Host, Student{
    public static void main(String[] args) throws Exception{
    	String login = "Host";

		//ExchangeStudent student = new ExchangeStudent();
          HostFamily host = new HostFamily();


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
