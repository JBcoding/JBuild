import org.fife.ui.rsyntaxtextarea.AbstractTokenMaker;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.TokenMap;

import javax.swing.text.Segment;

public class JBuildTokenMaker extends AbstractTokenMaker {
    @Override
    public TokenMap getWordsToHighlight() {
        TokenMap tokenMap = new TokenMap();

        tokenMap.put("split",   Token.RESERVED_WORD);
        tokenMap.put("if",      Token.RESERVED_WORD);
        tokenMap.put("extrude", Token.RESERVED_WORD);
        tokenMap.put("plot",    Token.RESERVED_WORD);
        tokenMap.put("true",    Token.LITERAL_BOOLEAN);
        tokenMap.put("false",    Token.LITERAL_BOOLEAN);

        tokenMap.put("random", Token.FUNCTION);
        tokenMap.put("color",  Token.FUNCTION);
        tokenMap.put("translate",  Token.FUNCTION);
        tokenMap.put("translateG",  Token.FUNCTION);
        tokenMap.put("rotateX",  Token.FUNCTION);
        tokenMap.put("rotateY",  Token.FUNCTION);
        tokenMap.put("rotateZ",  Token.FUNCTION);
        tokenMap.put("rotatePX",  Token.FUNCTION);
        tokenMap.put("rotatePY",  Token.FUNCTION);
        tokenMap.put("rotatePZ",  Token.FUNCTION);
        tokenMap.put("scale",  Token.FUNCTION);
        tokenMap.put("polygon",  Token.FUNCTION);

        return tokenMap;
    }

    @Override
    public Token getTokenList(Segment segment, int i, int i1) {
        return null;
    }
}
