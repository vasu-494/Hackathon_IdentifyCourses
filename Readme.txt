Problem Statement : Identify Courses
 
Search and display all web development courses 
1. Should be for beginners level.
2. Courses offered in English language
3. Display first two courses with name, total learning hours and rating.
(Suggested Site: coursera.org however  you are free to choose any other legitimate  site)
 
 
Detailed Description:
 
1. Search for web development courses for Beginners level & English Language and extract the course names, total learning hours & rating for first 2 courses
2. Look for Language Learning; Extract all the languages and different levels with its total count & display them
3. In Home page, go to "For Enterprise"; Look into Courses for Campus under Product; Fill the  "Ready to transform" form with any one input invalid (example: email); Capture the error message & display
(Suggested Site: coursera.org however  you are free to choose any other legitimate  site)
 
 
Key Automation Scope
 
Handling different browser windows, search option
Extract multiple drop down list items & store in collections
Navigating back to home page
Filling form (in different objects in web page)
Capture warning message
Scrolling down in web page
 
 
*********************************STEPS TO EXECUTE*********************************
 
-> unzip the folder
-> On eclipse, goto file-> import-> select maven-> click on existing maven project->next-> browse the location where u unzip the folder-> click on finish
-> Now go to the testng.xml file and run as TestNGSuite.
-> Now the file will Execute and we get the expected output as shown below.
-> Now go to TestRunner.java file and run as JUnit test.
-> Now the file will Execute in Cucumber and we get the expected output as shown below.
 
 
*********************************FILES DESCRIPTION*********************************

1. src/test/java - There are 8 packages present in this folder.
 
-> pageobject : Page Object containing different class contains which are BasePage, Module1, Module2, Module3, Module3_1
 
-> test_base:In this package we have BaseClass.java is our main project file in which we Firstly invoke the selected browser and generate the report file in html format and store it in report opening Coursera website [Cousera](https://www.coursera.org/) and closing the browser
 
-> test_cases:In this package we have TC001, TC002, TC003 java files which extends baseClass.java where the methods are present which will login to the page and verify and validate all the testCases.
 
-> utilities: In the utilities package all the read, write work of and extent report work is done.
-> TestRunner : In this package we have TestRunner.java file where we include feature file path and cucumber plugins to generate cucumber report.
 
-> Cucumber.Step : This package contains StepsDefinition.java which contains the testSteps to execute the project in Cucumber and Hooks.java contains the driver setup , screenshots and Closing the browser.
 
-> Factory : In this package we have CucumberBaseClass.java file in which we invoke the browser initialization, we also added logger and properties method to include logs and access config.properties file.
 
-> IdentifyCourse : This package contains the selenium file of the project
 
 
2. src/test/resources- In this folder, there are three files
->  config.properties  : This file is used to store the reusable values such as apprl,browser name and os name.
->  log4j2.xml  : This file is used to generate log informations about the execution of test cases.
->  extent.properties  : This file is used to generate the extentReport for the execution in cucumber framework.

3. JRE System Library: In this File we have all dependencies of JAR.files.         

4. Maven Dependencies: In this File we have all the directory on the local machine, where all the project artifacts are stored. When a Maven build is executed, Maven automatically downloads all the dependency jars into the local repository. Usually, this directory is named.

5. Report: In this folder the Test-Report-YYYY.MM.DD.html is present which is the report of the project

6. ScreenShots : There are 9 images, 1 clickcourse.png, 2 clickenterprises.png, 3 clicking.png, 4 clickoffer.png, 5 course1.png, 6 course2.png, 7 fillForm.png, 8 getLangLvl.png, 9 searching.png
 
7. src: In this, there are two folders
	-main:It is an empty folder
	-test:It is an empty folder
8. target: It is an empty folder
 
9. Feature Files : In this folder we have all the feature files with .feature extension which needs to be invoked while excuting the project in cucumber framework.

10. Logs : In this folder logs are present which is generated while executing the project.
 
11. TestData : In this folder we have two files
	-Read  : In this excel file all the data which need to be passed to required WebElements are stored.
	-Write  : After the execution of project the result will be stored.
12. pom.xml: The pom.xml file contains information of project and configuration information for the maven to build the project such as dependencies,build directory, source directory, test source directory, plugin, goals etc. Maven reads the pom.xml file, then executes the goal.
 
13. Mastertestng.xml : this file contain suit from where the compilation of project begins.

 
*********************************OUTPUT*********************************
 
***TestNG***
 
RemoteTestNG] detected TestNG version 7.9.0
SLF4J(W): No SLF4J providers were found.
SLF4J(W): Defaulting to no-operation (NOP) logger implementation
SLF4J(W): See https://www.slf4j.org/codes.html#noProviders for further details.

Module 1 : Search for web development courses for Beginners level & English Language and extract the course names, total learning hours & rating for first 2 courses

COURSES:
********

Meta Front-End Developer
Rating: 4.7
7 months at 6 hours a week
Introduction to Web Development
4.7
Approx. 21 hours to complete

****************************************************
Module 2 : Look for Language Learning; Extract all the languages and different levels with its total count & display them

LANGUAGES:
**********

Total number of languages available: 24
English (1,645)
Spanish (1,101)
Arabic (1,012)
French (997)
Chinese (China) (993)
Portuguese (Brazil) (988)
German (977)
Indonesian (976)
Hindi (972)
Italian (971)
Swedish (970)
Dutch (969)
Greek (969)
Polish (969)
Thai (969)
Turkish (969)
Ukrainian (969)
Russian (946)
Kazakh (894)
Hungarian (697)
Japanese (90)
Korean (88)
Chinese (Traditional) (5)
Hebrew (2)

****************************************************
LEVEL:

Total number of level available: 4
Beginner (884)
Intermediate (779)
Advanced (80)
Mixed (149)

****************************************************

Module 3 : In Home page, go to "For Enterprise"; Look into Courses for Campus under Product; Fill the  "Ready to transform" form with any one input invalid (example: email); Capture the error message & display

ERROR MESSAGE:
***************

Must be valid email.
example@yourdomain.com

Must be valid email.
example@yourdomain.com

Must be valid email.
example@yourdomain.com

Must be valid email.
example@yourdomain.com

Must be valid email.
example@yourdomain.com

Must be valid email.
example@yourdomain.com

===============================================
Suite
Total tests run: 24, Passes: 24, Failures: 0, Skips: 0
===============================================


***Cucumber***
 

Scenario: Web Development Courses Search      # features/C1_WebDevelopmentCourseStep.feature:3
  Given User navigates to Coursera Home Page  # stepDefinition.WebDevelopmentCoursesStep.user_navigates_to_coursera_home_page()

    Embedding Web Development Courses Search [image/png 179566 bytes]

  When the user clicks on the search bar      # stepDefinition.WebDevelopmentCoursesStep.the_user_clicks_on_the_search_bar()

    Embedding Web Development Courses Search [image/png 457335 bytes]

  And the user selects the language and level # stepDefinition.WebDevelopmentCoursesStep.the_user_selects_the_language_and_level()

    Embedding Web Development Courses Search [image/png 97980 bytes]

  Then verify details of the first course     # stepDefinition.WebDevelopmentCoursesStep.verify_details_of_the_first_course()

    Embedding Web Development Courses Search [image/png 653676 bytes]

  And verify details of the second course     # stepDefinition.WebDevelopmentCoursesStep.verify_details_of_the_second_course()

    Embedding Web Development Courses Search [image/png 649829 bytes]


Scenario: Display the language and level         # features/C2_LanguageLearningStep.feature:3
  Given user navigates to the coursera home page # stepDefinition.LanguageLearningStep.user_navigates_to_the_coursera_home_page()

    Embedding Display the language and level [image/png 252362 bytes]

  When the user clicks on languages show more    # stepDefinition.LanguageLearningStep.the_user_clicks_on_languages_show_more()

    Embedding Display the language and level [image/png 153267 bytes]

  Then gets the languages count and languages    # stepDefinition.LanguageLearningStep.gets_the_languages_count_and_languages()

    Embedding Display the language and level [image/png 563900 bytes]

  And get the levels count and levels            # stepDefinition.LanguageLearningStep.get_the_levels_count_and_levels()

    Embedding Display the language and level [image/png 563900 bytes]


Scenario: Fill the Ready To Transform form      # features/C3_ReadyToTransformStep.feature:3
  Given user navigate to the coursera home page # stepDefinition.ReadyToTransformStep.user_navigate_to_the_coursera_home_page()

    Embedding Fill the Ready To Transform form [image/png 307430 bytes]

  When user clicks on For Enterprise page       # stepDefinition.ReadyToTransformStep.user_clicks_on_for_enterprise_page()

    Embedding Fill the Ready To Transform form [image/png 413539 bytes]

  And user clicks on What We Offer page         # stepDefinition.ReadyToTransformStep.user_clicks_on_what_we_offer_page()

    Embedding Fill the Ready To Transform form [image/png 232287 bytes]

  And user clicks on Coursera for Campus        # stepDefinition.ReadyToTransformStep.user_clicks_on_coursera_for_campus()

    Embedding Fill the Ready To Transform form [image/png 814121 bytes]

  And scrolls to the form                       # stepDefinition.ReadyToTransformStep.scrolls_to_the_form()

    Embedding Fill the Ready To Transform form [image/png 98579 bytes]

  Then enters the details in the form           # stepDefinition.ReadyToTransformStep.enters_the_details_in_the_form()

    Embedding Fill the Ready To Transform form [image/png 122973 bytes]

  And captures the error message                # stepDefinition.ReadyToTransformStep.captures_the_error_message()

    Embedding Fill the Ready To Transform form [image/png 122239 bytes]

┌──────────────────────────────────────────────────────────────────────────┐
│ View your Cucumber Report at:                                            │
│ https://reports.cucumber.io/reports/55081cb5-f949-403e-b0b6-39af8ed5a8af │
│                                                                          │
│ This report will self-destruct in 24h.                                   │
│ Keep reports forever: https://reports.cucumber.io/profile                │
└──────────────────────────────────────────────────────────────────────────┘