package easygraph.controller;

import javafx.fxml.FXML;

public class EditorViewController extends BaseViewController {
	
	//@FXML
	//private Label firstNameLabel;


	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public EditorViewController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}


	/**
	 * Fills all text fields to show details about the person. If the specified
	 * person is null, all text fields are cleared.
	 * 
	 * @param person
	 *            the person or null
	 *
	private void showPersonDetails(Person person) {
		if (person != null) {
			// Fill the labels with info from the person object.
			firstNameLabel.setText(person.getFirstName());
			lastNameLabel.setText(person.getLastName());
			streetLabel.setText(person.getStreet());
			postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
			cityLabel.setText(person.getCity());
			birthdayLabel.setText(DateUtil.format(person.getBirthday()));
		} else {
			// Person is null, remove all the text.
			firstNameLabel.setText("");
			lastNameLabel.setText("");
			streetLabel.setText("");
			postalCodeLabel.setText("");
			cityLabel.setText("");
			birthdayLabel.setText("");
		}
	}
	
	/**
	 * Called when the user clicks on the delete button.
	 *
	@FXML
	private void handleDeletePerson() {
	    int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
	    if (selectedIndex >= 0) {
	        personTable.getItems().remove(selectedIndex);
	    } else {
	        // Nothing selected.
	        Dialogs.create()
	            .title("No Selection")
	            .masthead("No Person Selected")
	            .message("Please select a person in the table.")
	            .showWarning();
	    }
	}
	
	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new person.
	 *
	@FXML
	private void handleNewPerson() {
	    Person tempPerson = new Person();
	    boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
	    if (okClicked) {
	        mainApp.getPersonData().add(tempPerson);
	    }
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 *
	@FXML
	private void handleEditPerson() {
	    Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
	    if (selectedPerson != null) {
	        boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
	        if (okClicked) {
	            showPersonDetails(selectedPerson);
	        }

	    } else {
	        // Nothing selected.
	        Dialogs.create()
	            .title("No Selection")
	            .masthead("No Person Selected")
	            .message("Please select a person in the table.")
	            .showWarning();
	    }
	}
	*/
}