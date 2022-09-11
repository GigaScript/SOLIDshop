package entity;

import repositorys.PrivilegesRepository;

import java.util.List;

public class User {
    private PrivilegesRepository privileges;
    private final String email;
    private String password;
    private String nickName;

    private User(PrivilegesRepository privileges, String email, String password, String nickName) {
        this.privileges = privileges;
        this.email = email;
        this.password = password;
        this.nickName = nickName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public PrivilegesRepository getPrivileges() {
        return privileges;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNickName() {
        return nickName;
    }


    public static class Builder {
        private PrivilegesRepository privileges;
        private String email;
        private String password;
        private String nickName;
        private Cart cart;
        private List<Order> orderList;

        public Builder() {
        }

        public Builder setPrivileges(PrivilegesRepository privileges) {
            this.privileges = privileges;
            return this;
        }

        public Builder setEmail(String email) {
            this.nickName = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.nickName = password;
            return this;
        }

        public Builder setNickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public Builder setOrderList(List<Order> orderList) {
            this.orderList = orderList;
            return this;
        }

        public User build() {
            return new User(privileges, email, password, nickName);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.equals(getEmail())) {
            return true;
        } else {
            return false;
        }
    }
}
