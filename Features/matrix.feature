Feature: Matrix
  Background:
    Given I have A Matrix

  Scenario: Determinant
    When I compute determinant of
      | col1 | col2 | col3 |
      | 1    | 2  | 3      |
      | 4    | 5  | 6      |
      | 7    | 8  | 12     |
    Then The result of determinant is -9


  Scenario: Transpose
    When I compute transpose of
      | col1 | col2  |
      | 1    | 2  |
      | 3    | 4  |
      | 5    | 6 |
    Then The result of transpose is
      | col1 | col2 | col3 |
      | 1    | 3  | 5      |
      | 2    | 4  | 6      |


  Scenario: Inverse
    When I compute inverse of
      | col1 | col2  |
      | 1    | 2  |
      | 3    | 4  |
    Then The result of inverse is
      | col1 | col2 |
      | -2    | 1  |
      | 1.5   | -0.5  |


  Scenario: Cofactor
    When I compute cofactor of
      | col1 | col2  |
      | 1    | 2  |
      | 3    | 4  |
    Then The result of cofactor is
      | col1 | col2 |
      | 4    | -3  |
      | -2   | 1  |