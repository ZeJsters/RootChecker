package rootcheker.com.zoher.rootchecker;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        final Context context = this;
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String command[] = {"su", "-c", "ls", "/data"};
                Shell shell = new Shell();
                String text = shell.sendShellCommand(command);
                if ((text.indexOf("app") > -1) || (text.indexOf("anr") > -1)
                        || (text.indexOf("user") > -1)
                        || (text.indexOf("data") > -1)) {
                    AlertDialog.Builder alertbox = new AlertDialog.Builder(context);
                    alertbox.setTitle("Information");
                    alertbox.setMessage("Rooted :)");
                    alertbox.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            findViewById(R.id.button1).setDrawingCacheBackgroundColor(Color.RED);
                        }
                    });
                    alertbox.show();

                } else {
                    AlertDialog.Builder alertbox = new AlertDialog.Builder(context);
                    alertbox.setTitle("Information");
                    alertbox.setMessage("Not Rooted :(");
                    alertbox.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            findViewById(R.id.button1).animate();
                        }
                    });
                    alertbox.show();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.navigate) {
            AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
            alertbox.setTitle("Information");
            alertbox.setMessage("This App Is Made By Zoher Jetpurwala With The Help Of Various Tutorials Available On The Internet :)!");
            alertbox.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(getApplicationContext(), "OK button clicked", Toast.LENGTH_LONG).show();
                }
            });
            alertbox.show();
        }

        return super.onOptionsItemSelected(item);
    }
}
