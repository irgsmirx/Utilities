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
package com.ramforth.utilities.triggering.implementation.conditions;

//[Description("Bedingung, die erfüllt ist, wenn die Equals(elementA, elementB)-Methode des übergebenen EqualityComparers 'true' zurückgibt.")]
import com.ramforth.utilities.common.interfaces.IEqualityComparator;

//[Category("Common")]
//[Serializable]
public class EqualityComparerCondition extends AbstractCondition {

    private IEqualityComparator equalityComparer = null;
    private Object elementA = null;
    private Object elementB = null;

    public IEqualityComparator getEqualityComparer() {
        return equalityComparer;
    }

    public void setEqualityComparer(IEqualityComparator value) {
        this.equalityComparer = value;
    }

    public Object getElementA() {
        return elementA;
    }

    public void setElementA(Object value) {
        elementA = value;
    }

    public Object getElementB() {
        return elementB;
    }

    public void setElementB(Object value) {
        elementB = value;
    }

    @Override
    public boolean isMet() {
        return ( equalityComparer != null ) && equalityComparer.equals(elementA, elementB);
    }

    @Override
    public String toString() {
        return String.format("{%1s} == {%2s}", elementA.toString(), elementB.toString());
    }

    @Override
    public String getFormatString() {
        return "{elementA} == {elementB}";
    }
}