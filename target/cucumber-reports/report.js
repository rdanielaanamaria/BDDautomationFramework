$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/resources/features/SignIn.feature");
formatter.feature({
  "name": "Shopping Automation",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Testing the authentication",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I go to the Website",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.i_go_to_the_Website()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Sign in button",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.i_click_on_Sing_in_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I specify my credentials and click Login",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.i_specify_my_credentials_and_click_Login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I can log into the website",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.i_can_log_into_the_website()"
});
formatter.result({
  "status": "passed"
});
});