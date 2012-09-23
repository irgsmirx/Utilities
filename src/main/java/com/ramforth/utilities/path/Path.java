package com.ramforth.utilities.path;

import java.io.File;
import com.ramforth.utilities.common.implementation.OS;
import com.ramforth.utilities.common.implementation.StringUtilities;
import com.ramforth.utilities.common.implementation.SystemProperties;

/**
 *
 * @author tobias.ramforth at udo.edu
 */
public class Path {

  public static final int VOLUME_SEPARATOR_CHAR = ':';
  
  private static char[] s_Base32Char = new char[]{'a', 'b', 'c', 'd', 'e', 'f',
                                                  'g', 'h', 'i', 'j', 'k', 'l',
                                                  'm', 'n', 'o', 'p', 'q', 'r',
                                                  's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                                                  '0', '1', '2', '3', '4', '5'};

  public static String combine(String path1, String path2) {
    Path.checkForInvalidPathCharacters(path1);
    Path.checkForInvalidPathCharacters(path2);
    return Path.combineUnchecked(path1, path2);
  }

  public static String combine(String path1, String path2, String path3) {
    Path.checkForInvalidPathCharacters(path1);
    Path.checkForInvalidPathCharacters(path2);
    Path.checkForInvalidPathCharacters(path3);
    return Path.combineUnchecked(Path.combineUnchecked(path1, path2), path3);
  }

  public static String combine(String path1, String path2, String path3, String path4) {
    Path.checkForInvalidPathCharacters(path1);
    Path.checkForInvalidPathCharacters(path2);
    Path.checkForInvalidPathCharacters(path3);
    Path.checkForInvalidPathCharacters(path4);
    return Path.combineUnchecked(Path.combineUnchecked(Path.combineUnchecked(path1, path2), path3), path4);
  }

  public static String combine(String... paths) {
    int totalPathLength = 0;
    int firstPathIndex = 0;
    
    for (int i = 0; i < paths.length; i++) {
      if (!StringUtilities.isNullOrWhitespace(paths[i])) {
        Path.checkForInvalidPathCharacters(paths[i]);
        if (Path.isPathRooted(paths[i])) {
          firstPathIndex = i;
          totalPathLength = paths[i].length();
        } else {
          totalPathLength += paths[i].length();
        }
        
        int currentLastCharacter = paths[i].codePointAt(paths[i].length() - 1);
        if (currentLastCharacter != File.separatorChar && !(OS.isWindows() && currentLastCharacter == Path.VOLUME_SEPARATOR_CHAR)) {
          totalPathLength++;
        }
      }
    }
    
    StringBuilder pathBuilder = new StringBuilder(totalPathLength);
    for (int j = firstPathIndex; j < paths.length; j++) {
      if (paths[j].length() != 0) {
        if (pathBuilder.length() == 0) {
          pathBuilder.append(paths[j]);
        } else {
          int currentLastCharacter = pathBuilder.codePointAt(pathBuilder.length() - 1);
          if (currentLastCharacter != File.separatorChar && !(OS.isWindows() && currentLastCharacter == Path.VOLUME_SEPARATOR_CHAR)) {
            pathBuilder.append(File.separatorChar);
          }
          pathBuilder.append(paths[j]);
        }
      }
    }
    return pathBuilder.toString();
  }

  private static String combineUnchecked(String path1, String path2) {
    if (path2.length() == 0) {
      return path1;
    }
    
    if (path1.length() == 0 || isPathRooted(path2)) {
      return path2;
    }

    int lastCharacter = path1.codePointAt(path1.length() - 1);
    if (lastCharacter != File.separatorChar && !(OS.isWindows() && lastCharacter == Path.VOLUME_SEPARATOR_CHAR)) {
      return path1 + File.separatorChar + path2;
    }
    return path1 + path2;
  }

  public static boolean isPathRooted(String path) {
    if (path != null) {
      Path.checkForInvalidPathCharacters(path);
      int length = path.length();
      if ((length >= 1 && (path.codePointAt(0) == File.separatorChar)) || (OS.isWindows() && (length >= 2 && path.codePointAt(1) == Path.VOLUME_SEPARATOR_CHAR))) {
        return true;
      }
    }
    return false;
  }

  private static String toBase32StringSuitableForDirName(byte[] buff) {
    StringBuilder stringBuilder = new StringBuilder();
    int num = buff.length;
    int num2 = 0;
    do {
      byte b = (num2 < num) ? buff[num2++] : 0;
      byte b2 = (num2 < num) ? buff[num2++] : 0;
      byte b3 = (num2 < num) ? buff[num2++] : 0;
      byte b4 = (num2 < num) ? buff[num2++] : 0;
      byte b5 = (num2 < num) ? buff[num2++] : 0;
      stringBuilder.append(Path.s_Base32Char[(int) (b & 31)]);
      stringBuilder.append(Path.s_Base32Char[(int) (b2 & 31)]);
      stringBuilder.append(Path.s_Base32Char[(int) (b3 & 31)]);
      stringBuilder.append(Path.s_Base32Char[(int) (b4 & 31)]);
      stringBuilder.append(Path.s_Base32Char[(int) (b5 & 31)]);
      stringBuilder.append(Path.s_Base32Char[(b & 224) >> 5 | (b4 & 96) >> 2]);
      stringBuilder.append(Path.s_Base32Char[(b2 & 224) >> 5 | (b5 & 96) >> 2]);
      b3 = (byte) (b3 >> 5);
      if ((b4 & 128) != 0) {
        b3 |= 8;
      }
      if ((b5 & 128) != 0) {
        b3 |= 16;
      }
      stringBuilder.append(Path.s_Base32Char[(int) b3]);
    } while (num2 < num);
    return stringBuilder.toString();
  }

  private static void checkForInvalidPathCharacters(String path) {
    for (int i = 0; i < path.length(); i++) {
      int num = (int) path.codePointAt(i);
      if (num == 34 || num == 60 || num == 62 || num == 124 || num < 32) {
        throw new IllegalArgumentException("invalid characters in path");
      }
    }
  }
  
  public static String getFileExtensionFromFilename(String filename) {
    int length = filename.length();
    
    int num = length - 1;
    while (num >= 0) {
      int c = filename.codePointAt(num);
      if (c == '.') {
        return filename.substring(num + 1, length);
      }
      if (c == SystemProperties.getFileSeparator().codePointAt(0)) {
        break;
      }
      num--;
    }
    
    return StringUtilities.EMPTY;
  }
  
  public static String getNameWithoutExtensionFromFilename(String filename) {
    int length = filename.length();
    
    int num = length - 1;
    int indexOfDot = -1;
    while (num >= 0) {
      int c = filename.codePointAt(num);
      if (c == '.') {
        indexOfDot = num;
      }
      if (c == SystemProperties.getFileSeparator().codePointAt(0)) {
        return filename.substring(num + 1, indexOfDot);
      }
      num--;
    }
    
    return StringUtilities.EMPTY;
  }
  
}
