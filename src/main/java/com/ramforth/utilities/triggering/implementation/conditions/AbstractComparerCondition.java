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

//  [Description("Bedingung, die erfüllt ist, wenn das Ergebnis der Compare(elementA, elementB)-Methode des übergebenen Comparers mit Wert der übergebenen comparisonResult übereinstimmt.")]
//  [Category("Common")]
//  [Serializable]
public abstract class AbstractComparerCondition<T> extends AbstractCondition {

    protected T elementA;
    protected T elementB;
    protected int comparisonResult;

    //[DataMember]
    public T getElementA() {
        return elementA;
    }

    public void setElementA(T value) {
        elementA = value;
    }

    //[DataMember]
    public T getElementB() {
        return elementB;
    }

    public void setElementB(T value) {
        elementB = value;
    }

    //[DataMember]
    public int getComparisonResult() {
        return comparisonResult;
    }

    public void setComparisonResult(int value) {
        this.comparisonResult = value;
    }
}