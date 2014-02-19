/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.common.interfaces;

import com.ramforth.utilities.common.implementation.Pair;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 * @param <LEFT>
 * @param <RIGHT>
 */
public interface IPairs<LEFT, RIGHT> extends Iterable<Pair<LEFT, RIGHT>> {

    void add(Pair<LEFT, RIGHT> value);

    void add(LEFT left, RIGHT right);

    void remove(Pair<LEFT, RIGHT> value);

    void remove(LEFT left);

    int numberOfPairs();

    void clear();

    boolean contains(Pair<LEFT, RIGHT> value);

    boolean contains(LEFT left);

    Pair<LEFT, RIGHT> get(LEFT left);
    
    Pair<LEFT, RIGHT> getAt(int index);

    RIGHT getRight(LEFT left);
    
    void set(LEFT left, RIGHT right);
    
}
