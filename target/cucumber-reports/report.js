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
formatter.step({
  "name": "I go to the Website",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.i_go_to_the_Website()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat automation.drivers.strategies.DriverStrategyImplementer.chooseStrategy(DriverStrategyImplementer.java:7)\r\n\tat automation.drivers.DriverSingleton.instantiate(DriverSingleton.java:16)\r\n\tat automation.drivers.DriverSingleton.\u003cinit\u003e(DriverSingleton.java:13)\r\n\tat automation.drivers.DriverSingleton.getInstance(DriverSingleton.java:26)\r\n\tat automation.glue.StepDefinition.i_go_to_the_Website(StepDefinition.java:45)\r\n\tat ✽.I go to the Website(src/main/resources/features/SignIn.feature:3)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "I click on Sign in button",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.i_click_on_Sing_in_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I specify my credentials and click Login",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.i_specify_my_credentials_and_click_Login()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I can log into the website",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.i_can_log_into_the_website()"
});
formatter.result({
  "status": "skipped"
});
});