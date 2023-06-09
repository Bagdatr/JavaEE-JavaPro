package kz.bitlab.injection;

import org.springframework.stereotype.Component;

@Component
public class DetectiveBook extends Book{

    @Override
    public int calculateTotal() {
        return getPrice() * getAmount() - 10000;
    }
}
