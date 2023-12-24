Feature: Login Validation

@regression
Scenario: Successful Login with valid Credentials

Given User Launch Chrome Browser
When User Opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
When User Enters Email as "admin@yourstore.com" and Password as "admin"
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on Logout Link
Then Page Title should be "Your store. Login"
And close browse


Scenario Outline: Login Data Driven

Given User Launch Chrome Browser
When User Opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
When User Enters Email as "<email>" and Password as "<password>"
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on Logout Link
Then Page Title should be "Your store. Login"
And close browse

Examples: 
| email | password |
| admin@yourstore.com | admin |
| admin1@yourstore.com | admin123 |

