package com.luizacode.API.Exceptions;

public class WishlistDetails {
    private String title;
    private int status;
    private String detail;
    private long timestamp;
    private String developerMessage;

    private WishlistDetails(){

    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public static final class WishlistBuilder {
        private String title;
        private int status;
        private String detail;
        private long timestamp;
        private String developerMessage;

        private WishlistBuilder() {
        }

        public static WishlistBuilder newBuilder() {
            return new WishlistBuilder();
        }

        public WishlistBuilder title(String title) {
            this.title = title;
            return this;
        }

        public WishlistBuilder status(int status) {
            this.status = status;
            return this;
        }

        public WishlistBuilder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public WishlistBuilder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public WishlistBuilder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public WishlistDetails build() {
            WishlistDetails wishlistDetails = new WishlistDetails();
            wishlistDetails.developerMessage = this.developerMessage;
            wishlistDetails.detail = this.detail;
            wishlistDetails.timestamp = this.timestamp;
            wishlistDetails.title = this.title;
            wishlistDetails.status = this.status;
            return wishlistDetails;
        }
    }
}
