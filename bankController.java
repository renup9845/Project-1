package first.bank.Controller;

import first.bank.model.bankModel;

import java.io.IOException;
import java.util.regex.Pattern;

public class bankController {

    public boolean checkUsername(bankModel bm ) throws IOException{
        String username = bm.getAccHolder();

        if(Pattern.matches("[a-zA-Z0-9]{5,13}", username)){

            return true;
        }
        else {
            throw new IOException("username can only alphabets and digits");
        }
    }
}
































