/* 
 * Copyright (C) 2014 Tobias Ramforth
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
