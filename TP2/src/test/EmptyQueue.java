package test;

public class EmptyQueue extends QueueState {
    @Override
    public boolean isEmpty() {
        return true;
    }
    @Override
    public Object head() {
        emptyQueueError();
        return null;
    }
    @Override
    public int size() {
        return 0;
    }
    @Override
    public QueueState add(Object cargo) {
        return  new NonEmptyQueue(cargo, this);
    }
    @Override
    public Object take() {
        emptyQueueError();
        return null;
    }

    private void emptyQueueError() {
        throw new Error("test.Queue is empty");
    }

}
