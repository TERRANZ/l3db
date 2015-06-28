package ru.terra.l3db.browser.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.terra.l3db.shared.entity.Browser;
import ru.terra.l3db.shared.entity.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Date: 15.06.15
 * Time: 10:52
 */
public class BrowserImpl implements Browser {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private WebDriver driver;
    private Configuration.BrowserConfiguration browserConfiguration;

    public BrowserImpl(Configuration.BrowserConfiguration browserConfiguration) {
        this.browserConfiguration = browserConfiguration;
        driver = new FirefoxDriver();
    }

    @Override
    public void openPage(String page) {
        try {
            driver.get(page);
        } catch (Exception e) {
            logger.error("Unable to navigate", e);
        }
    }

    @Override
    public boolean login(String user, String pass, String userXpath, String passXpath) {
        openPage(browserConfiguration.loginAddress);
        if (isTextExists(browserConfiguration.loginHeader)) {
            inputData(browserConfiguration.loginXpath, browserConfiguration.login);
            inputData(browserConfiguration.passwordXpath, browserConfiguration.password);
            pressSubmit(browserConfiguration.goButtonXpath, "go");
            int tryes = 0;
            while (!isTextExists(browserConfiguration.loginSuccessHeader) || tryes > 5)
                try {
                    Thread.sleep(500);
                    tryes++;
                } catch (InterruptedException e) {
                    logger.error("Unable to wait", e);
                }

        }
        return true;
    }

    @Override
    public boolean inputData(String boxPath, String text) {
        Optional<WebElement> element = findElement(boxPath);
        element.ifPresent(e -> e.sendKeys(text));
        return element.isPresent();
    }

    @Override
    public boolean chooseDropBoxElement(String xpath, String text) {
        Optional<WebElement> element = findElement(xpath);
        if (!element.isPresent())
            return false;
        Select select = ((Select) element.get());
        try {
            select.selectByVisibleText(text);
        } catch (NoSuchElementException e) {
            logger.error("Unable to find text " + text + " in dropbox " + xpath);
            return false;
        }
        return true;
    }

    @Override
    public boolean isExistDropBoxElement(String xpath, String text) {
        return false;
    }

    @Override
    public String getElementText(String xpath) {
        Optional<WebElement> element = findElement(xpath);
        if (element.isPresent())
            return element.get().getText();
        return null;
    }

    @Override
    public String[][] getElementTable(String xpath) {
        // simplified: find table which contains the keyword
        Optional<WebElement> element = findElement(xpath);
        if (!element.isPresent())
            return null;

        WebElement tableElement = element.get();


        ArrayList<HashMap<String, WebElement>> userTable = new ArrayList<>();
        List<WebElement> rowElements = tableElement.findElements(By.xpath(".//tr"));

        ArrayList<String> columnNames = new ArrayList<>();
        List<WebElement> headerElements = rowElements.get(0).findElements(By.xpath(".//th"));
        for (WebElement headerElement : headerElements) {
            columnNames.add(headerElement.getText());
        }

        for (WebElement rowElement : rowElements) {
            HashMap<String, WebElement> row = new HashMap<>();

            // add table cells to current row
            int columnIndex = 0;
            List<WebElement> cellElements = rowElement.findElements(By.xpath(".//td"));
            for (WebElement cellElement : cellElements) {
                row.put(columnNames.get(columnIndex), cellElement);
                columnIndex++;
            }

            userTable.add(row);
        }
        return new String[0][];
    }

    @Override
    public boolean isTextExists(String text) {
        return false;
    }

    @Override
    public boolean pressSubmit(String submitXpath, String text) {
        Optional<WebElement> element = findElement(submitXpath);
        element.ifPresent(e -> e.click());
        return element.isPresent();
    }

    private Optional<WebElement> findElement(String xpath) {
        return findElements(xpath).stream().findFirst();
    }

    private List<WebElement> findElements(String xpath) {
        return (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
    }
}
