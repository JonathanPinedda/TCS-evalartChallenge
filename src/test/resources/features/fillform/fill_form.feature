#author: Jonathan Gonzalez Pineda
#Date:05/02/2025
#language: en

Feature: TC01 - Confirm validation hash-code (E2E)
  Background:
    Given the user is logged in
  Scenario: Validate that after filling the form 10 times, the hash-code appears
    When the user fills the form
    Then validation hash-code should be shown