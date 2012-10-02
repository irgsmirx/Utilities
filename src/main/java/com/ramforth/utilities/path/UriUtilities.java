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
public class UriUtilities {
    
    public static String getLastPathElementFromURI(final URI uri){
        return getLastPathElementFromURIString(uri.getPath());
    }

    public static String getLastPathElementFromURIString(final String uriString){
        return uriString.replaceFirst(".*/([^/?]+).*", "$1");
    }
    
}
