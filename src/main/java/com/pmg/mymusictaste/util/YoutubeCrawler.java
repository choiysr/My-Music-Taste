package com.pmg.mymusictaste.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTube.Search;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.pmg.mymusictaste.DTO.SongInfo;
/**
 * YoutubeCrawler
 */
public class YoutubeCrawler {

    // 참고할 파일명(GoogleAPI Key 정보)
    private static String PROPERTIES_FILENAME = "youtube.properties";

    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

    private static final JsonFactory JSON_FACTORY = new JacksonFactory();

    // 검색해서 가져올 결과 갯수 
    private static final long NUMBER_OF_VIDEOS_RETURNED = 1;

    // API Request를 만드는 객체 
    private static YouTube youtube;

    private static List<SongInfo> songList;

    public YoutubeCrawler(List<SongInfo> songList) {
        this.songList = songList;
    }

    public void useYoutubeAPI() {
        Properties properties = new Properties();
        try {
            // youtube.properties파일을 참고한다. 
            InputStream in = Search.class.getResourceAsStream("/" + PROPERTIES_FILENAME);
            properties.load(in);
        } catch (IOException e) {
            System.err.println("There was an error reading " + PROPERTIES_FILENAME + ": " + e.getCause() + " : " + e.getMessage());
            System.exit(1);
        }

        try {
            /*
             * The YouTube object is used to make all API requests. The last argument is
             * required, but because we don't need anything initialized when the HttpRequest
             * is initialized, we override the interface and provide a no-op function.
             */
            youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
                public void initialize(HttpRequest request) throws IOException {
                }
            }).setApplicationName("youtube-cmdline-search-sample").build();

            // 검색 키워드를 가져오는 getInputQuery 호출 
            // String queryTerm = getInputQuery();

            YouTube.Search.List search = youtube.search().list("id,snippet");
            /*
             * It is important to set your API key from the Google Developer Console for
             * non-authenticated requests (found under the Credentials tab at this link:
             * console.developers.google.com/). This is good practice and increased your
             * quota.
             */
            String apiKey = properties.getProperty("youtube.apikey");
            search.setKey(apiKey);
            search.setType("video");
            /*
             * This method reduces the info returned to only the fields we need and makes
             * calls more efficient.
             */
            search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
            search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);

            for(SongInfo song : songList) {
                String queryTerm = song.getTitle()+" "+song.getSinger()+" official";
                search.setQ(queryTerm);
                SearchListResponse searchResponse = search.execute();
                List<SearchResult> searchResultList = searchResponse.getItems();
    
                if (searchResultList != null) {
                    prettyPrint(searchResultList.iterator(), queryTerm);
                }
            }
            
        } catch (GoogleJsonResponseException e) {
            System.err.println(
                    "There was a service error: " + e.getDetails().getCode() + " : " + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }



    /*
     * Returns a query term (String) from user via the terminal.
     */
    private static String getInputQuery() throws IOException {

        String inputQuery = "조정석 아로하 official";

        // 콘솔로 입력받을 시 사용. 
        // System.out.print("Please enter a search term: ");
        // BufferedReader bReader = new BufferedReader(new
        // InputStreamReader(System.in));
        // inputQuery = bReader.readLine();

        if (inputQuery.length() < 1) {
            // If nothing is entered, defaults to "YouTube Developers Live."
            inputQuery = "YouTube Developers Live";
        }
        return inputQuery;
    }

    /*
     * Prints out all SearchResults in the Iterator. Each printed line includes
     * title, id, and thumbnail.
     *
     * @param iteratorSearchResults Iterator of SearchResults to print
     *
     * @param query Search query (String)
     */
    private static void prettyPrint(Iterator<SearchResult> iteratorSearchResults, String query) {

        System.out.println("\n=============================================================");
        System.out.println("   First " + NUMBER_OF_VIDEOS_RETURNED + " videos for search on \"" + query + "\".");
        System.out.println("=============================================================\n");
        if (!iteratorSearchResults.hasNext()) {
            System.out.println(" There aren't any results for your query.");
        }
        while (iteratorSearchResults.hasNext()) {

            SearchResult singleVideo = iteratorSearchResults.next();
            ResourceId rId = singleVideo.getId();
            // Double checks the kind is video.
            if (rId.getKind().equals("youtube#video")) {
                // 썸네일 필요시 사용.
                // Thumbnail thumbnail = (Thumbnail) singleVideo.getSnippet().getThumbnails().get("default");
                System.out.println(" Video Id" + rId.getVideoId());
                System.out.println(" Title: " + singleVideo.getSnippet().getTitle());
                // System.out.println(" Thumbnail: " + thumbnail.getUrl());
                System.out.println("\n-------------------------------------------------------------\n");
            }
        }
    }
}