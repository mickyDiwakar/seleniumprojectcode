@CRM
Feature: Case tab 
Background:
Given User navigate to CRMPro URL
And User Enter CRMuserName and CRMPassword

@NewCaseTab
Scenario Outline: Create a new case
And user select "New Case" from "Cases" tab
And Capture the CaseNo
When user enter  "<Title>","<Status>","<Deadline>","<State>","<Identifier>" 
And user enter "<Type>","<Priority>","<Assingedto>"
And user enter "<Contact>" and "<KeyCompany>" from Lookup
And user select "<KnowledgeBaseNode>"
And click on "Save" button
Then verify that Case Created

Examples:
|Title|Status|Deadline	|State|Identifier|Type|Priority|Assingedto|Contact|KeyCompany|KnowledgeBaseNode|
|MR	|Enquiring|31-Jul-2020|Open|test1|Complaint|Low|diwakar kumar|diwa|diwa|Root|
|Ms	|Enquiring|31-Jul-2020|Closed|test2|Complaint|High|diwakar kumar|diwa|diwa|Root|

@SearchCaseTab
Scenario: Serch the case
And user select "Full Search Form" from "Cases" tab
When user enter Title,State Deadline and Deadlinedropdown 
	|Title|State|Deadline|Deadlinedropdown|
	|MR|Open|31-Jul-2020|Equal|

And Click on "Search Cases" button in SearchPage
And Search Case with Title edit it Status "Closed"
Then Verfiy that Case edit done








