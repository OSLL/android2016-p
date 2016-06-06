import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {
    ServerSocket server;
    ArrayList<Connection> connections = new ArrayList<>();


    Server(int port) {
        System.out.println("Server started");
        try {
            server = new ServerSocket(port);
            while (true) {
                try {

                    Socket socket = server.accept();
                    Connection connection = new Connection(socket);
                    connections.add(connection);
                    connection.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void end() {
        try {
            server.close();

            connections.forEach(Connection::close);
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private class Connection extends Thread {
        private BufferedReader in;
        private PrintWriter out;
        private Socket socket;

        private String nick;

        Connection(Socket sock) {
            this.socket = sock;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void run() {
            try {
                nick = in.readLine();

                for (Connection c : connections) {
                    c.out.println(nick + " cames now");
                }

                String message = "";
                while (true) {
                    message = in.readLine();
                    if (message.equals("exit"))
                        break;
                    for (Connection c : connections) {
                        c.out.println(nick + ": " + message);
                    }
                }

                for (Connection c : connections) {
                    c.out.println(nick + " has left.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void close(){
            try {
                in.close();
                out.close();
                socket.close();

                connections.remove(this);
                if (connections.size() == 0) {
                    Server.this.end();
                    System.exit(0);
                }
            }
            catch (Exception e) {
                System.err.println("Threads wasn't closed");
            }

        }
    }
}
