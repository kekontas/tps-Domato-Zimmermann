public class Queue {

  public QueueState queue1 = new EmptyQueue();
  public boolean isEmpty() {
      return queue1.isEmpty();
  }

  public Queue add( Object  cargo ) {
      queue1 = queue1.add(cargo);
      return this;
  }

  public Object take() {
      Object info = queue1.head();
      queue1 = (QueueState) queue1.take();

      return info;
  }


  public Object head() { return queue1.head(); }

  public int size() {
		return queue1.size();
  }

}
