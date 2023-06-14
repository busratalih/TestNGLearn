package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;
import utilities.ReusableMethods;

public class ProductPage {

    public ProductPage() {

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(css = "input[placeholder='Ara Amazon.com.tr']")
    private WebElement searchBox;

    @FindBy(id = "s-result-sort-select")
    private WebElement dropDown;

    @FindBy(xpath = "(//label/i)[4]")
    private WebElement marka;

    @FindBy(xpath = "(//h2/a)[1]")
    private WebElement firstBrand;

    @FindBy(className = "a-price-whole")
    private WebElement price;

        
        
    public void compareProductPrices(String brand){

        String bigP = "Fiyat: Yüksekten Düşüğe";
        String smallP = "Fiyat: Düşükten Yükseğe";

        searchBox.sendKeys(brand+ Keys.ENTER);

        ReusableMethods.selectByVisibleText(dropDown,bigP);

        ReusableMethods.scrollIntoViewJS(marka);

        marka.click();

        firstBrand.click();

        String intPrice = price.getText().replace(".","");

        System.out.println("price.getText() = " + intPrice);



        int highPrice=Integer.parseInt(intPrice);

        System.out.println("intPrice = " + intPrice);

        Driver.getDriver().navigate().back();

        ReusableMethods.selectByVisibleText(dropDown,smallP);

        firstBrand.click();

        String smllPrice = price.getText().replace(".","");

        System.out.println("price.getText() = " + smllPrice);

        int smallPrice = Integer.parseInt(price.getText());

        System.out.println("smallPrice = " + smallPrice);

        Assert.assertTrue(highPrice>smallPrice);


    }




}
