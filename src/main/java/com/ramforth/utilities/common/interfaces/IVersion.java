/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ramforth.utilities.common.interfaces;

/**
 *
 * @author Tobias Ramforth
 */
public interface IVersion {
    
    int getMajor();
    int getMinor();
    int getBuild();
    int getRevision();
    
}
