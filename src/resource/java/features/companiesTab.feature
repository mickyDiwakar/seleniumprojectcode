Feature: companies tab relatedd scenario
@companiesTab
Scenario: add a company
Given user launch cogmento url
And sign in with valid credentials to cogmento
When user add companies from "companies" tab
|Name|Phone|priority|Status|
|CompDiwa|Uk 90856 Home|High|Active|
And user click on "Save" button
Then verify companies details added got saved