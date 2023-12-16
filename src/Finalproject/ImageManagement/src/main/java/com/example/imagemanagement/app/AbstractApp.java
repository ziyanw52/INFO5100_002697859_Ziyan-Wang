package com.example.imagemanagement.app;

import com.example.imagemanagement.model.ImageInfo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * basic class for javafx application
 */
public class AbstractApp extends Application {
    public static ImageInfo currentInfo;
    public static Stage mainStage;
    // resource fxml file
    protected String resource;
    // stage name
    protected String stageName;
    protected Stage stage;

    /**
     * app constructor
     * @param resource
     * @param stageName
     */
    public AbstractApp(String resource, String stageName) {
        this.resource = resource;
        this.stageName = stageName;

        this.stage = new Stage();
    }

    /**
     * show current stage and add it to session
     * @throws Exception
     */
    public void show() throws Exception {
        start(stage);
    }

    /**
     * override start method, load resource file and start
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(resource));
        primaryStage.setTitle(stageName);
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
