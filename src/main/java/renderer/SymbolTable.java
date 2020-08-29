package renderer;

import AST.Type;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTable {
    List<Map<String, Pair<Object, Type>>> symbols = new ArrayList<>();

    Pair<Object, Type> get(String key) {
        for (int i = symbols.size() - 1; i >= 0; i--) {
            if (symbols.get(i).containsKey(key)) {
                return symbols.get(i).get(key);
            }
        }
        throw new IllegalStateException("Variable does not exist");
    }

    void push() {
        symbols.add(new HashMap<>());
    }

    void pop() {
        symbols.remove(symbols.size() - 1);
    }

    void set(String key, Object value, Type type) {
        symbols.get(symbols.size() - 1).put(key, new Pair<>(value, type));
    }
}
