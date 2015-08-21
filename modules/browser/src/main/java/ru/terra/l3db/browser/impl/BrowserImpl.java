package ru.terra.l3db.browser.impl;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.terra.l3db.shared.entity.Browser;
import ru.terra.l3db.shared.entity.config.Configuration;
import ru.terra.l3db.shared.util.TextUtil;

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
    private Configuration configuration;

    public BrowserImpl(Configuration configuration) {
        this.configuration = configuration;
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
    public boolean login() {
        openPage(configuration.browserConfiguration.loginAddress);
        if (isTextExists(configuration.browserConfiguration.loginHeader)) {
            inputData(configuration.browserConfiguration.loginXpath, configuration.browserConfiguration.login);
            inputData(configuration.browserConfiguration.passwordXpath, configuration.browserConfiguration.password);
            pressSubmit(configuration.browserConfiguration.goButtonXpath, "go");
            alertClickButton(true);

            int tryes = 0;
            while (!isTextExists(configuration.browserConfiguration.loginSuccessHeader) || tryes > 5)
                try {
                    Thread.sleep(500);
                    tryes++;
                } catch (InterruptedException e) {
                    logger.error("Unable to wait", e);
                }

        } else
            logger.debug("Unable to locate text: " + configuration.browserConfiguration.loginHeader);

        return true;
    }

    @Override
    public ArrayList<HashMap<String, String>> loadL3DBConfig(String CKT) {
        openPage(configuration.l3DBConfiguration.L3DBAddress);
        if (isTextExists(configuration.l3DBConfiguration.L3DBHeader)) {
            inputData(configuration.l3DBConfiguration.CKTInputXpath, CKT);
            pressSubmit(configuration.l3DBConfiguration.SearchButtonXpath, "go");
            try {
                Thread.sleep(1000 * configuration.l3DBConfiguration.tableWaitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return getElementTable(configuration.l3DBConfiguration.DataTableXpath);
        } else
            logger.debug("Unable to locate text " + configuration.l3DBConfiguration.L3DBHeader);

        return new ArrayList<>();
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
    public ArrayList<HashMap<String, String>> getElementTable(String xpath) {
        // simplified: find table which contains the keyword
        Optional<WebElement> element = findElement(xpath);
        if (!element.isPresent())
            return null;

        WebElement tableElement = element.get();


        ArrayList<HashMap<String, String>> userTable = new ArrayList<>();
        List<WebElement> rowElements = tableElement.findElements(By.xpath(".//tr"));

        ArrayList<String> columnNames = new ArrayList<>();
        List<WebElement> headerElements = rowElements.get(0).findElements(By.xpath(".//td"));
        for (WebElement headerElement : headerElements) {
            columnNames.add(TextUtil.filterEOL(headerElement.getText()));
        }

        for (WebElement rowElement : rowElements) {
            HashMap<String, String> row = new HashMap<>();

            // add table cells to current row
            int columnIndex = 0;
            List<WebElement> cellElements = rowElement.findElements(By.xpath(".//td"));
            for (WebElement cellElement : cellElements) {
                row.put(columnNames.get(columnIndex), TextUtil.filterEOL(cellElement.getText()));
                columnIndex++;
            }

            userTable.add(row);
        }
        userTable.remove(0);
        return userTable;
    }

    @Override
    public boolean isTextExists(String text) {
        return true;
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

    @Override
    public void alertClickButton(boolean ok) {
        logger.debug("Clicking alert ok: " + ok);
        int tries = 0;
        Alert alert = null;
        while (tries < 5) {
            tries++;
            try {
                alert = driver.switchTo().alert();
                break;
            } catch (NoAlertPresentException e) {
                logger.debug("No alert present, sleeping");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    logger.error("Unable to sleep well", e1);
                }
            }
        }
        if (alert != null)
            if (ok)
                alert.accept();
            else
                alert.dismiss();
    }

}
