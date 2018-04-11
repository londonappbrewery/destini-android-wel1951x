package com.tahoesoftware.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    {
    final int BEGINNING_OF_STORY = 1;
    final int CLICKED_TOP_BUTTON_FIRST = 2;
    final int CLICKED_BOTTOM_BUTTON_FIRST = 3;

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mButtonTop,
            mButtonBottom;

    int mStoryIndex = BEGINNING_OF_STORY;

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);

        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener()
            {
            @Override
            public void onClick(View view)
                {
                handleButtonTop(mStoryIndex);
                mStoryIndex = CLICKED_TOP_BUTTON_FIRST;
                }
            });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener()
            {
            @Override
            public void onClick(View view)
                {
                handleButtonBottom(mStoryIndex);
                mStoryIndex = CLICKED_BOTTOM_BUTTON_FIRST;
                }
            });

        }

    private void handleButtonTop(int mStoryIndex)
        {
        if (mStoryIndex == BEGINNING_OF_STORY)
            {
            mStoryTextView.setText(R.string.T3_Story);
            mButtonTop.setText(R.string.T3_Ans1);
            mButtonBottom.setText(R.string.T3_Ans2);
            }
        else
            {
            if (mStoryIndex == CLICKED_TOP_BUTTON_FIRST)
                {
                mStoryTextView.setText(R.string.T6_End);
                hideButtons();
                }
            else
                {
                mStoryIndex = BEGINNING_OF_STORY;
                handleButtonTop(mStoryIndex);
                mStoryIndex = CLICKED_TOP_BUTTON_FIRST;
                }
            }
        }

    private void handleButtonBottom(int mStoryIndex)
        {
        if (mStoryIndex == BEGINNING_OF_STORY)
            {
            mStoryTextView.setText(R.string.T2_Story);
            mButtonTop.setText(R.string.T2_Ans1);
            mButtonBottom.setText(R.string.T2_Ans2);
            }
        else
            {
            if (mStoryIndex == CLICKED_BOTTOM_BUTTON_FIRST)
                mStoryTextView.setText(R.string.T4_End);
            else
                mStoryTextView.setText(R.string.T5_End);
            hideButtons();
            }
        }

    private void hideButtons()
        {
        mButtonTop.setVisibility(View.GONE);
        mButtonBottom.setVisibility(View.GONE);
        }

    }
