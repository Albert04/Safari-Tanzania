package com.example.safari.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.safari.R;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import static androidx.media.MediaBrowserServiceCompat.RESULT_OK;


public class UsersFragment extends Fragment {

    private static final int PICK_IMAGE_REQUEST = 1;
    private Button mButtonChooseImage, mbuttonUpload, mButtonShowUploads;
    private EditText mEditTextFileName;
    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private Uri mImageUri;
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private StorageTask mUploadTask;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_users, container, false);


        mButtonChooseImage = root.findViewById(R.id.button_choose_image);
        mbuttonUpload = root.findViewById(R.id.button_upload);
        mButtonShowUploads = root.findViewById(R.id.btn_show_uploads);
        mEditTextFileName = root.findViewById(R.id.edit_text_file_name);
        mImageView = root.findViewById(R.id.imageView);
        mProgressBar = root.findViewById(R.id.progress_bar);

        mStorageRef = FirebaseStorage.getInstance().getReference("uploads");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");

        mButtonChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Implement the choosing of a file
                openFileChooser();
            }
        });

        mbuttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   uploadFile();
            }
        });

        mButtonShowUploads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ImagesActivity.class));
            }
        });
return root;
    }



    //Open a file chooser
    public void openFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE_REQUEST);
    }


//    //Set the chosen image to the imageview
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
//        super.onActivityResult(requestCode,resultCode,data);
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data !=null){
//            mImageUri = data.getData();
//            Glide.with(this).load(mImageUri).into(mImageView);
//        }
//    }
//
//    //Getting a file extention
//    private  String getFileExtention(Uri uri){
//        ContentResolver cR = getContentResolver();
//        MimeTypeMap mime = MimeTypeMap.getSingleton();
//        return  mime.getExtensionFromMimeType(cR.getType(uri));
//    }
//
//    //Uploading the image and the name
//    private void uploadFile(){
//        if (mImageUri != null){
//            StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()+"."+getFileExtention(mImageUri));
//            mUploadTask = fileReference.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                    Thread delay = new Thread(){
//                        @Override
//                        public void run() {
//                            try {
//                                sleep(500);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    };
//                    delay.start();
//                    //Toast.makeText(MainActivity.this, "Upload Successful", Toast.LENGTH_SHORT).show();
//                    Upload upload = new Upload(mEditTextFileName.getText().toString(),taskSnapshot.getDownloadUrl().toString(),String.valueOf(System.currentTimeMillis()));
//                    String uploadID = mDatabaseRef.push().getKey();
//                    mDatabaseRef.child(System.currentTimeMillis()+"").setValue(upload);
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    //Toast.makeText(Activity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
//                    double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
//                    mProgressBar.setProgress((int) progress);
//                }
//            });
//
//        }else {
//            //Toast.makeText(this, "No file selected for upload", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//
//

}