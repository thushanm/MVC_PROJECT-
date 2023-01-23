import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DmiInitilize extends Application {
    public static void main(String[] args) {


        launch();

    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("lk/ijse/dmi/view/Login.fxml"))));
primaryStage.setMaximized(false);
primaryStage.setResizable(false);
        primaryStage.show();

    }
}
