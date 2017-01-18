package server;
/*
 * An interface to handle the starting and termination of server
 */
public interface HandleServer {
	public void startServer(int port);
	public void terminateServer();
}
