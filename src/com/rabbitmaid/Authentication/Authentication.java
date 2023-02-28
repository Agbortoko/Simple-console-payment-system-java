package com.rabbitmaid.Authentication;
import java.util.HashMap;


public class Authentication {

    public String username;
    public String password;
    protected Boolean isLoggedIn;

    public void login() {

        String username  = this.username;
        String password = this.password;

        HashMap<String, String> userInformation = new HashMap<String, String>();

        // Set saved user data
        userInformation.put("rabbitmaid", "lolita");
        userInformation.put("joebiden", "mikie80");
        userInformation.put("lofy", "lofy2020");

        for (String i : userInformation.keySet()) {

            if(userInformation.containsKey(username) && userInformation.containsValue(password)){
                System.out.println("Login Successfully!");
                this.isLoggedIn = true;
                break;
            }else{
                System.out.println("Wrong Login Credentials!");
                this.isLoggedIn = false;
                break;
            }
        }
    }


    public Boolean getLoggedState()
    {
        return this.isLoggedIn;
    }


    public String[][] accountInformation()
    {
        String[][] accountInfo = {
                {"rabbitmaid", "RabbitMaid", "100000", "12AD3223AD12AD"},
                {"joebiden", "Joe Biden", "150000", "48ED3DDA3AD12AD"},
                {"lofy", "Monkey the Lofy", "4000000", "U8ED3DDA52D12AD"}
        };

        return accountInfo;
    }

}
