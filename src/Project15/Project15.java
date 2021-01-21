package Project15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Project15 {

    //        NOTE-1: You do not have to use TestNG
    //        NOTE-2: Do not use Thread.sleep()


    // Navigate to https://test.campus.techno.study/
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", MyConstants.DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get("https://test.campus.techno.study/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 5);

        // Dismiss the cookie message by clicking on "Got it!" button
        String GotIt = "#cookieconsent > div > div > a";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(GotIt)));
        driver.findElement(By.cssSelector(GotIt)).click();


        // Login by the credentials (username = "daulet2030@gmail.com" and password = "TechnoStudy123@")
        driver.findElement(By.xpath("//input[@data-placeholder=\"Username\"]")).sendKeys("daulet2030@gmail.com");
        driver.findElement(By.xpath("//input[@data-placeholder=\"Password\"]")).sendKeys("TechnoStudy123@");
        driver.findElement(By.xpath("//button[@aria-label=\"LOGIN\"]")).click();


        // Click on Setup in the left menu
        String parentMenu = "//span[text()='Setup']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(parentMenu)));
        driver.findElement(By.xpath(parentMenu)).click();


        // Click on School Setup
        String secondLevelMenu = "//span[text()='School Setup']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondLevelMenu)));
        driver.findElement(By.xpath(secondLevelMenu)).click();


        // Click on Departments
        String thirdLevelMenu = "//span[text()='Departments']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(thirdLevelMenu)));
        driver.findElement(By.xpath(thirdLevelMenu)).click();


        // Click on "+" button to add a school department
        String plus = "svg[data-icon=\"plus\"";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(plus)));
        driver.findElement(By.cssSelector(plus)).click();


        // On the pop-up window, type "High School" for the name of the department and "HS-1" for the code.
        WebElement DepartmentName = driver.findElement(By.cssSelector("input#ms-text-field-0:nth-child(1)"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#ms-text-field-0:nth-child(1)")));
        DepartmentName.sendKeys("High School");
        WebElement Code = driver.findElement(By.cssSelector("#ms-text-field-1>input"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ms-text-field-1>input")));
        Code.sendKeys("HS-1");


        // Click on "Section" tab
        String section = "mat-tab-label-0-1";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(section)));
        driver.findElement(By.id(section)).click();


        // Click on "+" button to ad a new section.
        String plus1 = "#ms-table-2_buttons > ms-table-toolbar > div > ms-add-button > div > button";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(plus1)));
        driver.findElement(By.cssSelector(plus1)).click();


        // Type "Junior Classes" for the name of the section and "Juniors" for the short name and click on "Add" button to create the section.
        WebElement Name = driver.findElement(By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.NAME']>input"));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.NAME']>input")));
        Name.sendKeys("Junior Classes");

        WebElement ShortName = driver.findElement(By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.SHORTNAME']>input"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.SHORTNAME']>input")));
        ShortName.sendKeys("Juniors");
        driver.findElement(By.cssSelector("ms-button>button")).click();


        // Create another section with the name "Senior Classes" and the short name "Seniors" similarly.
        String plus2 = "#ms-table-2_buttons > ms-table-toolbar > div > ms-add-button > div > button";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(plus1)));
        driver.findElement(By.cssSelector(plus1)).click();

        WebElement Name1 = driver.findElement(By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.NAME']>input"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.NAME']>input")));
        Name.sendKeys("Senior Classes");

        WebElement ShortName1 = driver.findElement(By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.SHORTNAME']>input"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.SHORTNAME']>input")));
        ShortName.sendKeys("Seniors");


        // Click on "Save" for creating the school department.
       // String Save = "ms-save-button[class='ng-star-inserted']";
        String Save = "//*[text() = 'Save']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Save)));
        driver.findElement(By.cssSelector(Save)).click();


        // Verify if the department with the name "High School" created. It should write "School Department successfully created." on the console.
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("toast-container"),"School Department successfully updated"));
        String message =driver.findElement(By.id("toast-container")).getText();
        if (message.contains("School Department successfully updated")){
            System.out.println("New department created");
        }else {
            System.out.println("New departmet was not created ");
        }



        // Click on "+" button to add a school department AGAIN

        // On the pop-up window, type "High School" for the name of the department and "HS-1" for the code AGAIN

        // Click on "Save" for TRYING to create a school department with the same name.

        // Verify that a dialog box occurs with a message "There is already Department with "High School" name!". It should write the message of the dialog box on the console.

        // Click on "x" to dismiss the pop-up window.

        // Click on edit button (or the row) of the "High School" department to edit it.

        // Edit the school department name as "High School Classes" and department code as "HSC-1" and click on "Save"

        // Verify if the department name was edited as "High School Classes" and department code was edited as "HSC-1"
        // It should write "School Department name successfully edited." on the console.
        // And it should write "School Department code successfully edited." on the console.

        // Click on corresponding trash icon

        // Click on "Yes" for deleting the school department.

        // Verify the department is deleted. (it should not be present in the table anymore)

        // Close the browser

    }
}
