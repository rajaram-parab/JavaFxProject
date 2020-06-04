
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

// the ticket class is implemented as seneralization because the program will convert its objects into byte.

class Ticket implements Serializable {

  // Attributes

  public String customerId; // Customer identification.
  public String lotteryNumber; // lottery number.

  // constructor

  public Ticket(String id) {

    customerId = id;
    Random obj_random = new Random();
    int cont = 0;
    String s = "";

    // random numbers are generated, from 1 to 40, this is done 6 times
    // then assigned as the lottery number.

    int num = obj_random.nextInt(39) + 2;
    s = s + "(" + num + ")";

    while (cont < 5) {

      num = obj_random.nextInt(39) + 2;
      s = s + "(" + num + ")";
      cont++;
    }

    lotteryNumber = s;
  }

  public byte[] auxGenerator() throws Exception {

    Random obj_random = new Random();
    int n = obj_random.nextInt(100) * 10;
    Ticket t = new Ticket("BA" + n + "");

    /* here I convert an object of the ticket class to bytes. */

    ByteArrayOutputStream Fl = new ByteArrayOutputStream();
    ObjectOutputStream Obj = new ObjectOutputStream(Fl);
    Obj.writeObject(t);
    Obj.flush();
    byte[] info = Fl.toByteArray();

    /* an array od byte is returned. */
    return info;
  }

  public byte[] generator() {

    // try is used because there may be errors, but runtime errors
    // if there is an error then an exception is thrown

    try {

      byte[] info = auxGenerator();
      return info;

    } catch (Exception e) {

    }

    String s = "null";
    byte[] info = s.getBytes();

    // a array of bytes is returned.
    return info;
  }
}

class ServerA {

  // all lotteries are stored in the buffer (they are stored in bytes).

  ArrayList<byte[]> buffer;

  // constructor

  public ServerA() {

    // reserve memory

    buffer = new ArrayList<byte[]>();

  }

  public void generator() {

    // The generator function is responsible for invoking an object of the ticket
    // class that proceeds to create a ticket and then returns a byte array.

    Ticket t = new Ticket("null");
    byte[] info = t.generator();

    buffer.add(info);
    serverPort(info);

  }

  public void serverPort(byte[] info) {

    // when to create a ticket proceed to send to the other server

    Lotterys.serverB.clientPort(info);

  }

  public void clientPort(byte[] info) {

    // a byte ticket is received from the opposing server

    buffer.add(info);

  }

  public void auxSeeData(byte[] info) throws Exception {

    // the information is read in bytes and then a conversion is performed
    // with the object to its class type.

    ByteArrayInputStream FL = new ByteArrayInputStream(info); // bytes es el byte[]
    ObjectInputStream Obj = new ObjectInputStream(FL);

    Ticket t = (Ticket) Obj.readObject();
    Obj.close();

    System.out.println("Receiving request from Client for Ticket and Generated Ticket No : "
        + t.customerId + "_" + t.lotteryNumber.replace("(", "").replace(")", ""));
  }

  public void seeData(byte[] info) {

    // function that to read data from the server.

    try {

      auxSeeData(info);

    } catch (Exception e) {

      System.out.println(e.getMessage());
    }

  }

}

class ServerB {

  ArrayList<byte[]> buffer;

  public ServerB() {

    buffer = new ArrayList<byte[]>();

  }

  public void generator() {

    // The generator function is responsible for invoking an object of the ticket
    // class that proceeds to create a ticket and then returns a byte array.

    Ticket t = new Ticket("null");
    byte[] info = t.generator();
    buffer.add(info);
    serverPort(info);

  }

  public void serverPort(byte[] info) {

    // when to create a ticket proceed to send to the other server

    Lotterys.serverA.clientPort(info);

  }

  public void clientPort(byte[] info) {

    // a byte ticket is received from the opposing server

    buffer.add(info);

  }

  public void auxSeeData(byte[] info) throws Exception {

    // the information is read in bytes and then a conversion is performed
    // with the object to its class type.

    ByteArrayInputStream FL = new ByteArrayInputStream(info); // bytes es el byte[]
    ObjectInputStream Obj = new ObjectInputStream(FL);
    Ticket t = (Ticket) Obj.readObject();
    Obj.close();

    // System.out.println("Custome id: " + t.customerId + "_" + t.lotteryNumber);
    System.out.println("Server Storing Ticket in Buffer Memory : " + t.customerId + "_"
        + t.lotteryNumber.replace("(", "").replace(")", ""));
  }

  public void seeData(byte[] info) {

    // function that to read data from the server.

    try {

      auxSeeData(info);

    } catch (Exception e) {

      System.out.println(e.getMessage());
    }

  }

}

class Lotterys {

  // global variables for server management.

  public static ServerA serverA = new ServerA();
  public static ServerB serverB = new ServerB();

}

public class Main {

  // throws Exception: it is used because at runtime there may be errors when reading a byte

  public static void main(String[] args) throws Exception {

    // test cases

    // System.out.println("\nGenerating lottery from server A:\n");
    // Lotterys.serverA.generator();
    //
    // try {
    //
    // System.out.println("Server log A: " + Lotterys.serverA.buffer.get(0));
    //
    // byte[] info = Lotterys.serverA.buffer.get(0);
    // Lotterys.serverA.seeData(info);
    //
    // System.out.println("\nServer log B: " + Lotterys.serverB.buffer.get(0));
    //
    // info = Lotterys.serverB.buffer.get(0);
    // Lotterys.serverB.seeData(info);
    //
    // } catch (Exception e) {
    //
    // System.out.println(e.getMessage());
    //
    // }
    //
    // System.out.println("\nGenerating lottery from server B:\n");
    // Lotterys.serverB.generator();
    //
    // try {
    //
    // System.out.println("Server log B: " + Lotterys.serverB.buffer.get(1));
    //
    // byte[] info = Lotterys.serverB.buffer.get(1);
    // Lotterys.serverB.seeData(info);
    //
    // System.out.println("\nServer log A: " + Lotterys.serverA.buffer.get(1));
    //
    // info = Lotterys.serverA.buffer.get(1);
    // Lotterys.serverA.seeData(info);
    //
    // } catch (Exception e) {
    //
    // System.out.println(e.getMessage());
    // }
    //
  }
}
