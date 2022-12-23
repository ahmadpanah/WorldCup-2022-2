package ir.shariaty.fifaworldcup2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import ir.shariaty.fifaworldcup2.adapter.FixtureAdapter;
import ir.shariaty.fifaworldcup2.manager.RequestManager;
import ir.shariaty.fifaworldcup2.models.FixtureResponse;

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
        // TODO I'll fix it later.
        manager.getFixture(listener);
    }

    private final ResponseListener listener = new ResponseListener() {

        @Override
        public void didFetch(FixtureResponse response, String status) {
            dialog.dismiss();
            recyclerview.setHasFixedSize(true);
            recyclerview.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL , false));
            FixtureAdapter adapter = new FixtureAdapter(MainActivity.this, response.data);
            recyclerview.setAdapter(adapter);
        }

        @Override
        public void didError(String status) {
            dialog.dismiss();
            Toast.makeText(MainActivity.this, status, Toast.LENGTH_SHORT).show();
        }
    };
}