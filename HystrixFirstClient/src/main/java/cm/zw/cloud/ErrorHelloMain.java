package cm.zw.cloud;

public class ErrorHelloMain {

	public static void main(String[] args) {
		ErrorCommand errorCommand = new ErrorCommand();
		String result = errorCommand.execute();
		System.out.println(result);
	}
}
