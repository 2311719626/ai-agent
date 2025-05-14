package com.hezhaohui.aiagent.rag;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PgVectorVectorStoreConfigTest {

    @Resource
    private VectorStore pgVectorVectorStore;


    @Test
    void pgVectorVectorStore() {
        List<Document> documents = List.of(
                new Document("我是一个大学生，正在谈恋爱"),
                new Document("我很喜欢我的对象"),
                new Document("我的对象每天给我做饭"));

        // Add the documents to PGVector
        pgVectorVectorStore.add(documents);

        // Retrieve documents similar to a query
        List<Document> results = this.pgVectorVectorStore.similaritySearch(SearchRequest.builder().query("和对象谈恋爱").topK(5).build());
        Assertions.assertNotNull(results);
    }
}