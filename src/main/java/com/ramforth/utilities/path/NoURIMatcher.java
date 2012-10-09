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
public class NoURIMatcher implements IURIMatcher {

    @Override
    public boolean matches(URI uri) {
        return false;
    }
    
}
