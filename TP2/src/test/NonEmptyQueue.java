package test;

public class NonEmptyQueue extends QueueState {
    NonEmptyQueue(Object element, QueueState prevQueue) {
        this.element = element;
        this.prevQueue = prevQueue;
    }
    @Override
    public boolean isEmpty() {
        return false;
    }
    @Override
    public Object head() { return this.element; }
    @Override
    public int size() {
        return 1 + prevQueue.size();
    }
    @Override
    public QueueState add(Object cargo) {

        return new NonEmptyQueue(element, prevQueue.add(cargo));
    }
    @Override
    public Object take() {
        return this.prevQueue;
    }

}
