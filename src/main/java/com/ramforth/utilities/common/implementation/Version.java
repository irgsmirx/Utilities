/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ramforth.utilities.common.implementation;

import com.ramforth.utilities.common.interfaces.IVersion;

/**
 *
 * @author Tobias Ramforth
 */
public class Version implements IVersion {

    private final int major;
    private final int minor;
    private final int build;
    private final int revision;
    
    public Version(int major, int minor, int build, int revision) {
        this.major = major;
        this.minor = minor;
        this.build = build;
        this.revision = revision;
    }
    
    public Version(int major, int minor, int build) {
        this(major, minor, build, 0);
    }

    public Version(int major, int minor) {
        this(major, minor, 0, 0);
    }

    public Version(int major) {
        this(major, 0, 0, 0);
    }

    
    @Override
    public int getMajor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMinor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getBuild() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRevision() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.major;
        hash = 97 * hash + this.minor;
        hash = 97 * hash + this.build;
        hash = 97 * hash + this.revision;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Version other = (Version) obj;
        return true;
    }

    
    @Override
    public String toString() {
        return String.format("%d.%d.%d.%d", major, minor, build, revision);
    }
    
}
