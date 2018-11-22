package hello.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloWorld
 */
@Stateless
@LocalBean
public class HelloWorld implements HelloWorldRemote {

    /**
     * Default constructor. 
     */
    public HelloWorld() {
        // TODO Auto-generated constructor stub
    }

    public String sayHello(String something) {
    	return "Hello World! " + something;
	}

}
