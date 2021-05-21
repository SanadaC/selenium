package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex01 {

	public static void main(String[] args) {
		// クロームを起動する
		System.setProperty("webdriver.chrome.driver", "exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/?hl=ja");

		// 検索テキストボックスの要素を取得
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("selenium");
		searchBox.submit();

		// 一番上のサイトの文字を取得
		WebElement element = driver.findElement(By.cssSelector("div.yuRUbf > a > h3"));
		// コンソール出力
		System.out.println(element.getText());
	}
}
