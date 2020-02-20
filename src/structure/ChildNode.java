package structure;


// this class allows the user to add, remove and edit nodes in the board, collumn
// or event classes. Ie in the board class a node would be the board itself
// in the event class the node would be the event etc.

import java.util.ArrayList;
import java.util.Iterator;

public class ChildNode {
  protected ArrayList<Node> nodes = new ArrayList<Node>();

  // adds a node
  public Node addNode(Node aNode) {
    this.nodes.add(aNode);
    return aNode;
  }

  // removes a node
  public void removeNode(int id) {
    Iterator<Node> itr = nodes.iterator();

    // while there are nodes in the list, check if node is
    // equal to the parameter, and if so removes that node
    while (itr.hasNext()) {
      Node nodeCheck = itr.next();
      int nodeId = nodeCheck.getId();

      if (nodeId == id) {
        nodes.remove(nodeCheck);
      }
    }
  }
}