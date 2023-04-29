package app.data.messaging;

import app.data.models.CarValues;
import java.util.ArrayList;
import java.util.List;

public class CarValuesObservable implements IObservable {
    private final List<IObserver> observers = new ArrayList<>();
    private CarValues carValues;

    @Override
    public void add(IObserver o) {
        this.observers.add(o);
    }

    @Override
    public void remove(IObserver o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(IObserver o : observers) {
            o.update();
        }
    }

    public CarValues getCarValues() {
        return this.carValues;
    }

    public void setCarValues(CarValues carValues) {
        this.carValues = carValues;
    }
}
