package db;

import com.datastax.driver.core.*;
import corpus.CorpusStatistic;
import corpus.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mustafa on 05.04.2017.
 */
public class CorpusDAO {
    public CorpusStatistic buildCorpus(String keyspace, String query) {
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        Session session = cluster.connect(keyspace);

        ResultSet resultSet = session.execute(query);

        List<Document> documents = new ArrayList<Document>();
        while (resultSet.iterator().hasNext()) {
            Row row = resultSet.iterator().next();
            String sourceName = row.get(0, String.class);
            List sentenceList = row.getList(1, String.class);
            Document document = new Document();
            document.setDocumentName(sourceName);
            document.setSentenceList(sentenceList);
            documents.add(document);
        }

        CorpusStatistic corpus = new CorpusStatistic();
        corpus.setDocumentList(documents);
        session.close();
        cluster.close();
        return corpus;
    }
}
