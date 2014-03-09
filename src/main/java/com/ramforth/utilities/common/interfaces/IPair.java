/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ramforth.utilities.common.interfaces;

/**
 *
 * @author Tobias Ramforth
 * @param <LEFT>
 * @param <RIGHT>
 */
public interface IPair<LEFT, RIGHT> {

    LEFT getLeft();

    void setLeft(LEFT value);

    RIGHT getRight();

    public void setRight(RIGHT value);
    
}
