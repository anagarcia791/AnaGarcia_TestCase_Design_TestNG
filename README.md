# Final Exam Web Module

Based on the ESPN webpage

URL: https://www.espnqa.com/?src=com&_adblock=true&espn=cloud

Create a single test for the following steps:


A. Doing Login
   1. Click ‘Log in’ element - Validate a modal is present and contains:
      - ‘ESPN’ Logo
      -  ‘Log In’ button 
      - ‘Sign Up’ button 
   2. Once logged in, go to 'Watch' and validate that at least one carousel is present:
      - Each card in the carousel has a title and a small description about
            streaming source
   3. Click on the second card in the first carousel and validate:
      - 'X' button to close is present
   4. Click 'X' button to close
   5. Go back to the landing page
   6. Perform mouse hover the ‘User Icon’ element located in the top right corner of
      the view:
      - Validate the element 'Nav text' has the right information previously entered in sign up modal: 'Welcome {{username}}!'
   7. Click 'Log Out' element and validate:
      - The user has logged out successfully i.e. Validate the element 'Nav text' has text: 'Welcome!' without username specified


B. Doing Logout
   1. Once logged in, create the flow to log out from current session.
   2. Validate session is log out from user panel

C. Deactivate Account
   1. Once Logged in create the flow to deactivate account (is mandatory to explore the page to understand the flow
   2. Validate the check green action when the account is deactivated
   3. Try to log in again with the same account to get message from page, validate it.

Remember:
- You should improve your code compared to the past exercise applied to ESPN web application. Include the best practices topics given.
- Avoid using implicit waits, they end up creating idle times in the test executions.