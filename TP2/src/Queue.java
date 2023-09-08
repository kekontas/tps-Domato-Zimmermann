import java.util.ArrayList;
import java.util.List;
public class Queue {
  private final List<Object> cargoList = new ArrayList<Object>();
  public boolean isEmpty() {
      return cargoList.isEmpty();
  }

  public Queue add( Object  cargo ) {
      cargoList.add(cargo);
      return this;
  }

  public Object take() {
      isCargoEmpty();
      return cargoList.remove(0);
  }

  private void isCargoEmpty() {
      if (cargoList.isEmpty()) {
          throw new Error("Queue is empty");
        }
    }

  public Object head() {
      isCargoEmpty();
      return cargoList.get(0);
  }

  public int size() {
		return cargoList.size();
  }

}
