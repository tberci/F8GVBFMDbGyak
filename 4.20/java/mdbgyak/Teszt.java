package mdbgyak;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

public class Teszt {

	public static void main(String[] args) {
		
		MongoClient mongo  = new MongoClient("localhost", 27017);
		MongoDatabase database = mongo.getDatabase("mdbgyak");
		System.out.println("Connected to the database successfully");  
		
	    
	    //Kijel�li az auto kollekci�t.
	    MongoCollection<Document> collection = database.getCollection("auto"); 
	    System.out.println("Collection auto selected successfully"); 
	      
	    //Kilist�z mindent
	     FindIterable<Document> iterDoc = collection.find(); 
	     int i = 1; 
	      
	     Iterator it = iterDoc.iterator(); 
	     while (it.hasNext()) {  
	        System.out.println(it.next());  
	         i++; 
	      }    
	     
	    	
	      
//Beilleszt egy elemet
	 
	    Document document = new Document("tipus", "javaInserted")
	    			.append("szin", "k�k")
	    			.append("�r", 2000110)
	    			.append("gy�v", 2009)
	    			.append("�llapot", "j�");
	    			
	    			//Inserting document into the collection
	    		collection.insertOne(document);
	    		System.out.println("Document inserted successfully");
	      
	      
//t�bb dokumentum beilleszt�se kollekci�ba.
	     Document document1 = new Document("tipus", "javaInserted")
	    			.append("szin", "k�k")
	    			.append("�r", 2000110)
	    			.append("gy�v", 2009)
	    			.append("�llapot", "j�");
	    			
	    
	      Document document2 = new Document("tipus", "javaInserted2")
	    	    			.append("szin", "z�ld")
	    	    			.append("�r", 1223)
	    	    			.append("gy�v", 2009)
	    	    			.append("�llapot", "s�r�lt");
	    	    			
	    	    			
	      List<Document> list = new ArrayList<Document>();
	      list.add(document1);
	      list.add(document2);
	      collection.insertMany(list);

//update
	      collection.updateMany(Filters.eq("tipus", "javaInserted"), Updates.set("�llapot", "s�r�lt"));       
	      System.out.println("Document updated successfully...");  
	    
	      
//T�rl�s DB-b�l
	      collection.deleteMany(Filters.eq("tipus", "javaInserted")); 
	      System.out.println("Document deleted successfully...");        
	    
	}
	      
}

