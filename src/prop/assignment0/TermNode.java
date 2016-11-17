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
public class TermNode implements INode {
    	private FactorNode factor;
	private enum op{MULT_OP,DIV_OP};
        private TermNode term;

    public TermNode(FactorNode factore, enum op, TermNode term) {
        this.factor=factor;
        this.op=op;
        this.term = term;
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