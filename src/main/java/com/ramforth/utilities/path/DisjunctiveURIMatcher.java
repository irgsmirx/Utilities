/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.path;

import java.net.URI;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class DisjunctiveURIMatcher extends AbstractMultiURIMatcher {

    public DisjunctiveURIMatcher() {
        super();
    }

    public DisjunctiveURIMatcher(IURIMatcher... matchers) {
        super(matchers);
    }

    @Override
    public boolean matches(URI uri) {
        for (IURIMatcher matcher : matchers) {
            if (matcher.matches(uri)) {
                return true;
            }
        }
        return false;
    }
}
