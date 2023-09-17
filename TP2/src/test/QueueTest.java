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
    assertFalse( CreateQueueWithParameter("Something").isEmpty());
  }

  @Test
  public void test03AddedElementsIsAtHead() {
    Queue queue = CreateQueueWithParameter("Something");
    assertEquals("Something", queue.head());
  }

  @Test
  public void test04TakeRemovesElementsFromTheQueue() {
    Queue queue = CreateQueueWithParameter("Something");
    queue.take();
    assertTrue(queue.isEmpty());
  }

  @Test
  public void test05TakeReturnsLastAddedObject() {
    Queue queue = CreateQueueWithParameter("Something");
    assertEquals("Something", queue.take());
  }

  @Test
  public void test06QueueBehavesFIFO() {
    String firstAddedObject = "First";
    String secondAddedObject = "Second";
    Queue queue = CreateQueueWithParameter(firstAddedObject);
    queue.add(secondAddedObject);
    assertEquals(firstAddedObject, queue.take());
    assertEquals(secondAddedObject, queue.take());
    assertTrue(queue.isEmpty());
  }

  @Test
  public void test07HeadReturnsFirstAddedObject() {
    String firstAddedObject = "First";
    Queue queue = CreateQueueWithParameter(firstAddedObject);
    queue.add("Second");
    assertEquals(firstAddedObject, queue.head());
  }

  @Test
  public void test08HeadDoesNotRemoveObjectFromQueue() {
    Queue queue = CreateQueueWithParameter("Something");
    assertEquals(1, queue.size());
    queue.head();
    assertEquals(1, queue.size());
  }

  @Test
  public void test09SizeRepresentsObjectInTheQueue() {
    assertEquals(2, CreateQueueWithParameter("First").add("Second").size());
  }

  @Test
  public void test10CanNotTakeWhenQueueIsEmpty() {
    Queue queue = new Queue();
    assertThrows(Error.class, queue::take);
  }

  @Test
  public void test11CanNotTakeWhenQueueIsEmptyAfterHavingObjects() {
    Queue queue = CreateQueueWithParameter("Something");
    queue.take();
    assertThrows(Error.class, queue::take);
  }

  @Test
  public void test12CanNotHeadWhenQueueIsEmpty() {
    Queue queue = new Queue();
    assertThrows(Error.class, queue::head);
  }

  private static Queue CreateQueueWithParameter(String parameter) {
    Queue queue = new Queue();
    queue.add(parameter);
    return queue;
  }
}