package com.bravedroid.androidgesture;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView gestureText;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureText = (TextView) findViewById(R.id.tvGesture);
        AndroidGestureDetector androidGestureDetector = new AndroidGestureDetector();
        mGestureDetector = new GestureDetector(MainActivity.this, androidGestureDetector);
    }

    class AndroidGestureDetector implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

        @Override
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            gestureText.setText("onSingleTapConfirmed");
            Log.d("Gesture", "OnSingleTapConfirmed");
            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            gestureText.setText("onDoubleTap");
            Log.d("Gesture", "onDoubleTap");
            return false;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            gestureText.setText("onDoubleTapEvent");
            Log.d("Gesture", "onDoubleTapEvent");
            return false;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            gestureText.setText("onDown");
            Log.d("Gesture", "onDown");
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            gestureText.setText("onShowPress");
            Log.d("Gesture", "onShowPress");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            gestureText.setText("onSingleTapUp");
            Log.d("Gesture", "onSingleTapUp");
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float distanceX, float distanceY) {
            gestureText.setText("onScroll");
            if (motionEvent.getX()<motionEvent1.getX()){
                Log.d("Gesture","Right to Left Scroll : "+motionEvent.getX()+" - "+motionEvent.getX());
                Log.d("Speed",String.valueOf(distanceX) +"pixels/second");
            }

            if (motionEvent.getX()<motionEvent1.getX()){
                Log.d("Gesture","Left to Right Scroll : "+motionEvent.getX()+" - "+motionEvent.getX());
                Log.d("Speed",String.valueOf(distanceX) +"pixels/second");
            }

            if (motionEvent.getX()<motionEvent1.getY()){
                Log.d("Gesture","Up to Down Scroll : "+motionEvent.getX()+" - "+motionEvent.getY());
                Log.d("Speed",String.valueOf(distanceY) +"pixels/second");
            }

            if (motionEvent.getX()<motionEvent1.getY()){
                Log.d("Gesture","Down to Up Scroll : "+motionEvent.getX()+" - "+motionEvent.getY());
                Log.d("Speed",String.valueOf(distanceY) +"pixels/second");
            }
            Log.d("Gesture", "onScroll");
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            gestureText.setText("onLongPress");
            Log.d("Gesture", "onLongPress");
        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float velocityX, float velocityY) {
            gestureText.setText("onFling");
            if (motionEvent.getX()<motionEvent1.getX()){
                Log.d("Gesture","Right to Left Fling : "+motionEvent.getX()+" - "+motionEvent.getX());
                Log.d("Speed",String.valueOf(velocityX) +"pixels/second");
            }

            if (motionEvent.getX()<motionEvent1.getX()){
                Log.d("Gesture","Left to Right Fling : "+motionEvent.getX()+" - "+motionEvent.getX());
                Log.d("Speed",String.valueOf(velocityX) +"pixels/second");
            }

            if (motionEvent.getX()<motionEvent1.getY()){
                Log.d("Gesture","Up to Down Fling : "+motionEvent.getX()+" - "+motionEvent.getY());
                Log.d("Speed",String.valueOf(velocityY) +"pixels/second");
            }

            if (motionEvent.getX()<motionEvent1.getY()){
                Log.d("Gesture","Down to Up Fling : "+motionEvent.getX()+" - "+motionEvent.getY());
                Log.d("Speed",String.valueOf(velocityY) +"pixels/second");
            }
            Log.d("Gesture", "onFling");
            return false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
