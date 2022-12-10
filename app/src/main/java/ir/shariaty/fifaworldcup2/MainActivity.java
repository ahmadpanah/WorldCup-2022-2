package ir.shariaty.fifaworldcup2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import ir.shariaty.fifaworldcup2.manager.RequestManager;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerview;
    ProgressDialog dialog;
    RequestManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = findViewById(R.id.recycler_fixture);

        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading...⌛");

        manager = new RequestManager(this);
        manager.getFixture();
    }
}