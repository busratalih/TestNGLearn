package test;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ProductPage;
import utilities.BaseTestReport;

public class AmazonTestNG  extends BaseTestReport {

    ProductPage pp = new ProductPage();

        
    @Test(dataProvider = "brand")
    public void test(String product){

        pp.compareProductPrices(product);

    }
    @DataProvider
    public Object[][] brand() {

        Object[][] data ={
                {"Apple"},
                {"Xiaomi"},
                {"Oppo"}

    };
        return data;

    }



    @Test
    public void test1(){

        pp.compareProductPrices("Apple");


    }





}
