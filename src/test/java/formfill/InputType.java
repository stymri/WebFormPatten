package formfill;

import org.openqa.selenium.WebElement;

public class InputType {
	private String type;
	private WebElement ele;
	
	public InputType(String type, WebElement ele) {
		super();
		this.type = type;
		this.ele = ele;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public WebElement getEle() {
		return ele;
	}
	public void setEle(WebElement ele) {
		this.ele = ele;
	}
	
}
