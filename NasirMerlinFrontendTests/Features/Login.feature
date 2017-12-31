Feature: Merlin Login Test
  This is feature file is to test if registered users of Merlin are able to login to their
  profile pages.

  Scenario Outline: Title of your scenario outline
    Given I am the login page of Merlin 
    When I login with my "<username>" and "<password>"
    Then I will be directed to the login page

    Examples: 
      | username          | password      |
      | bionicman         | jcd           |
      | the@nering@fP@wer | big.boss      |
      | EvanIsAwesome!    |  evanwest     |
      |  1merlin!         | alexp8        |