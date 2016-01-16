package com.blotspot.jalen.blotspot;

        import android.content.Context;
        import android.content.SharedPreferences;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.Toast;
       /* import com.twitter.sdk.android.Twitter;
        import com.twitter.sdk.android.core.TwitterAuthConfig;
        import com.twitter.sdk.android.core.TwitterException;
        import com.twitter.sdk.android.core.models.Tweet;
        import com.twitter.sdk.android.tweetui.CompactTweetView;
        import com.twitter.sdk.android.tweetui.LoadCallback;
        import com.twitter.sdk.android.tweetui.TweetUtils;*/


public class SurveyPage extends AppCompatActivity {
    private static RadioGroup radioGroupSocialMedia;
    private static RadioButton radioButtonSocialMedia;
    private static RadioGroup radioGroupMillenials;
    private static RadioButton radioButtonMillenials;
    private static RadioGroup radioGroupPopCulture;
    private static RadioButton radioButtonPopCulture;
    private static RadioGroup radioGroupPolitics;
    private static RadioButton radioButtonPolitics;
    private static RadioGroup radioGroupReligion;
    private static RadioButton radioButtonReligion;
    private static Button button_sub;
    public static final String PREFS_NAME = "MyPrefsFile";
    public static SharedPreferences prefs;
    private Context mContext; //Add this line <------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_page);
        onClicklistenerButton();

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.response_1:
                if (checked)

                    break;
            case R.id.response_2:
                if (checked)

                    break;
        }
    }

    //This is the action for the submit button.
    public void onClicklistenerButton() {
        radioGroupSocialMedia = (RadioGroup)findViewById(R.id.RadioGroup);
        radioGroupMillenials = (RadioGroup)findViewById(R.id.RadioGroup_1);
        radioGroupPopCulture = (RadioGroup)findViewById(R.id.RadioGroup_2);
        radioGroupPolitics = (RadioGroup)findViewById(R.id.RadioGroup_3);
        radioGroupReligion = (RadioGroup)findViewById(R.id.RadioGroup_4);
        button_sub = (Button)findViewById(R.id.button_sub);

        button_sub.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int selected_id = radioGroupSocialMedia.getCheckedRadioButtonId();
                        int selectMill_id = radioGroupMillenials.getCheckedRadioButtonId();
                        int selectPop_id = radioGroupPopCulture.getCheckedRadioButtonId();
                        int selectPolitics_id = radioGroupPolitics.getCheckedRadioButtonId();
                        int selectReligion_id = radioGroupReligion.getCheckedRadioButtonId();
                        prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor;
                        editor = prefs.edit();
                        //editor.putString("keyTestString","testJalenString");
                        editor.commit();
                        radioButtonSocialMedia = (RadioButton)findViewById(selected_id);
                        radioButtonMillenials = (RadioButton)findViewById(selectMill_id);
                        radioButtonPopCulture = (RadioButton)findViewById(selectPop_id);
                        radioButtonPolitics = (RadioButton)findViewById(selectPolitics_id);
                        radioButtonReligion = (RadioButton)findViewById(selectReligion_id);
                        String socialMediaRadioButtonText =  radioButtonSocialMedia.getText().toString();
                        editor.putString("keySocialMediaRadioButtonText",socialMediaRadioButtonText);
                        String millenialsRadioButtonText = radioButtonMillenials.getText().toString();
                        editor.putString("keyMillenialsRadioButtonText",millenialsRadioButtonText);
                        String popCultureRadioButtonText = radioButtonPopCulture.getText().toString();
                        editor.putString("keyPopCultureRadioButtonText",popCultureRadioButtonText);
                        String politicsRadioButtonText = radioButtonPolitics.getText().toString();
                        editor.putString("keyPoliticsRadioButtonText",politicsRadioButtonText);
                        String religionRadioButtonText = radioButtonReligion.getText().toString();
                        editor.putString("keyReligionRadioButtonText",religionRadioButtonText);
                        editor.commit();
                        String testString = socialMediaRadioButtonText + millenialsRadioButtonText +
                                popCultureRadioButtonText + politicsRadioButtonText + religionRadioButtonText;
                        String testString_1 = prefs.getString("keyTestString","TestString");
                        Toast.makeText(SurveyPage.this,
                                testString_1, Toast.LENGTH_SHORT). show();


                    }
                }
        );

    }


}