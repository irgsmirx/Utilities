/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.exceptions;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IllegalArgumentException extends RuntimeException {

  public IllegalArgumentException() {
    super();
  }

  public IllegalArgumentException(String message) {
    super(message);
  }

  public IllegalArgumentException(String message, Throwable cause) {
    super(message, cause);
  }

  public IllegalArgumentException(Throwable cause) {
    super(cause);
  }

  public IllegalArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
  
}
