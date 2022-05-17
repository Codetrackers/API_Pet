
@smoke
Feature: Pet Store



  Scenario: Find pets by status  - Positive
    Given User send get request to the right url and "/pet/findByStatus" end point
    Then status code should be 200


  Scenario: Find pets by id  - Positive
    Given User send get request to the right url and "/pet/{petID}" end point with id "10"
    Then status code should be 200



 Scenario: Create a new pet
   Given User send POST request to the right url and "/pet" end point
  Then status code should be 200


  Scenario: Create a new pet
    Given User send POST request to the right url and "/pet" end point
    Then status code should be 200


  Scenario: Delete pet
  Given User send delete request to the right url and "/pet/{petID}" end point with id 5000
   Then status code should be 200






 # Scenario: verify 2 information about pet store
  #  Given send get request with json body and ID 5
   # Then status code should be 404


  #Scenario : verify 3 information about pet store
   # Given I send POST request "/user" endpoint with following information
   #   | username   | sep.t              |
   #   | firstName  | Rudy               |
   #   | lastName   | Pameraninan        |
   #   | email      | Rudy_dog@gmail.com |
    #  | password   | Hello              |
   #   | phone      | 1234567890         |
   #   | userStatus | 7                  |
   # Then status code should be 200
##

