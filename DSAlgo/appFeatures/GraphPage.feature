Feature: Graph Page feature file

  Background:  User launch home page of an dsalgo project
    Given The user is on Signin page of DS Algo portal 
    When The user enter valid "Numpysdet84" and "sdet84batch"
    And The user click on login button
    Then The user redirected to homepage

  @TS_graph_02
  Scenario: The user is able to navigate to Graph Data Structure Page
    Given The user is on the home page after logged in 
    When The user clicks the graph item from the drop down menu
    Then The user be directed to Graph Page

  @TS_graph_03
  Scenario: The user is able to navigate to Graph page
    Given The user is on the Graph Page
    When The user clicks Graph link on Graph page
    Then The user should be redirected to Graph Graph page

  @TS_graph_04
  Scenario: The user should be directed to editor page with run button to test python code
    Given The user navigates to Graph Graph page
    When The user clicks on Tryhere link in Graph Page
    Then The user should be directed to Editor page with Run button

  @TS_graph_05
  Scenario Outline: The user is able to run code in Editor for Graph page
    Given The user is in a page having an Editor with a Run button to test
    When The user enters valid python code in Editor from sheet "<Sheetname>" and <RowNumber>
    And clicks run button
    Then The user is presented with the result after run button is clicked

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @TS_graph_06
  Scenario Outline: The user is presented with error message for invalid code in Editor for Graph page
    Given The user is in a page having an Editor with a Run button to test
    When The user enters invalid python code in Editor from sheet "<Sheetname>" and <RowNumber>
    And clicks run button
    Then The user gets an error message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @TS_graph_07
  Scenario: The user is able to navigate to graph page and click on Graph Representations link
    Given The user in editor page and navigates to the graph page
    When The user clicks on Graph Representations link
    Then The user should be redirected to Graph Representations page

  @TS_graph_08
  Scenario: The user should be directed to editor page with run button to test python code from Graph Representations page
    Given The user is in Graph Representations page
    When The user clicks on Tryhere link on graph representations page
    Then The user navigates to Editor page with Run button

  @TS_graph_09
  Scenario Outline: The user is able to run code in Editor for Graph Representations page
    Given The user is in a page having an Editor with a Run button to test
    When The user enters valid python code in Editor from sheet "<Sheetname>" and <RowNumber>
    And clicks run button
    Then The user is presented with the result after run button is clicked

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @TS_graph_10
  Scenario Outline: The user is presented with error message for invalid code in Editor for Graph Representations page
    Given The user is in a page having an Editor with a Run button to test
    When The user enters invalid python code in Editor from sheet "<Sheetname>" and <RowNumber>
    And clicks run button
    Then The user gets an error message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |
