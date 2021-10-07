package com.example.class_8c.api;

public class Api {
    public static final String BASE_URL = "http://52.79.195.156:3000";
    public static final String GET_POST = BASE_URL + "/api/post";

    public static class Post {
        int id;
        String uploader;
        String text;
        int likes;
        String create_at;
        String updated_at;
        Image image;

        public static class Image {
            String url;

            public String getUrl() {
                return url;
            }
        }

        public int getId() {
            return id;
        }

        public String getUploader() {
            return uploader;
        }

        public String getText() {
            return text;
        }

        public int getLikes() {
            return likes;
        }

        public String getCreate_at() {
            return create_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public Image getImage() {
            return image;
        }
    }

}
