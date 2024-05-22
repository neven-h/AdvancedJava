import java.io.Serializable;
import java.util.*;

public class Dictionary implements Serializable {

    private TreeMap<String, String> dictionaryMap;

    // no-argument constructor initialize map of dictionary
    public Dictionary() {
        this.dictionaryMap = new TreeMap<String, String>();
    }

    // adds word: word(key) and definition(value) to map
    protected void addWord(String word, String definition) {
        dictionaryMap.put(word, definition);
    }

    // deletes word from treeMap
    protected void deleteWord(String word) {
        dictionaryMap.remove(word);
    }

    // edits a word by updating its definition(value) in map
    protected void editWord(String word, String newDefinition) {
        String currentDefinition;
        // checks if word is already in treemap
        if (dictionaryMap.containsKey(word)) {
            currentDefinition = dictionaryMap.get(word);
            //checks if new definition is different from old definition
            if (!newDefinition.equals(currentDefinition))
                dictionaryMap.replace(word, newDefinition);
        }
    }

    // gets definition of a word
    protected String getDefinition(String word) {
        String definition = "";
        if (dictionaryMap.containsKey(word))
            definition = dictionaryMap.get(word);
        return definition;
    }

    // returns an array of strings containing all words(keys) in map
    protected ArrayList<String> getWordsFromDictionary() {
        Set<String> words = dictionaryMap.keySet();
        ArrayList<String> arrayOfWords = new ArrayList<String>();
        for (String word : words){
            arrayOfWords.add(word);
        }
        return arrayOfWords;
    }
}









