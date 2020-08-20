package xxp;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

public class PasswordEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
		Scanner scanner = new Scanner(System.in);
		System.out.print("input password:");
		String password = scanner.nextLine();
		System.out.println(DigestUtils.md5DigestAsHex(password.getBytes()));
	}

}
