/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package templates;

/**
 *
 * @author ramforth
 */
public interface IVisitor<T> {
    
    void visit(T toVisit);
    
}
