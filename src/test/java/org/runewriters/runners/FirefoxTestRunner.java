package org.runewriters.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Test Runner cho Firefox Browser
 * Chạy song song với ChromeTestRunner
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.runewriters.stepdefs", "org.runewriters.hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/firefox/cucumber.html",
                "json:target/cucumber-reports/firefox/cucumber.json",
                "junit:target/cucumber-reports/firefox/cucumber.xml"
        },
        publish = true
)
public class FirefoxTestRunner {

    // Static block để set browser type
    // Chạy trước khi JUnit khởi tạo runner
    static {
        System.setProperty("browser", "firefox");
        System.out.println("═══════════════════════════════════════════");
        System.out.println("🦊 FIREFOX TEST RUNNER INITIALIZED");
        System.out.println("   Thread: " + Thread.currentThread().getName());
        System.out.println("   Browser: FIREFOX");
        System.out.println("═══════════════════════════════════════════");
    }
}