package learning.playwright.tutorials;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.FilePayload;
import org.testng.annotations.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Upload Single File
 * Upload Multiple Files
 * Create a file during run-time and upload
 */
public class FileUploadTest {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeMethod
    public void setupBrowserContext() {
        browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    @AfterMethod
    public void teardownBrowserContext() {
        browserContext.close();
    }

    @AfterClass
    public void teardown() {
        browser.close();
        playwright.close();
    }

    /**
     * Upload Single File
     */
    @Test(priority = 1)
    public void uploadSingleFile() {
        page.navigate("https://the-internet.herokuapp.com/upload");
        page.setInputFiles("#file-upload", Paths.get("SampleFilesToUpload\\example1.txt"));
        page.locator("#file-submit").click();

        System.out.println("Uploading a Single File:");
        System.out.println(page.locator(".example>h3").textContent() + ": " + page.locator(".example>div").textContent());
    }

    /**
     * Upload Multiple Files
     */
    @Test(priority = 2)
    public void uploadMultipleFiles() {
        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
        Path[] filePathsToUpload = {Paths.get("SampleFilesToUpload\\example1.txt"),
                                    Paths.get("SampleFilesToUpload\\example2.txt"),
                                    Paths.get("SampleFilesToUpload\\example3.txt"),
                                    Paths.get("SampleFilesToUpload\\example4.txt")};
        page.setInputFiles("#filesToUpload", filePathsToUpload);
        Locator uploadedFiles = page.locator("#main>.demo-wrapper>ul>li");
        List<String> uploadedFilesNames = uploadedFiles.allTextContents();

        System.out.println("Uploading Multiple Files:");
        System.out.println("Uploaded Files:");
        uploadedFilesNames.forEach(System.out::println);
        System.out.println();
    }

    /**
     * Create a file during run-time and upload
     */
    @Test(priority = 3)
    public void creatingAFileInRuntimeAndUploading() {
        page.navigate("https://the-internet.herokuapp.com/upload");
        page.setInputFiles("#file-upload", new FilePayload("example.text", "text/plain",
                "This is a text file created in Runtime".getBytes(StandardCharsets.UTF_8)));
        page.locator("#file-submit").click();

        System.out.println("Create a file during run-time and upload:");
        System.out.println(page.locator(".example>h3").textContent() + ": " + page.locator(".example>div").textContent());
    }
}
