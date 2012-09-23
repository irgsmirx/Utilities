/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.inifile.interfaces;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public interface IIniFileSection extends Iterable<IIniFileEntry> {

    String getName();

    void setName(String value);

    IIniFileEntries getEntries();
}
