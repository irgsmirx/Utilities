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
public class NegatingURIMatcher implements IURIMatcher {

    private IURIMatcher child;

    public NegatingURIMatcher(IURIMatcher child) {
        this.child = child;
    }

    @Override
    public boolean matches(URI uri) {
        return !child.matches(uri);
    }
}
