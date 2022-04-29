Feature: Get the COVID incidence data
  Scenario: Search Data by City Name, Country Code, Region name and date
      When I search for covid data from  the city 'Adams', country code 'USA', date '2022-04-28' and Region name 'US'
      Then data should appear, like for example, the province 'Washington'
