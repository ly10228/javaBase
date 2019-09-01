package com.ly.senior.designpatterns.principle.ocp.improve;

import org.junit.Test;

/**
 * @author luoyong
 * @Description: OcpBadImprove 开闭原则案例
 * @create 2019-09-01 17:19
 * @last modify by [LuoYong 2019-09-01 17:19]
 **/
public class OcpBadImprove {
    @Test
    public void test() {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Triangle());
        graphicEditor.drawShape(new Other());
    }
}


/**
 * 这是一个用于绘图的类 [使用方]
 */
class GraphicEditor {
    public void drawShape(Shape shape) {
        shape.draw();
    }
}

abstract class Shape {
    int m_type;

    abstract void draw();
}

class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }

    @Override
    void draw() {
        System.out.println(" 绘制矩形 ");
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }

    @Override
    void draw() {
        System.out.println(" 绘制圆形 ");
    }
}

/**
 * 新增画三角形
 */
class Triangle extends Shape {
    Triangle() {
        super.m_type = 3;
    }

    @Override
    void draw() {
        System.out.println(" 绘制三角形 ");
    }
}

class Other extends Shape {
    Other() {
        super.m_type = 4;
    }

    @Override
    void draw() {
        System.out.println(" 绘制其他图形 ");
    }
}