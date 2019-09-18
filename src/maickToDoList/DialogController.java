package maickToDoList;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import maickToDoList.datamodel.TodoData;
import maickToDoList.datamodel.TodoItem;

import java.time.LocalDate;

public class DialogController {

    @FXML
    private TextArea detailsArea;
    @FXML
    private TextField shortDescriptionField;
    @FXML
    private DatePicker deadLinePicker;

    public TodoItem processResults() {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadLinePicker.getValue();

        TodoItem newItem = new TodoItem(shortDescription, details, deadlineValue);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }
}
