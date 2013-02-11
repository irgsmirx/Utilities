package com.ramforth.utilities.triggering.implementation;

import com.ramforth.utilities.triggering.interfaces.IAction;
import com.ramforth.utilities.triggering.interfaces.ICondition;
import com.ramforth.utilities.triggering.interfaces.IEvent;
import com.ramforth.utilities.triggering.interfaces.ITrigger;
import com.ramforth.utilities.triggering.interfaces.IVariable;
import java.util.ArrayList;
import java.util.List;

public class Trigger implements ITrigger/*, IXmlSerializable*/ {

    private String name;
    private List<IEvent> events = new ArrayList<>();
    private List<IVariable> variables = new ArrayList<>();
    private List<ICondition> conditions = new ArrayList<>();
    private List<IAction> actions = new ArrayList<>();

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
    }

    @Override
    public void evaluate() {
        boolean eventsOccurred = false;
        for (IEvent event : events) {
            try {
                if (event.occurred()) {
                    eventsOccurred = true;
                    event.reset();
                    break;
                }
            }
            catch (Exception eventException) {
            }
        }

        if (eventsOccurred) {
            Boolean conditionsMet = true;
            for (ICondition condition : conditions) {
                try {
                    if (!condition.isMet()) {
                        conditionsMet = false;
                        break;
                    }
                }
                catch (Exception conditionException) {
                }
            }
            if (conditionsMet) {
                for (IAction action : actions) {
                    try {
                        action.perform();
                    }
                    catch (Exception actionException) {
                    }
                }
            }
        }
    }

//    #region events
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
        events.add(value);
    }

    @Override
    public void removeEvent(IEvent value) {
        events.remove(value);
    }

    @Override
    public void removeEventAt(int index) {
        events.remove(index);
    }
//    #endregion

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

//    #region conditions
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
        conditions.add(value);
    }

    @Override
    public void removeCondition(ICondition value) {
        conditions.remove(value);
    }

    @Override
    public void removeConditionAt(int index) {
        conditions.remove(index);
    }
//    #endregion

//    #region actions
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
        actions.add(value);
    }

    @Override
    public void removeAction(IAction value) {
        actions.remove(value);
    }

    @Override
    public void removeActionAt(int index) {
        actions.remove(index);
    }
//    #endregion
//    #endregion

    @Override
    public String toString() {
        return name == null ? "?TRIGGER?" : name;
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
