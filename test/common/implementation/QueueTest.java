/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.implementation;

import common.interfaces.IQueue;
import junit.framework.Assert;
import newparsing.interfaces.IToken;
import newparsing.interfaces.ITokenQueue;
import org.junit.Test;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class QueueTest {
  
  private IQueue<String> queue;
  
  public QueueTest() {
    queue = new Queue<>();
  }
  
  @Test
  public void GetLength_ShouldReturnDefaultValueOfTwo() {
    Assert.assertEquals(2, queue.getLength());
  }
  
  @Test
  public void NumberOfTokens_ShouldReturnZero_IfNoTokenWasEnqueued() {
    Assert.assertEquals(0, queue.numberOfTokens());
  }
  
  @Test(expected = TokenQueueException.class)
  public void Dequeue_ShouldThrowIndexOutOfBoundsException_IfNoTokenWasEnqueued() {
    String token = queue.dequeue();
  }
  
  @Test
  public void NumerOfTokens_ShouldReturnOne_IfOneTokenWasEnqueued() {
    String token = "a";
    queue.enqueue(token);
    
    Assert.assertEquals(1, queue.numberOfTokens());
  }
  
  @Test
  public void Dequeue_ShouldReturnEnqueuedToken_IfOnlyOneTokenWasEnqueued() {
    String token = new Token(null, null);
    queue.enqueue(token);
    
    Assert.assertEquals(token, queue.dequeue());
  }
  
  @Test 
  public void NumberOfTokens_ShouldBeReducedByOne_IfQueueWasNotEmptyAndOneElementIsDequeued() {
    String token = new Token(null, null);
    queue.enqueue(token);
    
    int numberOfTokens = queue.numberOfTokens();
    
    queue.dequeue();
    
    Assert.assertEquals(numberOfTokens - 1, queue.numberOfTokens());
  }
  
  @Test
  public void GetLength_ShouldReturnTwo_IfInitializedWithOneAndTwoTokensEnqueued() {
    String token = "a";
    queue.enqueue(token);

    String token2 = "b";
    queue.enqueue(token2);
    
    Assert.assertEquals(2, queue.getLength());
  }
  
  @Test
  public void Clear_ShouldSetNumberOfTokensToZero() {
    String token = "a";
    queue.enqueue(token);
    
    queue.clear();
    
    Assert.assertEquals(0, queue.numberOfTokens());
  }
  
  @Test
  public void GetAt_ShouldReturnTheNthTokenInTheQueue() {
    String token = "a";
    String token2 = "b";

		queue.enqueue(token);
    queue.enqueue(token2);
    
    Assert.assertSame(token, queue.getAt(0));
    Assert.assertSame(token2, queue.getAt(1));
  }
  
  @Test
  public void Dequeue_ShouldReturnEnqueuedTokensInOrderTheyWereEnqueued() {
    String token = "a";
    String token2 = "b";

		queue.enqueue(token);
    queue.enqueue(token2);
            
    Assert.assertSame(token, queue.dequeue());
    Assert.assertSame(token2, queue.dequeue());
  }

  @Test
	public void GetLength_ShouldNotIncreaseAboveTwo_IfTwoTokensAreEnqueuedDequeuedAndAgainEnqueued() {
    IToken token = new Token(new TokenType("Characters a to z", "[a-z]+"), null);
    IToken token2 = new Token(new TokenType("Digits 0 to 9", "[0-9]+"), null);

		queue.enqueue(token);
    queue.enqueue(token2);
            
		int length = queue.getLength();
		
		queue.dequeue();
		queue.dequeue();

		queue.enqueue(token);
    queue.enqueue(token2);

    Assert.assertSame(length, queue.getLength());
	}
	
	@Test
	public void Dequeue_ShouldReturnTheFirstEnqueuedToken_IfTwoTokensAreEnqueuedDequeuedAndAgainEnqueued() {
    String token = "a";
    String token2 = "b";

		queue.enqueue(token);
    queue.enqueue(token2);
            
		queue.dequeue();
		queue.dequeue();

		queue.enqueue(token);
    queue.enqueue(token2);

    Assert.assertSame(token, queue.dequeue());
	}
	
	
}
