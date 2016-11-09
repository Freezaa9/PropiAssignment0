package prop.assignment0;


import java.io.IOException;

class Parser implements IParser{
    Tokenizer t = null;

    @Override
    public void open(String fileName) throws IOException, TokenizerException {
	t = new Tokenizer();			
	t.open(fileName);
	//t.moveNext();
    }

    @Override
    	public INode parse() throws IOException, TokenizerException, ParserException {
	    if (t == null)
		throw new IOException("No open file.");

	    return new TextNode(t);	    
	}

    @Override
    public void close() throws IOException {
	if (t != null)
	    t.close();
    }
    
    class TextNode implements INode{
	SentenceNode s = null;
	TextNode tx = null;

	public TextNode(Tokenizer t) {
	    s = new SentenceNode(t);
	    if (t.current().token() != Token.EOF)
		tx = new TextNode(t);
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

    class SentenceNode implements INode{
	NounphraseNode n = null;
	VerbphraseNode v = null;

	public SentenceNode(Tokenizer t) {
	    n = new NounphraseNode(t);
	    v = new VerbphraseNode(t);
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

    class NounphraseNode implements INode {
	DeterminerNode d = null;
	NounNode n = null;
	public NounphraseNode(Tokenizer t) {
	    d = new DeterminerNode(t);
	    n = new NounNode(t);
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

    class VerbphraseNode implements INode {
	VerbNode v = null;
	NounphraseNode n = null;

	public VerbphraseNode(Tokenizer t) {
	    v = new VerbNode(t);
	    n = new NounphraseNode(t);
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

    class DeterminerNode implements INode {
	Lexeme l = null;
	public DeterminerNode(Tokenizer t) {
	    // get next token and check that it's a determiner
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

    class NounNode implements INode {
	Lexeme l = null;
	public NounNode(Tokenizer t) {
	    // get next token and check that it's a Noun
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

    class VerbNode implements INode {
	Lexeme l = null;
	public VerbNode(Tokenizer t) {
	    // get next token and check that it's a Verb
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

}
