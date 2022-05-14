Feature: newtour member craetion
10 member using scnario outline

@travel
Scenario Outline:
Given 	Navigate to homepage of newtoursdemoautURl and Click on the register link
When 	Enter contact info "<FirstName>" and "<LastName>" and "<Phone>" and "<Email>"
And 	Enter Mailing info "<address1>" and "<address2>"and "<city> " and "<State>" and "<PostalCode>" and "<Country>"
And 	Enter UserInfo "<UserName>" and "<Password>" and "<ConfirmPassword>"
And 	Click on submit 
Then 	User created"<UserName>"


Examples:

|FirstName|LastName|Phone|Email|address1|address2|city|State|PostalCode|Country|UserName|Password|ConfirmPassword|
|ram1	|kumar	|908|ram@gmail.com|bangalore|adresss2 |bangalore|KARNATAKA|560059|INDIA|mercury1|mercury|mercury|
|ram2	|kumar	|908|ram@gmail.com|bangalore |address2|bangalore|KARNATAKA|560059|INDIA|mercury2|mercury|mercury|
|ram3	|kumar	|908|ram@gmail.com|bangalore |address2|bangalore|KARNATAKA|560059|INDIA|mercury3|mercury|mercury|
|ram4	|kumar	|908|ram@gmail.com|bangalore |address|bangalore|KARNATAKA|560059|INDIA|mercury4|mercury|mercury|
|ram5	|kumar	|908|ram@gmail.com|bangalore |addre|bangalore|KARNATAKA|560059|INDIA|mercury5|mercury|mercury|
|ram6	|kumar	|908|ram@gmail.com|bangalore |aad|bangalore|KARNATAKA|560059|INDIA|mercury6|mercury|mercury|
|ram7	|kumar	|908|ram@gmail.com|bangalore |as|bangalore|KARNATAKA|560059|INDIA|mercury7|mercury|mercury|
|ram8	|kumar	|908|ram@gmail.com|bangalore |adfefg|bangalore|KARNATAKA|560059|INDIA|mercury8|mercury|mercury|
|ram9	|kumar	|908|ram@gmail.com|bangalore |add|bangalore|KARNATAKA|560059|INDIA|mercury9|mercury|mercury|
|ram10	|kumar	|908|ram@gmail.com|bangalore |dsd|bangalore|KARNATAKA|560059|INDIA|mercury10|mercury|mercury|
