package app;

import app.components.Body;
import app.data.messaging.CarValuesObservable;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import app.data.socket.Server;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        CarValuesObservable observable = new CarValuesObservable();
        Body body = new Body(observable);
        observable.add(body);

        // Start the app
        GridPane gridPane = body.getAppBodyAsGridPane();
        Scene scene = new Scene(gridPane,240, 400);
        primaryStage.setTitle("Settings");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        // Server
        Task<Void> task = new Task<>() {
            @Override
            protected Void call() {
                Server server;
                try {
//                    server = new Server(5000, InetAddress.getByName("192.168.43.92"), observable);
                    server = new Server(5000, InetAddress.getByName("127.0.0.1"), observable);
                    server.run();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

        new Thread(task).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
