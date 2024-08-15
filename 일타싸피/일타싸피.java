import java.net.*;
import java.io.*;

public class DAEJEON02_JAVA {

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "DAEJEON03_KIMHYEONGPYO";

	// 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
	static final String HOST = "127.0.0.1";

	// 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// 게임 환경에 대한 상수입니다.
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		float[][] balls = new float[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");

			while (socket != null) {

				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Float.parseFloat(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = (int) balls[0][1];
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				float angle = 0.0f;
				float power = 0.0f;

				//////////////////////////////
				// 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
				//
				// 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
				// - order: 1인 경우 선공, 2인 경우 후공을 의미
				// - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
				// 예) balls[0][0]: 흰 공의 X좌표
				// balls[0][1]: 흰 공의 Y좌표
				// balls[1][0]: 1번 공의 X좌표
				// balls[4][0]: 4번 공의 X좌표
				// balls[5][0]: 마지막 번호(8번) 공의 X좌표

				// 여기서부터 코드를 작성하세요.
				// 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.

				// whitex, whitey: 흰 공의 X, Y좌표를 나타내기 위해 사용한 변수
				float whitex = balls[0][0];
				float whitey = balls[0][1];

				// 0번 인덱스를 제외하고 1번부터 8번공이 있는지 없는지 볼거임
				boolean[] targetball = new boolean[6];

				for (int r = 0; r < balls.length; r++) {
					// if문에 들어가면 있다는 뜻
					if (balls[r][0] != -1 && balls[r][1] != -1) {
						targetball[r] = true;
					}
				}

				// targetx, targety: 목적구의 X, Y좌표를 나타내기 위해 사용한 변수
				float targetx = -1;
				float targety = -1;

				// 선공이면 1,3번 공을 치고
				if (order == 1) {
					if (targetball[1]) {
						targetx = balls[1][0];
						targety = balls[1][1];
					} else if (targetball[3]) {
						targetx = balls[3][0];
						targety = balls[3][1];
					}
				}
				// 후공이면 2번,4번 공을 친다
				else if (order == 2) {
					if (targetball[2]) {
						targetx = balls[2][0];
						targety = balls[2][1];
					} else if (targetball[4]) {
						targetx = balls[4][0];
						targety = balls[4][1];
					}
				}

				// 1번,3번 또는 2,4번 공이 없다면 8번 공을 친다. (여기선 balls[5]가 마지막 공이다.
				if (targetx == -1 && targety == -1) {
					targetx = balls[5][0];
					targety = balls[5][1];
				}

				
				
				
				// 타겟공 기준으로 가장 가까운 홀에 공을 넣을거임
				// 가까운 홀의 x좌표
				double closeHolex = 0;
				// 가까운 홀의 y좌표
				double closeHoley = 0;
				// 최단거리를 비교할 min 변수
				double min = Double.MAX_VALUE;
				
				//모든 홀 좌표에서 타겟 공 사이의 거리를 비교하면서 가장 가까운 홀을 찾음.
				for (int r = 0; r < HOLES.length; r++) {
					
					double holex = HOLES[r][0];
					double holey = HOLES[r][1];
					double distance = Math.sqrt(Math.pow(holey - targety, 2) + Math.pow(holex - targetx, 2));
					if (min > distance) {
						min = distance;
						closeHolex = holex;
						closeHoley = holey;
					}
				}

				// 타겟공에서 홀로 가는 각도 구하기
				double angleTargetToHole = Math.atan2(closeHoley - targety, closeHolex - targetx);

				// 타겟공이 angleTargetToHole 각도로 움직이기 위해 흰공으로 쳐야되는 충돌지점 좌표 구하기  
				// 5.73은 공의 지름.
				double impactx = targetx - Math.cos(angleTargetToHole) * 5.73;
				double impacty = targety - Math.sin(angleTargetToHole) * 5.73;

				//흰공에서 충돌지점까지 각도 계산
				double digree = Math.toDegrees(Math.atan2(impacty - whitey, impactx - whitex));

				//일타싸피는 시초선이 90도 이므로 90-digree
				digree = 90 - digree;

				
				if (digree < 0) {
					digree += 360;
				}

				// // 흰공과  충돌지점의 거리 계산     그만큼 힘을 줄거임.
				// double distance = Math.sqrt(Math.pow(impacty - whitey, 2) + Math.pow(impactx - whitex, 2));

				angle = (float) digree;
				power = (float) (100-min);

				// 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
				// 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
				// - angle: 흰 공을 때려서 보낼 방향(각도)
				// - power: 흰 공을 때릴 힘의 세기
				//
				// 이 때 주의할 점은 power는 100을 초과할 수 없으며,
				// power = 0인 경우 힘이 제로(0)이므로 아무런 반응이 나타나지 않습니다.
				//
				// 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
				//////////////////////////////

				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}

			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
