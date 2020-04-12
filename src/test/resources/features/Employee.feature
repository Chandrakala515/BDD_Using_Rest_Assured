Feature: Post functionality

  Scenario Outline: Get the employee details
    Given I hit the Post api endpoint
    When I post the employee id <id>, name <name>,location <location>,salary <salary>
    Then I will get new employee record

    Examples:
    |id|name|location|salary|
    |10|Chandu|AP   |20000 |
    |11|Deepak|AP   |20000 |