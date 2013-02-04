/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.actions;

import com.ramforth.utilities.triggering.interfaces.IAction;
import com.ramforth.utilities.triggering.interfaces.ICondition;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tobias
 */
public class IfThenElseAction extends AbstractAction {
    
    private List<ICondition> ifConditions = new ArrayList<>();
    private List<IAction> thenActions = new ArrayList<>();
    private List<IAction> elseActions = new ArrayList<>();
    
    public Iterable<ICondition> getIfConditions() {
        return ifConditions;
    }

    public void clearConditions() {
        ifConditions.clear();
    }

    public void addCondition(ICondition c) {
        ifConditions.add(c);
    }

    public void removeCondition(ICondition c) {
        ifConditions.remove(c);
    }

    public void removeConditionAt(int index) {
        ifConditions.remove(index);
    }

    public Iterable<IAction> getThenActions() {
        return thenActions;
    }

    public void clearThenActions() {
        thenActions.clear();
    }

    public void addThenAction(IAction a) {
        thenActions.add(a);
    }

    public void removeThenAction(IAction a) {
        thenActions.remove(a);
    }

    public void removeThenActionAt(int index) {
      thenActions.remove(index);
    }

    public Iterable<IAction> getElseActions() {
        return elseActions;
    }

    public void clearElseActions() {
      elseActions.clear();
    }

    public void addElseAction(IAction a) {
      elseActions.add(a);
    }

    public void removeElseAction(IAction a) {
      elseActions.remove(a);
    }

    public void removeElseActionAt(int index) {
      elseActions.remove(index);
    }

    @Override
    public void perform() {
      boolean conditionsMet = true;
      for (ICondition c : ifConditions) {
        try {
          if (!c.isMet()) {
            conditionsMet = false;
            break;
          }
        } catch (Exception conditionException) {
        }
      }
      if (conditionsMet) {
        for (IAction action : thenActions) {
          try {
            action.perform();
          } catch (Exception actionException) {
          }
        }
      } else {
        for (IAction action : elseActions) {
          try {
            action.perform();
          } catch (Exception actionException) {
          }
        }
      }
    }

    @Override
    public String getFormatString() {
        return "IF {ifConditions} THEN {thenActions} ELSE {elseActions}";
    }
    
}
