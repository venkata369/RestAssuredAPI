package com.employeeapi.utilities;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

//Listener Class
public class Reporting extends TestListenerAdapter
{
 
 public ExtentHtmlReporter htmlReporter;
 public ExtentReports extent;
 public ExtentTest logger;
 
  
 public void onStart(ITestContext testContext)
 {
	 String timestamp = new SimpleDateFormat("YYYY.MM.dd.HH.mm.ss").format(new Date());
	 String repName = "Test-Report - "+timestamp+".html";
		
  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/Reports/"+repName);//specify location of the report
  //htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/myReport.html");
  htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
  
  extent=new ExtentReports();
  
  extent.attachReporter(htmlReporter);
  extent.setSystemInfo("Project Name","Employee Database API Project");
  extent.setSystemInfo("Host name","localhost");
  extent.setSystemInfo("Environemnt","QA");
  extent.setSystemInfo("user","Venkata");
  
  htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
  htmlReporter.config().setReportName("Rest API Testing Report"); // name of the report
  //htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
  htmlReporter.config().setTheme(Theme.DARK);
 }
 
 public void onTestSuccess(ITestResult tr)
 {
  logger=extent.createTest(tr.getName()); // create new entry in the report
  logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
 }
 
 public void onTestFailure(ITestResult tr)
 {
  logger=extent.createTest(tr.getName()); // create new entry in the report
  logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
  
  //String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
  //try {
  // logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
 // } catch (IOException e) {
 //   e.printStackTrace();
 // } 
 }
 
 public void onTestSkipped(ITestResult tr)
 {
  logger=extent.createTest(tr.getName()); // create new entry in the report
  logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
 }
 
 public void onFinish(ITestContext testContext)
 {
  extent.flush();
 }
 
 }
