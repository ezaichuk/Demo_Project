package util;

public enum UserRoles {

    SUBSCRIBER("subscriber","Subscriber"),
    SHOP_MANAGER("show_manager", "Менеджер магазина"),
    CUSTOMER("customer","Клиент"),
    CONTRIBUTOR("contributor","Contributor"),
    AUTHOR("author","Author"),
    EDITOR("editor","Editor"),
    ADMINISTRATOR("administrator", "Administrator");

    private String value;
    private String rolename;

    UserRoles(String value, String rolename) {
        this.value = value;
        this.rolename = rolename;
    }

    public String value() {
        return value;
    }

    public String role(){
        return rolename;
    }

}