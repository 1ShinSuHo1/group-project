package com.example.sh_project.fuctions;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageView;

import com.example.sh_project.R;

import java.io.InputStream;
import java.net.Socket;

public class cctv extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cctv);

        imageView = findViewById(R.id.imageView); // XML에 ImageView 추가

        // 소켓 통신을 위한 정책 설정 (네트워크 스레드에서 UI 업데이트)
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 라즈베리파이의 IP 주소와 포트 번호
                    Socket socket = new Socket("192.168.0.19", 13245);
                    InputStream inputStream = socket.getInputStream();

                    while (true) {
                        // 프레임 크기 읽기
                        byte[] lengthBytes = new byte[10];
                        if (inputStream.read(lengthBytes) == -1) break;

                        // 프레임 크기 파싱
                        int length = Integer.parseInt(new String(lengthBytes).trim());
                        byte[] data = new byte[length];

                        // 프레임 데이터 읽기
                        int read = 0;
                        while (read < length) {
                            read += inputStream.read(data, read, length - read);
                        }

                        // 비트맵으로 변환하고 UI 업데이트
                        final Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                imageView.setImageBitmap(bitmap);
                            }
                        });
                    }
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
