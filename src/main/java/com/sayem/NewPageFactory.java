package com.sayem;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.reflections.Reflections;

import java.util.Set;

public class NewPageFactory {

    public static <T> T constructPage(WebDriver driver, Class<T> interfaceToProxy) {

        // Get interface namespace.
        String namespace = interfaceToProxy.getPackage().getName();

        // Get a set of classes that implements the interfaces.
        Reflections reflections = new Reflections(namespace);
        Set<Class<? extends T>> subTypes = reflections.getSubTypesOf(interfaceToProxy);


        for (Class<? extends T> classObj : subTypes) {
            try {
                T pageInstance = PageFactory.initElements(driver, classObj);

                // Page object instantiated correctly, we have found a match to
                // return.
                System.out.println("Found a matching PageObject: " + classObj.getName());
                return pageInstance;
            } catch (Exception e) {
                //These are not the droids you're looking for.
            }

        }

        return null;
    }
}
