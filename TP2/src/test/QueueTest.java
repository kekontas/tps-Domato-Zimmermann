package test;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QueueTest {

  @Test
  public void test01QueueShouldBeEmptyWhenCreated() {
    assertTrue(new Queue().isEmpty());
  }

  @Test
  public void test02AddElementsToTheQueue() {
    assertFalse(new Queue().add("Something").isEmpty());
  }

  @Test
  public void test03AddedElementsIsAtHead() {
    Queue queue = new Queue().add("Something");
    assertEquals("Something", queue.head());
  }

  @Test
  public void test04TakeRemovesElementsFromTheQueue() {
    Queue queue = new Queue().add("Something");
    queue.take();
    assertTrue(queue.isEmpty());
  }

  @Test
  public void test05TakeReturnsLastAddedObject() {
    Queue queue = new Queue();
    String addedObject = "Something";
    queue.add(addedObject);
    assertEquals(addedObject, queue.take());
  }

  @Test
  public void test06QueueBehavesFIFO() {
    Queue queue = new Queue();
    String firstAddedObject = "First";
    String secondAddedObject = "Second";
    queue.add(firstAddedObject);
    queue.add(secondAddedObject);
    assertEquals(firstAddedObject, queue.take());
    assertEquals(secondAddedObject, queue.take());
    assertTrue(queue.isEmpty());
  }

  @Test
  public void test07HeadReturnsFirstAddedObject() {
    Queue queue = new Queue();
    String firstAddedObject = "First";
    queue.add(firstAddedObject);
    queue.add("Second");
    assertEquals(firstAddedObject, queue.head());
  }

  @Test
  public void test08HeadDoesNotRemoveObjectFromQueue() {
    Queue queue = new Queue();
    queue.add("Something");
    assertEquals(1, queue.size());
    queue.head();
    assertEquals(1, queue.size());
  }

  @Test
  public void test09SizeRepresentsObjectInTheQueue() {
    assertEquals(2, new Queue().add("First").add("Second").size());
  }

  @Test
  public void test10CanNotTakeWhenQueueIsEmpty() {
    Queue queue = new Queue();
    assertThrows(Error.class, queue::take);
  }

  @Test
  public void test11CanNotTakeWhenQueueIsEmptyAfterHavingObjects() {
    Queue queue = new Queue();
    queue.add("Something");
    queue.take();
    assertThrows(Error.class, queue::take);
  }

  @Test
  public void test12CanNotHeadWhenQueueIsEmpty() {
    Queue queue = new Queue();
    assertThrows(Error.class, queue::head);
  }
}