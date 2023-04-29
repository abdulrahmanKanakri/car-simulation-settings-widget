package app.data.messaging;

public interface IObservable {
    void add(IObserver o);
    void remove(IObserver o);
    void notifyObservers();
}
