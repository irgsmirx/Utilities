/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.exceptions;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IOException extends RuntimeException {

  public IOException() {
  }

  public IOException(String message) {
    super(message);
  }

  public IOException(String message, Throwable cause) {
    super(message, cause);
  }

  public IOException(Throwable cause) {
    super(cause);
  }

  public IOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
  
}
