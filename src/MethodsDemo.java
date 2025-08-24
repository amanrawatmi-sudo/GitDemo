import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodsDemo {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		MethodsDemo d = new MethodsDemo();

		String name = d.getData();

		System.out.println(name);

		MethodsDemo2 d1 = new MethodsDemo2();

		d1.getUserData();

		getData2();

		ArrayList<String> a = new ArrayList<String>();
		a.add("name");
		System.out.println(a);
		String[] name1 = { "a", "b", "c" };
		List<String> nameList = Arrays.asList(name1);

		String nsme = "my nme is noah";
		for (int i = 0; i < nsme.length(); i++) {
			System.out.println(nsme.charAt(i));
		}
		for (int i = nsme.length() - 1; i > -1; i--) {
			System.out.println(nsme.charAt(i));
		}

	}

	public String getData()

	{

		System.out.println("hello world");

		return "rahul shetty";

	}

	public static String getData2()

	{

		System.out.println("hello world");

		return "rahul shetty";

	}

}
