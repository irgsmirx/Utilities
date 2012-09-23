/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.common.implementation;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class Pair<LEFT, RIGHT> {

    private LEFT left;
    private RIGHT right;

    public Pair(LEFT left, RIGHT right) {
        this.left = left;
        this.right = right;
    }

    public LEFT getLeft() {
        return left;
    }

    public void setLeft(LEFT value) {
        this.left = value;
    }

    public RIGHT getRight() {
        return right;
    }

    public void setRight(RIGHT value) {
        this.right = value;
    }
}
