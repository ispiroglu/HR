package org.ytu.hr.util.position;

public enum Position {
    EMPLOYEE(1); // Buraya pozisyonları ve onların hiyerarşik karşılıklarını girmemiz gerekecek.

    Position(int power)
    {
        this.power = power;
    }
    final int power;

}
