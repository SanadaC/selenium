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

//QA�Fcopy�ŃG���[��throws�ŉ��P���ꂽ

public class ex02 {

	public static void main(String[] args) throws IOException {
		// �N���[�����N������
		System.setProperty("webdriver.chrome.driver", "exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// raku+���J��
		driver.get("https://rakuplus.jp/");

		// ������ID,PASSWORD�Ń��O�C��
		// user_login/user_pass
		WebElement idbox = driver.findElement(By.id("user_login"));
		idbox.sendKeys("chiho.sanada@rakus-partners.co.jp");
		WebElement passbox = driver.findElement(By.id("user_pass"));
		passbox.sendKeys("chiho.sanada@rakus-partners.co.jp");
		passbox.submit();

		// ���O�C������̉�ʂ̃X�N���[���V���b�g���擾
		// �ۑ���͔C��
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(file.toPath(), new File("C:/Users/Sanada/" + file.getName()).toPath());
		
	}

}
