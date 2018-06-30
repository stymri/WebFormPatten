package formfill;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Formclass {
	public void fill(JSONObject data,Map<String, InputType> map) {
		Set<String> it = data.keySet();
		for(String name:it) {
			
			try {
				String value = (String) data.get(name);
				if(map.containsKey(name)) {
					InputType inpt = map.get(name);
					String type = inpt.getType();
					WebElement ele = inpt.getEle();
					if(type.equalsIgnoreCase("text")||type.equalsIgnoreCase("email")||type.equalsIgnoreCase("password")) {
						System.out.println(type);
						System.out.println(name);
						
						try {
							ele.clear();
						ele.sendKeys(value);
						}catch (Exception e) {
							//for js blocks
							
						}
					}else if(type.equalsIgnoreCase("checkbox")){
						
					}else if(type.equalsIgnoreCase("select")){
						Select select = new Select(ele);
						select.deselectAll();
						select.selectByVisibleText(value);
					}else {
						// for others
					}
				}else {
					System.out.println("Wrong input name");
				}
			} catch (JSONException e) {
				System.out.println("String format required only");
				e.printStackTrace();
			}
		}
	}
	public HashMap<String, InputType> getFormWebElements(WebDriver driver,By formElement) {
        List<WebElement> elements = driver.findElements(formElement);

        HashMap <String, InputType> map = new HashMap();

        for(WebElement ele : elements) {
            map.put(ele.getAttribute("name"), new InputType(ele.getAttribute("type"), ele));
        }

        for (Map.Entry<String,InputType> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() +
                    ", Ele type = " + entry.getValue().getType() + " , Element: " + entry.getValue().getEle());
        }

        return map;
    }
	public void fillform(WebDriver driver,By formElement,JSONObject data) {
		List<WebElement> elements = driver.findElements(formElement);

        HashMap <String, InputType> map = new HashMap();
        String name,value,type;
        for(WebElement ele : elements) {
        	name = ele.getAttribute("name");
        	value = (String) data.get(name);
        	type = ele.getAttribute("type");
        	if(type.equalsIgnoreCase("text")||type.equalsIgnoreCase("email")||type.equalsIgnoreCase("password")) {
				System.out.println(type);
				System.out.println(name);
				
				try {
					ele.clear();
				ele.sendKeys(value);
				}catch (Exception e) {
					//for js blocks
					
				}
			}else if(type.equalsIgnoreCase("checkbox")){
				
			}else if(type.equalsIgnoreCase("select")){
				Select select = new Select(ele);
				select.deselectAll();
				select.selectByVisibleText(value);
			}else {
				// for others
			}
		}
            //map.put(ele.getAttribute("name"), new InputType(ele.getAttribute("type"), ele));
        }
}


