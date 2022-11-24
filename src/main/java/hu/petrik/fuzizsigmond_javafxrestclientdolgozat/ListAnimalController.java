package hu.petrik.fuzizsigmond_javafxrestclientdolgozat;

import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class ListAnimalController extends Controller{

    @FXML
    private Button insertButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button DeleteButton;
    @FXML
    private TableView<Animal> animalTable;
    @FXML
    private TableColumn<Animal, String> nameCol;
    @FXML
    private TableColumn<Animal, Integer> ageCol;
    @FXML
    private TableColumn<Animal, Boolean> birdCol;

    @FXML
    private void initialize(){
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        birdCol.setCellValueFactory(new PropertyValueFactory<>("bird"));
        Platform.runLater(() -> {
            try{
                loadAnimalsFromServer();
            } catch (IOException e){
                error("Couldn't get data from server", e.getMessage());
                Platform.exit();
            }
        });
    }

    private void loadAnimalsFromServer() throws IOException {
        Response response = RequestHandler.get(App.BASE_URL);
        String content = response.getContent();
        Gson converter = new Gson();
        Animal[] animals = converter.fromJson(content, Animal[].class);
       animalTable.getItems().clear();
        for (Animal animal : animals) {
            animalTable.getItems().add(animal);
        }
    }

    public void insertClick(ActionEvent actionEvent) {
    }

    public void updateClick(ActionEvent actionEvent) {
    }

    public void deleteClick(ActionEvent actionEvent) {
    }
}