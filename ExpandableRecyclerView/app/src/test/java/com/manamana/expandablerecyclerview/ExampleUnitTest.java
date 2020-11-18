package com.manamana.expandablerecyclerview;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    // 내장 클래스를 외부에서 사용한다.
    OuterClass o = new OuterClass(); // 외부 클래스 객체 선언
    // 인스턴스 내장 클래스의 객체 선언 : 인스턴스 클래스이기 때문에 밖의 객체를 선언 후 사용 가능
    OuterClass.InnerInstanceClass ii = o.new InnerInstanceClass();
    // 정적 내장 클래스의 객체 선언
    OuterClass.InnerStaticClass is = new OuterClass.InnerStaticClass();

}
class OuterClass{

    InnerInstanceClass c1 = new InnerInstanceClass();
    InnerStaticClass c2 = new InnerStaticClass();

    class InnerInstanceClass{

    }

    static class InnerStaticClass{

    }

    void method(){
        class LocalClass{

        }
        LocalClass c = new LocalClass(); // 객체 생성
    }
}