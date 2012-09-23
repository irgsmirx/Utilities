/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.common.implementation;

import org.junit.Assert;
import org.junit.Test;
import com.ramforth.utilities.common.implementation.Queue;
import com.ramforth.utilities.common.implementation.QueueException;
import com.ramforth.utilities.common.interfaces.IQueue;

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
    public void NumberOfElements_ShouldReturnZero_IfNoElementWasEnqueued() {
        Assert.assertEquals(0, queue.numberOfElements());
    }

    @Test(expected = QueueException.class)
    public void Dequeue_ShouldThrowIndexOutOfBoundsException_IfNoElementWasEnqueued() {
        String token = queue.dequeue();
    }

    @Test
    public void NumerOfElements_ShouldReturnOne_IfOneTokenWasEnqueued() {
        String token = "a";
        queue.enqueue(token);

        Assert.assertEquals(1, queue.numberOfElements());
    }

    @Test
    public void Dequeue_ShouldReturnEnqueuedElement_IfOnlyOneElementWasEnqueued() {
        String token = "a";
        queue.enqueue(token);

        Assert.assertEquals(token, queue.dequeue());
    }

    @Test
    public void NumberOfElements_ShouldBeReducedByOne_IfQueueWasNotEmptyAndOneElementIsDequeued() {
        String token = "a";
        queue.enqueue(token);

        int numberOfTokens = queue.numberOfElements();

        queue.dequeue();

        Assert.assertEquals(numberOfTokens - 1, queue.numberOfElements());
    }

    @Test
    public void GetLength_ShouldReturnTwo_IfInitializedWithOneAndTwoElementsEnqueued() {
        String token = "a";
        queue.enqueue(token);

        String token2 = "b";
        queue.enqueue(token2);

        Assert.assertEquals(2, queue.getLength());
    }

    @Test
    public void Clear_ShouldSetNumberOfElementsToZero() {
        String token = "a";
        queue.enqueue(token);

        queue.clear();

        Assert.assertEquals(0, queue.numberOfElements());
    }

    @Test
    public void GetAt_ShouldReturnTheNthElementInTheQueue() {
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
    public void GetLength_ShouldNotIncreaseAboveTwo_IfTwoElementsAreEnqueuedDequeuedAndAgainEnqueued() {
        String token = "a";
        String token2 = "b";

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
    public void Dequeue_ShouldReturnTheFirstEnqueuedElement_IfTwoElementsAreEnqueuedDequeuedAndAgainEnqueued() {
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
