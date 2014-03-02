/* 
 * Copyright (C) 2014 Tobias Ramforth
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ramforth.utilities.common.implementation;

public class SystemProperties {

    public static final String USERNAME = "user.name";
    public static final String CURRENT_WORKING_DIRECTORY = "user.dir";
    public static final String USER_HOME_DIRECTORY = "user.home";
    public static final String FILE_SEPARATOR = "file.separator";
    public static final String JAVA_CLASS_PATH = "java.class.path";
    public static final String JAVA_INSTALLATION_DIRECTORY = "java.home";
    public static final String JAVA_VENDOR_NAME = "java.vendor";
    public static final String JAVA_VENDOR_URL = "java.vendor.url";
    public static final String JAVA_VERSION = "java.version";
    public static final String LINE_SEPARATOR = "line.separator";
    public static final String OPERATING_SYSTEM_ARCHITECTURE = "os.arch";
    public static final String OPERATING_SYSTEM_NAME = "os.name";
    public static final String OPERATING_SYSTEM_VERSION = "os.version";
    public static final String JAVA_CLASS_PATH_SEPARATOR = "path.separator";

    public static String getUsername() {
        return System.getProperty(USERNAME);
    }

    public static String getCurrentWorkingDirectory() {
        return System.getProperty(CURRENT_WORKING_DIRECTORY);
    }

    public static String getUserHomeDirectory() {
        return System.getProperty(USER_HOME_DIRECTORY);
    }

    public static String getFileSeparator() {
        return System.getProperty(FILE_SEPARATOR);
    }

    public static String getJavaClassPath() {
        return System.getProperty(JAVA_CLASS_PATH);
    }

    public static String getJavaInstallationDirectory() {
        return System.getProperty(JAVA_INSTALLATION_DIRECTORY);
    }

    public static String getJavaVendorName() {
        return System.getProperty(JAVA_VENDOR_NAME);
    }

    public static String getJavaVendorUrl() {
        return System.getProperty(JAVA_VENDOR_URL);
    }

    public static String getJavaVersion() {
        return System.getProperty(JAVA_VERSION);
    }

    public static String getLineSeparator() {
        return System.getProperty(LINE_SEPARATOR);
    }

    public static String getOperatingSystemArchitecture() {
        return System.getProperty(OPERATING_SYSTEM_ARCHITECTURE);
    }

    public static String getOperatingSystemName() {
        return System.getProperty(OPERATING_SYSTEM_NAME);
    }

    public static String getoperatingSystemVersion() {
        return System.getProperty(OPERATING_SYSTEM_VERSION);
    }

    public static String getJavaClassPathSeparator() {
        return System.getProperty(JAVA_CLASS_PATH_SEPARATOR);
    }
}
