Feature: Login page feature
 Background:  User launch home page of an dsalgo project
    Given The user opens DS Algo portal link
    When The user clicks the "Get Started" button
    Then The user should be redirected to homepage

@TS_S1    
Scenario Outline: The user is able to signin with registered credential	
Given The user is in the Sign in page	
When The user enters a valid "<username>" and "<password>"	
Then click login button to verify
 Examples: 
      | username   | password  |
      | HarveySpector1 | Summer@123 |
@TS_S2
Scenario: Verifying Register link 
Given The user is in the Sign in page	
When The user clicks on register link on signin page 
Then The user redirected to Registration page from signin page
@TS_S3
Scenario Outline: User on login page and login with invalid inputs 
Given The user is on signin page 
When The user enter invalid "<username>" and "<password>" 
Then click login button to verify 
Examples: 
| username | password |
| user | |
| | passowrd |
| | |
@TS_S4
Scenario Outline: User on login page and login with invalid and valid inputs from Excel
Given The user is on signin page
When The user enter sheet "<Sheetname>" and <RowNumber> 
Then click login button to verify 
Examples: 
| Sheetname | RowNumber |
| Sheet1 | 0 |
| Sheet1 | 1 |
| Sheet1 | 2 |
| Sheet1 | 3 |
@TS_S5
Scenario: Verifying signout link
Given The user is in the Home page with valid  log in	
When The user clicks "Sign out" 	
Then The user redirected to homepage
