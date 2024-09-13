Feature: Calculate Privathaftpflicht for a User and recommend options

  Background:
    Given that I can open verivox de

    @Scenario1
  Scenario Outline: Scenario 1 - Verify the DSL Calculator
  When I navigate to <Product Type> and select <SubProduct Type>
  And I enter my Age <age> and Family Type<Family Type>
  Then I go to the Privathaftpflicht personal information page by clicking on <Compare Button1>
  And I enter my Date of Birth<Date of Birth>
  And I enter my Zip Code<Zip Code>
  And I click the Jetzt vergleichen <Compare Button2>
  And I should see a page that lists the available tariffs for my selection

    Examples:
    | Product Type   |SubProduct Type    | age | Family Type      | Date of Birth | Zip Code| Compare Button1   | Compare Button2  |
    | Versicherungen |Privathaftpflicht  | 30  |Single ohne Kinder| 01.01.1990    | 13088   | Jetzt vergleichen | Jetzt vergleichen |

    @Scenario2
    Scenario Outline: Scenario-2 - Load multiple tariff result pages
      When I navigate to <Product Type> and select <SubProduct Type>
      And I enter my Age <age> and Family Type<Family Type>
      Then I go to the Privathaftpflicht personal information page by clicking on <Compare Button1>
      And I enter my Date of Birth<Date of Birth>
      And I enter my Zip Code<Zip Code>
      And I click the Jetzt vergleichen <Compare Button2>
      And I should see a page that lists the available tariffs for my selection
      And I should see the total number of available tariffs listed above all the result list
      When I scroll to the end of the result list page
      Then I should see only the first 20 tariffs displayed
      When  I click on the button labeled 20 weitere Tarife laden
      Then I should see the next 20 tariffs displayed
      And  I can continue to load any additional tariffs until all tariffs have been displayed
      Examples:
        | Product Type   |SubProduct Type    | age | Family Type      | Date of Birth | Zip Code| Compare Button1   | Compare Button2  |
        | Versicherungen |Privathaftpflicht  | 30  |Single ohne Kinder| 01.01.1990    | 13088   | Jetzt vergleichen | Jetzt vergleichen |

