package corpus;

import java.util.List;

/**
 * Created by mustafa on 05.04.2017.
 */
public class CorpusStatistic {
    private List<Document> documentList;
    private double averageWordCountInASentence;
    private double averageLetterCountInAWord;
    private double averageSentenceCountInADocument;

    public void buildStats() {
        int sentenceCount = 0;
        int wordCount = 0;
        int letterCount = 0;

        //Bir dokümandaki ortalama cümle sayısı
        for(Document document: documentList) {
            sentenceCount += document.getDocumentStats().getSentenceCount();

            for(String sentence: document.getSentenceList()) {
                String[] words = sentence.split(" ");
                wordCount += words.length;

                letterCount += sentence.length() - words.length + 1;
            }
        }

        averageSentenceCountInADocument = (double) sentenceCount / documentList.size();
        averageWordCountInASentence = (double) wordCount / sentenceCount;
        averageLetterCountInAWord = (double) letterCount / wordCount;
    }

    public void printStats() {
        System.out.println("Doküman sayısı:" + documentList.size()
                + "\nBir dokümandaki ortalama cümle sayısı:" + averageSentenceCountInADocument
                + "\nBir cümledeki ortalama kelime sayısı:" + averageWordCountInASentence
                + "\nBir kelimedeki ortalama harf sayısı:" + averageLetterCountInAWord);
    }

    //getter - setter
    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }
}
