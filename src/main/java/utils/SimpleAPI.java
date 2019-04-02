package utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;

public abstract class SimpleAPI {

	private static final Logger LOGGER = LogManager.getLogger(SimpleAPI.class);

	protected abstract WebDriver getDriver();

	protected void open(String url) {
		getDriver().get(url);
	}

	protected WebElement $(By locator) {
		return $(locator, Conditions.VISIBLE);
	}

	protected WebElement $(String xPath) {
		return $(By.xpath(xPath));
	}

	protected WebElement $(By locator, Function<By, ExpectedCondition<WebElement>> condition) {
		return waitFor(condition.apply(locator));
	}

	protected WebElement $(By locator, Conditions condition) {
		return waitFor(condition.getCondition().apply(locator));
	}

	protected List<WebElement> $$(By locator) {
		return waitFor(visibilityOfAllElementsLocatedBy(locator));
	}

	protected List<WebElement> $$(String xPath) {
		return $$(By.xpath(xPath));
	}

	protected <T> T waitFor(ExpectedCondition<T> condition, long timeout) {
		return (new WebDriverWait(getDriver(), timeout)).until(condition);
	}

	protected void captureScreenshoot(String methodName) {
		File screenshot = ((TakesScreenshot)getDriver())
				.getScreenshotAs(OutputType.FILE);
		String screenshotName = screenshot.getName().replace("screenshot", methodName + "_");
		String path = System.getProperty("report.path") + "/screenshots/" + screenshotName;
		try {
			FileUtils.copyFile(screenshot, new File(path));
			LOGGER.error("Screenshot was got: " + screenshotName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected <T> T waitFor(ExpectedCondition<T> condition) {
		return waitFor(condition, 10l);
	}
}
