# README for javafx-pass-data-demo
**javafx-pass-data-demo** is a demonstration of how to pass data from one JavaFX controller to another.  This is useful if your scene graph is composed of more than one FXML file.  The graphics are purposely very fundamental.

## Intro
**javafx-pass-data-demo** uses three FXML files, two inside the other. `PassDataDemo` loads these three files, then sets the controller factory of the main pane so that the correct controller will be called when focus is in one of the other two scene graphs.  The class `DataHolder` is a JavaFX bean that contains a name string and property.  It is injected into the two controllers and provides a bridge between them.  This bridge is used to bind the text properties of the text field in one controller to the label in the other.

## Requirements

* Java 11.0.6
* Maven 3.6.1

Lower requirements may work but haven't been tested.

## Build and Execute

To build, from the command line, type

    mvn clean compile

To execute, type

    mvn javafx:run
    
Tested on Ubuntu 19.10 and Windows 10 1909
    
## What to notice
Launch the app, enter a name into the text field, and press the Ok button.  The name appears in a label above the separator.  This would be unremarkable except that the area above and below the separator are controlled by different controllers.

## Bugs, improvements
Fork the repository and submit a pull request, or email knute (at) snortum (dot) net.