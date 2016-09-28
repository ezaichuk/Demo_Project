package util;

public enum UserRoles {

    SUBSCRIBER("subscriber"),
    SHOP_MANAGER("shop_manager"),
    CUSTOMER("customer"),
    CONTRIBUTOR("contributor"),
    AUTHOR("author"),
    EDITOR("editor"),
    ADMINISTRATOR("administrator");

    private String value;

    UserRoles(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
    
}