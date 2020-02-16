package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;

public class FacebookTestingApp
{
    public static final String XPATH_MONTH = "//span[contains(@data-name, \"birthday_wrapper\")]/span/select[1]";
    public static final String XPATH_DAY = "//span[contains(@data-name, \"birthday_wrapper\")]/span/select[2]";
    public static final String XPATH_YEAR = "//span[contains(@data-name, \"birthday_wrapper\")]/span/select[3]";

    public static void main(String[] args)
    {
        LocalDate birthday = LocalDate.now().minusYears(20L).minusMonths(6L).minusDays(10L);

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement selectMonth = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectCombo1 = new Select(selectMonth);
        selectCombo1.selectByIndex(birthday.getMonthValue());

        WebElement selectDay = driver.findElement(By.xpath(XPATH_DAY));
        Select selectCombo2 = new Select(selectDay);
        selectCombo2.selectByIndex(birthday.getDayOfMonth());

        WebElement selectYear = driver.findElement(By.xpath(XPATH_YEAR));
        Select selectCombo3 = new Select(selectYear);
        selectCombo3.selectByVisibleText(Integer.toString(birthday.getYear()));
    }
}
