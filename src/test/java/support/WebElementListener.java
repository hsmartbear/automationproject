package support;

import com.qmetry.qaf.automation.ui.webdriver.*;
import com.qmetry.qaf.automation.ui.*;
import org.openqa.selenium.JavascriptExecutor;

public class WebElementListener implements QAFWebElementCommandListener  {
    @Override
    public void beforeCommand(QAFExtendedWebElement element, CommandTracker commandTracker) {
        highlightElement(element);
    }

    @Override
    public void afterCommand(QAFExtendedWebElement paramQAFExtendedWebElement, CommandTracker paramCommandTracker) {
        //highlightElement(paramQAFExtendedWebElement);
    }

    @Override
    public void onFailure(QAFExtendedWebElement paramQAFExtendedWebElement, CommandTracker paramCommandTracker) {
        highlightElement(paramQAFExtendedWebElement);
    }

    public QAFExtendedWebElement highlightElement(QAFExtendedWebElement element) {
		((JavascriptExecutor) new WebDriverTestBase().getDriver()).executeScript("arguments[0].style.border='2px solid red'",
				new Object[] { element });
		return element;
	}
}