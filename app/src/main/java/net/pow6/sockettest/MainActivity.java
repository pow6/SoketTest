package net.pow6.sockettest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    private static final String IP_ADDRESS = "127.0.0.1"; //IPアドレス
    private static final int PORT=4649; //ポート番号
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.sendText);

}


    public void send_onClick(View v){       //xmlでメソッドを呼び出しているので，引数はViewにしなければいけない
        sendData(editText.getText().toString());
    }
    //ソケット通信処理
    private void sendData(String str){
        //ソケットの作成
        Socket socket;
        PrintWriter stream;
        try{
            socket = new Socket(IP_ADDRESS, PORT);
            stream = new PrintWriter(socket.getOutputStream(),true); //既存のOutputStreamから新しいPrintWriterを作成
            stream.write(str);
            if(stream != null) stream.close();
            if(socket != null)socket.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
