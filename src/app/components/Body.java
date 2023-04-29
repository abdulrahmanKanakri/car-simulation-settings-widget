package app.components;

import app.data.models.Config;
import app.data.messaging.CarValuesObservable;
import app.data.messaging.IObserver;
import app.data.repositories.ConfigRepoImpl;
import app.data.repositories.IConfigRepo;
import app.data.models.CarValues;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Body implements IObserver {

    private final IConfigRepo configRepo;
    private final Config config;
    private final CarValuesObservable carValuesObservable;

    private Text textVelocityValue;
    private Text textAccelerationValue;

    public Body(CarValuesObservable carValuesObservable) {
        this.configRepo = new ConfigRepoImpl();
        this.config = this.configRepo.getConfigData();
        this.carValuesObservable = carValuesObservable;
    }

    public GridPane getAppBodyAsGridPane() {

        // EngineTorque
        Text textEngineTorque = new Text("Engine Torque");
        TextField textFieldEngineTorque = new TextField(config.getEngineTorque());

        // RollingFrictionForce
        Text textRollingFrictionForce = new Text("Rolling Friction Force");
        TextField textFieldRollingFrictionForce = new TextField(config.getRollingFrictionForce());

        // CarMass
        Text textCarMass = new Text("Car Mass");
        TextField textFieldCarMass = new TextField(config.getCarMass());

        // BrakeCoefficient
        Text textBrakeCoefficient = new Text("Brake Coefficient");
        TextField textFieldBrakeCoefficient = new TextField(config.getBrakeCoefficient());

        // RoadDegree
        Text textRoadDegree = new Text("Road Degree");
        TextField textFieldRoadDegree = new TextField(config.getRoadDegree());

        // AirResistanceX
        Text textAirResistanceX = new Text("Air Resistance X");
        TextField textFieldAirResistanceX = new TextField(config.getAirResistanceX());

        // AirResistanceY
        Text textAirResistanceY = new Text("Air Resistance Y");
        TextField textFieldAirResistanceY = new TextField(config.getAirResistanceY());

        // AirResistanceZ
        Text textAirResistanceZ = new Text("Air Resistance Z");
        TextField textFieldAirResistanceZ = new TextField(config.getAirResistanceZ());

        //Creating Button
        Button submit = new Button("Update Values");
        submit.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        submit.setOnAction(event -> {
            this.configRepo.setConfigData(new Config(
                textFieldEngineTorque.getText(),
                textFieldRollingFrictionForce.getText(),
                textFieldCarMass.getText(),
                textFieldBrakeCoefficient.getText(),
                textFieldRoadDegree.getText(),
                textFieldAirResistanceX.getText(),
                textFieldAirResistanceY.getText(),
                textFieldAirResistanceZ.getText()
            ));
            // Show success alert
            new Alert(Alert.AlertType.NONE, "Config Successfully updated", ButtonType.OK).show();
        });

        //Creating a Grid Pane
        GridPane gridPane = new GridPane();

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //Arranging all the nodes in the grid
        gridPane.add(textEngineTorque, 0, 0);
        gridPane.add(textFieldEngineTorque, 1, 0);

        gridPane.add(textRollingFrictionForce, 0, 1);
        gridPane.add(textFieldRollingFrictionForce, 1, 1);

        gridPane.add(textCarMass, 0, 2);
        gridPane.add(textFieldCarMass, 1, 2);

        gridPane.add(textBrakeCoefficient, 0, 3);
        gridPane.add(textFieldBrakeCoefficient, 1, 3);

        gridPane.add(textRoadDegree, 0, 4);
        gridPane.add(textFieldRoadDegree, 1, 4);

        gridPane.add(textAirResistanceX, 0, 5);
        gridPane.add(textFieldAirResistanceX, 1, 5);

        gridPane.add(textAirResistanceY, 0, 6);
        gridPane.add(textFieldAirResistanceY, 1, 6);

        gridPane.add(textAirResistanceZ, 0, 7);
        gridPane.add(textFieldAirResistanceZ, 1, 7);

        gridPane.add(submit, 0, 8, 3, 1);
        GridPane.setMargin(submit, new Insets(8, 0, 20, 0));

        // Display car values //

        // Car Velocity
        Text textVelocity = new Text("Velocity");
        this.textVelocityValue = new Text("0");

        // Car Acceleration
        Text textAcceleration = new Text("Acceleration");
        this.textAccelerationValue = new Text("0");

        gridPane.add(textVelocity, 0, 9);
        gridPane.add(this.textVelocityValue, 1, 9);

        gridPane.add(textAcceleration, 0, 10);
        gridPane.add(this.textAccelerationValue, 1, 10);

        return gridPane;
    }

    @Override
    public void update() {
        CarValues carValues = this.carValuesObservable.getCarValues();
        this.textAccelerationValue.setText(Float.toString(carValues.getAcceleration()));
        this.textVelocityValue.setText(Float.toString(carValues.getVelocity()));
    }
}
