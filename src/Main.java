import java.net.*;
class W2SwingIPaddress {

    public static void main(String[] args) {
        try
        {
            new MainWindow();
        }
        catch( UnknownHostException e )
        {
            System.out.println("Unable to resolve name and address");
        }
    }

}