Feature: Customers



Background: Below are common steps for every scenario

Given User Launch Chrome Browser
When User Opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
When User Enters Email as "admin@yourstore.com" and Password as "admin"
And Click on Login
Then User can view Dashboard

@sanity
Scenario: Add a new Customer

When User clicks on customer menu
And Click on customer Menu Iteam
And Click on Add new button
Then User can view Add new customer page
When User enter customers info
And click on save button
Then User can view confirmation message "The new customer has been added successfully."
And close brower


Scenario: Search customer by Email ID

When User clicks on customer menu
And Click on customer Menu Iteam
And Enter customer Email
When Click on search button
Then User should found Email in the search table
And close brower



Scenario: Search customer by FirstName and LastName

When User clicks on customer menu
And Click on customer Menu Iteam
And Enter customer FirstName
And Enter customer LastName
When Click on search button
Then User should found name in the search table
And close brower






