package app.data.socket;

import app.data.messaging.CarValuesObservable;
import app.data.models.CarValues;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.*;
import java.io.*;

public class Server {

    private final int port;
    private final InetAddress address;
    private final CarValuesObservable carValuesObservable;

    public Server(int port, InetAddress address, CarValuesObservable carValuesObservable) {
        this.port = port;
        this.address = address;
        this.carValuesObservable = carValuesObservable;
    }
    public void run() {
        Socket socket;
        ServerSocket server;
        DataInputStream input;

        try {
            server = new ServerSocket(this.port, 1, this.address);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
            socket = server.accept();
            System.out.println("Client accepted");
            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";
            while (!line.equals("Over")) {
                try {
                    line = input.readUTF();

                    GsonBuilder gsonBuilder = new GsonBuilder();
                    Gson gson = gsonBuilder.create();
                    CarValues carValues = gson.fromJson(line, CarValues.class);

                    // Notify observers
                    this.carValuesObservable.setCarValues(carValues);
                    this.carValuesObservable.notifyObservers();

                    System.out.println(line);

                } catch(IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
            System.out.println("Closing connection");
            socket.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
