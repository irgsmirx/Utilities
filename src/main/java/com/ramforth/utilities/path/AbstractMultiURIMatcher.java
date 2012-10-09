/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.path;

import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public abstract class AbstractMultiURIMatcher implements IURIMatcher {

    protected final List<IURIMatcher> matchers;

    public AbstractMultiURIMatcher() {
        this.matchers = new ArrayList<>();
    }

    public AbstractMultiURIMatcher(IURIMatcher... matchers) {
        this();
        for (IURIMatcher matcher : matchers) {
            this.matchers.add(matcher);
        }
    }

    public void addMatcher(IURIMatcher value) {
        matchers.add(value);
    }

    public void removeMatcher(IURIMatcher value) {
        matchers.remove(value);
    }

    public void clear() {
        matchers.clear();
    }
}
