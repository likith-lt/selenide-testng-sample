package com.lambdatest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.title;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleTest extends LambdaTestSetup {

	@Test
	public void test() throws Exception {

		System.out.println("Loading Url");
        open("https://stage-demo.lambdatest.com/");

            // Let's select the location
            $(By.id("headlessui-listbox-button-1")).click();
            $(By.id("Bali")).click();
            System.out.println("Location is selected as Bali.");
            // Let's select the number of guests
            $(By.id("headlessui-listbox-button-5")).click();
            $(By.id("2")).click();
            System.out.println("Number of guests are selected.");
            $(By.xpath("//*[@id='search']")).click();
            Thread.sleep(3000);
            // Let's select one of the hotels for booking
            $(By.id("reserve-now")).click();
            Thread.sleep(3000);
            $(By.id("proceed")).click();
            Thread.sleep(3000);
            System.out.println("Booking is confirmed.");
            // Let's download the invoice
            boolean exec = $(By.id("invoice")).isDisplayed();
            if(exec){
                status = "passed";
                $(By.id("invoice")).click();
                System.out.println("Tests are run successfully!");
            }
            else
                status="failed";
	}

}
