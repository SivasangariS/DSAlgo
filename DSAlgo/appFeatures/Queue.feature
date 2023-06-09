Feature: Queue Page feature file

  Background: User launch home page of an dsalgo project
    Given The user is on Signin page of DS Algo portal
    When The user enter valid "Numpysdet84" and "sdet84batch"
    And The user click on login button
    Then The user redirected to homepage

  @TS_queue_02
  Scenario: The user is able to navigate to Queue Data Structure Page
    Given The user is on the home page after logged in
    When The user clicks the Queue item from the drop down menu
    Then The user be directed to Queue Page

  @TS_queue_03
  Scenario: The user is able to navigate to Implementation of Queue in Python link page
    Given The user is on the Queue Page
    When The user clicks on Implementation of queue in Python link
    Then The user should be redirected to Implementation of queue in Python Page

  @TS_queue_04
  Scenario: The user should be directed to editor page with run button to test python code
    Given The user is in Implementation of queue  in Python Page
    When The user clicks on Try here link
    Then The user should be directed to Editor page with Run button

  @TS_queue_05
  Scenario Outline: The user is able to run code in Editor for Implementation of queue page
    Given The user is in a page having an Editor with a Run button to test
    When The user enters valid python code in Editor from sheet "<Sheetname>" and <RowNumber>
    And clicks run button
    Then The user is presented with the result after run button is clicked

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @TS_queue_06
  Scenario Outline: The user is presented with error message for invalid code in Editor for Implementation of queue page
    Given The user is in a page having an Editor with a Run button to test
    When The user enters invalid python code in Editor from sheet "<Sheetname>" and <RowNumber>
    And clicks run button
    Then The user gets an error message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @TS_queue_07
  Scenario: The user is able to navigate to queue page and click on Implementation using collections deque link
    Given The user is in Editor Page and navigates to Queue Page
    When The user clicks on Implementation using collections deque link
    Then TThe user should be redirected to Implementation using collections deque page

  @TS_queue_08
  Scenario: The user should be directed to editor page with run button to test python code from Implementation using collections page
    Given The user in implementation using collections page
    When The user clicks on Tryhere link
    Then The user navigates to Editor page with Run button

  @TS_queue_09
  Scenario Outline: The user is able to run code in Editor for Implementation using collections page
    Given The user is in a page having an Editor with a Run button to test
    When The user enters valid python code in Editor  from sheet "<Sheetname>" and <RowNumber>
    And clicks Run Button
    Then The user is presented with the result after run button is clicked

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @TS_queue_10
  Scenario Outline: The user is presented with error message for invalid code in Editor for Implementation using collections page
    Given The user is in a page having an Editor with a Run button to test
    When The user enters invalid python code in Editor  from sheet "<Sheetname>" and <RowNumber>
    And clicks Run Button
    Then The user gets an Error Message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @TS_queue_11
  Scenario Outline: The user is able to navigate to queue page and click on Implementation using array link
    Given The user in editor page and navigates to the Queue page
    When The user clicks on Implementation using array link
    Then The user should be redirected to Implementation using array page

  @TS_queue_12
  Scenario Outline: The user should be directed to editor page with run button to test python code from Implementation using array page
    Given The user in Implementation using array page
    When The user clicks on Tryhere link
    Then The user navigates to Editor page with Run button

  @TS_queue_13
  Scenario Outline: The user is able to run code in Editor for Implementation using array page
    Given The user is in a page having an Editor with a Run button to test
    When The user enters valid python code in Editor  from sheet "<Sheetname>" and <RowNumber>
    And clicks Run Button
    Then The user is presented with the result after run button is clicked

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @TS_queue_14
  Scenario Outline: The user is presented with error message for invalid code in Editor for Implementation using array page
    Given The user is in a page having an Editor with a Run button to test
    When The user enters invalid python code in Editor  from sheet "<Sheetname>" and <RowNumber>
    And clicks Run Button
    Then The user gets an Error Message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @TS_queue_15
  Scenario Outline: The user is able to navigate to queue page and click on Queue Operations link
    Given The user in Editor page and navigates to the Queue page
    When The user clicks on Queue Operations  link
    Then The user should be redirected to Queue Operations page

  @TS_queue_16
  Scenario Outline: The user should be directed to editor page with run button to test python code
    Given The user in Queue Operations page
    When The user clicks on Tryhere link
    Then The user navigates to Editor page with Run button

  @TS_queue_17
  Scenario Outline: The user is able to run code in Editor for Queue Operations page
    Given The user is in a page having an Editor with a Run button to test
    When The user enters valid python code in Editor  from sheet "<Sheetname>" and <RowNumber>
    And clicks Run Button
    Then The user is presented with the result after run button is clicked

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @TS_queue_18
  Scenario Outline: The user is presented with error message for invalid code in Editor
    Given The user is in a page having an Editor with a Run button to test
    When The user enters invalid python code in Editor  from sheet "<Sheetname>" and <RowNumber>
    And clicks Run Button
    Then The user gets an error message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @TS_queue_19
  Scenario Outline: The user is able to navigate to QueueOp page and click on Practice Questions
    Given The user is in Editor page and navigates to QueueOp page
    When The user clicks on Practice Questions
    Then The user is directed to Practice page
