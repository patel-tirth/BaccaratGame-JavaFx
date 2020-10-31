package projectThreeClient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.function.Consumer;

public class Client  extends Thread{
	
    Socket socketClient;
	
	ObjectOutputStream out;
	ObjectInputStream in;
	
	BaccaratInfo info;
   private Consumer<Serializable> callback;
	
	public Client(Consumer<Serializable> call){
	
		callback = call;
	}
	
		public void run() {
		
		try {
		socketClient= new Socket("127.0.0.1",5555);
	    out = new ObjectOutputStream(socketClient.getOutputStream());
	    in = new ObjectInputStream(socketClient.getInputStream());
	    socketClient.setTcpNoDelay(true);
		}
		catch(Exception e) {}
		
		while(true) {
			 
			try {
		    info = (BaccaratInfo) in.readObject();
			callback.accept(info);
			}
			catch(Exception e) {}
		}
	
    }
	
	public void send(BaccaratInfo info) {
		
		try {
			out.writeObject(info.bidAmount);
			out.writeObject(info.bidOnPerson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
