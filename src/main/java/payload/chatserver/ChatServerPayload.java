package payload.chatserver;

public class ChatServerPayload {

    public static String getCreateUserPlayLoad()
    {
        return "{\n" +
                "  \"username\": \"john_doe\",\n" +
                "  \"password\": \"SecurePass123!\",\n" +
                "  \"email\": \"john.doe@example.com\",\n" +
                "  \"name\": \"John\",\n" +
                "  \"surname\": \"Doe\",\n" +
                "  \"chat_nickname\": \"JohnnyD\",\n" +
                "  \"departments\": [\n" +
                "    1,\n" +
                "    2\n" +
                "  ],\n" +
                "  \"departments_read\": [\n" +
                "    2\n" +
                "  ],\n" +
                "  \"department_groups\": [\n" +
                "    1\n" +
                "  ],\n" +
                "  \"user_groups\": [\n" +
                "    1\n" +
                "  ]\n" +
                "}\n";
    }

    public static String getCreateUserPlayLoad(String username,String password
            ,String email,String name,String surname,String nickName)
    {
        return "{\n" +
                "  \"username\": \""+username+"\",\n" +
                "  \"password\": \""+password+"\",\n" +
                "  \"email\": \""+email+"\",\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"surname\": \""+surname+"\",\n" +
                "  \"chat_nickname\": \""+nickName+"\",\n" +
                "  \"departments\": [\n" +
                "    1,\n" +
                "    2\n" +
                "  ],\n" +
                "  \"departments_read\": [\n" +
                "    2\n" +
                "  ],\n" +
                "  \"department_groups\": [\n" +
                "    1\n" +
                "  ],\n" +
                "  \"user_groups\": [\n" +
                "    1\n" +
                "  ]\n" +
                "}\n";
    }
}
