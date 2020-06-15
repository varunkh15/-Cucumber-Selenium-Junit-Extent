Feature: MRA form 

  Background: User logs in the BGP Portal
    Given user navigates to MRA form page after login 
  
  Scenario: User validate the Eligibility section
     When user validates questions in the form 
      And user answers no to any question
      And user should get a warning message as expected
      And user click on link in Warning message a new tab opens
      And user switch new tab and validates the URL
     When user select the answer to each mandatory question
      And user save the form after click on the button
      And user refresh the page
      And user validates the text of question which should be as expected
      And user close the browser 
  
  Scenario: Do basic validation for contact details page
     When user navigates to contact details sections
     When user validates Main contact person subsection with inputs
      And user checks that Block House No and Street details auto populates with Valid postal code
      And on clicking checkbox Same as registered address in Company Profile user validates auto population of Mailing address
      And user validates Letter of Offer Addressee subsection with input 
      And user validates option for same as main contact person with auto populate
      And user save the form after click on the button
      And user refresh the page
      And user validate the reloaded values
      And user close the browser
  
  Scenario: To do form submission after giving mandatory details and review
     When user select the answer to each mandatory question
      And user save the form after click on the button
     When user navigates to contact details sections
     When user validates Main contact person subsection with inputs
      And user checks that Block House No and Street details auto populates with Valid postal code
      And on clicking checkbox Same as registered address in Company Profile user validates auto population of Mailing address
      And user validates Letter of Offer Addressee subsection with input 
      And user validates option for same as main contact person with auto populate
      And user save the form after click on the button
      And user fills information in all section but leaves one mandatory information unfilled  	 
      And user saves and click on Review after which user validates the error and validates the page redirected to
      And user fills all mandatory details and click on Review button in Declare and Review section
      And user is navigated to read only summary page and he validates the page values
      And user clicks on Consent and Acknowledgement checkbox and he gets a message of submission
      And user checks if his application is under Processing tab in Grants dashboard
      And user close the browser