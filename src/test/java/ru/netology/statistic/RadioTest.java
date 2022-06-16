package ru.netology.statistic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio();


    // установка количества радиостанций

    @Test
    void shouldSpecifyStationQuantityPositive() {
        Radio radio = new Radio((short) 120);
        radio.setStationsQuantity((short) 1);
        assertEquals(1, radio.getStationsQuantity());
    }

    @Test
    void shouldSpecifyStationQuantityNegative() {
        Radio radio = new Radio((short) 120);
        radio.setStationsQuantity((short) 121);
        assertEquals(120, radio.getStationsQuantity());
    }

    @Test
    void shouldSpecifyStationQuantityNegative2() {
        Radio radio = new Radio((short) 120);
        radio.setStationsQuantity((short) 0);
        assertEquals(120, radio.getStationsQuantity());
    }


    // установка номера радиостанции при количестве радиостанций по умолчанию

    @Test
    void shouldSpecifyStationWithDefaultQuantityPositive() {
        radio.setStation(5);
        assertEquals(5, radio.getStation());
    }

    @Test
    void shouldSpecifyStationWithDefaultQuantityNegative() {
        radio.setStation(11);
        assertEquals(0, radio.getStation());
    }

    @Test
    void shouldSpecifyStationWithDefaultQuantityNegative2() {
        radio.setStation(-1);
        assertEquals(0, radio.getStation());
    }


    // установка номера радиостанции при собственном количестве радиостанций

    @Test
    void shouldSpecifyStationWithCustomQuantityPositive() {
        Radio radio = new Radio((short) 120);
        radio.setStationsQuantity((short) 60);
        radio.setStation(30);
        assertEquals(30, radio.getStation());
    }

    @Test
    void shouldSpecifyStationWithCustomQuantityNegative() {
        Radio radio = new Radio((short) 120);
        radio.setStationsQuantity((short) 60);
        radio.setStation(61);
        assertEquals(0, radio.getStation());
    }

    @Test
    void shouldSpecifyStationWithCustomQuantityNegative2() {
        Radio radio = new Radio((short) 120);
        radio.setStationsQuantity((short) 60);
        radio.setStation(-1);
        assertEquals(0, radio.getStation());
    }


    // переключение радиостанций

    @Test
    void shouldSwitchStationUpToRoundDefault() {
        Radio radio = new Radio("ThroughMax", 9);
        radio.switchStationUp(); // 9~10
        radio.switchStationUp(); // 10~0
        assertEquals(0, radio.getStation());
    }

    @Test
    void shouldSwitchStationDownToRoundDefault() {
        Radio radio = new Radio("ThroughMin", 1);
        radio.switchStationDown(); // 1~0
        radio.switchStationDown(); // 0~10
        assertEquals(10, radio.getStation());
    }


    // регулировка громкости

    @Test
    void shouldIncreaseVolumeToThreshold() {
        Radio radio = new Radio(99);
        radio.increaseVolume(); // 99~100
        radio.increaseVolume(); // 100~100
        assertEquals(100, radio.getVolume());
    }

    @Test
    void shouldDecreaseVolumeToThreshold() {
        Radio radio = new Radio(1);
        radio.decreaseVolume(); // 1~0
        radio.decreaseVolume(); // 0~0
        assertEquals(0, radio.getVolume());
    }


    // тесты для полного покрытия

    @Test
    void shouldSetVolumeNegative() {
        Radio radio = new Radio(101);
        assertEquals(20, radio.getVolume());
    }

    @Test
    void shouldSetVolumeNegative2() {
        Radio radio = new Radio(-1);
        assertEquals(20, radio.getVolume());
    }
}