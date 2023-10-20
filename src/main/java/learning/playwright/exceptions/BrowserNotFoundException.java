package learning.playwright.exceptions;

public class BrowserNotFoundException extends Exception{
    public BrowserNotFoundException(String message) {
        super(message);
    }
}
