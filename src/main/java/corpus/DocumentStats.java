package corpus;

/**
 * Created by mustafa on 05.04.2017.
 */
public class DocumentStats {
    private int sentenceCount;
    private int wordCount;
    private String maxWord;
    private int maxWordCount;

    public void printStatistics() {
        System.out.println("TO DO");
    }

    //getter - setter
    public int getSentenceCount() {
        return sentenceCount;
    }

    public void setSentenceCount(int sentenceCount) {
        this.sentenceCount = sentenceCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public String getMaxWord() {
        return maxWord;
    }

    public void setMaxWord(String maxWord) {
        this.maxWord = maxWord;
    }

    public int getMaxWordCount() {
        return maxWordCount;
    }

    public void setMaxWordCount(int maxWordCount) {
        this.maxWordCount = maxWordCount;
    }
}
