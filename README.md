## Cafe Dansa Database Project

A simple application for my Java class (CS143).

### Project Objective:

To create an application for a dance club to keep track of members and
their information.

##### Features:

  - Storing dancers in a database, we allow for users to add, edit, delete,
    search, and print dancers from the club.
  - Dancers may be listed in alphabetical order by last name or first name.
  - Dancers may be listed in descending order of experience in years.
  - Changes to the database are dynamic in nature, so Dancers that are
    deleted do not reappear when the application is restarted.
  - Both the GUI an individual's information may be printed, by the file
    menu and the print button respectively.
  - Splash screen is displayed on start-up.
  - If a duplicate dancer is added to the database the action will be
    prevented and the user will be notified without crashing the program.
  - While editing a dancer, if their information is changed to match a
    different dancer whom exists in the database then the dancer is not
    edited and the user is notified without the program crashing.
  - Fields from editing and adding Dancers are validated with regular
    expressions.
  - Dancer must have 2-3 (Capitalized) parts of their name to have valid
    names.

##### Notes:

  - The class which adheres most rigorously to Java style standards is
    Dancer.java
  - This code is protected under GPL 3.0
