package com.anfly.a1908a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.anfly.a1908a.template.CS;
import com.anfly.a1908a.template.Foodball;
import com.anfly.a1908a.template.Game;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //单例使用
//        SingleInstance.getInstance().fun();

        //工厂模式
//        ShapeFactory shapeFactory = new ShapeFactory();
//        Shape shape1 = shapeFactory.getShape(Constants.CIRCLE);
//        shape1.draw();
//
//        Shape shape2 = shapeFactory.getShape(Constants.RECTANGLE);
//        shape2.draw();
//
//        Shape shape3 = shapeFactory.getShape(Constants.SQUARE);
//        shape3.draw();

        //模板模式
//        Game game = new Foodball();
//        game.play();
//
//        game = new CS();
//        game.play();

        Computer computerr = new Computer.Builder()
                .setColor(123)
                .setName("拯救者")
                .setPrice(9000)
                .setOs("windows")
                .build();

        Log.e("TAG", computerr.toString());
    }


}
