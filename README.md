Assignment 1
Glen Shaw (27859511)
CEJV 669 2164


This application displays facts.

  The user will be able to select a fact that is completely random or random within category.

Choice of 4 categories of facts
 For each category has 5 facts, one or a couple of sentences long.

There are 4 imageButoons, 1 for each category,
A button for Random and and a button for Last
    6 Buttons in total.

All data are defined in the resources directory.

The main UI has 6 buttons, a counter for runtime and my name.

Each category Button will has an appropriate listener onClick method to create an Intent
 and to invoke the appropriate Activity to display the fact.
    This will also increment a counter that is shown on the Main UI.
    This also saves and restores the state of the TextView, so that you don’t lose it on rotate.

The Last Button onClick listener method creates an intent and invokes an appropriate Activity to display the fact
 if there is one saved in SharedPreferences, otherwise it will pop up a toast saying "Nothing Saved”

The Random button onClick listener method creates an intent and invokes an appropriate Activity to
  choose a fact randomly across all categories and display's it.

The Activity(ies) for the category buttons select a random fact within it’s category
 then display's the fact.
 Text is largish.
  so that it displays nicely, use styles, make it look nice, maybe some colour.
    Ensure that it is displayed on rotate.

App saves the last fact chosen in the shared preferences.

Uses the following components of the Android Framework

•Activities
•Intents
•Resources such as strings, layouts etc.
•Instance State: Maintaining UI state
•Shared Preferences: Maintaining information between runtimes

•Main Activity UI
•One Activity & UI for each category  that displays the fact.
•One Activity & UI for the Last fact from the last run.
•One Activity & UI for the Random fact chosen randomly from all categories together.
•For all but the Main Activity you can use the same layout or have a different layout for each one.
•Twenty facts in total
◦Choose 5 facts (strings) for each category for example from wikipedia


Optional Components
•Use ImageButtons instead of Buttons (for categoriess only or for all buttons)
•Have an image in drawable associated either with each category or with each fact and display it with the fact
•Have the a word in the fact be a link to the source (url)

Submission

Due Date: February 22 2017,
before that date submit the ssh url of your private git repository via moodle.
User campbe13 must be a developer on your repository host - github.

All images are copyrighted 2017 www.GlenShaw.ca
All facts are from wikipedia.