/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.templates;

/**
 *
 * @author tobias
 */
public class StringBuilderRenderer extends AbstractCharRenderer {

    private StringBuilder stringBuilder;

    public StringBuilderRenderer(StringBuilder sb) {
        this.stringBuilder = sb;
    }

    @Override
    public void render(char c) {
        stringBuilder.append(c);
    }

    @Override
    public void render(String s) {
        stringBuilder.append(s);
    }

    @Override
    public void render(Object o) {
        stringBuilder.append(o);
    }
}
