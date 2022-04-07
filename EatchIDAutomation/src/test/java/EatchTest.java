import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class EatchTest {
	static AppiumDriver<MobileElement> driver;
	public static void main(String[] args) throws Exception {
		try {
			openapp();
		} catch (Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();

		} 
		/* new addition */
		
	}

	public static void openapp() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Xiaomi11i");
		cap.setCapability("udid", "gmaybemv9xaaeqpz");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11.0");
		cap.setCapability("appPackage", "me.eatch.app");
		cap.setCapability("appActivity", "me.eatch.app.MainActivity");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		System.out.println("Application Started");
		Thread.sleep(3000);
		MobileElement emailTextBox = driver.findElement(By.xpath("//android.widget.EditText[@index='3']"));
		MobileElement submitButton = driver.findElement(By.xpath("//android.view.ViewGroup[@index='4']"));
		emailTextBox.sendKeys("test@123456.test");
		submitButton.click();
		//test@123456.test 

		Thread.sleep(3000);
		
		/* OTP Entering */
		
		String count = "1";
		for( int i=4; i<= 10; i++) {
			if (i!=7) {
				MobileElement emailVerification =  driver.findElement(By.xpath("//android.widget.EditText[@index='"+i+"']"));
				emailVerification.sendKeys(count);
				int a =Integer.parseInt(count);  
				a = a+1;
				
				 count=Integer.toString(a);
			}else {
				count = count;
			}
	
		}
		
		 Thread.sleep(3000);
		 MobileElement confirmButton =  driver.findElement(By.xpath("//android.view.ViewGroup[@index='12']")); 
		 confirmButton.click();
		 
		 
				
	}

}
