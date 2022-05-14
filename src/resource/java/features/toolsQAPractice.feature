@ToolsQA
Feature: webtable practice
Background:
Given user logged in to toolsQA Url
When user click on "Elements" and "Web Tables" on toolsqa page

@WebTableDatafetch
Scenario: get first name from 2nd row of the table

Then user fetch firstName from 2nd row of WebTable
And Verify the FirstName is "Alden"

@EditAgeInTable
Scenario: edit the age of a persion in table

And User click on "edit" button in 2nd row WebTable
And change the value of age to 49
Then Verfiy the "Age" of 2nd row changed in the table

@deleteRowinTable
Scenario: edit the age of a persion in table

And User click on "delete" button in 2nd row WebTable
Then Verfiy the  2nd row got deleted in the table

@AddRowinTable
Scenario: Add a row in table
And user click on "Add" button in WebTable page
And User enter FirstName,LastName,email, Age,Salary and Depart
|diw|kum|a@gmail.com|35|1000|commerce|
|diw|kum1|b@gmail.com|36|1009|bt|
And user click on "Submit" button  on reg form page
Then Verify thye new row eneterd