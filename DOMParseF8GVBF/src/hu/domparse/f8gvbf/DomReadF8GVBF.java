package hu.domparse.f8gvbf;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class DomReadF8GVBF {
	
    
	
	public static void getEtterem(DocumentBuilderFactory dbFactory,Document doc,String element ) throws ParserConfigurationException, SAXException, IOException{
	
		
		NodeList nList = doc.getElementsByTagName(element);
        System.out.println("Root elem :" + doc.getDocumentElement().getNodeName());  
	
         for (int temp = 0; temp < nList.getLength(); temp++) {
             Node nNode = nList.item(temp);
             
             
             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                 Element eElement = (Element) nNode;
                 
                 String id = eElement.getAttribute("ekod");
                
                 
                 String etterem_nev = eElement.getElementsByTagName("nev").item(0).getTextContent();
                 String varos = eElement.getElementsByTagName("varos").item(0).getTextContent();
                 String utca = eElement.getElementsByTagName("utca").item(0).getTextContent();
                 String hazszam= eElement.getElementsByTagName("hazszam").item(0).getTextContent();
                 int etterem_csillag = Integer.parseInt(eElement.getElementsByTagName("csillag").item(0).getTextContent());
                
                   
                System.out.println("");
                System.out.println("Étterem azonosítója: " + id);
                
                System.out.println("Étterem neve: " + etterem_nev);
                System.out.println("Étterem címe: " + varos +" "+ utca +" "+ hazszam);
                System.out.println("Étterem csillaga: " + etterem_csillag);
                    
             }
      
            
         }
	}
	
	public static void getFoszakacs(DocumentBuilderFactory dbFactory,Document doc,String element) throws ParserConfigurationException, SAXException, IOException{
		
		 NodeList nList = doc.getElementsByTagName(element);
		 
         for (int temp = 0; temp < nList.getLength(); temp++) {
             Node nNode = nList.item(temp);
          
             
             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                 Element eElement = (Element) nNode;
               
                 String id = eElement.getAttribute("fkod");
                 String fk = eElement.getAttribute("e_f");
                
                 
                 String nev = eElement.getElementsByTagName("nev").item(0).getTextContent();
                 
                 int eletkor = Integer.parseInt(eElement.getElementsByTagName("eletkor").item(0).getTextContent());
                 
                 System.out.println("");
                 System.out.println("A fõszakács azonosítója: " + id);
                 System.out.println("A fõszakács neve: " + nev);
              
                 System.out.println("A fõszakács eletkora: " + eletkor);
                 System.out.println("Munkahelye: " + fk);
                 int num = eElement.getElementsByTagName("vegzettseg").getLength();
                 String vegzettseg = ""; 
                 
                 for(int i = 0; i< num; i++) {
                 	vegzettseg = eElement.getElementsByTagName("vegzettseg").item(i).getTextContent();
                 	System.out.println("A fõszakács végzettsege: " + vegzettseg);
                 }
                   
                
               
                    
             }
      
            
         }
	}

	public static void getSzakacs(DocumentBuilderFactory dbFactory,Document doc,String element) throws ParserConfigurationException, SAXException, IOException{
		
		 NodeList nList = doc.getElementsByTagName(element);
        
        
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
           
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                
                String id = eElement.getAttribute("szkod");
                String fk = eElement.getAttribute("e_sz");
                String nev = eElement.getElementsByTagName("nev").item(0).getTextContent(); 
                int reszleg = Integer.parseInt(eElement.getElementsByTagName("reszleg").item(0).getTextContent());
                
                int num = eElement.getElementsByTagName("vegzettseg").getLength();
                String vegzettseg = ""; 
                
                System.out.println("");
                System.out.println("A szakács azonosítója: " + id);
                System.out.println("Munkahelye: " + fk);
                System.out.println("A szakács neve: " + nev);    
                System.out.println("A szakács reszlege: " + reszleg);
                
                for(int i = 0; i< num; i++) {
                	vegzettseg = eElement.getElementsByTagName("vegzettseg").item(i).getTextContent();
                	System.out.println("A szakács végzettsege: " + vegzettseg);
                }
   
            }
     
           
        }
	}
	
	public static void getGyakornok(DocumentBuilderFactory dbFactory,Document doc,String element) throws ParserConfigurationException, SAXException, IOException{
		
		 NodeList nList = doc.getElementsByTagName(element);
       
       
       for (int temp = 0; temp < nList.getLength(); temp++) {
           Node nNode = nList.item(temp);
          
           
           if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               
               String id = eElement.getAttribute("gykod");
               String fk = eElement.getAttribute("e_gy");
               String nev = eElement.getElementsByTagName("nev").item(0).getTextContent(); 
               //String gyakorlat = eElement.getElementsByTagName("gyakorlat").item(0).getTextContent();
               String kezdete = eElement.getElementsByTagName("kezdete").item(0).getTextContent();
               String idotartama = eElement.getElementsByTagName("idotartama").item(0).getTextContent();
               
               System.out.println("");
               System.out.println("A gyakornok azonosítója: " + id);
               System.out.println("Gyakorlat helye: " + fk);
               
               System.out.println("A gyakornok neve: " + nev); 
               System.out.println("Gyakorlat kezdete: " + kezdete); 
               System.out.println("Gyakorlat idõtartama: " + idotartama);
               
              
  
           }
    
          
       }
	}
	
public static void getRendeles(DocumentBuilderFactory dbFactory,Document doc,String element ) throws ParserConfigurationException, SAXException, IOException{
	
		
		NodeList nList = doc.getElementsByTagName(element);
        
	
         for (int temp = 0; temp < nList.getLength(); temp++) {
             Node nNode = nList.item(temp);
            
             
             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                 Element eElement = (Element) nNode;
                 
                 String id = eElement.getAttribute("rkod");
                 String fk = eElement.getAttribute("r_v");
                 
                 int osszeg = Integer.parseInt(eElement.getElementsByTagName("osszeg").item(0).getTextContent());
                 String etel = eElement.getElementsByTagName("etel").item(0).getTextContent();
                
                
                   
                System.out.println("");
                System.out.println("A rendelés azonosítója: " + id);
                System.out.println("A rendelõ vendég : " + fk);
                System.out.println("A rendelés összege: " + osszeg);
                System.out.println("A rendelt étel: " + etel);
               
                    
             }
      
            
         }
	}
	

public static void getVendeg(DocumentBuilderFactory dbFactory,Document doc,String element) throws ParserConfigurationException, SAXException, IOException{
	
	 NodeList nList = doc.getElementsByTagName(element);
  
  
  for (int temp = 0; temp < nList.getLength(); temp++) {
      Node nNode = nList.item(temp);
    
      
      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
          Element eElement = (Element) nNode;
          
          String id = eElement.getAttribute("vkod");
          
          String nev = eElement.getElementsByTagName("nev").item(0).getTextContent(); 
          
          String varos = eElement.getElementsByTagName("varos").item(0).getTextContent();
          String utca = eElement.getElementsByTagName("utca").item(0).getTextContent();
          String hazszam= eElement.getElementsByTagName("hazszam").item(0).getTextContent();
          
          System.out.println("");
          System.out.println("A vendég azonosítója: " + id);
          
          System.out.println("A vendég neve: " + nev); 
          System.out.println("A vendég lakhelye: " + varos+", "+utca+", "+hazszam); 
        
      }

     
  }
}


	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException  {
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		 
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse("./src/hu/domparse/f8gvbf/F8GVBF_XML.xml");
		doc.getDocumentElement().normalize();
		
		getEtterem(dbFactory,doc,"etterem");
		getFoszakacs(dbFactory,doc,"foszakacs");
		getSzakacs(dbFactory,doc,"szakacs");
		getGyakornok(dbFactory,doc,"gyakornok");
		getRendeles(dbFactory,doc,"rendeles");
	    getVendeg(dbFactory,doc,"vendeg");
         
         
   
	}

}
