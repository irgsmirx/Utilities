/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package measurement.interfaces;

/**
 *
 * @author tobias
 */
public interface IUnit {
	
	double getValue();
	void setValue(double value);
	
	String getSymbol();
	String getName();
	
	IUnit multiply(IUnit value);
	IUnit divide(IUnit value);	
	IUnit add(IUnit value);
	IUnit subtract(IUnit value);
	
}
