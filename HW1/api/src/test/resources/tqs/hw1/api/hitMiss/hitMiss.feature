Feature: Get Basic Cache Statistics
  Scenario: No requests were made
    When I ask for the hitMiss statistics
    Then the total value is 0, the hit  value is 0 and the miss value is 0
  Scenario: A request was made
    When I ask for covid data for the country with the iso code 'PRT'
    and I ask for the hitMiss statistics
    Then the total value is 1, the hit  value is 0 and the miss value is 1