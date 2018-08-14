package Autorizador;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
        driver.switchTo().frame("contentFrame");
        getElementXpath("//li[2][text()='Atendimento ao Cliente']").click();
        driver.switchTo().defaultContent();

        //Acessar o campo Card Number
        driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
        driver.switchTo().frame("CardLeftPage");
        getElementXpath("//body[@class='left-frame']//div[@class='search-box']//div[@id='ctlSearch_update']//span[@id='ctlSearch_txtfind_dropWrapper']//input[@id='ctlSearch_txtfind']").click();
    }
    public void realizarLogOff(){
        getElementXpath("//a[@id='aLogOff']").click();
        getElementXpath("//*[contains(text(),'Log Off')]");
        //driver.switchTo().defaultContent();
    }
    public void alteracaoIdioma(){
        driver.switchTo().frame("bannerFrame");
        getElementXpath("//select[@name='ddlLanguage']").click();
        getElementXpath("//option[@value='pt-BR']").click();

    }


}
