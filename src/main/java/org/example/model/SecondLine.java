package org.example.model;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * 卫星数据第二行
 */
public class SecondLine {

    //轨道报行号
    public String lineNum;

    //卫星号
    public String satelliteNum;

    //卫星轨道倾角
    public String orbitInclination;

    //升交点赤经
    public String ascendNodeEquinox;

    //偏心率
    public String eccentricity;

    //近地点角距
    public String perigeeAngular;

    //平近点角
    public String flatNearAngle;

    //平均运动（每天绕地球圈数）
    public String averageMovement;

    //历元轨道数
    public String orbitNum;

    //校验码
    public String checksum;

    /**
     * 构造函数，根据序列号随机初始化对象
     *
     * @param serialNum 序列号
     */
    public SecondLine(Integer serialNum) {
        this.lineNum = "2";
        this.satelliteNum = String.valueOf(25544 + serialNum);
        //轨道倾角在50-80，100-130之间随机
        this.orbitInclination = generateOrbitInclination();
        //升交点赤经1-360
        this.ascendNodeEquinox = generateAscendNodeEquinox();
        //偏心率
        this.eccentricity = "0004612";
        //近地点角距，1-360,同升角点赤经
        this.perigeeAngular = generateAscendNodeEquinox();
        //平近点角，1-360
        this.flatNearAngle = generateAscendNodeEquinox();
        //平均运动，13-16
        this.averageMovement = generateAverageMovement();
        this.orbitNum = "40266";
        this.checksum = "4";
    }

    /**
     * tostring方法的重载，符合格式要求
     *
     * @return
     */
    @Override
    public String toString() {
        if (ascendNodeEquinox.length() != 8) {
            this.ascendNodeEquinox = padString(ascendNodeEquinox, 8);
        }
        if (perigeeAngular.length() != 8) {
            this.perigeeAngular = padString(perigeeAngular, 8);
        }
        if (flatNearAngle.length() != 8) {
            this.flatNearAngle = padString(flatNearAngle, 8);
        }
        return lineNum + " " + satelliteNum + " " + orbitInclination + " " + ascendNodeEquinox + " " + eccentricity + " " + perigeeAngular + " " + flatNearAngle + " " + averageMovement + orbitNum + checksum;
    }

    /**
     * 生成两浮点数之间的随机数
     *
     * @param min 下限
     * @param max 上线
     * @return 返回结果
     */
    public static double generateRandomNumber(double min, double max) {
        Random random = new Random();
        return random.nextDouble() * (max - min) + min;
    }

    /**
     * 生成两整数之间的随机数
     *
     * @param min 下限
     * @param max 上限
     * @return 返回结果
     */
    public static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * 轨道倾角在50-80，100-130之间随机
     *
     * @return
     */
    public static String generateOrbitInclination() {
        double randomValue = generateRandomInt(0, 1);
        double randomValue1 = generateRandomNumber(50, 80);
        double randomValue2 = generateRandomNumber(100, 130);

        double result = (randomValue == 0) ? randomValue1 : randomValue2;

        DecimalFormat decimalFormat = new DecimalFormat("000.0000");
        String res = decimalFormat.format(result);
        res = res.replaceAll("^0+", " "); // 替换开头的0为一个或多个空格
        return res;
    }

    /**
     * 1-360随机8字符浮点数生成
     *
     * @return
     */
    public static String generateAscendNodeEquinox() {
        double randomValue = generateRandomNumber(1, 360);
        DecimalFormat decimalFormat = new DecimalFormat("000.0000");
        String res = decimalFormat.format(randomValue);
        res = res.replaceAll("^0+", " ");
        return res;
    }

    /**
     * 平均运动，13-16
     *
     * @return
     */
    public static String generateAverageMovement() {
        double randomValue = generateRandomNumber(13, 16);
        DecimalFormat decimalFormat = new DecimalFormat("00.00000000");
        return decimalFormat.format(randomValue);
    }


    /**
     * 用空格占位符补充字符位数不够的数据
     *
     * @param str
     * @param length
     * @return
     */
    public static String padString(String str, int length) {
        if (str.length() >= length) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length - str.length(); i++) {
            sb.append(' ');
        }
        sb.append(str);
        return sb.toString();
    }

}
