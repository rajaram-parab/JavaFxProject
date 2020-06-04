
public class TypePromotion2 {

	void sum(int a,int b ){System.out.println("int method is invoked");}
	void sum(float a,float b ){System.out.println("float method is invoked");}
	
	public static void main(String[] args) {
      TypePromotion2 obj = new TypePromotion2();
      obj.sum(20,20);//int method is inovked
	}

}
