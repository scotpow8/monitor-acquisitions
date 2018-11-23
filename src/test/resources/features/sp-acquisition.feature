Feature: Acquisition by Scottish Power

  Scenario: Basic acquisition
    Given I start acquisitions
    When I close the cookie panel
    And I enter postcode 'G2 5AD'
    Then I must see my address 'SCOTTISHPOWER SCOTTISHPOWER HOUSE 320 ST. VINCENT STREET GLASGOW G2 5AD'
    And I select address 'SCOTTISHPOWER SCOTTISHPOWER HOUSE 320 ST. VINCENT STREET GLASGOW G2 5AD'
    And I submit address

    When I enter property type Flat
    And I enter people 2
    And I enter bedrooms 1
    And I submit property consumption

    And I select 1 Year tariff
    And I click Continue on popup

    When I enter title Mr
    And I enter first name Mickey
    And I enter surname Mouse
    And I enter dob 6 June 1906
    And I enter telephone number 01411112222
    And I enter email mickey.mouse@disney.com
    And I enter smart meter YES
    And I enter marketing consent email YES
    And I enter marketing consent letter YES
    And I enter marketing consent sms YES
    And I enter marketing consent phone YES
    And I submit personal details

    When I enter bank account holder Money Bags
    And I enter bank account number 38290008
    And I enter sort code 200415
    And I check Ts and Cs
    And I submit bank details