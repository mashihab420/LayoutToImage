package com.example.layouttoimage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import yuku.ambilwarna.AmbilWarnaDialog;


public class MainActivity extends AppCompatActivity {
    OutputStream outputStream;
    private static final int PICK_IMAGE = 1;
    public static final int WRITE_EXTERNAL_STORAGE_CODE = 1;
    Uri imageUri;
    private String filename = "SampleFile.txt";
    private String filepath = "MyFileStorage";
    File myExternalFile;
    String myData = "";

    private String filePath;

    boolean isOnlyImageAllowed = true;
    private static final int PICK_PHOTO = 1958;

    private Button button3, backgroundchang;
    private TextView font1, font2, font3, font4, font5, font6, font7, font8, font9;
    RelativeLayout relativeLayout = null;

    ImageView imageView;
    TextView textView, image, color, text, cross1, cross2, fontchange, fontcolorchange;

    //font color
    TextView textcolor1, textcolor2, textcolor3, textcolor4, textcolor5, textcolor6, textcolor7, tvpuls;

    //background color
    TextView bgcolor1, bgcolor2, bgcolor3, bgcolor4, bgcolor5;


    //background image
    CircleImageView begimage3, begimage4, begimage5, begimage6;

    EditText editText = null;
    private float x;
    private float y;
    SeekBar seekBar;
    int seekvalue;
    private int currentColor;
    LinearLayout linearLayout, bottommenu;
    HorizontalScrollView horizontalScrollViewfont, horizontalScrollTextColor, horizontalScrollBackgroundcolor, horizontalScrollimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                horizontalScrollBackgroundcolor.setVisibility(View.GONE);
                horizontalScrollimage.setVisibility(View.VISIBLE);

                tvpuls.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        addPhoto();

                    }
                });

                begimage3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Drawable image = getResources().getDrawable(R.drawable.pic1_b);
                        relativeLayout.setBackgroundDrawable(image);
                    }
                });

                begimage4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Drawable image = getResources().getDrawable(R.drawable.pic2_b);
                        relativeLayout.setBackgroundDrawable(image);
                    }
                });

                begimage5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Drawable image = getResources().getDrawable(R.drawable.pic3_b);
                        relativeLayout.setBackgroundDrawable(image);
                    }
                });

                begimage6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Drawable image = getResources().getDrawable(R.drawable.pic4_b);
                        relativeLayout.setBackgroundDrawable(image);
                    }
                });

            }


        });

        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                x = event.getX();
                y = event.getY();
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    editText.setX(x);
                    editText.setY(y);

                }
                return true;
            }
        });


        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horizontalScrollBackgroundcolor.setVisibility(View.VISIBLE);

                bgcolor1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int color = getResources().getColor(R.color.deeporange);

                        int transparent = getResources().getColor(R.color.transparent);

                        relativeLayout.setBackgroundColor(color);
                        editText.setBackgroundColor(transparent);


                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(color + 15));
                        Window win = getWindow();
                        win.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        win.setStatusBarColor(color);

                    }
                });

                bgcolor2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int color = getResources().getColor(R.color.orange);
                        int transparent = getResources().getColor(R.color.transparent);
                        relativeLayout.setBackgroundColor(color);
                        editText.setBackgroundColor(transparent);


                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(color + 15));
                        Window win = getWindow();
                        win.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        win.setStatusBarColor(color);

                    }
                });

                bgcolor3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int color = getResources().getColor(R.color.amber);
                        int transparent = getResources().getColor(R.color.transparent);
                        relativeLayout.setBackgroundColor(color);
                        editText.setBackgroundColor(transparent);


                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(color + 15));
                        Window win = getWindow();
                        win.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        win.setStatusBarColor(color);

                    }
                });

                bgcolor4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int color = getResources().getColor(R.color.yellow);
                        int transparent = getResources().getColor(R.color.transparent);
                        relativeLayout.setBackgroundColor(color);
                        editText.setBackgroundColor(transparent);


                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(color + 15));
                        Window win = getWindow();
                        win.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        win.setStatusBarColor(color);

                    }
                });

                bgcolor5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int color = getResources().getColor(R.color.red);
                        int transparent = getResources().getColor(R.color.transparent);
                        relativeLayout.setBackgroundColor(color);
                        editText.setBackgroundColor(transparent);


                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(color + 15));
                        Window win = getWindow();
                        win.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        win.setStatusBarColor(color);

                    }
                });
            }
        });


        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horizontalScrollimage.setVisibility(View.GONE);
                horizontalScrollBackgroundcolor.setVisibility(View.GONE);
                linearLayout.setVisibility(View.VISIBLE);


                cross1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        linearLayout.setVisibility(View.GONE);
                        bottommenu.setVisibility(View.VISIBLE);
                        horizontalScrollViewfont.setVisibility(View.GONE);
                        horizontalScrollTextColor.setVisibility(View.GONE);

                    }
                });

                cross2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        linearLayout.setVisibility(View.GONE);
                        bottommenu.setVisibility(View.VISIBLE);
                        horizontalScrollViewfont.setVisibility(View.GONE);
                        horizontalScrollTextColor.setVisibility(View.GONE);
                    }
                });

                fontchange.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        horizontalScrollViewfont.setVisibility(View.VISIBLE);
                    }
                });

                fontcolorchange.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        horizontalScrollViewfont.setVisibility(View.GONE);
                        horizontalScrollTextColor.setVisibility(View.VISIBLE);

                        textcolor1.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {

                                editText.setTextColor(getResources().getColor(R.color.deeporange));
                            }
                        });

                        textcolor2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                editText.setTextColor(getResources().getColor(R.color.orange));
                            }
                        });

                        textcolor3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                editText.setTextColor(getResources().getColor(R.color.amber));
                            }
                        });

                        textcolor4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                editText.setTextColor(getResources().getColor(R.color.yellow));
                            }
                        });

                        textcolor5.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                editText.setTextColor(getResources().getColor(R.color.red));
                            }
                        });

                        textcolor6.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                editText.setTextColor(getResources().getColor(R.color.blue));
                            }
                        });

                        textcolor7.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                editText.setTextColor(getResources().getColor(R.color.white));
                            }
                        });

                    }
                });

            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                openDialog(false);


            }
        });

        backgroundchang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                backgroundchangeDialog(false);
            }
        });


        fontchange();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                seekvalue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                editText.setTextSize(seekvalue);

            }
        });


    }

    public void addPhoto() {

        Intent intent;

        if (isOnlyImageAllowed) {
            // only image can be selected
            intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        } else {
            // any type of files including image can be selected
            intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("file/*");
        }

        startActivityForResult(intent, PICK_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_PHOTO) {
            Uri imageUri = data.getData();
            filePath = getPath(imageUri);
            imageView.setImageURI(imageUri);


            BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
            relativeLayout.setBackground(drawable);


        }
    }

    private String getPath(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    private void saveimage() {

        closeKeyboard();

        editText.setCursorVisible(false);

        Bitmap bitmap = Bitmap.createBitmap(relativeLayout.getWidth(), relativeLayout.getHeight(),
                Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);

        relativeLayout.draw(canvas);


        File filepath = Environment.getExternalStorageDirectory();
        File dir = new File(filepath.getAbsolutePath() + "/QuoteXpediaClone/");
        dir.mkdir();
        File file = new File(dir, System.currentTimeMillis() + ".jpg");


        try {
            outputStream = new FileOutputStream(file);
            new SingleMediaScanner(this, file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
        Toast.makeText(this, "Image Save to Internal Storage", Toast.LENGTH_SHORT).show();
        try {
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        editText.setCursorVisible(true);
    }


    private void openDialog(boolean supportAlpha) {
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, currentColor, supportAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {

                currentColor = color;
                editText.setTextColor(color);


            }
        });
        dialog.show();
    }


    private void backgroundchangeDialog(boolean supportAlpha) {
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, currentColor, supportAlpha, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {

                currentColor = color;
                relativeLayout.setBackgroundColor(color);
                editText.setBackgroundColor(color);


                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(currentColor + 15));
                Window win = getWindow();
                win.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                win.setStatusBarColor(color);


            }
        });
        dialog.show();
    }


    private void fontchange() {
        font1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Typeface tf = Typeface.createFromAsset(getAssets(), "chinesecalligraphy.ttf");
                editText.setTypeface(tf);
            }
        });

        font2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Typeface tf = Typeface.createFromAsset(getAssets(), "changchang.ttf");
                editText.setTypeface(tf);
            }
        });

        font3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Typeface tf = Typeface.createFromAsset(getAssets(), "fixgirl.ttf");
                editText.setTypeface(tf);
            }
        });
        font4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Typeface tf = Typeface.createFromAsset(getAssets(), "fontl.ttf");
                editText.setTypeface(tf);
            }
        });

        font5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Typeface tf = Typeface.createFromAsset(getAssets(), "hamlake.ttf");
                editText.setTypeface(tf);
                //works
            }
        });

        font6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Typeface tf = Typeface.createFromAsset(getAssets(), "heard.ttf");
                editText.setTypeface(tf);
            }
        });

        font7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Typeface tf = Typeface.createFromAsset(getAssets(), "hearrg.ttf");
                editText.setTypeface(tf);
            }
        });
        font8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Typeface tf = Typeface.createFromAsset(getAssets(), "acorninitials.ttf");
                editText.setTypeface(tf);
            }
        });
    }

    private void init() {
        relativeLayout = findViewById(R.id.relativeLayout1);
        imageView = findViewById(R.id.imageview1);
        editText = findViewById(R.id.edittextid);


        button3 = findViewById(R.id.changecolor);

        backgroundchang = findViewById(R.id.changebackground);
        textView = findViewById(R.id.tv_cp);
        image = findViewById(R.id.imageTomenu);
        color = findViewById(R.id.colorTomenu);
        text = findViewById(R.id.textTomenu);
        cross1 = findViewById(R.id.ict1);
        cross2 = findViewById(R.id.ict2);
        fontchange = findViewById(R.id.fontchange1);
        fontcolorchange = findViewById(R.id.fontcolor1);

        linearLayout = findViewById(R.id.Textmenu);
        bottommenu = findViewById(R.id.bottommenu);

        horizontalScrollViewfont = findViewById(R.id.horizontalview);
        horizontalScrollTextColor = findViewById(R.id.horizontaltextcolor);
        horizontalScrollBackgroundcolor = findViewById(R.id.horizontalbackgroundcolor);
        horizontalScrollimage = findViewById(R.id.horizontalImage);

        //bacgground image

        begimage3 = findViewById(R.id.civ_image3);
        begimage4 = findViewById(R.id.civ_image4);
        begimage5 = findViewById(R.id.civ_image5);
        begimage6 = findViewById(R.id.civ_image6);

        tvpuls = findViewById(R.id.tv_plus);


        //font color
        textcolor1 = findViewById(R.id.tv_textcolor1);
        textcolor2 = findViewById(R.id.tv_textcolor2);
        textcolor3 = findViewById(R.id.tv_textcolor3);
        textcolor4 = findViewById(R.id.tv_textcolor4);
        textcolor5 = findViewById(R.id.tv_textcolor5);
        textcolor6 = findViewById(R.id.tv_textcolor6);
        textcolor7 = findViewById(R.id.tv_textcolor7);

        //background color
        bgcolor1 = findViewById(R.id.tv_bgcolor1);
        bgcolor2 = findViewById(R.id.tv_bgcolor2);
        bgcolor3 = findViewById(R.id.tv_bgcolor3);
        bgcolor4 = findViewById(R.id.tv_bgcolor4);
        bgcolor5 = findViewById(R.id.tv_bgcolor5);


        //to change font
        font1 = findViewById(R.id.tv_font1);
        font2 = findViewById(R.id.tv_font2);
        font3 = findViewById(R.id.tv_font3);
        font4 = findViewById(R.id.tv_font4);
        font5 = findViewById(R.id.tv_font5);
        font6 = findViewById(R.id.tv_font6);
        font7 = findViewById(R.id.tv_font7);
        font8 = findViewById(R.id.tv_font8);

        //font size
        seekBar = findViewById(R.id.seckbarid);


    }

    private void chekSelfPermission(String writeExternalStorage) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case WRITE_EXTERNAL_STORAGE_CODE: {
                if (grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {

                } else {
                    Toast.makeText(this, "Permission enable", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.save_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_photos:
                savePhotos();
                return true;
            case R.id.copy_text:
                copyToClipBoard();
                return true;
            case R.id.share_photos:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void savePhotos() {

        saveimage();
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void copyToClipBoard() {
        if ((editText.getText() != null)) {
            String selectedText = editText.getText().toString();
            int sdk = android.os.Build.VERSION.SDK_INT;
            if (sdk < Build.VERSION_CODES.LOLLIPOP) {
                android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                clipboard.setText(selectedText);

            } else {
                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("WordKeeper", selectedText);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();
            }


        }

    }
}
