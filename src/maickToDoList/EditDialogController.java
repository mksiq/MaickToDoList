package maickToDoList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import maickToDoList.datamodel.TodoData;
import maickToDoList.datamodel.TodoItem;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EditDialogController implements Initializable {



        @FXML
        private TextArea detailsArea;
        @FXML
        private TextField shortDescriptionField;
        @FXML
        private DatePicker deadLinePicker;
        TodoItem itemController;


    public void setDetailsArea(String details) {
        this.detailsArea.setText(details);
    }

    public void setShortDescriptionField(String shortDescriptionField) {
        this.shortDescriptionField.setText(shortDescriptionField);
    }

    public void setDeadLinePicker(LocalDate date) {
        this.deadLinePicker.setValue(date);
    }

    public TodoItem processResults(TodoItem item) {
            String shortDescription = shortDescriptionField.getText().trim();
            String details = detailsArea.getText().trim();
            LocalDate deadlineValue = deadLinePicker.getValue();


            TodoItem newItem = new TodoItem(shortDescription, details, deadlineValue);
            TodoData.getInstance().addTodoItem(newItem);
            return newItem;
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
