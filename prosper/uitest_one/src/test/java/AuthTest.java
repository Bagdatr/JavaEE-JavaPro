import org.junit.jupiter.api.Test;

public class AuthTest extends BaseTest{

    private final static String BASE_URL = "https://cabinet.preprod.prosperpay.kz/";
    private final static String login = "171140025252_A";
    private final static String password = "fb3ca8ab-34a";

    @Test
    public void checkAuth(){
        AuthPage authPage = new AuthPage();
        authPage.openSite(BASE_URL);
        int a = 0;
    }


}
