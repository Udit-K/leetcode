package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Solution {

    public String[] getMovieTitles(String substr) {
        String[] movieNameArray = getAllMovies(substr);

        return null;
    }

    private static String[] getAllMovies(String movieName) {
        try {
            URL url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + movieName);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "Application/json");

            if(con.getResponseCode() != 200) {
                throw new Exception("error calling api");
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //print in String
            System.out.println(response.toString());
            //Read JSON response and print

            System.out.println(response);

        }catch(Exception e) {

        }
        return null;
    }

    class Movie {
        String page;
        Integer per_page;
        Integer total;
        Integer total_pages;
        List<Data> data;

        public Movie() {

        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public Integer getPer_page() {
            return per_page;
        }

        public void setPer_page(Integer per_page) {
            this.per_page = per_page;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(Integer total_pages) {
            this.total_pages = total_pages;
        }

        public List<Data> getData() {
            return data;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }
    }

    class Data {
        String title;
        String year;
        String imdbID;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getImdbID() {
            return imdbID;
        }

        public void setImdbID(String imdbID) {
            this.imdbID = imdbID;
        }
    }
}
