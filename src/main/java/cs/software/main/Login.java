package cs.software.main;

public final class Login {
    private static Login session;
    public static boolean isLogged;
    private Login() {}

    public static Login getSession(){
        if(session == null) {
            session = new Login();
            isLogged = true;
        }
        return session;
    }

    @org.jetbrains.annotations.NotNull
    private String makePassword(String username){
        StringBuilder sb = new StringBuilder(username);
        sb.reverse();
        return sb.toString();
    }

    public boolean userLogin(String username){
        var password = makePassword(username);
        return username.length() == password.length();
    }

    public static void logout(){
        isLogged = false;
    }

}
