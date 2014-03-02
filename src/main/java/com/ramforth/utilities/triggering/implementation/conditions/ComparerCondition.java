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

import java.util.Comparator;

//  [Description("Bedingung, die erfüllt ist, wenn das Ergebnis der Compare(elementA, elementB)-Methode des übergebenen Comparers mit Wert der übergebenen comparisonResult übereinstimmt.")]
//  [Category("Common")]
//  [Serializable]
public class ComparerCondition extends AbstractComparerCondition<Object> {

    private Comparator comparer = null;

    public Comparator getComparer() {
        return comparer;
    }

    public void setComparer(Comparator value) {
        this.comparer = value;
    }

    @Override
    public boolean isMet() {
        return ( comparer != null ) && comparer.compare(elementA, elementB) == comparisonResult;
    }

    @Override
    public String toString() {
        return String.format("{%1s} {%2s} {%3s}", elementA.toString(), comparer.toString(), elementB.toString());
    }

    @Override
    public String getFormatString() {
        return "{elementA} {comparer} {elementB}";
    }
}
