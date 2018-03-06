# beercalc
Simple Java app to log ingredients and generate an all grain beer recipe

Recipe.txt holds the finale text of your recipe

beerButton creates the buttons seen at the bottom and gives them action listeners

beerButtonTop creates the clear button and gives it an action listener

beerCalc creates the beerGui and organizes its layout. Contains the main method

beerGui creates and organizes the panels and tables of this application. it creates a top and bottom panel and adds buttons plus user inputs

beerPanel creates the user input and labels. allows beerGui to get information through methods

beerPanelTop gives the restricted list and label for batch size

beerTable makes the actual table. This initializes a JTable with no initial rows and column headers. Allows adding to the table. converts all grains to pounds and returns total lbs of grains. returns a string of all grain names. Returns a string of all hop names.
