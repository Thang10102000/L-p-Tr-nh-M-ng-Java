/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionnary;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 *
 * @author Admin
 */
public class tcp_SeverThread extends Thread {

    ServerSocket mServer;
    JTextArea mTxaStatus; //JTextArea để lưu status của Server

    public tcp_SeverThread(JTextArea txaStatus) {
        mTxaStatus = txaStatus;

    }

    @Override
    public void run() {

        try {
            String work;
            int tong;
            mServer = new ServerSocket(1234);
            mTxaStatus.append("Server đã sẵn sàng!\nĐang chờ dữ liệu...\n\n");
            while (true) {
                int i=1;
                Socket connectionSocket = mServer.accept();
                DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                work = inFromClient.readLine();
                
               // mTxaStatus.append("Luồng thứ "+i+"\n" +"Từ cần tra cứu : " + work + "\n");
                mTxaStatus.append("Từ cần tra cứu : " + work + "\n");
                    i++;
                    i++;
                outToClient.writeBytes(work + '\n');
                mTxaStatus.append("Đã gửi kết quả về cho Client thành công\n\n");
                
            }
        } catch (Exception ex) {
            mTxaStatus.append("Server đã xảy ra lỗi\n");
        }

    }

    public void StopServer() {
        super.stop();
        try {
            mServer.close();
        } catch (Exception ex) {

        }
    }

    public String ChuanHoa(String str) {
        str = str.trim();
        str = str.replace("", " ");
        return new StringBuilder(str).reverse().toString();

    }
}
