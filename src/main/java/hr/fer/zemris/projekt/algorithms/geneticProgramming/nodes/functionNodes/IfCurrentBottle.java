package hr.fer.zemris.projekt.algorithms.geneticProgramming.nodes.functionNodes;

import hr.fer.zemris.projekt.algorithms.geneticProgramming.nodes.FunctionNode;
import hr.fer.zemris.projekt.algorithms.geneticProgramming.nodes.Node;
import hr.fer.zemris.projekt.grid.Field;

/**
 * An implementation of {@link FunctionNode} with the condition checking whether
 * the current {@link Field} contains a bottle.
 * 
 * @author Dunja Vesinger
 * @version 1.0.0
 */
public class IfCurrentBottle extends FunctionNode {
    /**
     * Name of the node.
     */
    public static String NAME = "ifCurrentBottle";

    public IfCurrentBottle() {
        super();
    }

    public IfCurrentBottle(Node ifTrue, Node ifFalse) {
        super(ifTrue, ifFalse);
    }

    @Override
    protected boolean evaluateCondition(Field current, Field left, Field right, Field up, Field down) {
        if (current == Field.BOTTLE)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return NAME + super.toString();
    }

    @Override
    protected Node copyThisNode(Node ifTrue, Node ifFalse) {
        return new IfCurrentBottle(ifTrue, ifFalse);
    }

}
