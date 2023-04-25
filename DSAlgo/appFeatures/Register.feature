Feature: User Registration Page
  
  Background:  User launch home page of an dsalgo project
    Given The user opens DS Algo portal link
    When The user clicks the "Get Started" button
    Then The user should be redirected to homepage
    @TS_R1
    Scenario: The user is presented with error message for empty fields below Username textbox
    Given The user opens Register Page
    When The user clicks "Register" button with all fields empty
    Then It should display an error "Please fill out this field." below Username textbox
   
    
   @TS_R2
    Scenario: The user is presented with error message for empty fields below Password textbox
    Given The user opens Register Page
    When The user clicks "Register" button after entering username with other fields empty
     | username     |
      | Numpy@sdet84_1 |
     Then It should display an error "Please fill out this field." below Password textbox
     
      @TS_R3
     Scenario: The user is presented with error message for empty fields below Password Confirmation textbox
      Given The user opens Register Page
      When The user clicks "Register" button after entering "username" and "password" with Password Confirmation field empty
      | username     | password     |
      | Numpy@sdet84_1 | testpassword |
      Then It should display an error "Please fill out this field." below Password Confirmation textbox
      
       @TS_R4
      Scenario: The user is presented with error message for invalid username
      Given The user opens Register Page
      When The user enters a "username" with characters other than Letters, digits and "@/./+/-/_"
       | username | password     | password confirmation |
      | &**&**&  | testpassword | testpassword          |
      Then It should display an error message "password_mismatch:The two password fields didn’t match."
       @TS_R5
      Scenario: The user is presented with error message for username already exists	The user is presented with error message for username already exists
      Given The user opens Register Page	
       When The user enters a valid existing "username""with "password" and "password confirmation"
      | username     | password  | password confirmation |
      | Numpy@sdet84_1 | RT56YUabc | RT56YUabc  |
      Then It should display an error message "password_mismatch:The two password fields didn’t match."
       @TS_R6
      Scenario: The user is presented with error message for password mismatch	The user opens Register Page	
      Given The user opens Register Page
      When The user clicks "Register" button after entering valid "username" and different passwords in "password" and "password confirmation" fields
      | username     | password     | password confirmation |
      | Numpy@sdet84_1 | testpassword | testpassword1   | 
      Then It should display an error message "password_mismatch:The two password fields didn’t match."
      @TS_R7
      Scenario: The user is presented with error message for password with characters less than 8	The user opens Register Page	
       Given The user opens Register Page
      When The user enters a valid username and password with characters less than 8
      | username     | password | password confirmation |
      | Numpy@sdet84_1 | a1b2c3d  | a1b2c3d            |
      Then It should display an error message "password_mismatch:The two password fields didn’t match."
      @TS_R8
      Scenario: The user is presented with error message for password with only numbers	The user opens Register Page
       Given The user opens Register Page
       When The user enters a valid "username" and "password" with only numbers
      | username     | password | password confirmation |
      | Numpy@sdet84_1 | 12345678 |              12345678 |
      Then It should display an error message "password_mismatch:The two password fields didn’t match."
      
      @TS_R9
      Scenario: The user is presented with error message for password too similar to your other personal information	The user opens Register Page
      Given The user opens Register Page
      When The user enters a valid "username" and "password" similar to username
      | username     | password   | password confirmation |
      | Numpy@sdet84_1 | testsdet84 | testsdet84          |
      Then It should display an error message "password_mismatch:The two password fields didn’t match."
      @TS_R10
      Scenario: The user is presented with error message for commonly used password	The user opens Register Page
      Given The user opens Register Page
      When The user enters a valid "username" and commonly used password "password"
      | username     | password | password confirmation |
      | Numpy@sdet84_1 | Welcome1 | Welcome1          |
      Then It should display an error message "password_mismatch:The two password fields didn’t match."
        @TS_R11
      Scenario: The user is succesfully able to register 	The user opens Register Page
      Given The user opens Register Page
      When The user enters a valid "username" and "password" and "password confirmation"
      | username     | password  | password confirmation |
      | Numpy@sdet84_123 | RT56YU@78 | RT56YU@78       |
      Then The user should be redirected to Homepage with the message "New Account Created. You are logged in as <username>"