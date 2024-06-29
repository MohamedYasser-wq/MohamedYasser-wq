package com.example.cashout.Data;

public class ResponseLogin {

    private String accessToken;
    private String tokenType;
    private UserDTOBean userDTO;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public UserDTOBean getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTOBean userDTO) {
        this.userDTO = userDTO;
    }

    public static class UserDTOBean {

        private int id;
        private String nationalId;
        private String username;
        private String mobileNumber;
        private String imageUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNationalId() {
            return nationalId;
        }

        public void setNationalId(String nationalId) {
            this.nationalId = nationalId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }
}
