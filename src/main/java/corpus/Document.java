package corpus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mustafa on 05.04.2017.
 */
public class Document {
    private String documentName;
    private DocumentStats documentStats;
    private Map<String, Integer> wordFrequency = new HashMap<String, Integer>();
    private List<String> sentenceList;

    public void buildStats() {
        documentStats = new DocumentStats();
        documentStats.setSentenceCount(sentenceList.size());
        int wordCount = 0;

        for(String sentence: sentenceList) {
            String[] words = sentence.split(" ");
            wordCount += words.length;

            //kelimeleri say
            for(String word: words) {
                if(wordFrequency.containsKey(word))
                    wordFrequency.put(word, wordFrequency.get(word) + 1);
                else
                    wordFrequency.put(word, 1);
            }
        }

        documentStats.setWordCount(wordCount);
    }

    //getter - setter
    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public DocumentStats getDocumentStats() {
        return documentStats;
    }

    public void setDocumentStats(DocumentStats documentStats) {
        this.documentStats = documentStats;
    }

    public Map<String, Integer> getWordFrequency() {
        return wordFrequency;
    }

    public void setWordFrequency(Map<String, Integer> wordFrequency) {
        this.wordFrequency = wordFrequency;
    }

    public List<String> getSentenceList() {
        return sentenceList;
    }

    public void setSentenceList(List<String> sentenceList) {
        this.sentenceList = sentenceList;
    }
}
