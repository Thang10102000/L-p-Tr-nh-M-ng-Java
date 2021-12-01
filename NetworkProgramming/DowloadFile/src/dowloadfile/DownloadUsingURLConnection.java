
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class DownloadUsingURLConnection extends JFrame implements ActionListener {

    private JProgressBar pBar;
    private JButton btnDownload;
    private JTextField tfURL;
    private JTextField tfSize;
    private JTextField tfFolder;
    private JButton btnSelectFolder;

    public DownloadUsingURLConnection() {
        setTitle("Download");
        setSize(400, 170);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Box b = Box.createVerticalBox();
        Box b1 = Box.createHorizontalBox();
        b1.add(new JLabel("Enter URL:"));
        b1.add(tfURL = new JTextField(20));
        tfURL.setText("https://jdbc.postgresql.org/download/postgresql-9.2-1002.jdbc4.jar");
        b1.add(new JLabel("Size:"));
        b1.add(tfSize = new JTextField(5));
        tfSize.setEditable(false);
        Box b2 = Box.createHorizontalBox();
        b2.add(new JLabel("Save to:"));
        b2.add(tfFolder = new JTextField(20));
        String homeDownload
                = System.getProperty("user.home") + File.separator + "Downloads";
        tfFolder.setText(homeDownload);
        b2.add(btnSelectFolder = new JButton("..."));
        btnSelectFolder.addActionListener(this);
        Box bButton = Box.createHorizontalBox();
        bButton.add(btnDownload = new JButton("Download"));
        btnDownload.addActionListener(this);
        b.add(Box.createVerticalStrut(8));
        b.add(b1);
        b.add(Box.createVerticalStrut(8));
        b.add(b2);
        b.add(Box.createVerticalStrut(8));
        b.add(pBar = new JProgressBar(), BorderLayout.NORTH);
        b.add(Box.createVerticalStrut(8));
        b.add(bButton);
        this.add(b, BorderLayout.NORTH);
    }

    private void trustAllHosts() {
// Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[]{};
            }

            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }
        }};
// Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HttpURLConnection getURLConnection(URL url) throws Exception {
        HttpURLConnection connection = null;
        if (url.getProtocol().toLowerCase().equals("https")) {
            trustAllHosts();
            HttpsURLConnection https = (HttpsURLConnection) url.openConnection();
            connection = https;
        } else {
            connection = (HttpURLConnection) url.openConnection();
        }
//con.setRequestProperty("Accept-Encoding", "identity"); 
        connection.connect();
        return connection;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if (o.equals(btnDownload)) {
            try {
//URL url=new URL("https://wallpapercave.com/wp/Xi3z1EN.jpg");
//URL url=new URL("http://localhost/hello/a.zip");
                pBar.setValue(0);
                String urlspec = tfURL.getText();
                String destFolder = tfFolder.getText();//check???
                URL url = new URL(urlspec);
                HttpURLConnection con = getURLConnection(url);
                String size = con.getContentLength() + "";
                tfSize.setText(size);
                DownloadURL qlu = new DownloadURL(con, pBar, destFolder);
                qlu.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (o.equals(btnSelectFolder)) {
            JFileChooser j = new JFileChooser();
            j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (j.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                tfFolder.setText(j.getSelectedFile().getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        new DownloadUsingURLConnection().setVisible(true);
    }
}

class DownloadURL extends SwingWorker<Void, Long> {

    private final int BUFFER_SIZE = 4096;
    private JProgressBar progress;
    private HttpURLConnection urlCon;
    private String destFolder;

    public DownloadURL(HttpURLConnection urlCon, JProgressBar progress, String destFolder) {
        this.progress = progress;
        this.urlCon = urlCon;
        this.destFolder = destFolder;
    }

    @Override
    protected Void doInBackground() throws Exception {
        downloadFile(urlCon, destFolder);
        return null;
    }

    public void downloadFile(HttpURLConnection conn, String saveDir) throws Exception {
        String fileURL = conn.getURL().toExternalForm();
        int responseCode = conn.getResponseCode();
// always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = conn.getHeaderField("Content-Disposition");
            if (disposition != null) {
// extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10,
                            disposition.length() - 1);
                }
            } else {
// extracts file name from URL
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
                        fileURL.length());
            }
            int length = urlCon.getContentLength();
            int downloaded = 0;
// opens input stream from the HTTP connection
            String saveFilePath = saveDir + File.separator + fileName;
            InputStream inputStream = urlCon.getURL().openStream();
// opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
            int bytesRead = -1;
            int pos = 0;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                downloaded += bytesRead;
                pos = (downloaded * 100) / length;
                progress.setValue(pos);
//System.out.println(pos+"\t"+downloaded);
            }
            outputStream.close();
            inputStream.close();
        } else {
            JOptionPane.showMessageDialog(null, "No file to download. Server replied HTTP code: " + responseCode, "Download Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    protected void done() {
        System.out.println("File downloaded");
    }
}
