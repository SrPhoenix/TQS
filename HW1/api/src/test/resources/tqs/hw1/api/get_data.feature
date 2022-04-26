Feature: Get Data From API
  Allow a user to obtain details on COVID incidence data
 
  Scenario: obtain details on COVID incidence on Portugal
    Given a user that ask information about the country 'PTR'
    Then the user must get that information