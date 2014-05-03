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
package com.ramforth.utilities.triggering.implementation;

import com.ramforth.utilities.triggering.interfaces.IAction;
import com.ramforth.utilities.triggering.interfaces.IActions;
import com.ramforth.utilities.triggering.interfaces.ICondition;
import com.ramforth.utilities.triggering.interfaces.IConditions;
import com.ramforth.utilities.triggering.interfaces.IEvent;
import com.ramforth.utilities.triggering.interfaces.IEvents;
import com.ramforth.utilities.triggering.interfaces.ITrigger;
import com.ramforth.utilities.triggering.interfaces.IVariable;
import java.util.ArrayList;
import java.util.List;

public class Trigger implements ITrigger/*, IXmlSerializable*/ {

    private String name;
    private final IEvents events = new Events();
    private final List<IVariable> variables = new ArrayList<>();
    private final IConditions conditions = new Conditions();
    private final IActions actions = new Actions();

    public Trigger() {
    }

    public Trigger(String name) {
        this.name = name;
    }

    public Trigger(String name, IEvent e, ICondition c, IAction a) {
        this(name);

        addEvent(e);
        addCondition(c);
        addAction(a);
    }
    
    public Trigger(String name, IEvent[] events, ICondition[] conditions, IAction[] actions) {
        this(name);

        for (IEvent e : events) {
            addEvent(e);
        }
        for (ICondition c : conditions) {
            addCondition(c);
        }
        for (IAction a : actions) {
            addAction(a);
        }
    }

//    #region ITrigger Members
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public void clear() {
        clearActions();
        clearConditions();
        clearEvents();
        clearVariables();
    }

    @Override
    public void evaluate() {
        if (events.occurred()) {
            if (conditions.areMet()) {
                actions.perform();
            }
        }
    }

    @Override
    public Iterable<IEvent> getEvents() {
        return events;
    }

    @Override
    public void clearEvents() {
        events.clear();
    }

    @Override
    public final void addEvent(IEvent value) {
        events.append(value);
    }

    @Override
    public void removeEvent(IEvent value) {
        events.remove(value);
    }

    @Override
    public void removeEventAt(int index) {
        events.removeAt(index);
    }

    @Override
    public Iterable<IVariable> getVariables() {
        return variables;
    }

    @Override
    public void clearVariables() {
        variables.clear();
    }

    @Override
    public final void addVariable(IVariable value) {
        variables.add(value);
    }

    @Override
    public void removeVariable(IVariable value) {
        variables.remove(value);
    }

    @Override
    public void removeVariableAt(int index) {
        variables.remove(index);
    }

    @Override
    public Iterable<ICondition> getConditions() {
        return conditions;
    }

    @Override
    public void clearConditions() {
        conditions.clear();
    }

    @Override
    public final void addCondition(ICondition value) {
        conditions.append(value);
    }

    @Override
    public void removeCondition(ICondition value) {
        conditions.remove(value);
    }

    @Override
    public void removeConditionAt(int index) {
        conditions.removeAt(index);
    }

    @Override
    public Iterable<IAction> getActions() {
        return actions;
    }

    @Override
    public void clearActions() {
        actions.clear();
    }

    @Override
    public final void addAction(IAction value) {
        actions.append(value);
    }

    @Override
    public void removeAction(IAction value) {
        actions.remove(value);
    }

    @Override
    public void removeActionAt(int index) {
        actions.removeAt(index);
    }

    @Override
    public String toString() {
        return name == null ? "?TRIGGER NAME?" : name;
    }
//    #region IXmlSerializable Members
//
//    public System.Xml.Schema.XmlSchema GetSchema() {
//      return null;
//    }
//
//    public void ReadXml(System.Xml.XmlReader reader) {
//      reader.ReadStartElement("Trigger");
//      
//      reader.ReadStartElement("Name");
//      name = reader.ReadString();
//      reader.ReadEndElement();
//
//      Int32 eventsCount = Int32.Parse(reader.GetAttribute("Count"));
//      Boolean eventsEmpty = reader.IsEmptyElement;
//      reader.ReadStartElement("Events");
//      if (!eventsEmpty) {
//        for (int i = 0; i < eventsCount; i++) {
//          Type eventType = Type.GetType(reader.GetAttribute("Type"));
//          reader.ReadStartElement();
//          XmlSerializer serializer = new XmlSerializer(eventType);
//          IEvent e = serializer.Deserialize(reader) as IEvent;
//          events.Add(e);
//          reader.ReadEndElement();
//        }
//        reader.ReadEndElement();
//      }
//
//      Int32 conditionsCount = Int32.Parse(reader.GetAttribute("Count"));
//      Boolean conditionsEmpty = reader.IsEmptyElement;
//      reader.ReadStartElement("Conditions");
//      if (!conditionsEmpty) {
//        for (int i = 0; i < conditionsCount; i++) {
//          Type conditionType = Type.GetType(reader.GetAttribute("Type"));
//          reader.ReadStartElement();
//          XmlSerializer serializer = new XmlSerializer(conditionType);
//          ICondition c = serializer.Deserialize(reader) as ICondition;
//          conditions.Add(c);
//          reader.ReadEndElement();
//        }
//        reader.ReadEndElement();
//      }
//
//      Int32 actionsCount = Int32.Parse(reader.GetAttribute("Count"));
//      Boolean actionsEmpty = reader.IsEmptyElement;
//      reader.ReadStartElement("Actions");
//      if (!actionsEmpty) {
//        for (int i = 0; i < actionsCount; i++) {
//          Type actionType = Type.GetType(reader.GetAttribute("Type"));
//          reader.ReadStartElement();
//          XmlSerializer serializer = new XmlSerializer(actionType);
//          IAction a = serializer.Deserialize(reader) as IAction;
//          actions.Add(a);
//          reader.ReadEndElement();
//        }
//        reader.ReadEndElement();
//      }
//
//      reader.ReadEndElement();
//    }
//
//    public void WriteXml(System.Xml.XmlWriter writer) {
//      writer.WriteStartElement("Name");
//      writer.WriteString(name);
//      writer.WriteEndElement();
//
//      writer.WriteStartElement("Events");
//      writer.WriteAttributeString("Count", events.Count.ToString());
//      foreach (IEvent e in events) {
//        writer.WriteStartElement("Event");
//        writer.WriteAttributeString("Type", e.GetType().AssemblyQualifiedName);
//        XmlSerializer eventSerializer = new XmlSerializer(e.GetType());
//        eventSerializer.Serialize(writer, e);
//        writer.WriteEndElement();
//      }
//      writer.WriteEndElement();
//
//      writer.WriteStartElement("Conditions");
//      writer.WriteAttributeString("Count", conditions.Count.ToString());
//      foreach (ICondition c in conditions) {
//        writer.WriteStartElement("Condition");
//        writer.WriteAttributeString("Type", c.GetType().AssemblyQualifiedName);
//        XmlSerializer conditionSerializer = new XmlSerializer(c.GetType());
//        conditionSerializer.Serialize(writer, c);
//        writer.WriteEndElement();
//      }
//      writer.WriteEndElement();
//
//      writer.WriteStartElement("Actions");
//      writer.WriteAttributeString("Count", actions.Count.ToString());
//      foreach (IAction a in actions) {
//        writer.WriteStartElement("Action");
//        writer.WriteAttributeString("Type", a.GetType().AssemblyQualifiedName);
//        XmlSerializer actionSerializer = new XmlSerializer(a.GetType());
//        actionSerializer.Serialize(writer, a);
//        writer.WriteEndElement();
//      }
//      writer.WriteEndElement();
//    }
//
//    #endregion
}
