package Test;

import corpus.CorpusStatistic;
import corpus.Document;
import db.CorpusDAO;

/**
 * Created by mustafa on 05.04.2017.
 */
public class TestMain {
    public static void main(String[] args) {
        String keyspace = "myk";
        String query = "select * from document";

        CorpusDAO corpusDAO = new CorpusDAO();
        CorpusStatistic thesisStatistic = corpusDAO.buildCorpus(keyspace, query);

        for(Document document: thesisStatistic.getDocumentList()) {
            document.buildStats();
        }

        thesisStatistic.buildStats();
        thesisStatistic.printStats();
    }
}
