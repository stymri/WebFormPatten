package formfill;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Jsondatareader {
	public JSONObject getData(String filename) {
        try {
			Object obj = new JSONParser().parse(new FileReader("test-data/"+filename));
			JSONObject json = (JSONObject) obj;
			return json;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file not found");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Io execption");
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Parser error");
			e.printStackTrace();
		}
        return null;
	}
}
