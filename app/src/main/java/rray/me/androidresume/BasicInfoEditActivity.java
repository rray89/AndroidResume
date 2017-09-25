package rray.me.androidresume;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import rray.me.androidresume.models.BasicInfo;
import rray.me.androidresume.util.ImageUtils;
import rray.me.androidresume.util.PermissionUtils;

public class BasicInfoEditActivity extends EditBaseActivity<BasicInfo> {

    public static final String KEY_BASIC_INFO = "basic_info";
    private static final int REQ_CODE_PICK_IMAGE = 100;


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
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == PermissionUtils.REQ_CODE_WRITE_EXTERNAL_STORAGE
                && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            pickImage();
        }

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_basic_info_edit;
    }

    @Override
    protected void setupUIForCreate() {

    }

    @Override
    protected void setupUIForEdit(@NonNull BasicInfo data) {
        ((EditText) findViewById(R.id.et_basic_info_edit_name)).setText(data.getName());
        ((EditText) findViewById(R.id.et_basic_info_edit_email)).setText(data.getEmail());
        ((EditText) findViewById(R.id.et_basic_info_edit_personal_site))
                .setText(data.getPersonalSite());
        if (data.getImageUri() != null) {
            showImage(data.getImageUri());
        }

        findViewById(R.id.fl_basic_info_edit_image_layout)
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!PermissionUtils.checkPermission(BasicInfoEditActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    PermissionUtils.requestReadExternalStoragePermission(BasicInfoEditActivity.this);
                } else {
                    pickImage();
                }
            }
        });

    }

    @Override
    protected void saveAndExit(@Nullable BasicInfo data) {
        if (data == null) {
            data = new BasicInfo();
        }
        String name;
        String email;
        String personalSite;
        Uri imageUri;

        name = ((EditText) findViewById(R.id.et_basic_info_edit_name)).getText().toString();
        email = ((EditText) findViewById(R.id.et_basic_info_edit_email)).getText().toString();
        personalSite = ((EditText) findViewById(R.id.et_basic_info_edit_personal_site))
                .getText().toString();
        imageUri = (Uri) findViewById(R.id.iv_basic_info_edit_image).getTag();

        data.setName(name);
        data.setEmail(email);
        data.setPersonalSite(personalSite);
        data.setImageUri(imageUri);

        Intent resultIntent = new Intent();
        resultIntent.putExtra(KEY_BASIC_INFO, data);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    @Override
    protected BasicInfo initializeData() {
        return null;
    }

    private void showImage(@NonNull Uri imageUri) {
        ImageView imageView = (ImageView) findViewById(R.id.iv_basic_info_edit_image);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        imageView.setTag(imageUri);
        ImageUtils.loadImage(this, imageUri, imageView);
    }

    private void pickImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "Select picture"), REQ_CODE_PICK_IMAGE);
    }
}
