import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;
import java.util.ArrayList;

public class DictionaryAppController {

    @FXML
    private BorderPane boarderPane;

    @FXML
    private ComboBox<String> searchComboBox;

    @FXML
    private TextField wordTextField;

    @FXML
    private TextField definitionTextField;

    @FXML
    private TextField newDefinitionTextField;

    @FXML
    private Label wordLabel;

    @FXML
    private Label definitionLabel;

    private Dictionary dictionary;
    private ArrayList<String> wordsInDictionary;

    String word;
    String definition;
    String newDefinition;

    boolean closingEventWillExecute = false; // flag for closing event execution

    public void initialize() {
        dictionary = new Dictionary();
        loadFromFile();
        updateWordsInSearchComboBox();
    }

    @FXML
    void SearchComboBoxSelected(ActionEvent event) {
        word = searchComboBox.getValue();
        if (word != null) {
            definition = dictionary.getDefinition(word);
            wordLabel.setText(word);
            definitionLabel.setText(definition);
        }
    }

    @FXML
    void addButtonPressed(ActionEvent event) {
        word = wordTextField.getText();
        definition = definitionTextField.getText();
        wordsInDictionary = dictionary.getWordsFromDictionary();

        // checks that word and definition are not empty and word is not already in dictionary
        if (!isBlank(word) && !isBlank(definition) && !isInDictionary(word)) {
            dictionary.addWord(word, definition);
            updateWordsInSearchComboBox();
        }

        // checks if event has already set to execute on closing event
        if (!closingEventWillExecute) {
            addClosingEvent();
            closingEventWillExecute = true;
        }
    }

    @FXML
    void replaceButtonPressed(ActionEvent event) {
        word = searchComboBox.getValue();
        newDefinition = newDefinitionTextField.getText();

        // checks if a word was selected in search combo-box and new definition is not empty
        if (word!=null && !isBlank(newDefinition)) {
            dictionary.editWord(word, newDefinition); // updates definition of word
            newDefinition = dictionary.getDefinition(word);
            definitionLabel.setText(newDefinition); // updates definition label of word
        }

        // checks if event has already set to execute on closing event
        if (!closingEventWillExecute) {
            addClosingEvent();
            closingEventWillExecute = true;
        }
    }

    @FXML
    void deleteButtonPressed(ActionEvent event) {
        word = searchComboBox.getValue();
        if (word!=null) {
            dictionary.deleteWord(word);
            updateWordsInSearchComboBox();
            // clear display (empty word and definition labels)
            wordLabel.setText("");
            definitionLabel.setText("");
        }

        // checks if event has already set to execute on closing event
        if (!closingEventWillExecute) {
            addClosingEvent();
            closingEventWillExecute = true;
        }
    }

    // updates list of words in dictionary in search combo-box menu
    private void updateWordsInSearchComboBox() {
        searchComboBox.getItems().clear();
        wordsInDictionary = dictionary.getWordsFromDictionary();
        searchComboBox.getItems().addAll(wordsInDictionary);
    }

    // checks if a word is in dictionary
    private boolean isInDictionary(String word) {
        wordsInDictionary = dictionary.getWordsFromDictionary();
        return wordsInDictionary.contains(word);
    }

    // checks if contains only white spaces (amount of non-white characters equals zero)
    private boolean isBlank(String string) {
        return string.trim().length()==0;
    }

    // saves text to a file in current folder
    private void addClosingEvent() {
        Stage stage = (Stage) ((Node) boarderPane).getScene().getWindow();
        stage.getScene().getWindow().addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST,
                windowEvent -> {
                    saveToFile();
                });
    }

    // loads a text file from current source folder in computer
    private void loadFromFile() {
        File file = getFile();
        if (file != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                // checks if loaded file is empty, if so skips loading (prevents an exception)
                // letting user add new words to and save to a file on window closing
                if (bufferedReader.readLine() == null)
                    return;

                // file is not empty, will load content to dictionary window
                FileInputStream fileInput = new FileInputStream(file);
                ObjectInputStream input = new ObjectInputStream(fileInput);
                dictionary = (Dictionary) input.readObject();
                input.close();
                fileInput.close();
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveToFile() {
        File file = getFile();
        try {
            FileOutputStream fileOutput = new FileOutputStream(file);
            ObjectOutputStream output = new ObjectOutputStream(fileOutput);
            output.writeObject(dictionary);
            output.close();
            fileOutput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a File");
        fileChooser.setInitialDirectory(new File("."));
        return fileChooser.showOpenDialog(null);
    }
}
