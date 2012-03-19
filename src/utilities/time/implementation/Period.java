/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.time.implementation;

/**
 *
 * @author Administrator
 */
public class Period implements Comparable<Period> {
  
  private DateTime start = null;
  private DateTime end = null;
  
  public Period(DateTime start, DateTime end) {
    if (start != null && end != null && start.compareTo(end) > 0) {
      throw new IllegalArgumentException();
    }
    this.start = start;
    this.end = end;
  }
  
  public static Period from(DateTime start) {
    return new Period(start, null);
  }
  
  public static Period until(DateTime end) {
    return new Period(null, end);
  }
  
  public DateTime getStart() {
    return start;
  }
  
  public DateTime getEnd() {
    return end;
  }

  public TimeSpan toTimeSpan() {
    return new TimeSpan(end.getTicks() - start.getTicks());
  }
  
  @Override
  public int compareTo(Period o) {
    int comparison = start.compareTo(o.start);
    
    if (comparison == 0) {
      comparison = end.compareTo(o.end);
    }
    
    return comparison;
  }
  
}
