package Utils;

import org.json.JSONObject;

public class APIPayLoadConstants {
    //we will pass the body in multiple formats, for this we have created this class

    public static String createEmployeePayload() {
        String createEmployeePayload = ("{\n" +
                "  \"emp_firstname\": \"Lara\",\n" +
                "  \"emp_lastname\": \"Zurgi\",\n" +
                "  \"emp_middle_name\": \"G\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"1976-08-11\",\n" +
                "  \"emp_status\": \"active\",\n" +
                "  \"emp_job_title\": \"Engineer\"\n" +
                "}");
        return createEmployeePayload;

    }
//second option: another way is json object (you can do either way)
    public static String createEmployeePayloadJson() {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "Lara");
        obj.put("emp_lastname", "Zurgi");
        obj.put("emp_middle_name", "G");
        obj.put("emp_gender", "F");
        obj.put("emp_birthday", "1976-08-11");
        obj.put("emp_status", "active");
        obj.put("emp_job_title", "Engineer");
        return obj.toString();
    }
    //-------------------------------------------------------------------------------
    public static String createEmployeePayloadDynamic(String emp_firstname, String emp_lastname, String emp_middle_name, String emp_gender, String emp_birthday, String emp_status, String emp_job_title) {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);
        return obj.toString();
    }

    public static String updateEmployeePayloadJson() {
        JSONObject obj = new JSONObject();
        obj.put("employee_id", "53151A");
        obj.put("emp_firstname", "Lilu");
        obj.put("emp_lastname", "Virgo");
        obj.put("emp_middle_name", "S");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "1984-09-11");
        obj.put("emp_status", "active");
        obj.put("emp_job_title", "Engineer");
        return obj.toString();
}}
