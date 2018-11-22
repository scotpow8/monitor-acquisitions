Feature: Acquisition by Scottish Power

  Scenario: Basic acquisition
    Given I start acquisitions
    When I enter postcode 'KW17 2DY'
    Then I must see my address 'BALFOUR CASTLE BALFOUR ORKNEY KW17 2DY'
    And I select address 'WALTNESS BALFOUR ORKNEY KW17 2DY'
    And I submit address

    Given I enter bedrooms 1
    And I enter people 2
    And I enter property type Flat
    When I submit property consumption

    When I select 1 Year tariff
