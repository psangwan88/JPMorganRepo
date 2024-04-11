Feature: News Article Validation

  Background: User launched browser
    Given User launches the browser

  @positive
  Scenario: Validate a valid news article from The Guardian
    Given User open the news page on "https://www.theguardian.com/tone/news"
    When User extract the title of the first news article
    And User search for the news title on Google
    Then User should find at least two articles confirming the news

  @negative
  Scenario: Validate a fake news article from The Guardian when only one result is filtered
    And User search for fake news with title "thisisfackeineswdandnothingisofundongooglehttpsabceckddhttpss"
    Then User should find less than two articles confirming it to be fake news

  @negative
  Scenario: Validate a fake news article from The Guardian when no result is found on google
    And User search for fake news with title "httpddsdfksd://sdfkjdkdfi://dsfksdfksfsdfsd"
    Then User should find zero results for this fake news