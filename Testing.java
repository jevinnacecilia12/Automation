import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Testing {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://github.com/login");


        String username="";
        String password="";
        String firstDescription="Test Description";
        String firstFileName="Test File Name";
        String firstMain="<h1>Jevinna Cecilia</h1>"+ Keys.ENTER +"<h2>Testing</h2>";
        String editMain="<h2>Testing</h2>"+ Keys.ENTER +"<h1>Jevinna Cecilia</h1>";

//LOGIN
        WebElement txtLogin = driver.findElement(By.xpath("//input[@id='login_field']"));
        txtLogin.sendKeys(username);
        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='password']"));
        txtPassword.sendKeys(password);
        WebElement btnLogin=driver.findElement(By.xpath("//input[@name='commit']"));
        btnLogin.click();
        driver.navigate().to("https://gist.github.com/");

//ADD NEW GIST
        WebElement txtDescription=driver.findElement(By.xpath("//input[@placeholder='Gist description…']"));
        txtDescription.sendKeys(firstDescription);
        WebElement txtFileName=driver.findElement(By.xpath("//input[@placeholder='Filename including extension…']"));
        txtFileName.sendKeys(firstFileName );
        WebElement txtMain=driver.findElement(By.xpath("//div[@class='CodeMirror-code']"));
        txtMain.sendKeys(firstMain);
        WebElement btnCreatePublic=driver.findElement(By.xpath("//button[contains(text(),'Create public gist')]"));
        btnCreatePublic.click();

//SEE ALL GIST
        driver.navigate().to("https://gist.github.com/");
        WebElement lblSeeAll=driver.findElement(By.xpath("//a[contains(text(),'See all of your gists')]"));
        lblSeeAll.click();

//CHOOSE ONE GIST
        int index=2; // you can change the index belong how much your gist, start from 2 until gist.count();
        WebElement oneGist = driver.findElement(By.xpath("//body[@class='logged-in env-production min-width-lg']/div[contains(@class,'application-main')]/div/main[@id='gist-pjax-container']/div[@class='container-lg px-3 new-discussion-timeline experiment-repo-nav mt-4']/div[@class='gutter d-flex']/div[@class='col-9']/div["+index+"]/div[2]/div[1]"));
        oneGist.click();

//EDIT GIST
        WebElement btnEdit=driver.findElement(By.xpath("//body[@class='logged-in env-production min-width-lg']/div[contains(@class,'application-main')]/div/main[@id='gist-pjax-container']/div[@class='gisthead pagehead repohead instapaper_ignore readability-menu experiment-repo-nav pt-3 mb-4']/div[@class='container-lg px-3']/div[@class='mb-3 d-flex']/ul[@class='pagehead-actions float-none']/li/a[1]"));
        btnEdit.click();
        WebElement txtDescriptionEdit=driver.findElement(By.xpath("//input[@placeholder='Gist description…']"));
        txtDescriptionEdit.sendKeys("A");
        WebElement txtFileNameEdit=driver.findElement(By.xpath("//input[@placeholder='Filename including extension…']"));
        txtFileNameEdit.sendKeys(Keys.BACK_SPACE);
        WebElement txtMainEdit=driver.findElement(By.xpath("//div[@class='CodeMirror-code']"));
        txtMainEdit.sendKeys(Keys.CONTROL + "a");
        txtMainEdit.sendKeys(Keys.DELETE);
        txtMainEdit.sendKeys(editMain);
        WebElement btnConfirmEdit=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        btnConfirmEdit.click();

//SEE ALL GIST FROM HEADER
        WebElement lblProfile=driver.findElement(By.xpath("//summary[@class='Header-link name']"));
        lblProfile.click();
        WebElement lblYourGist=driver.findElement(By.xpath("//a[contains(text(),'Your gists')]"));
        lblYourGist.click();

//DELETE GIST
        int indexing=2; // you can change the index belong how much your gist, start from 2 until gist.count();
        WebElement chooseOne = driver.findElement(By.xpath("//body[@class='logged-in env-production min-width-lg']/div[contains(@class,'application-main')]/div/main[@id='gist-pjax-container']/div[@class='container-lg px-3 new-discussion-timeline experiment-repo-nav mt-4']/div[@class='gutter d-flex']/div[@class='col-9']/div["+indexing+"]/div[2]/div[1]"));
        chooseOne.click();
        WebElement btnDelete =driver.findElement(By.xpath("//button[@class='btn btn-sm btn-danger']"));
        btnDelete.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.manage().timeouts().setScriptTimeout(10,SECONDS);
        driver.close();

    }
}
