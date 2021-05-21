package test;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex03 {

	public static void main(String[] args) throws IOException {
		// クロームを起動する
		System.setProperty("webdriver.chrome.driver", "exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// サイトを開く
		driver.get("https://www.e-procurement.metro.tokyo.jp/index.jsp");
		// 親画面のハンドルを取得
		String currentHandle = driver.getWindowHandle();

		// 入札情報サービスをクリック
		WebElement page = driver.findElement(By.linkText("入札情報サービス"));
		page.click();
		// 現在開いているウィンドウのハンドルを取得
		String newHandle = null;
		for (String id : driver.getWindowHandles()) {
			if (!id.equals(currentHandle)) {
				newHandle = id;
			}
		}
		// 親画面以外のhandleなら切替
		driver.switchTo().window(newHandle);

		// 発注予定情報をクリック
		WebElement page2 = driver.findElement(By.xpath("//*[@id=\"topMenuBtn03\"]/a"));
		page2.click();

		// 表示された画面の「希望受付期間」に入力
		WebElement page3 = driver.findElement(By.name("StartDateYY"));
		page3.sendKeys("3");
		WebElement page4 = driver.findElement(By.name("StartDateMM"));
		page4.sendKeys("5");
		WebElement page5 = driver.findElement(By.name("StartDateDD"));
		page5.sendKeys("2021");
		WebElement page6 = driver.findElement(By.name("EndDateYY"));
		page6.sendKeys("3");
		WebElement page7 = driver.findElement(By.name("EndDateMM"));
		page7.sendKeys("6");
		WebElement page8 = driver.findElement(By.name("EndDateDD"));
		page8.sendKeys("30");
		WebElement page9 = driver
				.findElement(By.xpath("/html/body/div[3]/div/form/table[2]/tbody/tr[3]/td/table[2]/tbody/tr/td/a"));
		page9.click();

		//コンソール出力
		List<WebElement> elment = driver.findElements(By.xpath("/html/body/div[3]/div/form/table[5]"));
		
		System.out.println("Number of elements:" + elment.size());
		for (ListIterator<WebElement> iterator = elment.listIterator(); iterator.hasNext();) {
			System.out.println(iterator.next().getText());
		}
	}
}
