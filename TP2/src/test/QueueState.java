package test;

public abstract class  QueueState {
    public Object element;
    public QueueState prevQueue;
    public abstract boolean isEmpty();

    public abstract Object head();


    public abstract int size();

    public abstract QueueState add(Object element);

    public abstract Object take();

}
