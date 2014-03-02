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
package com.ramforth.utilities.fractions.implementation;

import com.ramforth.utilities.fractions.interfaces.IFraction;

/**
 *
 * @author Administrator
 */
public abstract class AbstractFraction implements IFraction {

    public int greatestCommonDivisorEuclid(int a, int b) {
        int remainder;

        while (b != 0) {
            remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;
    }

    public int greatestCommonDivisorEuclidAnyOrder(int a, int b) {
        int greater = a;
        int smaller = b;
        if (b > a) {
            greater = b;
            smaller = a;
        }

        int remainder;

        while (smaller != 0) {
            remainder = greater % smaller;
            greater = smaller;
            smaller = remainder;
        }

        return greater;
    }

    public int greatestCommonDivisorStein(int a, int b) {
        int greatestCommonDivisor = b;

        if (a != 0) {
            int k = 0;

            while (a % 2 == 0 && b % 2 == 0) {
                a = a / 2;
                b = b / 2;
                k++;
            }

            int t;

            if (a % 2 == 1) {
                t = -b;
            } else {
                t = a;
            }

            while (t != 0) {
                while (t % 2 == 0) {
                    t = t / 2;
                }

                if (t > 0) {
                    a = t;
                } else {
                    b = -t;
                }

                t = a - b;
            }

            greatestCommonDivisor = a * ( 0x1 << k );
        }

        return greatestCommonDivisor;
    }

    public int greatestCommonDivisorSteinAnyOrder(int a, int b) {
        int greater = a;
        int smaller = b;
        if (b > a) {
            greater = b;
            smaller = a;
        }

        int greatestCommonDivisor = smaller;

        if (greater != 0) {
            int k = 0;

            while (greater % 2 == 0 && smaller % 2 == 0) {
                greater = greater / 2;
                smaller = smaller / 2;
                k++;
            }

            int t;

            if (greater % 2 == 1) {
                t = -smaller;
            } else {
                t = greater;
            }

            while (t != 0) {
                while (t % 2 == 0) {
                    t = t / 2;
                }

                if (t > 0) {
                    greater = t;
                } else {
                    smaller = -t;
                }

                t = greater - smaller;
            }

            greatestCommonDivisor = greater * ( 0x1 << k );
        }

        return greatestCommonDivisor;
    }

    public int leastCommonMultipleEuclid(int a, int b) {
        return Math.abs(a) / greatestCommonDivisorEuclid(a, b) * Math.abs(b);
    }
}
