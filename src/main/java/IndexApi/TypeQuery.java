package IndexApi;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;

import java.net.UnknownHostException;

/**
 * Auther: dyh
 * Date: 2019/5/3 20:36
 * Description:
 */
public class TypeQuery {
    public static void main(String[] args)throws Exception {
        queryDSL();
    }


    public static void queryDSL() throws UnknownHostException {
        TransportClient client = TransportClientFactory.getClient();
        SearchResponse searchResponse = client.prepareSearch()
                .setIndices("school")
                .setQuery(QueryBuilders.typeQuery("student"))
                .setSize(20)    // 返回数量
                .get();
        searchResponse.getHits().forEach(e -> {
            System.out.println(e.getSourceAsString());
        });
        System.out.println("命中：" + searchResponse.getHits().totalHits);

    }
}
