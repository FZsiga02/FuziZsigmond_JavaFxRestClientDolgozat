package hu.petrik.fuzizsigmond_javafxrestclientdolgozat;

import javafx.event.ActionEvent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateAnimalController extends Controller{

    @FXML
    private TextField nameField;
    @FXML
    private Spinner<Integer> ageField;
    @FXML
    private CheckBox isBird;
    @FXML
    private Button updateButton;

    private Animal animal;

    public void setAnimal(Animal animal) {
        this.animal = animal;
        nameField.setText(this.animal.getName());
        ageField.getValueFactory().setValue(this.animal.getAge());
        isBird.setIndeterminate(this.isBird.isSelected());
    }

    @FXML
    private void initialize() {
        SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50, 10);
        ageField.setValueFactory(valueFactory);
    }

    public void updateClick(ActionEvent actionEvent) {
        String name = nameField.getText().trim();
        int age = ageField.getValue();
        boolean bird = isBird.isSelected();
        if (name.isEmpty()) {
            warning("Name is required");
            return;
        }
        this.animal.setName(name);
        this.animal.setAge(age);
        this.animal.setBird(bird);
        Gson converter = new Gson();
        String json = converter.toJson(this.animal);
        try {
            String url = App.BASE_URL + "/" + this.animal.getId();
            Response response = RequestHandler.put(url, json);
            if (response.getResponseCode() == 200) {
                Stage stage = (Stage) this.updateButton.getScene().getWindow();
                stage.close();
            } else {
                String content = response.getContent();
                error(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
