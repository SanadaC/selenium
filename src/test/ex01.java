package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex01 {

	public static void main(String[] args) {
		// �N���[�����N������
		System.setProperty("webdriver.chrome.driver", "exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/?hl=ja");

		// �����e�L�X�g�{�b�N�X�̗v�f���擾
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("selenium");
		searchBox.submit();

		// ��ԏ�̃T�C�g�̕������擾
		WebElement element = driver.findElement(By.cssSelector("div.yuRUbf > a > h3"));
		// �R���\�[���o��
		System.out.println(element.getText());
	}
}
