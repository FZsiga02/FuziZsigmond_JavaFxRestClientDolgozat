package hu.petrik.fuzizsigmond_javafxrestclientdolgozat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class CreateAnimalController extends Controller{

    @FXML
    private TextField nameField;
    @FXML
    private Spinner<Integer> ageField;
    @FXML
    private CheckBox isBird;
    @FXML
    private Button submitButton;

    @FXML
    private void initialize() {
        SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 200, 30);
        ageField.setValueFactory(valueFactory);
    }

    public void submitClick(ActionEvent actionEvent) {
        String name = nameField.getText().trim();
        int age = ageField.getValue();
        boolean bird = isBird.isSelected();
        if (name.isEmpty()) {
            warning("Name is required");
            return;
        }
        Animal newAnimal = new Animal(0, name, age, bird);
        Gson converter = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json = converter.toJson(newAnimal);
        try {
            Response response = RequestHandler.post(App.BASE_URL, json);
            if (response.getResponseCode() == 201) {
                warning("Pet added!");
                nameField.setText("");
                ageField.getValueFactory().setValue(30);
            } else {
                String content = response.getContent();
                error(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
