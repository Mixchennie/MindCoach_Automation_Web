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

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys


WebUI.openBrowser('')
WebUI.navigateToUrl('http://localhost/register')
WebUI.maximizeWindow()

WebUI.setText(findTestObject("Authentication/Register_Page/txt_Username"), 'xuom')
WebUI.setText(findTestObject("Authentication/Register_Page/txt_Email"), 'anh@gmail.com')

WebUI.setText(findTestObject("Authentication/Register_Page/txt_Password"), 'Xuom@123')
WebUI.setText(findTestObject("Authentication/Register_Page/txt_ConfirmPassword"),  'Xuom@123')

WebUI.waitForElementClickable(findTestObject("Authentication/Register_Page/btn_SignUp"), 10)
WebUI.click(findTestObject("Authentication/Register_Page/btn_SignUp"))
boolean isSuccess = WebUI.waitForElementVisible(findTestObject("Authentication/Register_Page/msg_Success"), 10)

if (isSuccess) {
	WebUI.comment("✅ Registration successful!")
} else {
	WebUI.comment("❌ Registration failed!")
}


