package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//QA：copyでエラー→throwsで改善された

public class ex02 {

	public static void main(String[] args) throws IOException {
		// クロームを起動する
		System.setProperty("webdriver.chrome.driver", "exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// raku+を開く
		driver.get("https://rakuplus.jp/");

		// 自分のID,PASSWORDでログイン
		// user_login/user_pass
		WebElement idbox = driver.findElement(By.id("user_login"));
		idbox.sendKeys("chiho.sanada@rakus-partners.co.jp");
		WebElement passbox = driver.findElement(By.id("user_pass"));
		passbox.sendKeys("chiho.sanada@rakus-partners.co.jp");
		passbox.submit();

		// ログイン直後の画面のスクリーンショットを取得
		// 保存先は任意
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(file.toPath(), new File("C:/Users/Sanada/" + file.getName()).toPath());
		
	}

}
