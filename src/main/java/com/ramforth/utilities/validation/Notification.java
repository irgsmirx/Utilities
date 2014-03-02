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
