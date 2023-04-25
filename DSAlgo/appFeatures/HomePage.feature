Feature: HomePage Feature file
  I want to land on Home Page

  @TS_01
  Scenario: User launch home page of an dsalgo project
    Given The user opens DS Algo portal link
    When The user clicks the "Get Started" button
    Then The user should be redirected to homepage
 @TS_02
  Scenario Outline: User is on Home page and click getstarted link on  home page without sign in
    Given The user is on Home page
    When The user clicks on Get Started link on homepage "<option>" without login
    Then The user get warning message "You are not logged in"

    Examples: 
      | option         |
      | Datastructures |
      | Arrays         |
      | Linkedlist     |
      | Stack          |
      | Queue          |
      | Tree           |
      | Graph          |
@TS_03
    Scenario Outline: User is on Home page and click on dropdown without sign in
    Given The user is on Home page
    When The user clicks on dropdown "<option>" without login
    Then The user get warning message "You are not logged in"
    Examples: 
      | option         |
      | Arrays         |
      | Linkedlist     |
      | Stack          |
      | Queue          |
      | Tree           |
      | Graph          |
  
  @TS_04    
     Scenario: User is on Home page and click on sign in
     Given The user opens Home Page
     When The user clicks "Sign in"
     Then The user should be redirected to Sign in page
     
    @TS_05 
     Scenario: User is on Home page and click on Register
     Given The user opens Home Page
     When The user clicks "Register"
     Then The user should be redirected to Register form