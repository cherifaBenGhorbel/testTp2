package pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // OPEN PAGE
    public void openFormPage() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    // TEXT INPUT
    public void enterText(String text) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("my-text-id")));
        field.clear();
        field.sendKeys(text);
    }

    // PASSWORD
    public void enterPassword(String password) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-password")));
        field.clear();
        field.sendKeys(password);
    }

    // TEXTAREA
    public void enterTextArea(String text) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-textarea")));
        field.clear();
        field.sendKeys(text);
    }

    // CLICK LINK + BACK
    public void clickLinkAndReturn() {
        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.form-group.tp-align-right.mt-3 > a")));
        link.click();
        driver.navigate().back();
    }

    // DROPDOWN
    public void selectDropdownByIndex(int index) {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-select")));
        new Select(dropdown).selectByIndex(index);
    }

    // DATALIST
    public void enterDatalist(String value) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-datalist")));
        field.sendKeys(value);
    }

    // FILE UPLOAD
    public void uploadFile(String filePath) {
        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("my-file")));

        File file = new File(filePath);

        if (file.exists()) {
            fileInput.sendKeys(file.getAbsolutePath());
        } else {
            System.out.println("File not found: " + file.getAbsolutePath());
        }
    }

    // CHECKBOXES
    public void uncheckCheckbox1() {
        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("my-check-1")));
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void checkCheckbox2() {
        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("my-check-2")));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    // RADIO BUTTON
    public void selectRadioButton() {
        WebElement radio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("my-radio-2")));
        radio.click();
    }

    // COLOR PICKER
    public void setColor(String hexColor) {
        WebElement color = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-colors")));
        color.sendKeys(hexColor);
    }

    // DATE PICKER
    public void setDate(String date) {
        WebElement datePicker = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-date")));
        datePicker.sendKeys(date);
    }

    // SUBMIT
    public void submitForm() {
        WebElement submit = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submit.click();
    }

    // SUCCESS MESSAGE
    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message"))).getText();
    }
}