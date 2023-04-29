package app.data.models;

public class Config {
    private String engineTorque;
    private String rollingFrictionForce;
    private String carMass;
    private String brakeCoefficient;
    private String roadDegree;
    private String airResistanceX;
    private String airResistanceY;
    private String airResistanceZ;

    public Config(
        String engineTorque,
        String rollingFrictionForce,
        String carMass,
        String brakeCoefficient,
        String roadDegree,
        String airResistanceX,
        String airResistanceY,
        String airResistanceZ
    ) {
        this.engineTorque = engineTorque;
        this.rollingFrictionForce = rollingFrictionForce;
        this.carMass = carMass;
        this.brakeCoefficient = brakeCoefficient;
        this.roadDegree = roadDegree;
        this.airResistanceX = airResistanceX;
        this.airResistanceY = airResistanceY;
        this.airResistanceZ = airResistanceZ;
    }

    public String getEngineTorque() {
        return engineTorque;
    }

    public String getRollingFrictionForce() {
        return rollingFrictionForce;
    }

    public String getCarMass() {
        return carMass;
    }

    public String getBrakeCoefficient() {
        return brakeCoefficient;
    }

    public String getRoadDegree() {
        return roadDegree;
    }

    public String getAirResistanceX() {
        return airResistanceX;
    }

    public String getAirResistanceY() {
        return airResistanceY;
    }

    public String getAirResistanceZ() {
        return airResistanceZ;
    }
}
