
package javafxapplication13;

import java.io.IOException;

public class Admin extends User{
    public boolean access(String name, String pass){
        if(name.equals("admin")&&pass.equals("admin1")){
            return true;
        }
        else 
        return false;
    }
    public void changeRate(double _nr) throws IOException{
        double nr = _nr;
        changeInterest(nr);
    }
}
