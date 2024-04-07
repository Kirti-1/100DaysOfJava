package learning.Days;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        try {
        	
        	//Making http get request
        	//movies api this will return the list of all the movies from db 
            String urlString = "http://localhost:8098/movies"; 
            URL url = new URL(urlString);
            //openstream of url for scanner class to read and later string can be formed using stringbuilder
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //By default get request -- but if we have to set
            conn.setRequestMethod("GET");
            InputStream stream = conn.getInputStream();
            //Scanner scanner = new Scanner(url.openStream());
            
            Scanner scanner = new Scanner(stream);
                      
            StringBuilder str = new StringBuilder();
            while(scanner.hasNext()) {
            	str.append(scanner.next());
            }
            scanner.close();
            
            String jsonResponse = str.toString();
            /*
             * ************************** Response ***************************
             * {"content":[{"id":1,"title":"TheWitcher","score":4.5,"count":2,"image":"https://www.themoviedb.org/t/p/w533_and_h300_bestv2/jBJWaqoSCiARWtfV0GlqHrcdidd.jpg"},
             * {"id":2,"title":"Venom:LetThereBeCarnage","score":3.3,"count":3,"image":"https://www.themoviedb.org/t/p/w533_and_h300_bestv2/vIgyYkXkg6NC2whRbYjBD7eb3Er.jpg"},....
             * */
            System.out.println(jsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
