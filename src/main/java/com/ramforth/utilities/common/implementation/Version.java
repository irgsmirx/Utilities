/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.common.implementation;

import com.ramforth.utilities.common.interfaces.IVersion;
import java.text.ParseException;

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

    public static IVersion parseVersion(String s) throws ParseException {
        if (s == null) {
            throw new NullPointerException();
        }

        if (s.length() == 0) {
            return new Version(0, 0, 0, 0);
        }

        String[] split = s.split("\\.");

        if (split.length > 4 || split.length == 0) {
            throw new IllegalArgumentException();
        }

        int major = 0;
        int minor = 0;
        int build = 0;
        int release = 0;
        if (split.length > 0) {
            try {
                major = Integer.parseInt(split[0]);
            }
            catch (NumberFormatException e) {
                throw new ParseException(s, 0);
            }

            if (split.length > 1) {
                try {
                    minor = Integer.parseInt(split[1]);
                }
                catch (NumberFormatException e) {
                    throw new ParseException(s, split[0].length() + 1);
                }

                if (split.length > 2) {
                    try {
                        minor = Integer.parseInt(split[2]);
                    }
                    catch (NumberFormatException e) {
                        throw new ParseException(s, split[0].length() + split[1].length() + 2);
                    }

                    if (split.length > 3) {
                        try {
                            release = Integer.parseInt(split[3]);
                        }
                        catch (NumberFormatException e) {
                            throw new ParseException(s, split[0].length() + split[1].length() + split[2].length() + 3);
                        }
                    }
                }
            }
        }

        return new Version(major, minor, build, release);
    }

    @Override
    public String toString() {
        return String.format("%d.%d.%d.%d", major, minor, build, revision);
    }

    @Override
    public int compareTo(IVersion o) {
        if (o == null) {
            return 1;
        } else {
            if (o.getMajor() > major) {
                return -1;
            } else if (o.getMajor() < major) {
                return 1;
            } else {
                if (o.getMinor() > minor) {
                    return -1;
                } else if (o.getMinor() < minor) {
                    return 1;
                } else {
                    if (o.getBuild() > build) {
                        return - 1;
                    } else if (o.getBuild() < build) {
                        return 1;
                    } else {
                        return getRevision() - o.getRevision();
                    }
                }
            }
        }
    }
    
}
