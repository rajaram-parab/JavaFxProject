
public class SocketServerA {

  public static void main(String[] args) throws InterruptedException {
    while (true) {
      System.out.println("\nGenerating lottery from server B:\n");
      Lotterys.serverA.generator();

      try {

        System.out.println("Server log B: ");

        byte[] info = Lotterys.serverA.buffer.get(0);
        Lotterys.serverA.seeData(info);

        System.out.println("\nServer log A: ");

        info = Lotterys.serverB.buffer.get(0);
        Lotterys.serverB.seeData(info);

      } catch (Exception e) {

        System.out.println(e.getMessage());

      }
      Lotterys.serverA.buffer.clear();
      Lotterys.serverB.buffer.clear();
      Thread.sleep(3000);
    }
  }
}
