package edu.aa12;

/**
 * Author: Philip Pickering <pgpick@gmx.at>
 * Date: 5/30/12
 * Time: 3:03 PM
 */
public class SimpleStrategy implements ILowerBound {

    @Override
    public double lowerBound(Graph g, BnBNode node) {
        return 0; 
    }
}
