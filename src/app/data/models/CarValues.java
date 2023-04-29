package app.data.models;

public class CarValues {

    private float velocity;
    private float acceleration;

    public CarValues(float velocity, float acceleration) {
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    public float getVelocity() {
        return velocity;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }
}
