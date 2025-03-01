import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Cookie
import com.kms.katalon.core.webui.driver.DriverFactory

// Mở trình duyệt
WebUI.openBrowser('')

// Truy cập trực tiếp trang Task Management
WebUI.navigateToUrl('http://localhost/tasks')
WebUI.maximizeWindow()

// Thực hiện tạo task sau khi vào trang task
WebUI.setText(findTestObject("Task Management/Create_Task/Input_Title"), "Họp nhóm")
WebUI.setText(findTestObject("Task Management/Create_Task/Description_Textarea"), "Thảo luận về tiến độ dự án")

WebUI.setText(findTestObject("Task Management/Create_Task/Input_StartTime"), "10:00")
WebUI.setText(findTestObject("Task Management/Create_Task/Input_EndTime"), "11:00")

WebUI.click(findTestObject("Task Management/Create_Task/dropdown_Priority"))
WebUI.click(findTestObject("Task Management/Create_Task/option_HighPriority"))

WebUI.click(findTestObject("Task Management/Create_Task/dropdown_Security"))
WebUI.click(findTestObject("Task Management/Create_Task/option_Confidential"))

WebUI.click(findTestObject("Task Management/Create_Task/btn_Create"))

if (WebUI.waitForElementVisible(findTestObject("Task Management/Create_Task/task_TeamMeeting"), 10)) {
	WebUI.comment("✅ Task đã được tạo thành công!")
} else {
	WebUI.comment("❌ Task không hiển thị trong danh sách!")
	WebUI.takeScreenshot()
}

// Đóng trình duyệt
WebUI.closeBrowser()
