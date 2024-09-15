import java.util.Arrays;
import java.util.Scanner;

class Main {
	static class User implements Comparable<User>{
		int age;
		String name;

		public User(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(User o) {
			// TODO Auto-generated method stub
			return this.age-o.age;
		}

		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		User[] users = new User[N];
		
		for(int i=0; i<N; i++) {
			users[i] = new User(sc.nextInt(),sc.next());
		}
		
		Arrays.sort(users);
		
		for (User user : users) {
			System.out.println(user.age+" "+user.name);
		}
	}
}