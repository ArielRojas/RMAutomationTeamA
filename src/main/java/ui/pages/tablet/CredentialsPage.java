package ui.pages.tablet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by MiguelTerceros on 12/10/2015.
 */
public class CredentialsPage extends BasePageObject {
    @FindBy(xpath = "//div[contains(@ui-view,'modal')]/div[contains(@class,'ng-scope')]/h3")
    WebElement credentialsLabel;
    @FindBy(xpath = "//div[contains(@class,'input-control')]/input[contains(@placeholder,'username')]")
    @CacheLookup
    WebElement userNameInput;
    @FindBy(xpath = "//div[contains(@class,'input-control')]/input[contains(@placeholder,'password')]")
    @CacheLookup
    WebElement userPasswordInput;
    @FindBy(xpath = "//button[contains(@class,'pull-right')]/span[contains(text(),'OK')]")
    WebElement okButton;
    @FindBy(xpath = "//button[contains(@class,'pull-right')]/span[contains(text(),'Cancel')]")
    WebElement cancelButton;
    @FindBy(xpath = "//div[contains(text(),'There is a conflict with another meeting, please choose another time interval')]")
    WebElement conflictMessage;

    /**
     * This method is the constructor
     */
    public CredentialsPage() {
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(credentialsLabel));
    }

    public CredentialsPage setUserNameInput(String userName){
        userNameInput.clear();
        userNameInput.sendKeys(userName);
        return this;
    }

    public CredentialsPage setUserPasswordInput(String userPassword){
        userPasswordInput.clear();
        userPasswordInput.sendKeys(userPassword);
        return this;
    }

    public SchedulePage clickOkButton(){
        okButton.click();
        return new SchedulePage();
    }

    public SchedulePage clickCancelButton(){
        cancelButton.click();
        return new SchedulePage();
    }

    public SchedulePage confirmCredentials(String userName, String userPassword){
        setUserNameInput(userName);
        setUserPasswordInput(userPassword);
        return clickOkButton();
    }

    public CredentialsPage cancelCredentials(String userName, String userPassword){
        setUserNameInput(userName);
        setUserPasswordInput(userPassword);
        okButton.click();
        return this;
    }

    public boolean isConflictMessageDisplayed(){
        return conflictMessage.isDisplayed();
    }

    public SchedulePage confirmDelete(String userPassword){
        setUserPasswordInput(userPassword);
        return clickOkButton();
    }

    public SchedulePage confirmUpdate(String userPassword){
        setUserPasswordInput(userPassword);
        return clickOkButton();
    }
}
