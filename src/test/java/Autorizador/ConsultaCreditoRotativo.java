package Autorizador;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConsultaCreditoRotativo {

    FacilitadorFuncoes facilit = new FacilitadorFuncoes();

    @Before
    public void setUp(){
        facilit.getChrome("https://10.113.3.24/PRIME4/TSPrimeRoot/Default.aspx");
        facilit.efetuarLogin("cl7496_40546042856","Cog2022@");
        facilit.alteracaoIdioma();
    }
    @Test
    public void testConsultaCreditoRotativo(){
        facilit.AtendimentoAoCliente();
    }
    @After
    public void tearDown(){
        facilit.realizarLogOff();
    }
}
