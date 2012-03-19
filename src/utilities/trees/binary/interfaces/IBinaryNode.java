/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.trees.binary.interfaces;

import utilities.trees.interfaces.INode;

/**
 *
 * @author tobias
 */
public interface IBinaryNode extends INode {
	
	IBinaryNode getLeftChild();
	void setLeftChild(IBinaryNode value);
	
	IBinaryNode getRightChild();
	void setRightChild(IBinaryNode value);
	
}
