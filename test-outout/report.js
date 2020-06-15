$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("MRAForm.feature");
formatter.feature({
  "line": 1,
  "name": "MRA form",
  "description": "",
  "id": "mra-form",
  "keyword": "Feature"
});
formatter.background({
  "line": 3,
  "name": "User logs in the BGP Portal",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "user navigates to MRA form page after login",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDef_Form.user_navigates_to_MRA_form_page_after_login()"
});
formatter.result({
  "duration": 38156719500,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "User validate the Eligibility section",
  "description": "",
  "id": "mra-form;user-validate-the-eligibility-section",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "user validates questions in the form",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user answers no to any question",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "user should get a warning message as expected",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "user click on link in Warning message a new tab opens",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "user switch new tab and validates the URL",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "user select the answer to each mandatory question",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "user save the form after click on the button",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "user refresh the page",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "user validates the text of question which should be as expected",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "user close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "StepDef_Form.user_validates_questions_in_the_form()"
});
formatter.result({
  "duration": 396204900,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_answers_no_to_any_question()"
});
formatter.result({
  "duration": 1739125900,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_should_get_a_warning_message_as_expected()"
});
formatter.result({
  "duration": 160835800,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_click_on_link_in_warning_message_a_new_tab_opens()"
});
formatter.result({
  "duration": 405931300,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_switch_new_tab_and_validates_the_URL()"
});
formatter.result({
  "duration": 3119853500,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.he_select_the_answer_to_each_mandatory_question()"
});
formatter.result({
  "duration": 6047603300,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.he_save_the_form_after_click_on_the_button()"
});
formatter.result({
  "duration": 161965700,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_refresh_the_page()"
});
formatter.result({
  "duration": 5115931200,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_validates_the_text_of_question_which_should_be_as_expected()"
});
formatter.result({
  "duration": 5213669000,
  "error_message": "java.lang.AssertionError: [ The expected question-Is the applicant registered in Singapore?-does not matched with-  Is the applicant registered in Singapore?\n *\n,  The expected question- Is the applicant\u0027s group sales turnover less than or equal to S$100m or is the applicant\u0027s group employment size less than or equal to 200? -does not not matched with actual question-  Is the applicant\u0027s group sales turnover less than or equal to S$100m or is the applicant\u0027s group employment size less than or equal to 200?\n *\n,  The expected question-Does the applicant have at least 30% local equity?-does not matched with actual question-  Does the applicant have at least 30% local equity?\n *\n,  The expected question-Are all the following statements true for this project? * -does not matched with actual question-  Is the target market that you are applying for a new market? A market is new if your company\u0027s revenue from there has not exceeded $100,000 for any of the last 3 years.\n *\n]\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat stepDefinitions.StepDef_Form.user_validates_the_text_of_question_which_should_be_as_expected(StepDef_Form.java:175)\r\n\tat ✽.And user validates the text of question which should be as expected(MRAForm.feature:15)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "StepDef_Form.user_close_the_browser()"
});
formatter.result({
  "status": "skipped"
});
formatter.background({
  "line": 3,
  "name": "User logs in the BGP Portal",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "user navigates to MRA form page after login",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDef_Form.user_navigates_to_MRA_form_page_after_login()"
});
formatter.result({
  "duration": 32221150500,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Do basic validation for contact details page",
  "description": "",
  "id": "mra-form;do-basic-validation-for-contact-details-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "user navigates to contact details sections",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "user validates Main contact person subsection with inputs",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "user checks that Block House No and Street details auto populates with Valid postal code",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "on clicking checkbox Same as registered address in Company Profile user validates auto population of Mailing address",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "user validates Letter of Offer Addressee subsection with input",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "user validates option for same as main contact person with auto populate",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "user save the form after click on the button",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "user refresh the page",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "user validate the reloaded values",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "user close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "StepDef_Form.user_navigates_to_contact_details_sections_after_sign_in()"
});
formatter.result({
  "duration": 764496900,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_validates_main_contact_person_subsection_with_inputs()"
});
formatter.result({
  "duration": 14220103000,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_checks_that_block_house_no_and_street_details_auto_populates_with_valid_postal_code()"
});
formatter.result({
  "duration": 111292500,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.on_clicking_checkbox_same_as_registered_address_in_company_profile_user_validates_auto_population_of_mailing_address()"
});
formatter.result({
  "duration": 372014400,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_validates_letter_of_offer_addressee_subsection_with_input()"
});
formatter.result({
  "duration": 1565441900,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_validates_option_for_same_as_main_contact_person_with_auto_populate()"
});
formatter.result({
  "duration": 5302911800,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.he_save_the_form_after_click_on_the_button()"
});
formatter.result({
  "duration": 244327500,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_refresh_the_page()"
});
formatter.result({
  "duration": 5116749800,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_validate_the_reloaded_values()"
});
formatter.result({
  "duration": 5501725200,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_close_the_browser()"
});
formatter.result({
  "duration": 2047251400,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "User logs in the BGP Portal",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "user navigates to MRA form page after login",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDef_Form.user_navigates_to_MRA_form_page_after_login()"
});
formatter.result({
  "duration": 33743265900,
  "status": "passed"
});
formatter.scenario({
  "line": 30,
  "name": "To do form submission after giving mandatory details and review",
  "description": "",
  "id": "mra-form;to-do-form-submission-after-giving-mandatory-details-and-review",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 31,
  "name": "user select the answer to each mandatory question",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "user save the form after click on the button",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "user navigates to contact details sections",
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "user validates Main contact person subsection with inputs",
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "user checks that Block House No and Street details auto populates with Valid postal code",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "on clicking checkbox Same as registered address in Company Profile user validates auto population of Mailing address",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "user validates Letter of Offer Addressee subsection with input",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "user validates option for same as main contact person with auto populate",
  "keyword": "And "
});
formatter.step({
  "line": 39,
  "name": "user save the form after click on the button",
  "keyword": "And "
});
formatter.step({
  "line": 40,
  "name": "user fills information in all section but leaves one mandatory information unfilled",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "user saves and click on Review after which user validates the error and validates the page redirected to",
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "user fills all mandatory details and click on Review button in Declare and Review section",
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "user is navigated to read only summary page and he validates the page values",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "user clicks on Consent and Acknowledgement checkbox and he gets a message of submission",
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "user checks if his application is under Processing tab in Grants dashboard",
  "keyword": "And "
});
formatter.step({
  "line": 46,
  "name": "user close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "StepDef_Form.he_select_the_answer_to_each_mandatory_question()"
});
formatter.result({
  "duration": 6374476600,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.he_save_the_form_after_click_on_the_button()"
});
formatter.result({
  "duration": 342556300,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_navigates_to_contact_details_sections_after_sign_in()"
});
formatter.result({
  "duration": 349792400,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_validates_main_contact_person_subsection_with_inputs()"
});
formatter.result({
  "duration": 13597521500,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_checks_that_block_house_no_and_street_details_auto_populates_with_valid_postal_code()"
});
formatter.result({
  "duration": 133068900,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.on_clicking_checkbox_same_as_registered_address_in_company_profile_user_validates_auto_population_of_mailing_address()"
});
formatter.result({
  "duration": 401865500,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_validates_letter_of_offer_addressee_subsection_with_input()"
});
formatter.result({
  "duration": 1610738400,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_validates_option_for_same_as_main_contact_person_with_auto_populate()"
});
formatter.result({
  "duration": 5276053500,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.he_save_the_form_after_click_on_the_button()"
});
formatter.result({
  "duration": 164062300,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_fills_information_in_all_section_but_leaves_one_mandatory_information_unfilled()"
});
formatter.result({
  "duration": 54296966500,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_saves_and_click_on_review_after_which_user_validates_the_error_and_validates_the_page_redirected_to()"
});
formatter.result({
  "duration": 5328454000,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_fills_all_mandatory_details_and_click_on_review_button_in_declare_and_review_section()"
});
formatter.result({
  "duration": 12630123600,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_is_navigated_to_read_only_summary_page_and_he_validates_the_page_values()"
});
formatter.result({
  "duration": 8282568400,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_clicks_on_consent_and_acknowledgement_checkbox_and_he_gets_a_message_of_submission()"
});
formatter.result({
  "duration": 5632044700,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_checks_if_his_application_is_under_processing_tab_in_grants_dashboard()"
});
formatter.result({
  "duration": 29005309500,
  "status": "passed"
});
formatter.match({
  "location": "StepDef_Form.user_close_the_browser()"
});
formatter.result({
  "duration": 1103915300,
  "status": "passed"
});
});