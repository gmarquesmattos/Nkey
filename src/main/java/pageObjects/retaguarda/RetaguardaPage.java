package pageObjects.retaguarda;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;


public class RetaguardaPage extends BasePage {


   public RetaguardaPage(WebDriver driver) {
        super(driver);
    }
   private By tabelaCategoria = By.cssSelector("div.siebui-view:nth-child(2) div.siebui-applet.siebui-collapsible-applet.siebui-list.Selected.siebui-active.siebui-applet-active.siebui-hilight:nth-child(3) span.AppletStyleParent77 div.NotSelected div.AppletHIListBorder.siebui-applet-content.siebui-collapsible.siebui-collapsible-applet-content:nth-child(4) div.ui-jqgrid.ui-widget.ui-widget-content.ui-corner-all div.ui-jqgrid-view div.ui-jqgrid-bdiv table.ui-jqgrid-btable:nth-child(2) tbody:nth-child(1) tr.ui-widget-content.jqgrow.ui-row-ltr.ui-state-highlight:nth-child(2) td:nth-child(4) > a.drilldown");
   private By seletorVisibilidade = By.name("s_vis_div");
   private By opcaoTodosMeusAtendimentos = By.xpath("//div[@id='_swecontent']//option[2]");

    public RetaguardaPage acessarCadastroCanais() {
        HomePage homePO = new HomePage(driver);
        homePO.selecionarMenuHome();
        clicar(seletorVisibilidade);
        clicar(opcaoTodosMeusAtendimentos);

        return this;
    }


    public RetaguardaPage entrarRetarguarda() {


        clicar(tabelaCategoria);
        return this;

    }
}

