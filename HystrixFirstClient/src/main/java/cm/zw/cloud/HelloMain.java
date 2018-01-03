package cm.zw.cloud;

public class HelloMain {
	public static void main(String[] args) {
		HelloCommand helloCommand = new HelloCommand();
		String result = helloCommand.execute();
		System.out.println(result);
	}
}
