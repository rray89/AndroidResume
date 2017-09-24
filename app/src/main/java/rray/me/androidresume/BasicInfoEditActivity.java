package rray.me.androidresume;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import rray.me.androidresume.models.BasicInfo;

public class BasicInfoEditActivity extends EditBaseActivity<BasicInfo> {

    public static final String KEY_BASIC_INFO = "basic_info";
    private static final int REQ_CODE_PICK_IMAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_CODE_PICK_IMAGE && requestCode == RESULT_OK) {
            Uri imageUri = data.getData();
            if(imageUri != null) {
                showImage(imageUri);
            }
        }
    }



    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void setupUIForCreate() {

    }

    @Override
    protected void setupUIForEdit(@NonNull BasicInfo data) {

    }

    @Override
    protected void saveAndExit(@Nullable BasicInfo data) {

    }

    @Override
    protected BasicInfo initializeData() {
        return null;
    }

    private void showImage(@NonNull Uri imageUri) {
        //ImageView imageView = (ImageView) findViewById(R.id.ba)
    }
}
