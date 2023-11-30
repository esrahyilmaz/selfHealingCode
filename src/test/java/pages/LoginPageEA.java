package pages;


import helpers.BaseClass;
import helpers.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class LoginPageEA extends BaseClass {

    //	ExcelReader _dataRepo = new ExcelReader();
    private By clientId = By.name("accountnumber");
    private By userId = By.name("username");
    private By password = By.name("password");
    private By signInBtn = By.id("signOn");
    private By InvalidCredentials = By.xpath("//div[contains(text(),'Invalid Credentials')]");
    private By okBTn = By.xpath("//div[@class='html-face']//td");
    private By ForgotPWBtn = By.xpath("//a[@class='forgotPasswordLink']");
    private By submitBtn = By.xpath("//*[@id='submitBtn']");
    private By answer = By.xpath("//*[@type='password']");
    private By ConfirmPWTB = By.xpath("//*[@name='confirmPassword']");
    private By ReturnBtn = By.xpath("//*[@id='returnBtn']");
    private By proceedBtn = By.xpath("//td[@class='html-face' and text()='Proceed']");
    private By UserInformation = By.xpath("//div[text()='User Information']");
    private By UserSubmitBTn = By.id("submitBtn");
    private By agreeBtn = By.id("agreeBtn");
    private By Alerts_Notification = By.xpath("//div[text()='Alerts & Notifications']");
    private By continueBTn = By.id("continueBtn");
    private By OK = By.name("ok");
    private By homePage = By.id("home");
    private By ChangePasswordPage = By.xpath("//div[.='Change Password']");
    private By OldPWTB = By.xpath("//input[@name='oldPassword']");
    private By NewPWTB = By.xpath("//input[@name='password']");
    private By ConfirmNewPWTB = By.xpath("//input[@name='confirmPassword']");
    private static String DBPassword = "";
    private By homeMenu = By.id("EE_MENU_HOME");
    private By username = By.name("userName");
    private By login = By.xpath("//span[contains(text(),'Login')]");
    private By continueBtn = By.id("siteNavBar_welcomeBackBarLoggedOut_JicsLoginRedirectContinue");

    private EventFiringWebDriver eventFiringWebDriver;

    public LoginPageEA(EventFiringWebDriver driver) {
        this.eventFiringWebDriver = driver;
    }

    public void openUrl(String url) {
        loadUrl(eventFiringWebDriver, url);
        wait(15);
    }

    public void enterClientID(String id) {
        isDisplayed(eventFiringWebDriver, clientId, 10);
        enterTextToElement(eventFiringWebDriver, clientId, id);
    }

    public void enterUserID(String id) {
        setAttribute(eventFiringWebDriver, userId, "name", "userName");
        if (isDisplayed(eventFiringWebDriver, userId))
            enterTextToElement(eventFiringWebDriver, userId, id);
        else
            WebElementHelper.enterText(eventFiringWebDriver, userId, id);
    }

    public void enterPassword(String passw) {
        enterTextToElement(eventFiringWebDriver, password, passw);
    }

    public void clickSignInButton() {
//        setAttribute(eventFiringWebDriver, userId, "id", "loginBtn");
        if (isDisplayed(eventFiringWebDriver, signInBtn))
            clickOnElement(eventFiringWebDriver, signInBtn);
        else
            WebElementHelper.clickElement(eventFiringWebDriver, signInBtn);
    }

    public void clickProceedButton() {
        if (isDisplayed(eventFiringWebDriver, proceedBtn, 3))
            clickOnElement(eventFiringWebDriver, proceedBtn);
    }

    public void enterAnswer(String answ) {
        if (isDisplayed(eventFiringWebDriver, answer, 5))
            enterTextToElement(eventFiringWebDriver, answer, answ);
    }

    public void clickSubmitButton() {
        if (isDisplayed(eventFiringWebDriver, submitBtn))
            clickOnElement(eventFiringWebDriver, submitBtn);
    }

    public void clickAgreeBtn() {
        isDisplayed(eventFiringWebDriver, agreeBtn, 5);
        clickOnElement(eventFiringWebDriver, agreeBtn);
    }

    public boolean isDisplayedEaHomePage() {
        return isDisplayed(eventFiringWebDriver, homeMenu, 40);
    }

    public void enteruser(String user) {
        setAttribute(eventFiringWebDriver,username,"name","username");
        enterTextToElement(eventFiringWebDriver, username, user);
        wait(5);
    }

    public void clickLogin() {
        if (isDisplayed(eventFiringWebDriver, login))
            clickOnElement(eventFiringWebDriver, login);
        else
            WebElementHelper.clickElement(eventFiringWebDriver, login);

    }

    public void clickContinueBtn() {
        if (isDisplayed(eventFiringWebDriver, continueBtn))
            clickOnElement(eventFiringWebDriver, continueBtn);
        else
            WebElementHelper.clickElement(eventFiringWebDriver, continueBtn);
    }


//    public void login(String AccountNO, String UserName, String env) throws InterruptedException, Exception {
//        String Password = null;
//        String mysqlConn = PropertyFileReader.getProperty("AutomationConnection");
//        String mysqlUser = PropertyFileReader.getProperty("AutomationUserID");
//        String mysqlPass = PropertyFileReader.getProperty("AutomationPassword");
//
//        Connection dbConn = null;
//        PreparedStatement prepStmt = null;
//        Statement Stmt = null;
//        ResultSet rs = null;
//        String sql = null;
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//        } catch (Exception E) {
//            System.err.println("Unable to load driver");
//            E.printStackTrace();
//        }
//
//        try {
//            dbConn = DriverManager.getConnection(mysqlConn, mysqlUser, mysqlPass);
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        try {
//            //Date date = new Date();
//            dbConn.setAutoCommit(true);
//            //  sql="SELECT PASSWORD FROM fw_Env_Login WHERE Environment='BLR-QC2' AND Account_Number='111000LMS' AND User_Name='Tester'";
//            sql = "SELECT PASSWORD FROM fw_Env_Login WHERE Environment= '" + env + "' AND Account_Number= '" + AccountNO + "' AND User_Name='" + UserName + "'";
//
//            Stmt = dbConn.createStatement();
//
//
//            System.out.println(sql);
//            rs = Stmt.executeQuery(sql);
//            if (rs.next()) {
//
//                String DBPassword = rs.getString("Password");
//                this.DBPassword = DBPassword;
//                System.out.println(DBPassword);
//            }
//            rs.close();
//        } catch (SQLException e) {
//            logger.error(e);
//        } finally {
//            try {
//                if (dbConn != null)
//                    dbConn.close();
//            } catch (Exception e) {
//                logger.error(e);
//            }
//        }
//        try {
//            Password = DBPassword;
//
//            EnterText(AccountTB, "Entered Account number " + AccountNO, AccountNO);
//            EnterText(UserNameTB, "Entered UserName " + UserName, UserName);
//            EnterText(PasswordTB, "Entered Password" + Password, Password);
//            clickElement(SigninBTN, "Clicked on Sign in button");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        Password = null;
//        Random rand = new Random();
//        int rand_num = rand.nextInt(100000);
//        Password = "Testing@" + rand_num;
//        final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date(rand_num);
//        String date1 = sdf.format(date);
//
//        if (verifyElementPresence(InvalidCredentials)) {
//            try {
//                clickElement(OKBTn, "Clicked on ok button");
//                clickElement(ForgotPWBTn, "Clicked on Forgot Password");
//                EnterText(AccountTB, "Entered Account number " + AccountNO, AccountNO);
//                EnterText(UserNameTB, "Entered UserName " + UserName, UserName);
//                clickElement(SubmitBTN, "Clicked on Submit button");
//                String Answer = _dataRepo.getData("SecurityAns");
//                if (Answer == null || Answer.equalsIgnoreCase("")) {
//                    Answer = "Test";
//                }
//                EnterText(SecretTB, "Entered Secret Answer", Answer);
//                clickElement(SubmitBTN, "Clicked on Submit Button");
//                EnterText(PasswordTB, "Entered new Password " + Password, Password);
//                EnterText(ConfirmPWTB, "Entered confirm new Password " + Password, Password);
//                clickElement(SubmitBTN, "Clicked on submit Button");
//                clickElement(ReturnBTN, "Clicked on Return Button");
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
//            try {
//                Class.forName("com.mysql.jdbc.Driver").newInstance();
//            } catch (Exception E) {
//                System.err.println("Unable to load driver");
//                E.printStackTrace();
//            }
//
//            try {
//                dbConn = DriverManager.getConnection(mysqlConn, mysqlUser, mysqlPass);
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//
//
//            try {
//
//                dbConn.setAutoCommit(true);
//
//                sql = "UPDATE fw_Env_Login SET Password='" + Password + "', Update_Date='" + date + "', Updated_BY='Automation' WHERE Environment='" + env + "' AND Account_Number='" + AccountNO + "' AND User_Name='" + UserName + "'";
//
//                Stmt = dbConn.createStatement();
//
//
//                System.out.println(sql);
//                int count = Stmt.executeUpdate(sql);
//                System.out.println("Updated queries: " + count);
//                System.out.println("Password Updated :" + Password);
//                rs.close();
//            } catch (SQLException e) {
//                logger.error(e);
//            } finally {
//                try {
//                    if (dbConn != null)
//                        dbConn.close();
//                } catch (Exception e) {
//                    logger.error(e);
//                }
//            }
//
//
//            EnterText(AccountTB, "textbox field", AccountNO);
//            EnterText(UserNameTB, "textbox field", UserName);
//            EnterText(PasswordTB, "textbox field", Password);
//            clickElement(SigninBTN, "button");
//
//        }
//        if (verifyElementPresence(ChangePasswordPage)) {
//
//            try {
//
//                String Answer = _dataRepo.getData("SecurityAns");
//                if (Answer == null || Answer.equalsIgnoreCase("")) {
//                    Answer = "Test";
//                }
//                EnterText(OldPWTB, "old password", DBPassword);
//                EnterText(PasswordTB, "Entered new Password " + Password, Password);
//                EnterText(ConfirmPWTB, "Entered confirm new Password " + Password, Password);
//                clickElement(SubmitBTN, "Clicked on submit Button");
//                clickElement(ReturnBTN, "Clicked on Return Button");
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
//            try {
//                Class.forName("com.mysql.jdbc.Driver").newInstance();
//            } catch (Exception E) {
//                System.err.println("Unable to load driver");
//                E.printStackTrace();
//            }
//
//            try {
//                dbConn = DriverManager.getConnection(mysqlConn, mysqlUser, mysqlPass);
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//
//
//            try {
//
//                dbConn.setAutoCommit(true);
//
//                sql = "UPDATE fw_Env_Login SET Password='" + Password + "', Update_Date='" + date + "', Updated_BY='Automation' WHERE Environment='" + env + "' AND Account_Number='" + AccountNO + "' AND User_Name='" + UserName + "'";
//
//                Stmt = dbConn.createStatement();
//
//
//                System.out.println(sql);
//                int count = Stmt.executeUpdate(sql);
//                System.out.println("Updated queries: " + count);
//                System.out.println("Password Updated :" + Password);
//                rs.close();
//            } catch (SQLException e) {
//                logger.error(e);
//            } finally {
//                try {
//                    if (dbConn != null)
//                        dbConn.close();
//                } catch (Exception e) {
//                    logger.error(e);
//                }
//
//                try {
//
//
//                    EnterText(AccountTB, "Entered Account number " + AccountNO, AccountNO);
//                    EnterText(UserNameTB, "Entered UserName " + UserName, UserName);
//                    EnterText(PasswordTB, "Entered Password" + Password, Password);
//                    clickElement(SigninBTN, "Clicked on Sign in button");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        if (verifyElementPresence(proceedBTN)) {
//            clickElement(proceedBTN, "button");
//        }
//
//        if (verifyElementPresence(SecretTB)) {
//            String Answer = _dataRepo.getData("SecurityAns");
//            if (Answer == null || Answer.equalsIgnoreCase("")) {
//                Answer = "Test";
//            }
//            EnterText(SecretTB, "Entered Secret Answer", Answer);
//            clickElement(SubmitBTN, "Clicked on Submit Button");
//        }
//
//        if (verifyElementPresence(proceedBTN)) {
//            clickElement(proceedBTN, "button");
//        }
//
//        //check for user information update
//        if (verifyElementPresence(UserInformation)) {
//            clickElement(UserSubmitBTn, "button");
//        }
//
//        //click agreen button and check for UI
//        if (verifyElementPresence(AgreeBTn)) {
//            clickElement(AgreeBTn, "button");
//
//
//            //alerts & notifications
//            if (verifyElementPresence(Alerts_Notification)) {
//                clickElement(continueBTn, "button");
//            }
//
//                                                                /*//this.waitFor(By.id("EE_MENU_HOME"), 7);
//                                                                this.waitForDisappear(EspEnv.progressSpinner);*/
//        } else {
//            clickElementWithWait(OK, "waited and cliked OK");
//            verifyElementPresence(HomePage);
//
//
//        }
//
//
//    }

}


