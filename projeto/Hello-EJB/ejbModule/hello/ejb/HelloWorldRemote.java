package hello.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloWorldRemote {

	public String sayHello(String something);
	
}
