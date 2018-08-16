package Autorizador;

import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class FacilitadorFuncoes extends DriverPage{
    //Nessa classe, será armazenado os métodos para serem chamados da classe que será realizado o teste

    public WebElement getElement(String id) {
        return driver.findElement((By.id(id)));
    }

    public WebElement getElementXpath(String xpath) {

        return driver.findElement((By.xpath(xpath)));
    }

    public void efetuarLogin(String usuario, String senha) {
        getElement("ctl00_MainPlaceHolder_txtUserName").click();
        getElement("ctl00_MainPlaceHolder_txtUserName").sendKeys(usuario);
        getElement("ctl00_MainPlaceHolder_txtPassword").click();
        getElement("ctl00_MainPlaceHolder_txtPassword").sendKeys(senha);
        getElement("ctl00_MainPlaceHolder_btnLogon").click();

        // Condição caso apareça a mensagem "Session Alredy Active"
        if (getElementXpath("//div[@id='maincontent']").isDisplayed()) {
            getElement("ctl00_MainPlaceHolder_btnTerminateSession").click();
            getElement("ctl00_MainPlaceHolder_btnGo").click();
        } else {
            // Continua o processo de login no Botão "Continue"
            getElement("ctl00_MainPlaceHolder_btnGo]").click();
        }
    }
    public void AtendimentoAoCliente(){
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        metodoSwitchFrame("contentFrame");
        getElementXpath("//li[2][text()='Atendimento ao Cliente']").click();

        //Acessar o campo Card Number;
        driver.switchTo().defaultContent();
        metodoSwitchFrame("contentFrame");
        metodoSwitchFrame("applicationFrame");
        //driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
        driver.switchTo().frame("CardLeftPage");
        getElementXpath("//input[@id='ctlSearch_txtfind']").click();
        getElementXpath("//input[@id='ctlSearch_txtfind']").sendKeys("666");
        getElementXpath("//input[@id='ctlSearch_txtfind']").clear();
    }
    public void realizarLogOff(){
        metodoSwitchFrame("bannerFrame");
        getElementXpath("//a[@id='aLogOff']").click();
    }
    public void metodoSwitchFrame(String frame){
        driver.switchTo().frame(frame);
    }
    public void alteracaoIdioma(){
        metodoSwitchFrame("bannerFrame");
        getElementXpath("//select[@name='ddlLanguage']").click();
        getElementXpath("//option[@value='pt-BR']").click();

    }



}
