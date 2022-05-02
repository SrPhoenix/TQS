Feature: Get the COVID incidence data
 Scenario: No requests were made
    When I ask for the hitMiss statistics
    Then the total value is 0, the hit  value is 0 and the miss value is 0
  Scenario: Search Data by City Name, Country Code, Region name and date
      When I search for covid data from  the city 'Adams', country code 'USA', date '2022-04-28' and Region name 'US'
      Then data should appear, like for example, the province 'Washington'
  Scenario: A request was made
    When I ask for the hitMiss statistics
    Then the total value is 1, the hit  value is 0 and the miss value is 1
