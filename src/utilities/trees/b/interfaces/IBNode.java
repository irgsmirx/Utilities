/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.trees.b.interfaces;

import utilities.trees.interfaces.INode;

/**
 *
 * @author tobias
 */
public interface IBNode extends INode {
	
	IBNode getChidlAt(int index);
	void setChildAt(int index, IBNode value);
	
	int numberOfChildNodes();
	
	Object getDataAt(int index);
	void setDataAt(int index, Object value);
	
	int numberOfData();
	
}
