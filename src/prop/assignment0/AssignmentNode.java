/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prop.assignment0;

/**
 *
 * @author Geoffrey-Port
 */

public class AssignmentNode implements INode {
    	private char ident;
	private final char assignOp ='=';
        private ExpressionNode expr;

	public AssignmentNode(char ident, ExpressionNode expr) {
            this.ident = ident;
            this.expr=expr;
		//System.out.println("Lexeme:" + value + " " + token);
	}
    @Override
    public Object evaluate(Object[] args) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
