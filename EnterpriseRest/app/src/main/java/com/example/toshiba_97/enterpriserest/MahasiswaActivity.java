package com.example.toshiba_97.enterpriserest;

        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.webkit.WebView;
        import android.widget.Button;
        import android.widget.EditText;

        import org.xmlpull.v1.XmlPullParserException;

        import java.io.IOException;
        import java.io.InputStream;
        import java.net.HttpURLConnection;
        import java.net.URL;
        import java.util.List;

        import com.example.toshiba_97.enterpriserest.MahasiswaXmlParser.DataMahasiswa;

public class MahasiswaActivity extends AppCompatActivity {
    private  String URL = "";

    Button mButton;
    WebView myWebView;
    EditText edttext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa);
        mButton = (Button) findViewById(R.id.clickGet);
        myWebView = (WebView) findViewById(R.id.webview);
        edttext = (EditText) findViewById(R.id.edturl);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                URL = edttext.getText().toString();
                myWebView.loadUrl("about:blank");
                myWebView.clearView();
                new DownloadXmlTask().execute(URL);
            }
        });
    }


    // doInBackground --> implementasi AsyncTask untuk download XML  dari rest api mahasiswa
    // Asyntask digunakan untuk melakukan komputasi di background sehingga aplikasi kita tidak terlihat freeze
    private class DownloadXmlTask extends AsyncTask<String, Void, String> {

        //Disinilah biaanya proses yang memakan waktu lama dijalankan seperti permintaan data ke server,
        // komputasi yang membutuhkan waktu lama.
        @Override
        protected String doInBackground(String... urls) {
            try {
                return loadXmlFromNetwork(urls[0]);
            } catch (IOException e) {
                return "connection_error";//getResources().getString(R.string.connection_error);
            } catch (XmlPullParserException e) {
                return "xml_error";//getResources().getString(R.string.xml_error);
            }
        }

        //dipanggil setelah proses doinBackground selesai, method ini akan membaca hasil proses dari doInBackground yang digunakan untuk mengupdate nilai pada user interface.
        @Override
        protected void onPostExecute(String result) {
            setContentView(R.layout.activity_mahasiswa);
            // Displays the HTML string in the UI via a WebView
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadData(result, "text/html", null);
        }
    }

    // Digunakan untuk melakukan parsing XML untuk mengambil data dari server
    private String loadXmlFromNetwork(String urlString) throws XmlPullParserException, IOException {
        InputStream stream = null;
        MahasiswaXmlParser mahasiswaXmlParser = new MahasiswaXmlParser();
        List<DataMahasiswa> mahasiswaList = null;
        String title = null;
        String url = null;
        String summary = null;


        StringBuilder htmlString = new StringBuilder();

        try {
            stream = downloadUrl(urlString);
            mahasiswaList = mahasiswaXmlParser.parse(stream);
            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } finally {
            if (stream != null) {
                stream.close();
            }
        }

        for (DataMahasiswa tempDataMahasiswa : mahasiswaList) {
            htmlString.append("<p><h1>"+ tempDataMahasiswa.getNim()+"</h1>");
            htmlString.append("<br>Nama : " + tempDataMahasiswa.getNama() );
            htmlString.append("; Alamat :"+ tempDataMahasiswa.getAlamat() );
            htmlString.append("; Id_Jurusan :"+ tempDataMahasiswa.getId_jurusan() + "</br>" + "</p>");
        }
        return htmlString.toString();
    }

    private InputStream downloadUrl(String urlString) throws IOException {
        java.net.URL url = new URL(urlString);
        //menggunakan HttpURLConnection untuk melakukan request ke server
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000 /* milliseconds */);
        conn.setConnectTimeout(15000 /* milliseconds */);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.connect();
        InputStream stream = conn.getInputStream();
        return stream;
    }
}

