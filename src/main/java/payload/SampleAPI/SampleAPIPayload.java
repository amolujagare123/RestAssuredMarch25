package payload.SampleAPI;

public class SampleAPIPayload {

    public static String getCreateUserPayload(String name , String job)
    {
        return "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}";
    }


}
