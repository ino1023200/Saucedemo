
package org.runewriters.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Test Runner cho Chrome Browser
 * Chạy song song với FirefoxTestRunner
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.runewriters.stepdefs", "org.runewriters.hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/chrome/cucumber.html",
                "json:target/cucumber-reports/chrome/cucumber.json",
                "junit:target/cucumber-reports/chrome/cucumber.xml"
        },
        publish = true
)
public class ChromeTestRunner {

    // Static block để set browser type
    // Chạy trước khi JUnit khởi tạo runner
    static {
        System.setProperty("browser", "chrome");
        System.out.println("═══════════════════════════════════════════");
        System.out.println("🚀 CHROME TEST RUNNER INITIALIZED");
        System.out.println("   Thread: " + Thread.currentThread().getName());
        System.out.println("   Browser: CHROME");
        System.out.println("═══════════════════════════════════════════");
    }
}