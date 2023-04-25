package kz.bagdat.springboot_tables_bunch.beans;

import org.springframework.stereotype.Component;

@Component
public class TestBean {

    private String text = "Hello";

    public TestBean(){
        System.out.println("Creating Test Bean");
    }

    public void setText (String text){
        this.text = text;
    }

    public String getData(){
        return "This is "+this.text+" data";
    }

}
