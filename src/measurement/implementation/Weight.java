/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package measurement.implementation;

import measurement.interfaces.IUnit;
import measurement.interfaces.IWeight;

/**
 *
 * @author tobias
 */
public class Weight extends AbstractUnit implements IWeight {
	
	public static final IWeight KILOGRAM = new Weight();

	@Override
	public double getValue() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void setValue(double value) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public String getSymbol() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public String getName() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public IUnit multiply(IUnit value) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public IUnit divide(IUnit value) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public IUnit add(IUnit value) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public IUnit subtract(IUnit value) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
}
