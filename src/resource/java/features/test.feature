@Demo
Feature: demoautomationtesting url
Background:
Given User navigate to demo URL
And Click on "Skip Sign In" button on DemoHomePage

@RegPage
Scenario Outline: register 3 users 
When user enter firstName "<FName>"and LastName"<LName>" on reg page
And user enter email"<email>" and Phone"<Phone>" on reg page
And user select Gender "<Gender>" and Hobbies "<Hobbies>" on reg page
And User select Country "<Country>" and DOB "<DOB>" on reg page
And user click on "Submit" button on reg page
Then verify user should be created

Examples:
|FName|LName|email|Phone|Gender|Hobbies|Country|DOB|
|Ram|Kumar|abc@gmail.com|9087098765|Male|Movies|India|15/July/1991|
|Ram1|Kumar|abc1@gmail.com|9087098765|Male|Cricket|Yemen|15/July/1992|
|Ram|Kumar|abc2@gmail.com|9087098765|FeMale|Hockey|India|15/July/1999|
@AlertTest
Scenario: Switch to Diffrent alerts
When user click on "SwitchTo" Tab
And Select "Alerts" in SwitchTo Tab
And  click on "Alert with OK" tab and click red button
Then verfiy the text of Alert and click "OK"
And  click on "Alert with OK & Cancel" tab and click deepblue button
Then verfiy the text of Alert and click "Cancel" button
And  click on "Alert with Textbox" tab and click blue button
Then verfiy the text of Alert and enter the valueand click ok
@WindowSwitchTest
Scenario: Switch to diffrent frame
When user click on "SwitchTo" Tab
And Select "Windows" in SwitchTo Tab
And Click "Open New Tabbed Windows" tab in WindowSwitchPage and Click "Click" button
Then Verfiy a new Tab open with text "BLACK LIVES MATTER"
And Select "Open New Seperate Windows" tab in WindowSwitchPage and Click on "Click" button
Then Verfiy a new Window open with text "BLACK LIVES MATTER"
And  Click on "Open Seperate Multiple Windows" tab in WindowSwitchPage and Click "Click" button
Then Verfiy a mutiple window open switch to tab contains "BLACK LIVES MATTER"

@FrameSwitchTest
Scenario: Switch to diffrent frames
When user click on "SwitchTo" Tab
And Select "Frames" in SwitchTo Tab
Then Click on "Single Iframe" and enter Text "Single"
When Click on "Iframe within an Iframe" and enter text "Multi"
Then Click on "Single Iframe" on Frame
