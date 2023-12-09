Feature: myfeature

Scenario: iths.se should show the correct title
Given IT - Högskolan is available
When User visits IT - Högskolan
Then The title should be "IT-Högskolan – Här startar din IT-karriär!"


Scenario: iths.se should show the correct background image
Given IT - Högskolan is available
When User visits IT - Högskolan
Then The correct background image is "/html/body/section[1]/div[2]/div/div[1]/div"

Scenario: iths.se should show the correct background image
Given IT - Högskolan is available
When User visits IT - Högskolan
Then The correct front page logo is "//*[@id=\"logo\"]"

Scenario: iths.se should show the correct front page heading
Given IT - Högskolan is available
When User visits IT - Högskolan
Then The front page heading should be "Här startar din IT-karriär!"

Scenario: iths.se should show the correct front page preheader
Given IT - Högskolan is available
When User visits IT - Högskolan
Then The front page preheader should be "VÄLKOMMEN TILL IT-HÖGSKOLAN"

Scenario: iths.se should show the start page logo
Given IT - Högskolan is available
When User visits IT - Högskolan
Then The start page logo should be should be ""brand""

Scenario: iths.se should show the correct footer
Given IT - Högskolan is available
When User visits IT - Högskolan
Then the footer should be "footer"

Scenario: iths.se should show the correct element
Given IT - Högskolan is available
When User visits IT - Högskolan
Then the element should be "nav-liafrfretag"

Scenario: iths.se should show the correct element by css selector
Given IT - Högskolan is available
When User visits IT - Högskolan
Then The site should "#nav-nyheter"

Scenario: iths.se should click on menu kontakt
Given IT - Högskolan is available
When User visits IT - Högskolan
Then The menu kontakt should be clicked and show  "Kontakt IT-Högskolan"


Scenario: iths.se should click on OnMenuStudentPortal
Given IT - Högskolan is available
When User visits IT - Högskolan
Then The menu StudentPortal "//*[@id=\"nav-studentportaliclassfarfasigninalti\"]"

Scenario: iths.se should click on any course
Given IT - Högskolan is available
When User visits IT - Högskolan
Then The any course should be clicked and show  //*[@id=\"nav-utbildningar\"]/a","//*[@id=\"search-filter-results-4749\"]/div/div[1]/div/div[1]/h2/a/span","//*[@id=\"logo\"]"

