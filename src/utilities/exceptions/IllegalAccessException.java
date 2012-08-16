/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.exceptions;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IllegalAccessException extends RuntimeException {

  public IllegalAccessException() {
    super();
  }

  public IllegalAccessException(String message) {
    super(message);
  }

  public IllegalAccessException(String message, Throwable cause) {
    super(message, cause);
  }

  public IllegalAccessException(Throwable cause) {
    super(cause);
  }

  public IllegalAccessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
  
}
