package app.worker.check.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    public void basicToast(String message) {

        Toast toast = Toast.makeText(BaseActivity.this, message, Toast.LENGTH_LONG);
        toast.show();
    }

}
