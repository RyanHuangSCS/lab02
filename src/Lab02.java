import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(value = Parameterized.class)
public class Lab02 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

	private String account;
	private String password;
	private String expected;
	private static Object[][] a=new Object[3][97];
	//parameters pass via this constructor
	public Lab02(String ac, String pw, String ex) {
		this.account = ac;
		this.password = pw;
		this.expected = ex;
	}
  @Before
  public void setUp() throws Exception {
	
	  
    driver = new FirefoxDriver();
    baseUrl = "https://psych.liebes.top/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
//Declares parameters here
	@Parameters(name = "{index}: Ñ§ºÅ:{0}²âÊÔ½á¹û")
	public static Iterable<Object[]> data1() {
		Getdata gt=new Getdata();
		return Arrays.asList(gt.readExcel());
	}
  @Test
  public void testLab02() throws Exception {
	  driver.get(baseUrl + "/st");
	  driver.findElement(By.id("username")).clear();
	  driver.findElement(By.id("username")).sendKeys(account);
	  driver.findElement(By.id("password")).clear();
	  driver.findElement(By.id("password")).sendKeys(password);
	  driver.findElement(By.id("submitButton")).click();
	  assertEquals(expected,driver.findElement(By.cssSelector("p.login-box-msg")).getText());

   
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
