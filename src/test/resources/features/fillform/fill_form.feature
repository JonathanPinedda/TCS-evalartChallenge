#author: Jonathan Gonzalez Pineda
#Date:05/02/2025
#language: en

Feature: TC01 - Confirm validation hash-code (E2E)
  As user
  I want to fill 10 times the form
  So that I can validate that a confirmation hash-code appears

  Background:
    Given the user is logged in

  Scenario: Validate that after filling the form 10 times, the hash-code appears
    When the user fills the forms 10 times
    Then validation hash-code should be shown