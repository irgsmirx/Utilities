/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ramforth.utilities.validation;

import com.ramforth.utilities.exceptions.NoSuchElementException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author tobias
 */
public class Notification {
    
    private List<AbstractMessage> messages = new ArrayList<AbstractMessage>();
    
    public void register(AbstractMessage message) {
        messages.add(message);
    }
    
    public Iterable<AbstractMessage> getMessages() {
        return messages;
    }
    
    public Iterable<ErrorMessage> getErrors() {
        return new ErrorIterator(messages);
    }
    
    public boolean hasErrors() {
        return getErrors().iterator().hasNext();
    }
    
    private static class ErrorIterator implements Iterator<ErrorMessage>, Iterable<ErrorMessage> {
        
        private Iterator<AbstractMessage> messages;
        
        public ErrorIterator(Iterable<AbstractMessage> messages) {
            this.messages = messages.iterator();
        }
        
        @Override
        public boolean hasNext() {
            while (messages.hasNext()) {
                AbstractMessage currentMessage = messages.next();
                
                if (currentMessage instanceof ErrorMessage) {
                    return true;
                }
            }
            
            return false;
        }

        @Override
        public ErrorMessage next() {
            while (messages.hasNext()) {
                AbstractMessage currentMessage = messages.next();

                if (currentMessage instanceof ErrorMessage) {
                    return (ErrorMessage) currentMessage;
                }
            }
            
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported.");
        }

        @Override
        public Iterator<ErrorMessage> iterator() {
            return this;
        }

        
        
    }
    
}
