package net.sakuramilk.TweakGS2.RomManager;

import java.util.ArrayList;

import net.sakuramilk.TweakGS2.R;
import net.sakuramilk.util.SystemCommand;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.widget.Toast;



public class BalusActivity extends Activity {
    private static final int REQUEST_CODE = 0;

    @Override
	protected void onStart() {
        try {
            Intent intent = new Intent(
                    RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(
                    RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(
                    RecognizerIntent.EXTRA_PROMPT,
                    R.string.backup_summary);

            startActivityForResult(intent, REQUEST_CODE);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "ActivityNotFoundException", Toast.LENGTH_LONG).show();
            finish();
        }
        super.onStart();
	}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
        	ArrayList<String> results = data.getStringArrayListExtra(
        			RecognizerIntent.EXTRA_RESULTS);

        	if (results.indexOf("バルス") != -1) {
        		Toast.makeText(this, R.string.balus_confirmed, Toast.LENGTH_LONG).show();
       			SystemCommand.balus();
       			SystemCommand.reboot("recovery");
       			finish();
       			return;
        	}
        }
        Toast.makeText(this, R.string.balus_invalid, Toast.LENGTH_LONG).show();
        finish();

    }
}