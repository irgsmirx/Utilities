/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.path;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.PathMatcher;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class ExtensionURIMatcher implements IURIMatcher {

    private String extension;

    public ExtensionURIMatcher(String extension) {
        if (extension.startsWith(".")) {
            this.extension = extension.substring(1).toLowerCase();
        } else {
            this.extension = extension.toLowerCase();
        }
    }

    @Override
    public boolean matches(URI uri) {
        return UriUtilities.getLastPathElementFromURI(uri).toLowerCase().endsWith("." + extension);
    }
}
