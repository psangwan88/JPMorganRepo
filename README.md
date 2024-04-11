Project for mentioned requirement
Currently parallel execution is enabled, can be disabled from TestRunner file
configurations are mentioned in config file, tested browsers are firefox and chrome

Configuration
url = https://www.theguardian.com/tone/news    ----- URL for page 
browser = firefox ------ Browser to be used values chrome, firefox
headless = true ------ if we want to run in headless mode or not, true, false
waittime = 10 -------- implicit wait time, for testing its set to 10 for now
#to get screenshot after every step, unless debugging issue keep this false
debug = false  ------ if any scenario fails and we want to debug it, this feature captures screenshots at every step



Reporting :
Default cucumber html report is used
We can use extentReport, allure report etc if we need
Currently screenshots are part of report only but if project size grows we need to keep them separate else html file size will increase
Tried to create a csv file which will mark all test cases with status and we can use to send it in emails/slack notification --- WAS incomplete hence removed


Features :
Single feature file is used with both positive and negative scenarios
Step Defs are written for 2 pages only
Currently in same page redirecting to google to check, we can use, browser tabs also if needed for this purpose

Variables
constants and static variables are taken as part of interface only
Enum for supported browsers is created but not used
TestContextLib is used to keep all details separate for parallel runs as well as carrying data between steps
Base class for now have common methods only, we can use either hooks or base class , here we have both if needed one can be removed



