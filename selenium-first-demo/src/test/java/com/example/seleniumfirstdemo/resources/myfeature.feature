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

Scenario: iths.se should navigate forward
Given IT - Högskolan is available
When User visits IT - Högskolan
Then the site should navigate forward

Scenario: iths.se should navigate back
Given IT - Högskolan is available
When User visits IT - Högskolan
Then the site should navigate back

Scenario: iths.se should refresh
Given IT - Högskolan is available
When User visits IT - Högskolan
Then The site should refresh

Scenario: iths.se should show the start page banner image
Given IT - Högskolan is available
When User visits IT - Högskolan
Then The start page logo should be should be "/html/body/section[1]/div[2]/div/div[2]/div[1]/div/div/a/div/div[1]"
