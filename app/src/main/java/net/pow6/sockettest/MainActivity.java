package net.pow6.sockettest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedOutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    private static final String IP_ADDR = "1.1.1.1"; //IPアドレス
    private static final int PORT=4680; //ポート番号

    //ソケット通信処理
    private void sendData(Context content, byte[] data){
        //ソケットの作成
        Socket socket;
        BufferedOutputStream out;
        try{
            socket = new Socket(IP_ADDR, PORT);
            out = new BufferedOutputStream(socket.getOutputStream());
            out.write(data);
            if(out != null) out.close();
            if(socket != null)socket.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
